package com.jdbcauthentication.authentication;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthenticationController {
    
    @GetMapping("/")
    public String home(){
        return "<h1>Please login</h1>";
    }
    @GetMapping("/user")
    public String user(){
        return "<h1>Welcome User</h1>";
    }
    @GetMapping("/admin")
    public String admin(){
        return "<h1>Welcome Admin</h1>";
    }
}
