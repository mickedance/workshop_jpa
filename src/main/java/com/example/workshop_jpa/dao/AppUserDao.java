package com.example.workshop_jpa.dao;

import com.example.workshop_jpa.entity.AppUser;

import java.util.List;
import java.util.Optional;

public interface AppUserDao {
    AppUser save(AppUser appUser);
    Optional<AppUser> findById(int id);
    List<AppUser> findAll();
    AppUser update(AppUser appUser);
    void remove(AppUser appUser);
}
