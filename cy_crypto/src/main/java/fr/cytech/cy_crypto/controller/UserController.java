package fr.cytech.cy_crypto.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import fr.cytech.cy_crypto.service.UserService;

@Controller
@RequestMapping("/home")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping()
    public String userHome(HttpServletRequest request,
                           Model model){
        return userService.isLogged(request, model, "user_home");
    }

    @GetMapping("/favourites")
    public String userFavourites(HttpServletRequest request,
                                 Model model){
        return userService.isLogged(request, model, "favourite_currency");
    }

    @PostMapping("/favourites")
    public String addFavourite(HttpServletRequest request, Model model) {
        return "favourites";
    }

    @GetMapping("/mail")
    public String getMail(HttpServletRequest request,
                          Model model){
        return userService.isLogged(request, model, "mailbox");
    }

    @PostMapping("/mail")
    public String sendMail(HttpServletRequest request,
                           Model model){
        return "mail";
    }

    @GetMapping("/manage")
    public String manageInformations(HttpServletRequest request, Model model) {
        return userService.isLogged(request, model, "manageInformation");
    }

}
