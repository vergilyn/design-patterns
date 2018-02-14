package com.vergilyn.examples.design.behavioral.template_method.bean;

/**
 * 学生信息
 * @author VergiLyn
 * @blog http://www.cnblogs.com/VergiLyn/p/6243626.html
 * @date 2017/1/2
 */
public class StudentBean {
    public final static int TYPE_FORM = 1;
    public final static int TYPE_WEB = 2;
    public final static int TYPE_APP = 3;
    /* 任何条件必须*/
    private String name;
    /* 任何条件必须*/
    private int age;
    /* TYPE_FORM必须*/
    private Long birthday;
    /* TYPE_WEB必须*/
    private String hobby;
    /* TYPE_APP必须*/
    private String phoneNumber;
    private int registerType;

    public StudentBean(String name, int age){
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Long getBirthday() {
        return birthday;
    }

    public void setBirthday(Long birthday) {
        this.birthday = birthday;
    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getRegisterType() {
        return registerType;
    }

    public void setRegisterType(int registerType) {
        this.registerType = registerType;
    }
}
