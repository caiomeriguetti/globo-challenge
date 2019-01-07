package com.globo.challenge.controllers;

import com.globo.challenge.services.AppUserService;
import com.globo.challenge.models.AppUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.async.DeferredResult;

import java.util.concurrent.ForkJoinPool;


@RestController
public class UserController {

    @Autowired
    AppUserService appUserService;

    @RequestMapping(value = "/api/user/{username}", method = RequestMethod.GET)
    public DeferredResult<AppUser> getUserByUsername(@PathVariable("username") String username) {

        DeferredResult<AppUser> result = new DeferredResult<>(2000l);

        ForkJoinPool.commonPool().submit(() -> {

            AppUser usr = appUserService.getUserByUsername(username);

            result.setResult(usr);
        });

        return result;
    }

    @RequestMapping(value = "/api/user/{username}/status", method = RequestMethod.PUT)
    public String setUserStatus(@PathVariable("username") String username,
                                     @RequestParam("status") String status) {
        appUserService.setUserStatus(username, status);

        return "Done";
    }
}
