package com.example.restaraunt.mysql;

import java.sql.Date;

public class User {
    private String name;
    private String surname;
    private Date Bithd;
    private String password;

    public User(String name, String surname, Date bithd, String password) {
        this.name = name;
        this.surname = surname;
        this.Bithd = bithd;
        this.password = password;
    }

    public User() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Date getBithd() {
        return Bithd;
    }

    public void setBithd(Date bithd) {
        Bithd = bithd;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
