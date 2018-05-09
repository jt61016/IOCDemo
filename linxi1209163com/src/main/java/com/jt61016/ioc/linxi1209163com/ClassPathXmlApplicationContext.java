package com.jt61016.ioc.linxi1209163com;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author jiangtao
 * @Date 2018/5/7 下午4:08.
 */
public class ClassPathXmlApplicationContext implements BeanFactory {
    //从XML处读取的配置信息
    private Map<String, Bean> config;
    //bean容器,放置所管理的对象
    private Map<String, Object> context = new HashMap<String, Object>();

    public Object getBean(String beanName) {
        Object bean = context.get(beanName);
        return bean;
    }

    public ClassPathXmlApplicationContext(String path) {
        config = ConfigManager.getConfig(path);
        if (null != config) {
            for (Map.Entry<String, Bean> en : config.entrySet()) {
                String beanName = en.getKey();
                Bean bean = en.getValue();

                Object exsitBean = context.get(beanName);
                if (null == exsitBean) {
                    Object beanObj = createBean(bean);
                    context.put(beanName, beanObj);
                    System.out.println(beanName + "创建成功 " + beanObj);
                }
            }
        }
    }

    private Object createBean(Bean bean) {
        Object beanObj = null;

        String className = bean.getClassName();
        Class clazz = null;

        try {
            clazz = Class.forName(className);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException("请检查bean的class配置 " + className);
        }

        try {
            beanObj = clazz.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("没有空参数构造方法 " + className);
        }

        if (null != bean.getProperties()) {
            for (Property property : bean.getProperties()) {
                String name = property.getName();

                Method setMethod = BeanUtils.getWriteMethod(beanObj, name);
                Object param = null;
                Type[] types = setMethod.getGenericParameterTypes();
                if (null != property.getValue()) {
                    String value = property.getValue();
                    if ("int".equals(types[0].getTypeName()) || "java.lang.Integer".equals(types[0].getTypeName())) {
                        param = Integer.parseInt(value);
                    } else {
                        param = value;
                    }
                }
                if (null != property.getRef()) {
                    Object exsitBean = context.get(property.getRef());
                    if (null == exsitBean) {
                        Bean refBean = config.get(property.getRef());
                        exsitBean = createBean(refBean);
                        context.put(property.getRef(), exsitBean);
                    }
                    param = exsitBean;
                }

                try {
                    setMethod.invoke(beanObj, param);
                } catch (Exception e) {
                    e.printStackTrace();
                    throw new RuntimeException("bean的属性" + name + "没有对应set方法,或者参数不正确 " + className);
                }
            }
        }

        return beanObj;
    }
}
