package fr.cytech.cy_crypto.controller;

import java.util.Map;

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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import fr.cytech.cy_crypto.modele.Role;
import fr.cytech.cy_crypto.modele.UserModel;
import fr.cytech.cy_crypto.service.UserService;

@Controller
@RequestMapping("/")
public class MainController {

    @Autowired
    private UserService userService;
    
    @GetMapping()
    public String getIndex(Model model){
        return "index";
    }

    @GetMapping("signin")
    public String getsignin(HttpServletRequest request, RedirectAttributes rAttributes){
        if (request.getSession().getAttribute("user") != null) {
            return "redirect:/home";
        }
        return "signin";
    }

    @PostMapping("signin")
    public String postSignin(@RequestParam Map<String, String> allParams, HttpServletRequest request, RedirectAttributes rAttributes){
        if (userService.allSigninParams(allParams)) {
            UserModel user = userService.get(allParams.get("login"));
            if (user == null || !BCrypt.checkpw(allParams.get("password"), user.getPassword())) {
                rAttributes.addAttribute("cannotSignin", true);
                return "redirect:/signin";
            } else {
                request.getSession().setAttribute("user", user);
                return "redirect:/home";
            }
        } else {
            rAttributes.addAttribute("invalidParams", true);
            return "redirect:/signin";
        }
    }

    @GetMapping("signup")
    public String getSignup(HttpServletRequest request, RedirectAttributes rAttributes){
        if (request.getSession().getAttribute("user") != null) {
            return "redirect:/home";
        }
        return "signup";
    }

    @PostMapping("signup")
    public String postSignup(@RequestParam Map<String, String> allParams, HttpServletRequest request, RedirectAttributes rAttributes) {
        if (!userService.existUser(allParams.get("username"), allParams.get("email"))) {
            if (userService.allSignupParams(allParams)) {
                if (!allParams.get("password").equals(allParams.get("passwordConf"))) {
                    rAttributes.addAttribute("diffPassword", true);
                    return "redirect:/signup";
                } else {
                    if (userService.checkedPassword(allParams.get("password"))) {
                        if (userService.checkedEmail(allParams.get("email"))) {
                            UserModel user = new UserModel();
                            user.setName(allParams.get("name"));
                            user.setLastName(allParams.get("lastName"));
                            user.setUsername(allParams.get("username"));
                            user.setEmail(allParams.get("email"));
                            user.setPassword(BCrypt.hashpw(allParams.get("password"), BCrypt.gensalt()));
                            user.setRole(Role.USER);
                            userService.save(user);
                            request.getSession().setAttribute("user", user);
                        } else {
                            rAttributes.addAttribute("incorrectEmail", true);
                            return "redirect:/signup";
                        }
                    } else {
                        rAttributes.addAttribute("weakPassword", true);
                        return "redirect:/signup";
                    }
                }
            } else {
                rAttributes.addAttribute("invalidParams", true);
                return "redirect:/signup";
            }
        } else {
            // user already exist
            rAttributes.addAttribute("existUser", true);
            return "redirect:/signup";
        }
        return "redirect:/home";
    }

    @GetMapping("signout")
    public String signout(HttpServletRequest request) {
        HttpSession session = request.getSession();
		// destroy session
		session.invalidate();
		return "redirect:/";
    }

    @GetMapping("404")
    public String error404() {
        return "404";
    }
}
