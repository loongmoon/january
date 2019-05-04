package com.zhao.january.factory;

import com.zhao.january.BeanDefinition;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public interface BeanFactory {

    Object getBean(String beanName) throws IllegalAccessException, NoSuchFieldException, InstantiationException;

    void registerBeanDefinition(String name, BeanDefinition beanDefinition) throws IllegalAccessException, InstantiationException, NoSuchFieldException;

}
