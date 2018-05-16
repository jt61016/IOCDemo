package com.jt61016.ioc.blog158992.test;

import com.jt61016.ioc.blog158992.BeanHelper;
import com.jt61016.ioc.blog158992.annotation.MyBean;
import com.jt61016.ioc.blog158992.annotation.MyInject;

/**
 * @Author jiangtao
 * @Date 2018/5/16 下午2:41.
 */
@MyBean
public class OrderController {
    @MyInject
    OrderService orderService;

    public void createOrder() {
        String id = orderService.createOrder();
        System.out.println("created an order : " + id);
    }

    public void printOrder() {
        System.out.println(orderService.printOrder());
    }

    public static void main(String[] args) {
        OrderController controller  = BeanHelper.getBean(OrderController.class);
        controller.createOrder();
        System.out.println("------------");
        controller.printOrder();
    }
}
