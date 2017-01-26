package com.example.hp.recruiment;

/**
 * Created by hp on 1/26/2017.
 */

public class Student {

    private String name;
    private String deptName;
    private String rollNo;
    private String cgpa;
    private String age;
    private String email;
    private String key;

    public Student(String name,String email,String age,String deptName,String rollNo,String cgpa, String key)
    {
        this.name = name;
        this.deptName = deptName;
        this.rollNo = rollNo;
        this.cgpa = cgpa;
        this.age = age;
        this.email = email;
        this.key = key;
    }

    public String getName() {
        return name;
    }

    public String getDeptName() {
        return deptName;
    }

    public String getRollNo() {
        return rollNo;
    }

    public String getCgpa() {
        return cgpa;
    }

    public String getAge() {
        return age;
    }

    public String getEmail() {
        return email;
    }

    public String getKey() {
        return key;
    }


    public void setKey(String key) {
        this.key = key;
    }
}
