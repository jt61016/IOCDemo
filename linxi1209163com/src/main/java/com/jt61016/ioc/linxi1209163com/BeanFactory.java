package com.jt61016.ioc.linxi1209163com;

/**
 * @Author jiangtao
 * @Date 2018/5/7 下午4:02.
 */
public interface BeanFactory {
    /**
     * 根据bean的name获取bean对象
     * @param beanName
     * @return
     */
    Object getBean(String beanName);
}
