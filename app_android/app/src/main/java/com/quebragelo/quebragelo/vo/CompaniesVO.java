package com.quebragelo.quebragelo.vo;

/**
 * Created by Luis Gustavo on 16/04/2016.
 */
public class CompaniesVO {

    private int companiesId;

    private String name;

    private String phone;

    private String latitude;

    private String longitude;

    private UserVO users;

    public UserVO getUsers() {
        return users;
    }

    public void setUsers(UserVO users) {
        this.users = users;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public int getId() {
        return companiesId;
    }

    public void setId(int id) {
        this.companiesId = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }
}
