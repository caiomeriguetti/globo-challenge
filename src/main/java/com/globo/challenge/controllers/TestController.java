package com.globo.challenge.controllers;

import com.globo.challenge.models.Test;
import com.globo.challenge.repository.TestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class TestController {

    @Autowired
    TestRepository testRepository;

    @RequestMapping("/hello")
    public List hello() {
        ArrayList<Test> lst = new ArrayList<>();

        lst.add(new Test());


        Test t = new Test();
        t.setName("X");
        testRepository.insert(t);


        return lst;
    }
}
