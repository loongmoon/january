package com.zhao.january.context;

import com.zhao.january.factory.AbstractBeanFactory;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public abstract class AbstractApplicationContext implements ApplicationContext {

    protected AbstractBeanFactory beanFactory;

    public AbstractApplicationContext(AbstractBeanFactory beanFactory) {
        this.beanFactory = beanFactory;
    }

    @Override
    public Object getBean(String beanName) throws IllegalAccessException, NoSuchFieldException, InstantiationException {
        return beanFactory.getBean(beanName);
    }

    public abstract void refresh() throws IllegalAccessException, NoSuchFieldException, InstantiationException, ParserConfigurationException, SAXException, IOException;
}
