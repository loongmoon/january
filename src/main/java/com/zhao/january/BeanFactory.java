package com.zhao.january;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public interface BeanFactory {

    Object getBean(String beanName);

    void registerBeanDefinition(String name, BeanDefinition beanDefinition);

}
