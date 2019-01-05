package com.globo.challenge.services;

import com.globo.challenge.models.AppUser;

public interface AppUserService {
    public AppUser getUserByUsername(String username);
    public boolean setUserStatus(String id, String status);
}
