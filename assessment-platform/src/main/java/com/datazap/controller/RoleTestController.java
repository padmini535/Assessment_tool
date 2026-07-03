package com.datazap.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RoleTestController {

    @GetMapping("/api/admin/test")
    public String admin() {
        return "ADMIN ACCESS SUCCESS";
    }

    @GetMapping("/api/candidate/test")
    public String candidate() {
        return "CANDIDATE ACCESS SUCCESS";
    }
}