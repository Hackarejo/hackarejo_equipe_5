package com.hackarejo.divulgarejo.vo;

import com.google.gson.annotations.SerializedName;
import com.hackarejo.divulgarejo.helper.WebAddressable;

/**
 * Created by Bruno Casali on 21/04/2015.
 */
public class LocationVO implements WebAddressable {

    @SerializedName("api_id")
    private int apiId;
    private Long longitude;
    private Long latitude;
    private PersonVO person;

    public int getApiId() {
        return apiId;
    }

    public void setApiId(int apiId) {
        this.apiId = apiId;
    }

    public PersonVO getPerson() {
        return person;
    }

    public void setPerson(PersonVO person) {
        this.person = person;
    }

    public Long getLongitude() {
        return longitude;
    }

    public void setLongitude(Long longitude) {
        this.longitude = longitude;
    }

    public Long getLatitude() {
        return latitude;
    }

    public void setLatitude(Long latitude) {
        this.latitude = latitude;
    }

    @Override
    public String getPath() {
        return "location/";
    }


    @Override
    public Boolean hasId() {
        return getApiId() > 0;
    }

    @Override
    public int getId() {
        return getApiId();
    }
}
