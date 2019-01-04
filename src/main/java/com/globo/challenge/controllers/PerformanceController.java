package com.globo.challenge.controllers;

import com.globo.challenge.models.AppUser;
import com.globo.challenge.repository.AppUserRepository;
import com.globo.challenge.services.AppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class PerformanceController {

    @RequestMapping("/public/sleep")
    public String sleep() throws InterruptedException {

        Thread.sleep(20000);

        return "Ok";
    }
}
