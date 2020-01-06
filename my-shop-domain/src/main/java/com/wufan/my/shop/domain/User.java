package com.wufan.my.shop.domain;

import java.io.Serializable;

/**
 * @author ：WuFan
 * @date ：Created in 2019/11/16 0016 21:51
 * @description：
 * @modified By：
 * @version: $
 */
public class User implements Serializable {
    private String email;
    private String password;
    private String username;

    public boolean isRemember() {
        return isRemember;
    }

    public void setRemember(boolean remember) {
        isRemember = remember;
    }

    private boolean isRemember;

    public User() {
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return "User{" +
                "email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", username='" + username + '\'' +
                '}';
    }
}
