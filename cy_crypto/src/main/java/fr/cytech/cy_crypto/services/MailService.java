package fr.cytech.cy_crypto.services;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.cytech.cy_crypto.modele.MailModel;
import fr.cytech.cy_crypto.modele.UserModel;
import fr.cytech.cy_crypto.repository.MailRepository;

@Service
public class MailService {
    
    @Autowired
    private MailRepository mailRepository;

    @Transactional
    public MailModel find(Long id) {
        return mailRepository.findById(id).isPresent() ? mailRepository.findById(id).get() : null;
    }

    public MailModel find(int id){
        return find((long) id);
    }
    
    @Transactional
    public List<MailModel> findAll() {
        return mailRepository.findAll();
    }

    @Transactional
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

    @Transactional
    public void save(MailModel mail) {
        mailRepository.save(mail);
    }

    @Transactional
    public void delete(MailModel mail) {
        mailRepository.delete(mail);
    }
    
    public boolean checkMailParams(Map<String, String> allParams){
        if (allParams.get("receivers") == null || allParams.get("receivers") == "" ||
            allParams.get("subject") == null || allParams.get("subject") == "" ||
            allParams.get("content") == null || allParams.get("content") == "") {
            return false;
        } else {
            return true;
        }
    }
}