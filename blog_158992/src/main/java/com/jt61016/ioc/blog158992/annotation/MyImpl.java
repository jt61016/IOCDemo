package com.jt61016.ioc.blog158992.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * @Author jiangtao
 * @Date 2018/5/16 下午2:44.
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface MyImpl {
    public Class<?> value();
}
