package com.hackarejo.divulgarejo.vo;

/**
 * Created by Luis Gustavo on 16/04/2016.
 */
public class UserVO {

    private int usersid;

    private String email;

    private String name;

    public int getId() {
        return usersid;
    }

    public void setId(int id) {
        this.usersid = id;
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
}
