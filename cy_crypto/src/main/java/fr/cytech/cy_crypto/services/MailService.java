package fr.cytech.cy_crypto.services;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.cytech.cy_crypto.modele.MailModel;
import fr.cytech.cy_crypto.modele.UserModel;
import fr.cytech.cy_crypto.repository.MailRepository;

@Service
public class MailService {
    
    @Autowired
    private MailRepository mailRepository;

    public MailModel find(Integer id) {
        return mailRepository.findById(id).isPresent() ? mailRepository.findById(id).get() : null;
    }
    
    public List<MailModel> findAll() {
        return mailRepository.findAll();
    }

    public List<MailModel> findAllByAttribute(String attribute, Object value){
        try {
            switch (attribute) {
                case "sender":
                    return mailRepository.findAllBySender((UserModel) value);
    
                case "receivers":
                    return mailRepository.findAllByReceivers((UserModel) value);
    
                case "date":
                    // TODO : test for date format
                    return mailRepository.findAllByDate((Date) value);
    
                default:
                    return null;
            }
            
        } catch (Exception e) {
            System.err.println("Error while getting mails by " + attribute + " : " + e.getMessage());
            return null;
        }
    }

    public void save(MailModel mail) {
        mailRepository.save(mail);
    }

    public void delete(MailModel mail) {
        mailRepository.delete(mail);
    }
}
