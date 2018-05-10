package com.jt61016.ioc.blog158992.test;

import com.jt61016.ioc.blog158992.BeanHelper;
import com.jt61016.ioc.blog158992.annotation.MyBean;
import com.jt61016.ioc.blog158992.annotation.MyInject;

/**
 * @Author jiangtao
 * @Date 2018/5/9 下午9:02.
 */
@MyBean
public class OrderService {
    @MyInject
    Order order;

    public Order testOrder() {
        return order;
    }

    public String toString() {
        return "Service : " + order;
    }

    public static void main(String[] args) {
        System.out.println("------------------start");
        OrderService bean = BeanHelper.getBean(OrderService.class);
        System.out.println(bean);
        System.out.println("------------------end");
    }
}
