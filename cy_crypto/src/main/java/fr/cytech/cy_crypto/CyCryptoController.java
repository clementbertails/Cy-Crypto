package fr.cytech.cy_crypto;

import javax.annotation.Generated;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CyCryptoController {
    
    @GetMapping("/")
    public ModelAndView getIndex(){
        String viewName = "Cy-Crypto";

        return
    }

    @GetMapping("/login")
    public ModelAndView getlogin(){
        return "Login page";
    }
}
