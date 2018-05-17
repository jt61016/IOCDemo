package com.jt61016.ioc.blog158992;

import com.jt61016.ioc.blog158992.annotation.MyBean;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author jiangtao
 * @Date 2018/5/9 下午7:51.
 */
public class BeanHelper {
    //存放bean的容器
    private static final Map<Class<?>, Object> beanMap = new HashMap<Class<?>, Object>();

    static {
        try {
            List<Class<?>> beanClassList = ClassHelper.getClassListByAnnotation(MyBean.class);
            for (Class<?> beanClass : beanClassList) {
                Object beanInstance = beanClass.newInstance();
                beanMap.put(beanClass, beanInstance);
                System.out.println("装载bean : " + beanClass.getName());
            }
            //这里需要保证IOCHelper的调用是在BeanHelper初始化beanMap之后
            IOCHelper.init();
        } catch (Exception e) {
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
