package fr.cytech.cy_crypto.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import fr.cytech.cy_crypto.modele.Role;
import fr.cytech.cy_crypto.modele.UserModel;
import fr.cytech.cy_crypto.service.UserService;

@Controller
public class MainController {

    @Autowired
    private UserService userService;
    
    @GetMapping(value="/")
    public String index(){
        return ("index");
    }

    @GetMapping(value="/signin")
    public String getsignin(){
        return("signin");
    }

    @PostMapping(value="/signin")
    public String signin(){
        // TODO check on db the informations
        //      redirect to home page
        //      set Session
        return null;
    }

    @GetMapping(value="/register")
    public String register(){
        return("register");
    }

    public boolean existUser(String username, String email) {
        return userService.get(username) == null && userService.get(email) == null;
    }

    @PostMapping(value="/register")
    public String postRegister(@RequestParam String name,
                               @RequestParam String lastName,
                               @RequestParam String username,
                               @RequestParam String email,
                               @RequestParam String password,
                               @RequestParam String passwordConf,
                               Model model) {
        if (password.equals(passwordConf)) {
            model.addAttribute("diffPassword", false);
            if (existUser(username, email)) {
                // user already exist
                model.addAttribute("existUser", true);
            } else {
                model.addAttribute("existUser", false);
                UserModel user = new UserModel();
                user.setName(name);
                user.setLastName(lastName);
                user.setUsername(username);
                user.setEmail(email);
                user.setPassword(BCrypt.hashpw(password, BCrypt.gensalt()));
                user.setRole(Role.USER);
                userService.save(user);
            }
        } else {
            model.addAttribute("diffPassword", true);
        }
        return "redirect:/";
    }

    @GetMapping(value="/signout")
    public String signout(HttpServletRequest request) {
        HttpSession session = request.getSession(true);
		// destroy session
		session.invalidate();
		return "redirect:/";
    }

    @GetMapping("/404")
    public String error404() {
        return ("404");
    }
}
