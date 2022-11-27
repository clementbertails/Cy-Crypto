package fr.cytech.cy_crypto.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import fr.cytech.cy_crypto.modele.Role;

@Service
public class AdminService extends UserService{
    
    @Override
    public String isLogged(HttpServletRequest request,
                            Model model,
                            String expectedStr){
        if (request.getSession().getAttribute("user") == null) {
            model.addAttribute("notLogged", true);
            return "signin";
        }
        if (request.getSession().getAttribute("role") == Role.USER) {
            model.addAttribute("noAccess", true);
            return "home";
        }
        return expectedStr;
    }
}
