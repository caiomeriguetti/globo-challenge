package com.globo.challenge.models;

import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Test {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
