package com.jt61016.ioc.linxi1209163com.test;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author jiangtao
 * @Date 2018/5/7 下午5:09.
 */
@Data
@NoArgsConstructor
public class Gentleman {
    private String name;
    private String age;
    private Girl girlFriend;

    public String toString() {
        return name  + " : " + age + ", girl friend is : " + girlFriend;
    }
}
