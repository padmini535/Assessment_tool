package com.datazap.module.auth.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.datazap.module.auth.dto.RegisterRequest;
import com.datazap.module.auth.entity.User;
import com.datazap.module.auth.repository.UserRepository;
import java.util.Optional;
import com.datazap.module.auth.dto.LoginRequest;

import org.springframework.security.crypto.password.PasswordEncoder;

import com.datazap.security.JwtService;

@Service
public class AuthService {

 @Autowired
private JwtService jwtService;

@Autowired
private PasswordEncoder passwordEncoder;

   @Autowired
   private UserRepository userRepository;


   public User register(RegisterRequest request) {


       User user = new User();


       user.setName(request.getName());
       user.setEmail(request.getEmail());
user.setPassword(
        passwordEncoder.encode(
                request.getPassword()));
                       user.setRole(request.getRole());


       return userRepository.save(user);
   }


  public String login(LoginRequest request){

    Optional<User> user =
            userRepository.findByEmail(
                    request.getEmail());

    if(user.isPresent() &&
       passwordEncoder.matches(
               request.getPassword(),
               user.get().getPassword())){

        return jwtService.generateToken(
                user.get().getEmail());
    }

    return "Invalid Credentials";
}




}
