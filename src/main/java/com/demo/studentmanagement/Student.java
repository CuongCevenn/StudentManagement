package com.demo.studentmanagement;

public class Student {

    private int id, phone;
    private String fullname, birth, gender, email, address, sClass;

    public Student() {

    }

    public Student(int id, String fullname, String birth, String gender, String email, String address, int phone, String sClass) {
        this.id = id;
        this.fullname = fullname;
        this.birth = birth;
        this.gender = gender;
        this.email = email;
        this.address = address;
        this.phone = phone;
        this.sClass = sClass;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
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

    public String getsClass() {
        return sClass;
    }

    public void input() {

    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", phone=" + phone +
                ", fullname='" + fullname + '\'' +
                ", birth='" + birth + '\'' +
                ", gender='" + gender + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                '}';
    }

}
