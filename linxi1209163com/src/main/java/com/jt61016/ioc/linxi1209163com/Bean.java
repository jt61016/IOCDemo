package com.jt61016.ioc.linxi1209163com;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author jiangtao
 * @Date 2018/5/7 下午4:15.
 */
@Data
@NoArgsConstructor
public class Bean {
    private String name;
    private String className;
    private List<Property> properties = new ArrayList<Property>();

    @Override
    public String toString() {
        return "Bean [name = " + name + ", className = " + className + ", properties = " + properties + "]";
    }
}
