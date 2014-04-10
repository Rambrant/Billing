package com.tradedoubler.testutil;

import org.springframework.beans.factory.annotation.AnnotatedGenericBeanDefinition;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericApplicationContext;

/**
 * @author bjoek
 * @since 2012-06-25
 */
public class ApplicationContextUtil {
    private final GenericApplicationContext applicationContext;

    public ApplicationContextUtil(ApplicationContext applicationContext) {
        this.applicationContext = (GenericApplicationContext) applicationContext;
    }

    public <T> T registerRootBean(Class<T> clazz) {
        BeanDefinition beanDef1 = new RootBeanDefinition(clazz);
        applicationContext.registerBeanDefinition(lowerCaseFirstLetter(clazz.getName()), beanDef1);
        return applicationContext.getBean(clazz);
    }

    public <T> T registerAnnotatedBean(Class<T> clazz) {
        BeanDefinition beanDef1 = new AnnotatedGenericBeanDefinition(clazz);
        applicationContext.registerBeanDefinition(lowerCaseFirstLetter(clazz.getName()), beanDef1);
        return applicationContext.getBean(clazz);
    }

    public <T> T registerBeanInstance(T object) {
        Class<T> clazz = (Class<T>) object.getClass();
        applicationContext.getBeanFactory().registerSingleton(lowerCaseFirstLetter(clazz.getName()), object);
        return applicationContext.getBean(clazz);
    }

    private String lowerCaseFirstLetter(String name) {
        return name.substring(0, 1).toLowerCase() + name.substring(1);
    }

}
