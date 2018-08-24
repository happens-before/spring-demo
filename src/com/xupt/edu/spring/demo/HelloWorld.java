package com.xupt.edu.spring.demo;

/**
 * @author: zhaowanyue
 * @date: 2018/8/23
 * @description:
 */
public class HelloWorld {
    private String name;

    public HelloWorld() {
        System.out.println("hello 创建");
    }

    public void setName(String name) {
        System.out.println("setname:"+name);
        this.name = name;
    }
    public void hello()
    {
        System.out.println("hello:"+name);
    }
}
