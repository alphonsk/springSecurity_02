package com.george.springSecurity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
//@RequestMapping("/home")
public class HomeController {

    @GetMapping
    public String home(){
        return "user/home";
    }

    @GetMapping("/all")
    public String allUsers(){
        return "user/all-users";
    }

    @GetMapping("/logged")
    public String loggedUsers(){
        return "user/logged-users";
    }

    @GetMapping("/user")
    public String user(){
        return "user/users";
    }

    @GetMapping("/user1")
    public String user1(){
        return "user/users1";
    }

    @GetMapping("/user2")
    public String user2(){
        return "user/users2";
    }

    @GetMapping("/admin")
    public String admin(){
        return "user/admin-users";
    }

    @GetMapping("/admin1")
    public String admin1(){
        return "user/admin1";
    }

    @GetMapping("/admin2")
    public String admin2(){
        return "user/admin2";
    }
    // end
}
