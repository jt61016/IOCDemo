package com.jt61016.ioc.blog158992.test;

import com.jt61016.ioc.blog158992.annotation.MyImpl;

/**
 * @Author jiangtao
 * @Date 2018/5/16 下午1:52.
 */
@MyImpl(OiOrderService.class)
public interface OrderService {
    String createOrder();
    String printOrder();
}
