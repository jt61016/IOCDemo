package com.jt61016.ioc.blog158992;

import com.jt61016.ioc.blog158992.annotation.MyBean;
import com.jt61016.ioc.blog158992.annotation.MyInject;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author jiangtao
 * @Date 2018/5/9 下午7:51.
 */
public class BeanHelper {
    private static final Map<Class<?>, Object> beanMap = new HashMap<Class<?>, Object>();

    static {
        try {
            List<Class<?>> beanClassList = ClassHelper.getClassListByAnnotation(MyBean.class);
            for (Class<?> beanClass : beanClassList) {
                Object beanInstance = beanClass.newInstance();
                beanMap.put(beanClass, beanInstance);
            }

            for (Map.Entry<Class<?>, Object> beanEntry : beanMap.entrySet()) {
                Class<?> beanClass = beanEntry.getKey();
                Object beanInstance = beanEntry.getValue();

                Field[] beanFields = beanClass.getDeclaredFields();
                if (null != beanFields && 0 > beanFields.length) {
                    for (Field beanField : beanFields) {
                        if (beanField.isAnnotationPresent(MyInject.class)) {
                            Class<?> interfaceClass = beanField.getType();
                            List<Class<?>> implementClassList = ClassHelper.getClassListByInterface(interfaceClass);
                            if (null != implementClassList && !implementClassList.isEmpty()) {
                                Class<?> implementClass = implementClassList.get(0);
                                Object implementInstance = beanMap.get(implementClass);
                                beanField.setAccessible(true);
                                beanField.set(beanInstance, implementInstance);
                            }
                        }
                    }
                }
            }
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    public static Map<Class<?>, Object> getBeanMap() {
        return beanMap;
    }

    public static <T> T getBean(Class<T> clazz) {
        return (T) beanMap.get(clazz);
    }
}
