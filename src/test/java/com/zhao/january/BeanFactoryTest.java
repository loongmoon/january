package com.zhao.january;

import com.zhao.january.factory.AutowireCapableBeanFactory;
import com.zhao.january.factory.BeanFactory;
import com.zhao.january.io.ResourceLoader;
import com.zhao.january.xml.XmlBeanDefinitionReader;
import org.junit.Test;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.Map;

public class BeanFactoryTest {

    @Test
    public void test() throws IllegalAccessException, NoSuchFieldException, InstantiationException, ParserConfigurationException, SAXException, IOException {
        BeanFactory beanFactory = new AutowireCapableBeanFactory();

        XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(new ResourceLoader());
        xmlBeanDefinitionReader.loadBeanDefinitions("spring.xml");

        for (Map.Entry<String, BeanDefinition> entry : xmlBeanDefinitionReader.getRegistry().entrySet()) {
            beanFactory.registerBeanDefinition(entry.getKey(), entry.getValue());
        }

        HelloWorldService helloWorldService = (HelloWorldService) beanFactory.getBean("helloWorldService");
        helloWorldService.hello();
    }

}
