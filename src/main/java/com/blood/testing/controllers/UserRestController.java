package com.blood.testing.controllers;

import com.blood.testing.persistance.model.User;
import com.blood.testing.persistance.repos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api/v1")
public class UserRestController {

    @Autowired
    private UserRepo repository;


    @GetMapping("/detailfragment")
    @PreAuthorize("hasAnyRole('ROLE_USER','ROLE_ADMIN')")
    public List<User> getAllUser(){
        return repository.findAll();
    }

    @GetMapping("/detailfragment/{id}")
    @PreAuthorize("hasAnyRole('ROLE_USER','ROLE_ADMIN')")
    public Optional<User> getUserByName(@PathVariable int id){

            return repository.findById(id);

    }





}
