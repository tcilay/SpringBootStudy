package com.hy.demo.demo.entity;

import org.springframework.beans.factory.annotation.Value;

public class User {

    private long id;
    @Value("login.user.name")
    private String name;
    @Value("login.user.pwd")
    private String pwd;
    @Value("login.user.age")
    private int age;
    @Value("login.user.sex")
    private int sex;

    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPwd() {
        return pwd;
    }

    public int getAge() {
        return age;
    }

    public int getSex() {
        return sex;
    }
}
