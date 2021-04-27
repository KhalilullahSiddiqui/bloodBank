package com.blood.testing.controllers;

import com.blood.testing.persistance.model.Role;
import com.blood.testing.persistance.model.User;
import com.blood.testing.persistance.repos.RoleRepos;
import com.blood.testing.persistance.repos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

@Controller
public class UserController {

    @Autowired
    UserRepo userRepo;
    @Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
    RoleRepos roleRepos;
    @GetMapping("/login")
    public String login(){
        return "login";
    }

    @GetMapping("/showReg")
    public String showRegistrationPage(){
        return "RegisterDonor";
    }

    @PostMapping("/registerDonor")
    public String registerDonor(User user){
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        List<Role> role = Arrays.asList(roleRepos.findByRoleName("ROLE_USER"));
        Set<Role> targetRole;
        targetRole = Set.copyOf(role);
        user.setRoles(targetRole);
        userRepo.save(user);
        return "login";
    }

  
  
}
