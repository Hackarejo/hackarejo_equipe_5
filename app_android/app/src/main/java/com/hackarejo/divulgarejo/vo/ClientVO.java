package com.hackarejo.divulgarejo.vo;

/**
 * Created by Ezequiel on 16/04/2016.
 */
public class ClientVO {

    private int clientsId;

    private UserVO users;

    public int getClientsId() {
        return clientsId;
    }

    public void setClientsId(int clientsId) {
        this.clientsId = clientsId;
    }

    public UserVO getUser() {
        return users;
    }

    public void setUser(UserVO user) {
        this.users = user;
    }
}
