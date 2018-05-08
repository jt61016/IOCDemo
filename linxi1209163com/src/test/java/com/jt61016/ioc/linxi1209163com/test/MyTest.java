package com.jt61016.ioc.linxi1209163com.test;

import com.jt61016.ioc.linxi1209163com.ClassPathXmlApplicationContext;

/**
 * @Author jiangtao
 * @Date 2018/5/7 下午5:09.
 */
public class MyTest {
    public static void main(String[] args) {
        //String path = "/Users/jiangtao/CodeRepes/IOCDemo/src/test/resources/beans.xml";
        //String path = "/Users/jiangtao/CodeRepes/IOCDemo/src/main/java/com/jt61016/ioc/beans.xml";
        String path = "/beans.xml";
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext(path);
    }
}
