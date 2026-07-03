package com.datazap.module.auth.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import com.datazap.module.auth.dto.RegisterRequest;
import com.datazap.module.auth.entity.User;
import com.datazap.module.auth.service.AuthService;
import com.datazap.module.auth.dto.LoginRequest;




@RestController
@RequestMapping("/api/auth")
public class AuthController {


   @Autowired
   private AuthService authService;


   @PostMapping("/register")
   public User register(
           @RequestBody RegisterRequest request) {


       return authService.register(request);
   }


   @PostMapping("/login")
    public String login(
        @RequestBody LoginRequest request){


    return authService.login(request);
    }


}



