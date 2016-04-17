package com.hackarejo.divulgarejo.vo;

import com.google.gson.annotations.SerializedName;
import com.hackarejo.divulgarejo.helper.WebAddressable;

import java.util.Date;

/**
 * Created by Bruno Casali on 21/04/2015.
 */
public class StatusVO implements WebAddressable {

    @SerializedName("api_id")
    private int apiId;
    private PersonVO person;
    private Date last;
    private Date lastLogged;

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

    public Date getLast() {
        return last;
    }

    public void setLast(Date last) {
        this.last = last;
    }

    public Date getLastLogged() {
        return lastLogged;
    }

    public void setLastLogged(Date lastLogged) {
        this.lastLogged = lastLogged;
    }

    @Override
    public String getPath() {
        return "statuses/";
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
