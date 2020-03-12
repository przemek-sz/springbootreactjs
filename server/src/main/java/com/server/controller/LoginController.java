package com.server.controller;

import org.springframework.web.bind.annotation.*;
import java.security.Principal;

@RestController
public class LoginController {

    @PostMapping("/login")
    @ResponseBody
    public Principal login(Principal principal){

        return principal;
    }
}
