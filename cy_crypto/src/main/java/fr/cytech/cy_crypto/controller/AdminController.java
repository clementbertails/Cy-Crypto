package fr.cytech.cy_crypto.controller;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import fr.cytech.cy_crypto.model.CryptoCurrency;
import fr.cytech.cy_crypto.model.Role;
import fr.cytech.cy_crypto.model.User;
import fr.cytech.cy_crypto.services.CurrencyService;
import fr.cytech.cy_crypto.services.UserService;

@Controller
@RequestMapping("/admin")
public class AdminController    {

    private String ASSETS_DIR = "src/main/webapp/assets/";
    private String ICON_DIR = ASSETS_DIR + "currency_icon/";

    @Autowired
    private UserService userService;

    @Autowired
    private CurrencyService currencyService;
    
    @GetMapping()
    public String getAdminIndex(HttpServletRequest request, RedirectAttributes rAttributes){
        User user = (User) request.getSession().getAttribute("user");
        if (user == null) {
            rAttributes.addAttribute("notLogged", true);
            return "redirect:/signin";
        }
        if (user.getRole() != Role.ADMIN) {
            rAttributes.addAttribute("notAdmin", true);
            return "redirect:/user/home";
        }
        return "admin_pannel";
    }

    @GetMapping("/adminCrypto")
    public String adminCrypto(HttpServletRequest request, RedirectAttributes rAttributes){
        User user = (User) request.getSession().getAttribute("user");
        if (user == null) {
            rAttributes.addAttribute("notLogged", true);
            return "redirect:/signin";
        }
        if (user.getRole() != Role.ADMIN) {
            rAttributes.addAttribute("notAdmin", true);
            return "redirect:/user/home";
        }
        return "add_crypto";
    }

    @PostMapping("/addCrypto")
    public String addCrypto(HttpServletRequest request, RedirectAttributes rAttributes, @RequestParam Map<String, String> params, @RequestPart MultipartFile crypto_icon){
        User user = (User) request.getSession().getAttribute("user");
        if (user == null) {
            rAttributes.addAttribute("notLogged", true);
            return "redirect:/signin";
        }
        if (user.getRole() != Role.ADMIN) {
            rAttributes.addAttribute("notAdmin", true);
            return "redirect:/user/home";
        }
        if (userService.allAddCryptoParams(params) && !currencyService.existsBySymbol(params.get("symbol")) && !crypto_icon.isEmpty()) {
            CryptoCurrency currency = new CryptoCurrency();
            currency.setSymbol(params.get("symbol"));
            currency.setName(params.get("name"));
            currency.setIconPath(ICON_DIR+params.get("symbol")+".png");
            try {
                byte[] bytes = crypto_icon.getBytes();
                Path path = Paths.get(ICON_DIR + currency.getSymbol() + ".png");
                Files.write(path, bytes);
            } catch (Exception e) {
                e.printStackTrace();
                rAttributes.addAttribute("cryptoNotAdded", true);
                return "redirect:/admin/adminCrypto";
            }
            currencyService.save(currency);
            rAttributes.addAttribute("cryptoAdded", true);
        } else {
            rAttributes.addAttribute("cryptoNotAdded", true);
        }
        return "redirect:/admin/adminCrypto";
    }

    @GetMapping("/manage")
    public String manage_users(HttpServletRequest request, RedirectAttributes rAttributes, Model model){
        User user = (User) request.getSession().getAttribute("user");
        if (user == null) {
            rAttributes.addAttribute("notLogged", true);
            return "redirect:/signin";
        }
        if (user.getRole() != Role.ADMIN) {
            rAttributes.addAttribute("notAdmin", true);
            return "redirect:/user/home";
        }
        model.addAttribute("users", userService.findAll());
        return "manage_users";
    }

    @PostMapping("/addAdmin")
    public String addAdmin(HttpServletRequest request, RedirectAttributes rAttributes, @RequestParam Long addedAdmin){
        User user = (User) request.getSession().getAttribute("user");
        if (user == null) {
            rAttributes.addAttribute("notLogged", true);
            return "redirect:/signin";
        }
        if (user.getRole() != Role.ADMIN) {
            rAttributes.addAttribute("notAdmin", true);
            return "redirect:/user/home";
        }
        User toAdd = userService.find(addedAdmin);
        toAdd.setRole(Role.ADMIN);
        userService.save(toAdd);
        rAttributes.addAttribute("addAdmin", true);
        return "redirect:/admin/manage";
    }

    @PostMapping("/removeAdmin")
    public String removeAdmin(HttpServletRequest request, RedirectAttributes rAttributes, @RequestParam Long rmedAdmin) {
        User user = (User) request.getSession().getAttribute("user");
        if (user == null) {
            rAttributes.addAttribute("notLogged", true);
            return "redirect:/signin";
        }
        if (user.getRole() != Role.ADMIN) {
            rAttributes.addAttribute("notAdmin", true);
            return "redirect:/user/home";
        }
        User toRemove = userService.find(rmedAdmin);
        toRemove.setRole(Role.USER);
        userService.save(toRemove);
        rAttributes.addAttribute("removedAdmin", true);
        return "redirect:/admin/manage";
    }

    @PostMapping("/removeUser")
    public String removeUser(HttpServletRequest request, RedirectAttributes rAttributes, @RequestParam Long deletedUser) {
        User user = (User) request.getSession().getAttribute("user");
        if (user == null) {
            rAttributes.addAttribute("notLogged", true);
            return "redirect:/signin";
        }
        if (user.getRole() != Role.ADMIN) {
            rAttributes.addAttribute("notAdmin", true);
            return "redirect:/user/home";
        }
        User toRemove = userService.find(deletedUser);
        userService.delete(toRemove);
        rAttributes.addAttribute("deletedUser", true);
        return "redirect:/admin/manage";
    }
}
