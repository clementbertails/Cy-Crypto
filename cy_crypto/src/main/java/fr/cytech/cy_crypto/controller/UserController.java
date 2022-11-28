package fr.cytech.cy_crypto.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import fr.cytech.cy_crypto.service.UserService;

@Controller
@RequestMapping("/home")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping()
    public String userHome(HttpServletRequest request, RedirectAttributes rAttributes){
        if (request.getSession().getAttribute("user") == null) {
            rAttributes.addAttribute("notLogged", true);
            return "redirect:/signin";
        } else {
            return "user_home";
        }
    }

    @GetMapping("/favourites")
    public String userFavourites(HttpServletRequest request, RedirectAttributes rAttributes){
        if (request.getSession().getAttribute("user") == null) {
            rAttributes.addAttribute("notLogged", true);
            return "redirect:/signin";
        } else {
            return "user_home";
        }
    }

    @PostMapping("/favourites")
    public String addFavourite(HttpServletRequest request, RedirectAttributes rAttributes){
        if (request.getSession().getAttribute("user") == null) {
            rAttributes.addAttribute("notLogged", true);
            return "redirect:/signin";
        } else {
            return "redirect:/home/favourites";
        }
    }

    @GetMapping("/mail")
    public String getMail(HttpServletRequest request, RedirectAttributes rAttributes){
        if (request.getSession().getAttribute("user") == null) {
            rAttributes.addAttribute("notLogged", true);
            return "redirect:/signin";
        } else {
            return "mailbox";
        }
    }

    @PostMapping("/mail")
    public String sendMail(HttpServletRequest request, RedirectAttributes rAttributes){
        if (request.getSession().getAttribute("user") == null) {
            rAttributes.addAttribute("notLogged", true);
            return "redirect:/signin";
        } else {
            return "redirect:/user/mailbox";
        }
    }

    @GetMapping("/manage")
    public String manageInformations(HttpServletRequest request, RedirectAttributes rAttributes){
        if (request.getSession().getAttribute("user") == null) {
            rAttributes.addAttribute("notLogged", true);
            return "redirect:/signin";
        } else {
            return "manage_info";   
        }
    }

}
