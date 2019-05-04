package com.zhao.january;

public class AutowireCapableBeanFactory extends AbstractBeanFactory {
    @Override
    protected Object doCreatBean(BeanDefinition beanDefinition) {
        try {
            return beanDefinition.getBeanClass().newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }
}
