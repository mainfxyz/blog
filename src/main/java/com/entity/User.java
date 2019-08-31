package com.entity;

import java.time.LocalDate;
import java.util.List;

public class User {
    private int id;
    private String email;
    private String passwd;
    private boolean admin;
    private String name;
    private LocalDate logTime;
    private LocalDate regTime;
    private List<Review> reviews;

    public User(String email, String passwd, String name) {
        this.passwd = passwd;
        this.email = email;
        this.name = name;
        admin=false;
    }

    public User(String email, String passwd) {
        this.email = email;
        this.passwd = passwd;
        this.name = "用户名";
        admin=false;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", passwd='" + passwd + '\'' +
                ", admin=" + admin +
                ", email='" + email + '\'' +
                ", name='" + name + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    public boolean isAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getLogTime() {
        return logTime;
    }

    public void setLogTime(LocalDate logTime) {
        this.logTime = logTime;
    }

    public LocalDate getRegTime() {
        return regTime;
    }

    public void setRegTime(LocalDate regTime) {
        this.regTime = regTime;
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }
}
