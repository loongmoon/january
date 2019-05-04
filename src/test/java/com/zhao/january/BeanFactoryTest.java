package com.zhao.january;

import com.zhao.january.factory.AutowireCapableBeanFactory;
import com.zhao.january.factory.BeanFactory;
import org.junit.Test;

public class BeanFactoryTest {

    @Test
    public void test() throws IllegalAccessException, NoSuchFieldException, InstantiationException {
        BeanFactory beanFactory = new AutowireCapableBeanFactory();
        BeanDefinition beanDefinition = new BeanDefinition();
        beanDefinition.setBeanClassName("com.zhao.january.HelloWorldService");

        PropertyValue propertyValue = new PropertyValue("text", "hello");
        PropertyValues propertyValues = new PropertyValues();
        propertyValues.addPropertyValue(propertyValue);
        beanDefinition.setPropertyValues(propertyValues);

        beanFactory.registerBeanDefinition("helloWorldService", beanDefinition);
        HelloWorldService helloWorldService = (HelloWorldService) beanFactory.getBean("helloWorldService");
        helloWorldService.hello();
    }

}
