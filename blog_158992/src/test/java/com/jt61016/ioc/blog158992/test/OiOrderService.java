package com.jt61016.ioc.blog158992.test;

import com.jt61016.ioc.blog158992.annotation.MyBean;

/**
 * @Author jiangtao
 * @Date 2018/5/16 下午1:54.
 */
@MyBean
public class OiOrderService implements OrderService {
    private Order order = null;

    public String createOrder() {
        order = new Order();
        order.setId("oi-xx-20180516-001");
        order.setTitle("2018年05月16日-online");
        return order.getId();
    }

    public String printOrder() {
        return null == order ? "" : order.toString();
    }
}
