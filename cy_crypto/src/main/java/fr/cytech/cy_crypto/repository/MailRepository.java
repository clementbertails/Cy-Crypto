package fr.cytech.cy_crypto.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.cytech.cy_crypto.modele.MailModel;
import fr.cytech.cy_crypto.modele.UserModel;

@Repository
public interface MailRepository extends JpaRepository<MailModel, Integer>{

    public List<MailModel> findAllByDate(Date date);
    
    public List<MailModel> findAllBySender(UserModel sender);

    public List<MailModel> findAllByReceivers(UserModel receivers);
}