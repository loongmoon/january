package com.zhao.january;

import org.junit.Test;

public class BeanFactoryTest {

    @Test
    public void test() {
        BeanFactory beanFactory = new AutowireCapableBeanFactory();
        BeanDefinition beanDefinition = new BeanDefinition();
        beanDefinition.setBeanClassName("com.zhao.january.HelloWorldService");
        beanFactory.registerBeanDefinition("helloWorldService", beanDefinition);
        HelloWorldService helloWorldService = (HelloWorldService) beanFactory.getBean("helloWorldService");
        helloWorldService.hello();
    }

}
