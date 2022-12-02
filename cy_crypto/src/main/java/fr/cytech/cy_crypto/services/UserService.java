package fr.cytech.cy_crypto.services;

import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.cytech.cy_crypto.modele.Role;
import fr.cytech.cy_crypto.modele.UserModel;
import fr.cytech.cy_crypto.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public UserModel find(Object user) {
        try {
            switch (user.getClass().getSimpleName()) {
                case "Integer":
                    return userRepository.findById((Integer) user).isPresent() ? userRepository.findById((Integer) user).get() 
                            : null;

                case "int":
                    return userRepository.findById((int) user).isPresent() ? userRepository.findById((int) user).get() 
                            : null;

            
                case "String":
                    return userRepository.findByUsername((String) user).isPresent() ? userRepository.findByUsername((String) user).get()
                            : userRepository.findByEmail((String) user).isPresent() ? userRepository.findByEmail((String) user).get()
                            : null;

                case "UserModel":
                    return (UserModel) user;

                default:
                    return null;
            }
        } catch (Exception e) {
            System.err.println("Error while getting user : " + e.getMessage());
            return null;
        }
    }
    
    public List<UserModel> findAll() {
        return userRepository.findAll();
    }

    public List<UserModel> findAllByAttribute(String attribute, Object value){
        switch (attribute) {
            case "role":
                try {
                    switch (value.getClass().getSimpleName()) {
                        case "Role":
                            return userRepository.findAllByRole((Role) value);
                    
                        case "String":
                            return userRepository.findAllByRole(Role.valueOf((String) value));
                        
                        case "int":
                            return userRepository.findAllByRole(Role.values()[(int) value]);

                        case "Integer":
                            return userRepository.findAllByRole(Role.values()[(Integer) value]);

                        default:
                            break;
                    }
                } catch (Exception e) {
                    System.err.println("Error while getting users by role: " + e.getMessage());
                    return null;
                }

            default:
                return null;
        }
    }

    public void save(UserModel user) {
        userRepository.save(user);
    }

    public void delete(UserModel user) {
        userRepository.delete(user);
    }

    public boolean existUser(String username, String email) {
        return userRepository.existsByUsername(username) || userRepository.existsByEmail(email);
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
