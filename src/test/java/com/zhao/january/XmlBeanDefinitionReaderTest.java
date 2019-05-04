package com.zhao.january;

import com.zhao.january.io.ResourceLoader;
import com.zhao.january.xml.XmlBeanDefinitionReader;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.Map;

public class XmlBeanDefinitionReaderTest {

    public static void main(String[] args) throws IOException, ParserConfigurationException, SAXException {
        XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(new ResourceLoader());
        xmlBeanDefinitionReader.loadBeanDefinitions("spring.xml");
        Map<String, BeanDefinition> registry = xmlBeanDefinitionReader.getRegistry();
        for (Map.Entry<String, BeanDefinition> entry : registry.entrySet()) {
            System.out.println(entry.getKey());
        }
    }

}
