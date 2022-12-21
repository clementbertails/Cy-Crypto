package fr.cytech.cy_crypto.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.cytech.cy_crypto.model.Mail;
import fr.cytech.cy_crypto.model.User;

@Repository
public interface MailRepository extends JpaRepository<Mail, Long>{

    public List<Mail> findAllByDate(Date date);
    
    public List<Mail> findAllBySender(User sender);

    public List<Mail> findAllByReceivers(User receivers);
}