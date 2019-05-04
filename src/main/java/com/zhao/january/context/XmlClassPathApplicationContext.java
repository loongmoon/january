package com.zhao.january.context;

import com.zhao.january.BeanDefinition;
import com.zhao.january.factory.AbstractBeanFactory;
import com.zhao.january.factory.AutowireCapableBeanFactory;
import com.zhao.january.io.ResourceLoader;
import com.zhao.january.xml.XmlBeanDefinitionReader;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.Map;

public class XmlClassPathApplicationContext extends AbstractApplicationContext {

    private String configLocation;

    public XmlClassPathApplicationContext(String configLocation) throws IllegalAccessException, ParserConfigurationException, InstantiationException, NoSuchFieldException, SAXException, IOException {
        this(configLocation, new AutowireCapableBeanFactory());
        this.configLocation = configLocation;
    }

    public XmlClassPathApplicationContext(String configLocation, AbstractBeanFactory beanFactory) throws IllegalAccessException, InstantiationException, IOException, SAXException, ParserConfigurationException, NoSuchFieldException {
        super(beanFactory);
        this.configLocation = configLocation;
        refresh();
    }

    @Override
    public void refresh() throws IllegalAccessException, NoSuchFieldException, InstantiationException, ParserConfigurationException, SAXException, IOException {
        XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(new ResourceLoader());
        xmlBeanDefinitionReader.loadBeanDefinitions(configLocation);
        for (Map.Entry<String, BeanDefinition> entry : xmlBeanDefinitionReader.getRegistry().entrySet()) {
            beanFactory.registerBeanDefinition(entry.getKey(), entry.getValue());
        }
    }
}
