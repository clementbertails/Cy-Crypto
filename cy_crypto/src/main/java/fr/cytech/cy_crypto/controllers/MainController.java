package fr.cytech.cy_crypto.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class MainController {
    
    @GetMapping("/")
    public String index(){
        return ("view/index");
    }

    @GetMapping("/login")
    public String login(){
        return("view/login");
    }

    @GetMapping("/register")
    public String register(){
        return("wiew/register");
    }

    // @GetMapping("/")
    // public String handleError(HttpServletRequest request) {
    //     return ("404");
    // }
}
