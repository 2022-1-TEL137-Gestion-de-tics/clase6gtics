package com.example.clase6gtics.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping("/")
    public String index() {
        return "redirect:/product";
    }

    @GetMapping("/loginForm")
    public String loginForm(){
        return "login/form";
    }

    @GetMapping("/redirectByRole")
    public String redirectByRole(Authentication auth){

        String role = "";
        for (GrantedAuthority authority : auth.getAuthorities()) {
            role = authority.getAuthority();
            break;
        }

        if(role.equals("admin")){
            return "redirect:/shipper";
        }else{
            return "redirect:/employee";
        }


    }
}

