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
import fr.cytech.cy_crypto.modele.UserModel;
import fr.cytech.cy_crypto.service.AdminService;

@Controller
@RequestMapping("/admin")
public class AdminController    {

    @Autowired
    private AdminService adminService;
    
    @GetMapping()
    public String getAdminIndex(HttpServletRequest request, Model model){
        return adminService.isLogged(request, model, "admin_pannel");
    }

    //TODO management Security

    @GetMapping("/manage")
    public String manage_users(HttpServletRequest request, Model model){
        return adminService.isLogged(request, model, "manage_users");
    }

    @PostMapping("/addAdmin")
    public String addAdmin(@RequestParam Integer id, Model model){
        UserModel user = adminService.get(id);
        user.setRole(Role.ADMIN);
        adminService.update(user);
        model.addAttribute("addAdmin", true);
        return "manageUser";
    }

    @PostMapping("/removeAdmin")
    public String removeAdmin(@RequestParam Integer id, Model model) {
        UserModel user = adminService.get(id);
        user.setRole(Role.USER);
        adminService.update(user);
        model.addAttribute("removedAdmin", true);
        return "manage_users";
    }

    @PostMapping("/removeUser")
    public String removeUser(@RequestParam Integer id, Model model) {
        UserModel user = adminService.get(id);
        adminService.delete(user);
        model.addAttribute("deletedUser", true);
        return "manage_users";
    }

}
