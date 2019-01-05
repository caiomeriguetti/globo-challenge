package com.globo.challenge.controllers;

import com.globo.challenge.models.AppUser;
import com.globo.challenge.repository.AppUserRepository;
import com.globo.challenge.services.AppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class UserController {

    @Autowired
    AppUserService appUserService;

    @RequestMapping("/api/user/{username}")
    public AppUser getUserByUsername(@PathVariable("username") String username) {

        AppUser usr = appUserService.getUserByUsername(username);
        System.out.println(usr.getStatus());
        return usr;
    }
}
