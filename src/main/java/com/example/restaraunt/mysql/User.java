package com.example.restaraunt.mysql;

public class User {
    private String name;
    private String surname;
    private String Bithd;
    private String password;

    public User(String name, String surname, String bithd, String password) {
        this.name = name;
        this.surname = surname;
        Bithd = bithd;
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

    public String getBithd() {
        return Bithd;
    }

    public void setBithd(String bithd) {
        Bithd = bithd;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
