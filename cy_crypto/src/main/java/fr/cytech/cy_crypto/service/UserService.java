package fr.cytech.cy_crypto.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.cytech.cy_crypto.dao.UserDao;
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
}
