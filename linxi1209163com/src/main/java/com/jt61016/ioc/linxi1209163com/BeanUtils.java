package com.jt61016.ioc.linxi1209163com;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;

/**
 * @Author jiangtao
 * @Date 2018/5/7 下午5:00.
 */
public class BeanUtils {
    public static Method getWriteMethod(Object beanObj, String methodName) {
        Method method = null;

        try {
            BeanInfo beanInfo = Introspector.getBeanInfo(beanObj.getClass());
            PropertyDescriptor[] pds = beanInfo.getPropertyDescriptors();
            if (null != pds) {
                for (PropertyDescriptor pd : pds) {
                    String pName = pd.getName();
                    if (pName.equals(methodName)) {
                        method = pd.getWriteMethod();
                    }
                }
            }
        } catch (IntrospectionException e) {
            e.printStackTrace();
        }

        if (null == method) {
            throw new RuntimeException("请检查" + methodName + "属性的set方法是否创建");
        }

        return method;
    }
}
