package com.globo.challenge.controllers;

import com.globo.challenge.models.AppUser;
import com.globo.challenge.models.AppUserInMemory;
import com.globo.challenge.repository.AppUserInMemRepository;
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

    @Autowired
    AppUserRepository repo;

    @RequestMapping("/api/user/{username}")
    public AppUser getUserById(@PathVariable("username") String username) {

        AppUser usr = appUserService.getUserByUsername(username);
        System.out.println(usr.getStatus());
        return usr;
    }

    @RequestMapping("/public/test")
    public AppUser test() {

        AppUser usr = repo.findById("5c298b3e08813b0001fb4e0b").get();

        System.out.println(usr);

        return usr;
    }
}
