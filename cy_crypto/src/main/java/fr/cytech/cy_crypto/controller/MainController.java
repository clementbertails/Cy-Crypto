package fr.cytech.cy_crypto.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import fr.cytech.cy_crypto.modele.Role;
import fr.cytech.cy_crypto.modele.UserModel;
import fr.cytech.cy_crypto.service.UserService;

@Controller
@RequestMapping("/")
public class MainController {

    @Autowired
    private UserService userService;
    
    @GetMapping()
    public String getIndex(){
        return "index";
    }

    @GetMapping("signin")
    public String getsignin(HttpServletRequest request){
        if (request.getSession().getAttribute("user") != null) {
            
            return "redirect:/home";
        }
        return "signin";
    }

    @PostMapping("signin")
    public String postSignin(@RequestParam String login,
                             @RequestParam String password,
                             HttpServletRequest request,
                             Model model){
        UserModel user = userService.get(login);
        if (user == null || !BCrypt.checkpw(password, user.getPassword())) {
            model.addAttribute("cannotSignin", true);
            return "signin";
        } else {
            request.getSession().setAttribute("user", user);
        }
        return "redirect:/home";
    }

    @GetMapping("register")
    public String getRegister(HttpServletRequest request){
        if (request.getSession().getAttribute("user") != null) {
            return "redirect:/home";
        }
        return "register";
    }

    @PostMapping("register")
    public String postRegister(@RequestParam String name,
                               @RequestParam String lastName,
                               @RequestParam String username,
                               @RequestParam String email,
                               @RequestParam String password,
                               @RequestParam String passwordConf,
                               HttpServletRequest request,
                               Model model) {
        if (!userService.existUser(username, email)) {
            if (!password.equals(passwordConf)) {
                model.addAttribute("diffPassword", true);
                return "register";
            } else {
                if (userService.checkedPassword(password)) {
                    if (userService.checkedEmail(email)) {
                        UserModel user = new UserModel();
                        user.setName(name);
                        user.setLastName(lastName);
                        user.setUsername(username);
                        user.setEmail(email);
                        user.setPassword(BCrypt.hashpw(password, BCrypt.gensalt()));
                        user.setRole(Role.USER);
                        userService.save(user);
                        request.getSession().setAttribute("user", user);
                    } else {
                        model.addAttribute("incorrectEmail", true);
                        return "register";
                    }
                } else {
                    model.addAttribute("weakpassword", true);
                    return "register";
                }
            }
        } else {
            // user already exist
            model.addAttribute("existUser", true);
            return "register";
        }
        return "redirect:/home";
    }

    @GetMapping("signout")
    public String signout(HttpServletRequest request) {
        HttpSession session = request.getSession(true);
		// destroy session
		session.invalidate();
		return "redirect:/";
    }

    @GetMapping("404")
    public String error404() {
        return "404";
    }
}
