package fr.cytech.cy_crypto.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import fr.cytech.cy_crypto.modele.Role;
import fr.cytech.cy_crypto.modele.User;
import fr.cytech.cy_crypto.services.UserService;

@Controller
@RequestMapping("/admin")
public class AdminController    {

    @Autowired
    private UserService adminService;
    
    @GetMapping()
    public String getAdminIndex(HttpServletRequest request, Model model){
        // return adminService.isLogged(request, model, "admin_pannel");
        return null;
    }

    //TODO management Security

    @GetMapping("/manage")
    public String manage_users(HttpServletRequest request, Model model){
        // return adminService.isLogged(request, model, "manage_users");
        return null;
    }

    @PostMapping("/addAdmin")
    public String addAdmin(@RequestParam Long id, Model model){
        User user = adminService.find(id);
        user.setRole(Role.ADMIN);
        adminService.save(user);
        model.addAttribute("addAdmin", true);
        return "manageUser";
    }

    @PostMapping("/removeAdmin")
    public String removeAdmin(@RequestParam Long id, Model model) {
        User user = adminService.find(id);
        user.setRole(Role.USER);
        adminService.save(user);
        model.addAttribute("removedAdmin", true);
        return "manage_users";
    }

    @PostMapping("/removeUser")
    public String removeUser(@RequestParam Long id, Model model) {
        User user = adminService.find(id);
        adminService.delete(user);
        model.addAttribute("deletedUser", true);
        return "manage_users";
    }

}
