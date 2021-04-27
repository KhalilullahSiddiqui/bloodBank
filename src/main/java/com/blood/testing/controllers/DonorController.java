package com.blood.testing.controllers;

import com.blood.testing.persistance.model.Role;
import com.blood.testing.persistance.model.User;
import com.blood.testing.persistance.repos.RoleRepos;
import com.blood.testing.persistance.repos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

@Controller
public class DonorController {
    @Autowired
    UserRepo userRepo;
    @Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
    RoleRepos roleRepos;


    @GetMapping("/showAddNewDonor")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_USER')")
    public String showAddNewDonor(){
        return "addNewDonor";
    }

    @PostMapping("/saveDonor")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_USER')")
    public String saveDonor(User user){
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        List<Role> role = Arrays.asList(roleRepos.findByRoleName("ROLE_USER"));
        Set<Role> targetRole;
        targetRole = Set.copyOf(role);
        user.setRoles(targetRole);
        userRepo.save(user);
        return "index";
    }

    @GetMapping("/showGetDonor")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_USER')")
    public String showGetDonor(){
        return "showGetDonor";
    }

    @PostMapping("/getDonor")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_USER')")
    public ModelAndView getDonor(String name){
        ModelAndView mav = new ModelAndView("donorDetails");
        mav.addObject(userRepo.findByFullName(name));
        return mav;
    }


    @GetMapping("/showAllDonors")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_USER')")
    public ModelAndView donorDetails(){
        ModelAndView mav = new ModelAndView("listDonorDetails");
         mav.addObject("donors",userRepo.findAll());
        return mav;
    }

}
