package fr.cytech.cy_crypto.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@ComponentScan(basePackages = { "cy_crypto" })
public class UserController {
    

    @GetMapping(value = "/user")
    public String test(HttpServletRequest request,
                       Model model){
        if (request.getSession().getAttribute("user") == null) {
            model.addAttribute("notLogged", true);
            return "signin";
        }
        return "user_home";
    }
}
