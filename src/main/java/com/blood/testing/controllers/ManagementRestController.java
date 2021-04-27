package com.blood.testing.controllers;

import com.blood.testing.persistance.model.Role;
import com.blood.testing.persistance.model.User;
import com.blood.testing.persistance.repos.RoleRepos;
import com.blood.testing.persistance.repos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@RestController
@RequestMapping("/management/api/v1/")
public class ManagementRestController {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private RoleRepos roleRepos;

    @GetMapping("/detailfragment")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public List<User> getAllUser(){
        return userRepo.findAll();
    }

    @GetMapping("/detailfragment/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public Optional<User> getUserByName(@PathVariable int id){

        return userRepo.findById(id);

    }

    @PostMapping("/detailfragment")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String registerUser(@RequestBody User user){
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        List<Role> role = Arrays.asList(roleRepos.findByRoleName("ROLE_USER"));
        Set<Role> targetRole = Set.copyOf(role);
        user.setRoles(targetRole);
        userRepo.save(user);
        return "The User is created successfully";
    }
    @PutMapping("/detailfragment/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String updateUser(@PathVariable int id,@RequestBody User user){
        List<Role> role = Arrays.asList(roleRepos.findByRoleName("ROLE_USER"));
        Set<Role> targetRole = Set.copyOf(role);
        user.setRoles(targetRole);
        user.setId(id);
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        userRepo.save(user);
        return "The User is updated";
    }

    @DeleteMapping("/detailfragment/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String deleteUser(@PathVariable int id){
        userRepo.deleteById(id);
        return "The User is deleted";
    }


}
