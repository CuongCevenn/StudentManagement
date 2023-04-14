package com.demo.studentmanagement;

import java.util.*;

public class Student {

    private String id, fullName, birth, gender, email, address, phone;
    public String classObj;    // sau nay co the update classObj, address thanh 1 class rieng biet mang thong tin rieng

    public Student() {

    }

    public Student(String id) {
        this.id = id;
    }

    public Student(String id, String fullName, String birth, String gender, String email, String address, String phone, String classObj) {
        this.id = id;
        this.fullName = fullName;
        this.birth = birth;
        this.gender = gender;
        this.email = email;
        this.address = address;
        this.phone = phone;
        this.classObj = classObj;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFullname() {
        return fullName;
    }

    public void setFullname(String fullName) {
        this.fullName = fullName;
    }

    public String getBirth() {
        return birth;
    }

    public void setBirth(String birth) {
        this.birth = birth;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getClassObj() {
        return classObj;
    }

    public void setClassObj(String classObj) {
        this.classObj = classObj;
    }


    public void input() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Nhap MSV :");
        id = scan.nextLine();
        System.out.println("Nhap Ho va Ten :");
        fullName = scan.nextLine();
        System.out.println("Nhap Ngay Sinh (YYYY-MM-DD) :");
        birth = scan.nextLine();
        System.out.println("Nhap Gioi Tinh :");
        gender = scan.nextLine();
        System.out.println("Nhap Email : ");
        email = scan.nextLine();
        System.out.println("Nhap Dia Chi :");
        address = scan.nextLine();
        System.out.println("Nhap So Dien Thoai :");
        phone = scan.nextLine();
        System.out.println("Nhap Lop Hoc :");
        classObj = scan.nextLine();
    }


    public void show() {
        System.out.println(this);
    }


    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", fullName='" + fullName + '\'' +
                ", birth='" + birth + '\'' +
                ", gender='" + gender + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", phone=" + phone + '\'' +
                ", classObj='" + classObj + '\'' +
                '}';
    }
}
