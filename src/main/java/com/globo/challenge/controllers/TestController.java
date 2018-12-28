package com.globo.challenge.controllers;

import com.globo.challenge.services.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class TestController {

    @Autowired
    TestService testService;

    @RequestMapping("/hello")
    public Map hello() {

        testService.testMethod();

        HashMap<String, String>  response = new HashMap<>();

        response.put("prop", "YY");

        return response;
    }
}
