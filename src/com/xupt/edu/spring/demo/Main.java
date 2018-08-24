package com.xupt.edu.spring.demo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author: zhaowanyue
 * @date: 2018/8/23
 * @description:
 */
public class Main {
    public static void main(String[] args) {
        //创建对象以及为spring赋值，交给spring完成
        /*
        HelloWorld helloWorld=new HelloWorld();
        helloWorld.setName("zhaowanyue");
        */
        //创建spring ioc容器对象
        ApplicationContext context=new ClassPathXmlApplicationContext("spring-config.xml");

        //从ioc容器中获取bean实例
        HelloWorld helloWorld = (HelloWorld) context.getBean("helloWorld");
        helloWorld.hello();
    }
}
