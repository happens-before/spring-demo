package com.xupt.edu.spring.demo;

/**
 * @author: zhaowanyue
 * @date: 2018/8/24
 * @description:
 */
public class Boss {
    private String name;
    private Office office;

    public Boss() {
        System.out.println("Boss 初始化");
    }

    public Boss(String name, Office office) {

        this.name = name;
        this.office = office;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Office getOffice() {
        return office;
    }

    public void setOffice(Office office) {
        this.office = office;
    }
}
