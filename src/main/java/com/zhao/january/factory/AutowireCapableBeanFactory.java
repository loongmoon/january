package com.zhao.january.factory;

import com.zhao.january.BeanDefinition;
import com.zhao.january.BeanReference;
import com.zhao.january.PropertyValue;

import java.lang.reflect.Field;

public class AutowireCapableBeanFactory extends AbstractBeanFactory {
    @Override
    protected Object doCreatBean(BeanDefinition beanDefinition) throws InstantiationException, IllegalAccessException, NoSuchFieldException {
        Object bean = createBeanInstance(beanDefinition);
        applyPropertyValues(bean, beanDefinition);
        return bean;
    }

    public Object createBeanInstance(BeanDefinition beanDefinition) throws IllegalAccessException, InstantiationException {
        return beanDefinition.getBeanClass().newInstance();
    }

    public void applyPropertyValues(Object bean, BeanDefinition mbd) throws NoSuchFieldException, IllegalAccessException {
        for (PropertyValue propertyValue : mbd.getPropertyValues().getPropertyValueList()) {
            Field declaredField = bean.getClass().getDeclaredField(propertyValue.getName());
            declaredField.setAccessible(true);
            Object value = propertyValue.getValue();
            if (value instanceof BeanReference) {
                BeanReference beanReference = (BeanReference) value;
                value = getBean(beanReference.getName());
            }
            declaredField.set(bean, value);
        }
    }

}
