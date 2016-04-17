package com.hackarejo.divulgarejo.vo;

import android.net.Uri;
import com.google.gson.annotations.SerializedName;
import com.hackarejo.divulgarejo.helper.JSONSerializer;
import com.hackarejo.divulgarejo.helper.WebAddressable;

import java.util.Date;

/**
 * Created by Bruno Casali on 21/04/2015.
 */
public class PersonVO extends JSONSerializer implements WebAddressable {

    @SerializedName("id")
    private int apiId;
    private String bio;
    @SerializedName("birthday_at")
    private Date birthdayAt;
    private String email;
    @SerializedName("user_id")
    private String userId;
    private String image;
    private String phone;
    private LocationVO location;
    private String name;
    private StatusVO status;
    @SerializedName("fb_access_token")
    private String fbAccessToken;

    public int getApiId() {
        return apiId;
    }

    public void setApiId(int apiId) {
        this.apiId = apiId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userID) {
        this.userId = userID;
    }

    public String getFbAccessToken() {
        return fbAccessToken;
    }

    public void setFbAccessToken(String fbAccessToken) {
        this.fbAccessToken = fbAccessToken;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public Date getBirthdayAt() {
        return birthdayAt;
    }

    public void setBirthdayAt(Date birthdayAt) {
        this.birthdayAt = birthdayAt;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocationVO getLocation() {
        return location;
    }

    public void setLocation(LocationVO location) {
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public StatusVO getStatus() {
        return status;
    }

    public void setStatus(StatusVO status) {
        this.status = status;
    }

    // type could be: square, small, normal, large see Constraint class.
    public Uri getImageLink(String type){
        return Uri.parse("https://graph.facebook.com" + getImage() + "?type=" + type);
    }

    @Override
    public String getPath() {
        return "people/";
    }

    @Override
    public Boolean hasId() {
        return getApiId() > 0;
    }

    @Override
    public int getId() {
        return getApiId();
    }

    @Override
    public String getSerializerKey() {
        return "person";
    }
}
