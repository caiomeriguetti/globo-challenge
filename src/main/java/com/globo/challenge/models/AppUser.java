package com.globo.challenge.models;
import com.globo.challenge.repository.AppUserInMemRepository;
import com.globo.challenge.services.BeanUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;


import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Document
public class AppUser {

    @Id
    private ObjectId _id;

    private String username;
    private String password;

    private AppUserInMemRepository inMemRepository;

    @Transient
    private String status;

    public AppUser() {
        inMemRepository = BeanUtil.getBean(AppUserInMemRepository.class);
    }

    public AppUser(ObjectId _id, String username, String password) {

        this();

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

    public String setStatus(String s) {
        return this.status = s;
    }

    public String getStatus() {

        Optional<AppUserInMemory> usr = inMemRepository.findById(this.get_id());

        if (usr == null || !usr.isPresent()) {
            return null;
        }

        return usr.get().getStatus();
    }


    public String toString(){
        return "[username="+username+", status="+status+"]";
    }
}