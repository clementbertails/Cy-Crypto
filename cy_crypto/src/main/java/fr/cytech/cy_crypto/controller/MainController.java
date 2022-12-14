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

import fr.cytech.cy_crypto.model.User;
import fr.cytech.cy_crypto.services.CurrencyService;
import fr.cytech.cy_crypto.services.UserService;

@Controller
@RequestMapping("/")
public class MainController {

    @Autowired
    private UserService userService;

    @Autowired
    private CurrencyService currencyService;

    @GetMapping()
    public String getIndex(Model model){
        model.addAttribute("currency", currencyService.find("BTC"));
        model.addAttribute("currencies", currencyService.findAll());
        return "index";
    }

    @GetMapping("signin")
    public String getsignin(HttpServletRequest request, RedirectAttributes rAttributes){
        if (request.getSession().getAttribute("user") != null) {
            return "redirect:/user/home";
        }
        return "signin";
    }

    @PostMapping("signin")
    public String postSignin(@RequestParam Map<String, String> allParams, HttpServletRequest request, RedirectAttributes rAttributes){
        if (request.getSession().getAttribute("user") != null) {
            return "redirect:/user/home";
        }
        if (userService.allSigninParams(allParams)) {
            User user = userService.find(allParams.get("login"));
            if (user == null || !BCrypt.checkpw(allParams.get("password"), user.getPassword())) {
                rAttributes.addAttribute("cannotSignin", true);
                return "redirect:/signin";
            } else {
                request.getSession().setAttribute("user", user);
                return "redirect:/user/home";
            }
        } else {
            rAttributes.addAttribute("invalidParams", true);
            return "redirect:/signin";
        }
    }

    @GetMapping("signup")
    public String getSignup(HttpServletRequest request, RedirectAttributes rAttributes){
        if (request.getSession().getAttribute("user") != null) {
            return "redirect:/user/home";
        }
        return "signup";
    }

    @PostMapping("signup")
    public String postSignup(@RequestParam Map<String, String> allParams, HttpServletRequest request, RedirectAttributes rAttributes) {
        if (request.getSession().getAttribute("user") != null) {
            return "redirect:/user/home";
        }
        if (!userService.existUser(allParams.get("username"), allParams.get("email"))) {
            if (userService.allSignupParams(allParams)) {
                if (!allParams.get("password").equals(allParams.get("passwordConf"))) {
                    rAttributes.addAttribute("diffPassword", true);
                    return "redirect:/signup";
                } else {
                    if (userService.checkedPassword(allParams.get("password"))) {
                        if (userService.checkedEmail(allParams.get("email"))) {
                            User user = new User();
                            user.setName(allParams.get("name"));
                            user.setLastName(allParams.get("lastName"));
                            user.setUsername(allParams.get("username"));
                            user.setEmail(allParams.get("email"));
                            user.setPassword(BCrypt.hashpw(allParams.get("password"), BCrypt.gensalt()));
                            userService.save(user);
                            request.getSession().setAttribute("user", user);
                            return "redirect:/user/home";
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
