package com.hie2j.ad1009;

public class Student {
    private String name;
    private int age;
    private int imgId;

    public Student(String name,int age,int imgId){
        this.name = name;
        this.age = age;
        this.imgId = imgId;
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

    public int getImgId() {
        return imgId;
    }

    public void setImgId(int imgId) {
        this.imgId = imgId;
    }
}
