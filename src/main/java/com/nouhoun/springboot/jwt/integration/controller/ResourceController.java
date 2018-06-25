package com.nouhoun.springboot.jwt.integration.controller;

import com.nouhoun.springboot.jwt.integration.domain.PasswordChangeRequest;
import com.nouhoun.springboot.jwt.integration.domain.RandomCity;
import com.nouhoun.springboot.jwt.integration.domain.User;
import com.nouhoun.springboot.jwt.integration.repository.UserRepository;
import com.nouhoun.springboot.jwt.integration.service.GenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by nydiarra on 06/05/17.
 */
@RestController
@RequestMapping("/springjwt")
public class ResourceController {
    @Autowired
    private GenericService userService;

    @RequestMapping(value ="/cities")
    @PreAuthorize("hasAuthority('ADMIN_USER') or hasAuthority('STANDARD_USER')")
    public List<RandomCity> getUser(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = authentication.getName();
        System.out.println("Logged in user = " + currentPrincipalName);
        return userService.findAllRandomCities();
    }

    @RequestMapping(value ="/users", method = RequestMethod.GET)
    @PreAuthorize("hasAuthority('ADMIN_USER')")
    public List<User> getUsers(){
        return userService.findAllUsers();
    }
    
    @RequestMapping(value ="/changepassword", method = RequestMethod.POST, consumes = "application/json")
    @PreAuthorize("hasAuthority('STANDARD_USER')")
    public String changePassword(@RequestBody PasswordChangeRequest passwordChangeRequest){
        int responseCode = 0;
        String responseMessage = "OK";
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = authentication.getName();
        User user = userService.findByUsername(currentPrincipalName);
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        if (! encoder.matches(passwordChangeRequest.getOldPassword(), user.getPassword()))
        {
            responseCode = -1;
            responseMessage = "Old password does not match!";
            return responseCode + "," + responseMessage;
        }
        user.setPassword(encoder.encode(passwordChangeRequest.getNewPassword()));
        userService.saveUser(user);
        return responseCode + "," + responseMessage;
    }

}
