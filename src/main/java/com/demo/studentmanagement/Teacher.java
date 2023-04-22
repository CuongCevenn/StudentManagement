package com.demo.studentmanagement;

public class Teacher {
    private String id;
    private String fullname;
    private String birth;
    private String gender;
    private String email;
    private String address;
    private String phone;
    private String quali;
    private String exper;
    private String achie;

    public Teacher() {

    }

    public Teacher(String id, String fullname, String birth, String gender, String email, String address,
                   String phone, String quali, String exper, String achie) {
        this.id = id;
        this.fullname = fullname;
        this.birth = birth;
        this.gender = gender;
        this.email = email;
        this.address = address;
        this.phone = phone;
        this.quali = quali;
        this.exper = exper;
        this.achie = achie;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getQuali() {
        return quali;
    }

    public void setQuali(String quali) {
        this.quali = quali;
    }

    public String getExper() {
        return exper;
    }

    public void setExper(String exper) {
        this.exper = exper;
    }

    public String getAchie() {
        return achie;
    }

    public void setAchie(String achie) {
        this.achie = achie;
    }
}
