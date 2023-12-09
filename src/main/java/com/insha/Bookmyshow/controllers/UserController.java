package com.insha.Bookmyshow.controllers;

import com.insha.Bookmyshow.DTOs.ResponseStatus;
import com.insha.Bookmyshow.DTOs.signUpRequestDto;
import com.insha.Bookmyshow.DTOs.signUpResponseDto;
import com.insha.Bookmyshow.Model.User;
import com.insha.Bookmyshow.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class UserController {
    UserService userService;
    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }
    public signUpResponseDto signUp(signUpRequestDto request) {
        signUpResponseDto response = new signUpResponseDto();
        User user;
        try{
            user = userService.signUp(request.getEmail(),request.getPassword());
            response.setResponseStatus(ResponseStatus.SUCCESS);
            response.setUserId(user.getId());
        }catch(Exception ex){
            System.out.println("User Already Exists");
            response.setResponseStatus(ResponseStatus.ERROR);
        }
        return response;
    }

}
