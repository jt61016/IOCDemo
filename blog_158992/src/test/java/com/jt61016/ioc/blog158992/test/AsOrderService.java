package com.jt61016.ioc.blog158992.test;

import com.jt61016.ioc.blog158992.annotation.MyBean;

/**
 * @Author jiangtao
 * @Date 2018/5/16 下午2:01.
 */
@MyBean
public class AsOrderService implements OrderService {
    private Order order = null;

    public String createOrder() {
        order = new Order();
        order.setId("as-xx-20180516-001");
        order.setTitle("2018年05月16日-as");
        return order.getId();
    }

    public String printOrder() {
        return null == order ? "" : order.toString();
    }
}
