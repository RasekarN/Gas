package com.example.gas;

public class HelperClass {

    String email;
    String username;

    public HelperClass(String email, String username, String password) {
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    String password;

    public HelperClass(String name, String email, String username, String password) {
        this.email = email;
        this.username = username;
        this.password = password;
    }

    public HelperClass() {
    }
}
