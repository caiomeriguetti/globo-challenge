package com.globo.challenge.models;

import org.springframework.data.mongodb.core.mapping.Document;


import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

@Document
public class AppUser {

    @Id
    private ObjectId _id;

    private String username;
    private String password;
    private String status;


    public AppUser() {}

    public AppUser(ObjectId _id, String username, String password) {
        this._id = _id;
        this.username = username;
        this.password = password;
    }

    public void set_id(ObjectId _id) {
        this._id = _id;
    }

    public String get_id() {
        return this._id.toHexString();
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public String getStatus() {
        return status;
    }
}