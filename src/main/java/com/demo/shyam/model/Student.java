package com.demo.shyam.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Student {
    @Id
    String id;
    private String firstName;
    private String lastName;
    private int age;
    private String email;
    private long phoneNumber;
    private String [] courses;

    public Student(String firstName, String lastName, long phoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber=phoneNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String[] getCourses() {
        return courses;
    }

    public void setCourses(String[] courses) {
        this.courses = courses;
    }
    @Override
    public String toString(){
        return "Hello "+this.firstName+" "+this.lastName;
    }

    @Override
    public boolean equals(Object obj) {
        Student obj2=(Student)obj;
        if(obj2.getPhoneNumber()==phoneNumber){
            return true;
        }
        else{
            return false;
        }
    }
}
