package com.globo.challenge.services.impl;

import com.globo.challenge.models.AppUser;
import com.globo.challenge.repository.AppUserRepository;
import com.globo.challenge.services.AppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AppUserServiceImpl implements AppUserService {

    @Autowired
    AppUserRepository appUserRepository;

    @Override
    public AppUser getUserByUsername(String username) {

        AppUser usr = appUserRepository.findByUsername(username);

        return usr;
    }
}
