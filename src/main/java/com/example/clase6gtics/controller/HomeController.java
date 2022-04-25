package com.example.clase6gtics.controller;

import com.example.clase6gtics.entity.UsuarioSession;
import com.example.clase6gtics.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import java.net.http.HttpRequest;

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

    @Autowired
    UsuarioRepository usuarioRepository;

    @GetMapping("/redirectByRole")
    public String redirectByRole(Authentication auth, RedirectAttributes attributes,
                                 HttpSession session){

        String role = "";
        for (GrantedAuthority authority : auth.getAuthorities()) {
            role = authority.getAuthority();
            break;
        }

        //auth -> username (p.e. oscar.diaz@gmail) / rol (p.e. admin)

        UsuarioSession usuario = usuarioRepository.findByEmail(auth.getName());
        session.setAttribute("usuario",usuario);

        if(role.equals("admin")){
            return "redirect:/shipper";
        }else{
            return "redirect:/employee";
        }

    }
}

