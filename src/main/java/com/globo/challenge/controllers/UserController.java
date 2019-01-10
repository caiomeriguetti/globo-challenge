package com.globo.challenge.controllers;

import com.globo.challenge.services.AppUserService;
import com.globo.challenge.models.AppUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.async.DeferredResult;
import org.springframework.web.server.ResponseStatusException;

import java.util.concurrent.ForkJoinPool;


@RestController
public class UserController {

    @Autowired
    AppUserService appUserService;

    @RequestMapping(value = "/public/ping", method = RequestMethod.GET)
    public DeferredResult<String> getUserByUsername() {

        DeferredResult<String> result = new DeferredResult<>(2000l);

        ForkJoinPool.commonPool().submit(() -> {

            result.setResult("Pong");
        });

        return result;
    }

    @RequestMapping(value = "/api/user/{username}", method = RequestMethod.GET)
    public DeferredResult<AppUser> getUserByUsername(@PathVariable("username") String username) {

        DeferredResult<AppUser> result = new DeferredResult<>(2000l);

        ForkJoinPool.commonPool().submit(() -> {

            AppUser usr = appUserService.getUserByUsername(username);

            if (usr == null){
                result.setErrorResult(new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "User not found"));
            }

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
