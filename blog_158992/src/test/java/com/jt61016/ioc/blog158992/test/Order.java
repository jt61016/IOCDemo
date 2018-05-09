package com.jt61016.ioc.blog158992.test;

import com.jt61016.ioc.blog158992.annotation.MyBean;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author jiangtao
 * @Date 2018/5/9 下午9:01.
 */
@MyBean
@Data
@NoArgsConstructor
public class Order {
    private Long id;
    private String title;
}
