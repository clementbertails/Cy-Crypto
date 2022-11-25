package fr.cytech.cy_crypto.controller;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@ComponentScan(basePackages = { "cy_crypto" })
public class UserController {
    

    @GetMapping(value = "/user")
    public String test(){
        return("user_pannel");
    }
}
