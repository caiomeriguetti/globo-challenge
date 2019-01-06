package com.globo.challenge.services;

import com.globo.challenge.models.AppUser;

public interface AppUserService {
    public AppUser getUserByUsername(String username);
    public void setUserStatus(String id, String status);
}
