package com.george.springSecurity.controller;

import com.george.springSecurity.model.UserAccount;
import com.george.springSecurity.repository.AccountRepository;
import com.george.springSecurity.service.UserAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/register")
public class SecurityController {

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    UserAccountService userAccountService;

    @GetMapping
    public String register(Model model){
        UserAccount userAccount = new UserAccount();
        model.addAttribute("userAccount", userAccount);

        List<UserAccount> users = userAccountService.getAll();
        model.addAttribute("users", users);
        return "security/register";
    }

    @PostMapping("save")
    public String saveUser(Model model, UserAccount user){
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        userAccountService.save(user);
        return "redirect:/register";
    }

//    @GetMapping("/home")
//    public String home(){
//        return "user/home";
//    }


    //
}
