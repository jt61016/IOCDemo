package com.jt61016.ioc.linxi1209163com.test;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author jiangtao
 * @Date 2018/5/7 下午5:07.
 */
@Data
@NoArgsConstructor
public class Girl {
    private String name;
    private Integer age;

    public String toString() {
        return name  + " : " + age;
    }
}
