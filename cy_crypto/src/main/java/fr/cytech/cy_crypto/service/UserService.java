package fr.cytech.cy_crypto.service;

import java.util.List;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import fr.cytech.cy_crypto.dao.UserDao;
import fr.cytech.cy_crypto.modele.Role;
import fr.cytech.cy_crypto.modele.UserModel;

@Service
public class UserService {

    @Autowired
    private UserDao userDao;
    
    public UserModel get(Object user) {
        return userDao.get(user);
    }
    
    public List<UserModel> getAll() {
        return userDao.getAll();
    }

    public void save(UserModel user) {
        userDao.save(user);
    }
    
    public void update(UserModel user) {
        userDao.update(user);
    }

    public void delete(UserModel user) {
        userDao.delete(user);
    }

    public List<UserModel> getByRole(Role role){
        return userDao.getByRole(role);
    }

    public boolean existUser(String username, String email) {
        return this.get(username) != null || this.get(email) != null;
    }

    public boolean checkedPassword(String password){
        return Pattern.matches("^(?=.*[A-Z])(?=.*[!@#$&*])(?=.*[0-9])(?=.*[a-z]).{10,}$", password);
    }

    public boolean checkedEmail(String email){
        return Pattern.matches("^([a-z]+([_\\-\\.][a-z]+)?)+@([a-z]([_\\-\\.][a-z]+)?)+\\.[a-z]{2,4}$", email);
    }

    public String isLogged(HttpServletRequest request,
                           Model model,
                           String expectedStr){
        if (request.getSession().getAttribute("user") == null) {
            model.addAttribute("notLogged", true);
            return "signin";
        }
        return expectedStr;
    }
}
