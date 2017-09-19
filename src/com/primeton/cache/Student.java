package com.primeton.cache;

public class Student {

    private String name;


    private String id;

    private int age;

    private int sal;

    public Student() {

    }

    public Student(String name, String id, int age, int sal) {
        this.name = name;
        this.id = id;
        this.age = age;
        this.sal = sal;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getSal() {
        return sal;
    }

    public void setSal(int sal) {
        this.sal = sal;
    }


}
