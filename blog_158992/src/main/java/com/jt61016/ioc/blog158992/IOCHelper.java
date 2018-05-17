package com.jt61016.ioc.blog158992;

import com.jt61016.ioc.blog158992.annotation.MyImpl;
import com.jt61016.ioc.blog158992.annotation.MyInject;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;

/**
 * 实现bean的依赖注入
 * 对于循环依赖这里没有解决
 *
 * @Author jiangtao
 * @Date 2018/5/17 下午4:21.
 */
public class IOCHelper {
    public static void init() {
        try {
            Map<Class<?>, Object> beanMap = BeanHelper.getBeanMap();
            for (Map.Entry<Class<?>, Object> beanEntry : beanMap.entrySet()) {
                Class<?> beanClass = beanEntry.getKey();
                Object beanInstance = beanEntry.getValue();

                Field[] beanFields = beanClass.getDeclaredFields();
                if (null != beanFields && 0 < beanFields.length) {
                    for (Field beanField : beanFields) {
                        if (beanField.isAnnotationPresent(MyInject.class)) {
                            Class<?> interfaceClass = beanField.getType();
                            Class<?> implementClass = null;
                            if (interfaceClass.isAnnotationPresent(MyImpl.class)) {
                                implementClass = interfaceClass.getAnnotation(MyImpl.class).value();
                            } else {
                                List<Class<?>> implementClassList = ClassHelper.getClassListByInterface(interfaceClass);
                                if (null != implementClassList && !implementClassList.isEmpty()) {
                                    implementClass = implementClassList.get(0);
                                }
                            }
                            if (null != implementClass) {
                                Object implementInstance = beanMap.get(implementClass);
                                beanField.setAccessible(true);
                                beanField.set(beanInstance, implementInstance);
                            }
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
