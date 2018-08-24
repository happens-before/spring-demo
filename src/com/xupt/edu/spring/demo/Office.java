package com.xupt.edu.spring.demo;

/**
 * @author: zhaowanyue
 * @date: 2018/8/24
 * @description:
 */
public class Office {
    public String name;
    public Boss boss;

    public Office(String name, Boss boss) {

        this.name = name;
        this.boss = boss;
    }

    public Office() {
        System.out.println("Office 初始化");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boss getBoss() {
        return boss;
    }

    public void setBoss(Boss boss) {
        this.boss = boss;
    }
}
