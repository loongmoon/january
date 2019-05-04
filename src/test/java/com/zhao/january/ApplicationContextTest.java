package com.zhao.january;

import com.zhao.january.context.XmlClassPathApplicationContext;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class ApplicationContextTest {

    public static void main(String[] args) throws IllegalAccessException, NoSuchFieldException, InstantiationException, IOException, SAXException, ParserConfigurationException {
        XmlClassPathApplicationContext applicationContext = new XmlClassPathApplicationContext("spring.xml");
        HelloWorldService helloWorldService = (HelloWorldService) applicationContext.getBean("helloWorldService");
        helloWorldService.hello();
    }


}
