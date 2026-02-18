package com.bank.model;

import com.bank.util.IDGenerator;

public class User {
    private String userId;
    private String name;
    private String mobileNo ;
    private String address;
    private String email;
    IDGenerator id = new IDGenerator();
        //constructor
    public User(String name, String mobileNo, String address, String email) {
        this.name = name;
        this.mobileNo = mobileNo;
        this.address = address;
        this.email = email;
        this.userId = id.generateUserId();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId='" + userId + '\'' +
                ", name='" + name + '\'' +
                ", mobileNo='" + mobileNo + '\'' +
                ", address='" + address + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

}
