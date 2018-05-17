package com.jt61016.ioc.blog158992.test;

import com.jt61016.ioc.blog158992.BeanHelper;
import com.jt61016.ioc.blog158992.annotation.MyBean;
import com.jt61016.ioc.blog158992.annotation.MyInject;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author jiangtao
 * @Date 2018/5/16 下午1:56.
 */
@Data
@NoArgsConstructor
public class Order {
    private String id;
    private String title;

    public String toString() {
        return "[" + id + "] - " + title;
    }

}
