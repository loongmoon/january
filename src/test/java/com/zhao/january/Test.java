package com.zhao.january;

import com.zhao.january.io.Resource;
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
import java.net.URL;
import java.net.URLConnection;

public class Test {

    public static void main(String[] args) throws IOException, ParserConfigurationException, SAXException {
        //获取当前类class所在的resource路径
        System.out.println(BeanDefinition.class.getResource("/").getPath());
        //获取当前类class所在的路径：
        System.out.println(BeanDefinition.class.getResource("").getPath());

        //获取当前类class所在的路径：
        System.out.println(BeanDefinition.class.getResource("/spring.xml").getPath());

        //获取当前类class所在的路径：
//        System.out.println(BeanDefinition.class.getResource("spring.xml").getPath());

        System.out.println(BeanDefinition.class.getClassLoader().getResource("spring.xml").getPath());

//        URL url = BeanDefinition.class.getClassLoader().getResource("spring.xml");
//        URLConnection urlConnection = url.openConnection();
//        urlConnection.connect();


        ResourceLoader resourceLoader = new ResourceLoader();
        Resource resource = resourceLoader.getResource("spring.xml");

        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
        Document document = documentBuilder.parse(resource.getInputStream());
        Element root = document.getDocumentElement();
        NodeList childNodes = root.getChildNodes();
        for (int i = 0; i < childNodes.getLength(); i++) {
            Node node = childNodes.item(i);
            if (node instanceof Element) {
                Element element = (Element) node;
                System.out.println(element.getAttribute("name"));
            }
        }

    }

}
