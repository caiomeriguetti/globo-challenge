package com.globo.challenge.models;

import org.springframework.data.redis.core.RedisHash;

@RedisHash("AppUserInMemory")
public class AppUserInMemory {
    private String status;
    private String id;

    public String getStatus(){
        return this.status;
    }

    public void setStatus(String status){
        this.status = status;
    }

    public String getId(){
        return id;
    }

    public void setId(String id){
        this.id = id;
    }

}
