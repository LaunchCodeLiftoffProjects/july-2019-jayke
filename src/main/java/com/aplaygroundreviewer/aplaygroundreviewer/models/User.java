package com.aplaygroundreviewer.aplaygroundreviewer.models;

public class User {

    private int userId;
    private String userName;
    private String password;
    private String email;

    public User() {
    }

    public User(String userName, String password, String email) {
        this();
        this.userName = userName;
        this.password = password;
        this.email = email;
    }

    public int getUserId() {
        return userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
