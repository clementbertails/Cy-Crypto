package fr.cytech.cy_crypto.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.cytech.cy_crypto.modele.MailModel;
import fr.cytech.cy_crypto.repository.MailDAO;

@Service
public class MailService {
    
    @Autowired
    private MailDAO mailDao;

    public MailModel get(Object mail) {
        return mailDao.get(mail);
    }
    
    public List<MailModel> getAll() {
        return mailDao.getAll();
    }

    public List<MailModel> findAllByAttribute(String attribute, Object value){
        return mailDao.findAllByAttribute(attribute, value);
    }

    public void save(MailModel mail) {
        mailDao.save(mail);
    }

    public void update(MailModel mail) {
        mailDao.update(mail);
    }

    public void delete(MailModel mail) {
        mailDao.delete(mail);
    }
}
