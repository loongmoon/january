package com.zhao.january.xml;

import com.zhao.january.AbstractBeanDefinitionReader;
import com.zhao.january.BeanDefinition;
import com.zhao.january.PropertyValue;
import com.zhao.january.io.ResourceLoader;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.io.InputStream;

public class XmlBeanDefinitionReader extends AbstractBeanDefinitionReader {
    public XmlBeanDefinitionReader(ResourceLoader resourceLoader) {
        super(resourceLoader);
    }

    @Override
    public void loadBeanDefinitions(String location) throws IOException, ParserConfigurationException, SAXException {
        InputStream inputStream = getResourceLoader().getResource(location).getInputStream();
        doLoadBeanDefinitions(inputStream);
    }

    public void doLoadBeanDefinitions(InputStream inputStream) throws ParserConfigurationException, IOException, SAXException {
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
        Document document = documentBuilder.parse(inputStream);
        registerBeanDefinitions(document);
    }

    public void registerBeanDefinitions(Document document) {
        Element documentElement = document.getDocumentElement();
        parseBeanDefinitions(documentElement);
    }

    private void parseBeanDefinitions(Element documentElement) {
        NodeList childNodes = documentElement.getChildNodes();
        for (int i = 0; i < childNodes.getLength(); i++) {
            Node node = childNodes.item(i);
            if (node instanceof Element) {
                Element element = (Element) node;
                processBeanDefinition(element);
            }
        }
    }

    private void processBeanDefinition(Element element) {
        String name = element.getAttribute("name");
        String className = element.getAttribute("class");
        BeanDefinition beanDefinition = new BeanDefinition();
        processProperty(element, beanDefinition);
        beanDefinition.setBeanClassName(className);
        getRegistry().put(name, beanDefinition);
    }

    private void processProperty(Element element, BeanDefinition beanDefinition) {
        NodeList propertyNodeList = element.getElementsByTagName("property");
        for (int i = 0; i < propertyNodeList.getLength(); i++) {
            Node node = propertyNodeList.item(i);
            if (node instanceof Element) {
                Element propertyElement = (Element) node;
                String propertyName = propertyElement.getAttribute("name");
                String propertyValue = propertyElement.getAttribute("value");
                beanDefinition.getPropertyValues().addPropertyValue(new PropertyValue(propertyName, propertyValue));
            }
        }
    }
}
