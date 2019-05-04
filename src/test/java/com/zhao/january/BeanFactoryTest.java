package com.zhao.january;

import org.junit.Test;

public class BeanFactoryTest {

    @Test
    public void test() {
        BeanFactory beanFactory = new BeanFactory();
        BeanDefinition beanDefinition = new BeanDefinition(new HelloWorldService());
        beanFactory.registerBeanDefinition("helloWorldService", beanDefinition);
        HelloWorldService helloWorldService = (HelloWorldService) beanFactory.getBean("helloWorldService");
        helloWorldService.hello();
    }

}
