package com.globo.challenge.services.impl;

import com.globo.challenge.models.AppUser;
import com.globo.challenge.models.AppUserInMemory;
import com.globo.challenge.repository.AppUserInMemRepository;
import com.globo.challenge.repository.AppUserRepository;
import com.globo.challenge.services.AppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AppUserServiceImpl implements AppUserService {

    @Autowired
    AppUserRepository appUserRepository;

    @Autowired
    AppUserInMemRepository appUserInMemoryRepository;

    @Override
    public AppUser getUserByUsername(String username) {

        AppUser usr = appUserRepository.findByUsername(username);

        return usr;
    }

    @Override
    public boolean setUserStatus(String username, String status){

        AppUser usr = appUserRepository.findByUsername(username);

        AppUserInMemory usrmem = new AppUserInMemory();
        usrmem.setId(usr.get_id());
        usrmem.setStatus(status);

        appUserInMemoryRepository.save(usrmem);

        return true;
    }


}
