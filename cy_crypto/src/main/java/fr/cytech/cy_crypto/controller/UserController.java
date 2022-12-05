package fr.cytech.cy_crypto.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import fr.cytech.cy_crypto.modele.MailModel;
import fr.cytech.cy_crypto.modele.UserModel;
import fr.cytech.cy_crypto.services.MailService;
import fr.cytech.cy_crypto.services.UserService;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private MailService mailService;

    @Autowired
    private UserService userService;

    @GetMapping("/home")
    public String userHome(HttpServletRequest request, RedirectAttributes rAttributes){
        if (request.getSession().getAttribute("user") == null) {
            rAttributes.addAttribute("notLogged", true);
            return "redirect:/signin";
        } else {
            // Favourite list
            // mail
            // instant message with admins
            // manage profile
            return "user_home";
        }
    }

    @PostMapping("/currencies")
    public String userCurrencies(HttpServletRequest request, RedirectAttributes rAttributes){
        if (request.getSession().getAttribute("user") == null) {
            rAttributes.addAttribute("notLogged", true);
            return "redirect:/signin";
        } else {
            // Favourite list
            // mail
            // instant message with admins
            // manage profile
            return "currencies";
        }
    }

    @GetMapping("/currencies/favourites")
    public String userFavourites(HttpServletRequest request, RedirectAttributes rAttributes){
        if (request.getSession().getAttribute("user") == null) {
            rAttributes.addAttribute("notLogged", true);
            return "redirect:/signin";
        } else {
            return "add_favourite_currency";
        }
    }

    @PostMapping("/currencies/addfavourites")
    public String addFavourite(HttpServletRequest request, RedirectAttributes rAttributes){
        if (request.getSession().getAttribute("user") == null) {
            rAttributes.addAttribute("notLogged", true);
            return "redirect:/signin";
        } else {
            return "redirect:/user/home/currencies";
        }
    }

    @PostMapping("/currencies/removefavourites")
    public String removeFavourite(HttpServletRequest request, RedirectAttributes rAttributes){
        if (request.getSession().getAttribute("user") == null) {
            rAttributes.addAttribute("notLogged", true);
            return "redirect:/signin";
        } else {
            return "redirect:/user/home/currencies";
        }
    }

    @GetMapping("/mail")
    public String getMail(HttpServletRequest request, RedirectAttributes rAttributes, Model model){
        if (request.getSession().getAttribute("user") == null) {
            rAttributes.addAttribute("notLogged", true);
            return "redirect:/signin";
        } else {
            UserModel user = (UserModel) request.getSession().getAttribute("user");
            model.addAttribute("mails", mailService.findAllByAttribute("receivers", user));
            return "mailbox";
        }
    }

    @PostMapping("/sendmail")
    public String sendMail(@RequestParam Map<String, String> allParams, HttpServletRequest request, RedirectAttributes rAttributes){
        if (request.getSession().getAttribute("user") == null) {
            rAttributes.addAttribute("notLogged", true);
            return "redirect:/signin";
        } else {
            if (mailService.checkMailParams(allParams)) {
                MailModel mail = new MailModel();
                mail.setSubject(allParams.get("subject"));
                mail.setContent(allParams.get("content"));
                mail.setSender((UserModel) request.getSession().getAttribute("user"));
                List<UserModel> receivers = new ArrayList<UserModel>();
                for(String receiverAttribute : allParams.get("receivers").split(",")) {
                    UserModel receiverUser = userService.find(receiverAttribute);
                    if (receiverUser != null) {
                        receivers.add(receiverUser);
                    }
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
    }

    @PostMapping("/deletemail")
    public String deleteMail(HttpServletRequest request, RedirectAttributes rAttributes){
        if (request.getSession().getAttribute("user") == null) {
            rAttributes.addAttribute("notLogged", true);
            return "redirect:/signin";
        } else {
            return "redirect:/user/mail";
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

    @GetMapping("/saveInfos")
    public String managePassword(@RequestParam Map<String, String> allParams, HttpServletRequest request, RedirectAttributes rAttributes){
        if (request.getSession().getAttribute("user") == null) {
            rAttributes.addAttribute("notLogged", true);
            return "redirect:/signin";
        } else {
            return "redirect:/user/home/manage";   
        }
    }

}
