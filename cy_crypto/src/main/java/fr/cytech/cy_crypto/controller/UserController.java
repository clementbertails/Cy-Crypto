package fr.cytech.cy_crypto.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import fr.cytech.cy_crypto.model.CryptoCurrency;
import fr.cytech.cy_crypto.model.Mail;
import fr.cytech.cy_crypto.model.User;
import fr.cytech.cy_crypto.services.CurrencyService;
import fr.cytech.cy_crypto.services.MailService;
import fr.cytech.cy_crypto.services.UserService;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private MailService mailService;

    @Autowired
    private UserService userService;

    @Autowired
    private CurrencyService currencyService;

    @GetMapping("/home")
    public String userHome(HttpServletRequest request, @RequestParam Map<String, String> allParams, RedirectAttributes rAttributes, Model model){
        User user = (User) request.getSession().getAttribute("user");
        if (user == null) {
            rAttributes.addAttribute("notLogged", true);
            return "redirect:/signin";
        }
        if (allParams.get("currency") != null) {
            model.addAttribute("currency", currencyService.find(allParams.get("currency")));
        } else if (user.getFavoriteCurrencies().size() > 0) {
            model.addAttribute("currency", currencyService.find(user.getFavoriteCurrencies().get(0)));
        } else {
            model.addAttribute("currency", null);
        }
        return "user_home";
    }

    @GetMapping("/currencies")
    public String userFavoritesCrypto(HttpServletRequest request, RedirectAttributes rAttributes, Model model){
        if (request.getSession().getAttribute("user") == null) {
            rAttributes.addAttribute("notLogged", true);
            return "redirect:/signin";
        }
        model.addAttribute("currencies", currencyService.findAll());
        return "currencies";
    }

    @PostMapping(path = "/addfavoritescrypto")
    public String addFavoriteCrypto(HttpServletRequest request, RedirectAttributes rAttributes, @RequestParam String symbol){
        User user = (User) request.getSession().getAttribute("user");
        if (user == null) {
            rAttributes.addAttribute("notLogged", true);
            return "redirect:/signin";
        }
        if (symbol != null && currencyService.existsBySymbol(symbol)) {
            boolean alreadyIn = false;
            for (CryptoCurrency currency: user.getFavoriteCurrencies()) {
                if (currency.getSymbol().equals(symbol)) {
                    alreadyIn = true;
                    break;
                }
            }
            if (!alreadyIn) {
                user.getFavoriteCurrencies().add(currencyService.find(symbol));
                userService.save(user);
            }
        }
        return "redirect:/user/currencies";
    }

    @PostMapping("/removefavoritescrypto")
    public String removeFavoriteCrypto(HttpServletRequest request, RedirectAttributes rAttributes, @RequestParam String symbol){
        User user = (User) request.getSession().getAttribute("user");
        if (user == null) {
            rAttributes.addAttribute("notLogged", true);
            return "redirect:/signin";
        }
        if (symbol != null && currencyService.existsBySymbol(symbol)) {
            for (CryptoCurrency currency: user.getFavoriteCurrencies()) {
                if (currency.getSymbol().equals(symbol)) {
                    user.getFavoriteCurrencies().remove(currency);
                    userService.save(user);
                    break;
                }
            }
        }
        return "redirect:/user/currencies";
    }

    @GetMapping("/mail")
    public String getMail(HttpServletRequest request, RedirectAttributes rAttributes, Model model){
        if (request.getSession().getAttribute("user") == null) {
            rAttributes.addAttribute("notLogged", true);
            return "redirect:/signin";
        }
        User user = (User) request.getSession().getAttribute("user");
        model.addAttribute("mails", mailService.findAllByAttribute("receivers", user));
        return "mailbox";
    }

    @PostMapping("/sendmail")
    public String sendMail(@RequestParam Map<String, String> allParams, HttpServletRequest request, RedirectAttributes rAttributes){
        if (request.getSession().getAttribute("user") == null) {
            rAttributes.addAttribute("notLogged", true);
            return "redirect:/signin";
        }
        if (mailService.checkMailParams(allParams)) {
            Mail mail = new Mail();
            mail.setSubject(allParams.get("subject"));
            mail.setContent(allParams.get("content"));
            mail.setSender((User) request.getSession().getAttribute("user"));
            List<User> receivers = new ArrayList<User>();
            for(String receiverAttribute : allParams.get("receivers").split(",")) {
                User receiverUser = userService.find(receiverAttribute);
                if (receiverUser != null) {
                    receivers.add(receiverUser);
                }
            }
            if (receivers.isEmpty()) {
                rAttributes.addAttribute("errorReceiver", true);
                return "redirect:/user/mail";
            }
            mail.setReceivers(receivers);
            mail.setDate(Date.from(java.time.Instant.now()));
            mailService.save(mail);
            rAttributes.addAttribute("mailSent", true);
            return "redirect:/user/mail";
        } else {
            rAttributes.addAttribute("errorParams", true);
            return "redirect:/user/mail";
        }
    }

    @PostMapping("/deletemail")
    public String deleteMail(HttpServletRequest request, RedirectAttributes rAttributes){
        if (request.getSession().getAttribute("user") == null) {
            rAttributes.addAttribute("notLogged", true);
            return "redirect:/signin";
        }
        return "redirect:/user/mail";
    }

    @GetMapping("/manage")
    public String manageInformations(HttpServletRequest request, RedirectAttributes rAttributes, Model model){
        if (request.getSession().getAttribute("user") == null) {
            rAttributes.addAttribute("notLogged", true);
            return "redirect:/signin";
        } else {
            return "manage_info";
        }
    }

    @PostMapping("/saveInformations")
    public String manageInfos(@RequestParam Map<String, String> allParams, HttpServletRequest request, RedirectAttributes rAttributes){
        if (request.getSession().getAttribute("user") == null) {
            rAttributes.addAttribute("notLogged", true);
            return "redirect:/signin";
        } else {
            User user = (User) request.getSession().getAttribute("user");
            if (userService.allUpdateInformationsParams(allParams)) {
                if (userService.checkedEmail(allParams.get("email"))) {
                    if (userService.find(allParams.get("username")) != null && !allParams.get("username").equals(user.getUsername())) {
                        rAttributes.addAttribute("usedUsername", true);
                        return "redirect:/user/manage";
                    } else {
                        if (userService.find(allParams.get("email")) != null && !allParams.get("email").equals(user.getEmail())) {
                            rAttributes.addAttribute("usedEmail", true);
                            return "redirect:/user/manage";
                        } else {
                            user.setUsername(allParams.get("username"));
                            user.setEmail(allParams.get("email"));
                            user.setName(allParams.get("name"));
                            user.setLastName(allParams.get("lastName"));
                            userService.save(user);
                            rAttributes.addAttribute("updatedInformations", true);
                            return "redirect:/user/manage";
                        }
                    }
                } else {
                    
                    rAttributes.addAttribute("errorEmail", true);
                    return "redirect:/user/manage";
                }
            } else {
                rAttributes.addAttribute("errorParams", true);
                return "redirect:/user/manage";
            }
        }
    }

    @PostMapping("/savePassword")
    public String managePassword(@RequestParam Map<String, String> allParams, HttpServletRequest request, RedirectAttributes rAttributes, Model model){
        if (request.getSession().getAttribute("user") == null) {
            rAttributes.addAttribute("notLogged", true);
            return "redirect:/signin";
        } else {

            User user = (User) request.getSession().getAttribute("user");
            if (BCrypt.checkpw(allParams.get("lastPassword"), user.getPassword())) {
                if (!allParams.get("password").equals(allParams.get("passwordConf"))) {
                    rAttributes.addAttribute("diffPassword", true);
                    return "redirect:/user/manage";
                } else {
                    if (userService.checkedPassword(allParams.get("password"))) {
                        user.setPassword(BCrypt.hashpw(allParams.get("password"), BCrypt.gensalt()));
                        userService.save(user);
                        rAttributes.addAttribute("passwordChanged", true);
                        return "redirect:/user/manage";
                    } else {
                        rAttributes.addAttribute("weakPassword", true);
                        return "redirect:/user/manage";
                    }
                }
            } else {
                rAttributes.addAttribute("wrongPassword", true);
                return "redirect:/user/manage";
            }
            
        }
    }

}
