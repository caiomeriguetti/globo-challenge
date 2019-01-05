package com.globo.challenge.controllers;

import com.globo.challenge.models.AppUser;
import com.globo.challenge.models.AppUserInMemory;
import com.globo.challenge.repository.AppUserRepository;
import com.globo.challenge.services.AppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
public class UserController {

    @Autowired
    AppUserService appUserService;

    @RequestMapping(value = "/api/user/{username}", method = RequestMethod.GET)
    public AppUser getUserByUsername(@PathVariable("username") String username) {

        AppUser usr = appUserService.getUserByUsername(username);
        System.out.println(usr.getStatus());
        return usr;
    }

    @RequestMapping(value = "/api/user/{username}/status", method = RequestMethod.PUT)
    public boolean setUserStatus(@PathVariable("username") String username,
                                     @RequestParam("status") String status) {

        return appUserService.setUserStatus(username, status);
    }
}
