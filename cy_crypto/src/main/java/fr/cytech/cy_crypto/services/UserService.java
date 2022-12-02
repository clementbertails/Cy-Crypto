package fr.cytech.cy_crypto.services;

import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.cytech.cy_crypto.modele.Role;
import fr.cytech.cy_crypto.modele.UserModel;
import fr.cytech.cy_crypto.repository.UserDAO;

@Service
public class UserService {

    @Autowired
    private UserDAO userDao;
    
    public UserModel get(Object user) {
        return userDao.get(user);
    }
    
    public List<UserModel> getAll() {
        return userDao.getAll();
    }

    public List<UserModel> findAllByAttribute(String attribute, Role role){
        return userDao.findAllByAttribute(attribute, role);
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

    public boolean existUser(String username, String email) {
        return this.get(username) != null || this.get(email) != null;
    }

    public boolean checkedPassword(String password){
        return Pattern.matches("^(?=.*[A-Z])(?=.*[!@#$&*])(?=.*[0-9])(?=.*[a-z]).{10,}$", password);
    }

    public boolean checkedEmail(String email){
        return Pattern.matches("^([a-z]+([_\\-\\.][a-z]+)?)+@([a-z]([_\\-\\.][a-z]+)?)+\\.[a-z]{2,4}$", email);
    }

    public boolean allSignupParams(Map<String, String> allParams){
        for (var entry : allParams.entrySet()) {
            switch (entry.getKey()) {
                case "name":
                case "lastName":
                case "username":
                case "email":
                case "password":
                case "passwordConf":
                    if (entry.getValue() == null || entry.getValue() == "") {
                        return false;
                    }

                case "signup":
                    break;
            
                default:
                    return false;
            }
        }
        return true;
    }

    public boolean allSigninParams(Map<String, String> allParams){
        for (var entry : allParams.entrySet()) {
            switch (entry.getKey()) {
                case "login":
                case "password":
                    if (entry.getValue() == null || entry.getValue() == "") {
                        return false;
                    }

                case "signin":
                    break;
            
                default:
                    return false;
            }
        }
        return true;
    }
}
