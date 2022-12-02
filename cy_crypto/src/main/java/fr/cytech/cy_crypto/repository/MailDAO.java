package fr.cytech.cy_crypto.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import fr.cytech.cy_crypto.modele.MailModel;
import fr.cytech.cy_crypto.modele.UserModel;

@Repository
public class MailDAO implements DAO<MailModel>{

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public MailModel get(Object t) {
        if(t instanceof Integer) {
            TypedQuery<MailModel> query = entityManager.createQuery("FROM user WHERE id = :id", MailModel.class);
            query.setParameter("id", t);
            try {
                return query.getSingleResult();
            } catch (Exception e) {
                return null;
            }
        } else {
            return null;
        }
    }

    @Override
    public List<MailModel> getAll() {
        TypedQuery<MailModel> query = entityManager.createQuery("FROM mail", MailModel.class);
        return query.getResultList();
    }

    // @Override
    // public List<MailModel> findAllByAttribute(String attribute, Object value) {
    //     List<MailModel> result = null;
    //     switch (attribute) {
    //         case "receivers":
    //         case "sender":
    //             TypedQuery<MailModel> query = entityManager.createQuery("SELECT mail_id FROM mail_association WHERE " + attribute + "_id = :value GROUP BY mail_id", MailModel.class);
    //             query.setParameter("value", value = ((UserModel) value).getId());
    //             result = query.getResultList();
    //             break;
        
    //         default:
    //             break;
    //     }
    //     return result;
    // }

    @Override
    @Query("FROM mail WHERE :attribute = :value GROUP BY mail_id")
    public List<MailModel> findAllByAttribute(@Param("attribute") String attribute, @Param("value") Object value) {
        return null;
    }

    @Override
    public void save(MailModel t) {
        entityManager.persist(t);
    }

    @Override
    public void update(MailModel t) {
        entityManager.merge(t);
    }

    @Override
    public void delete(MailModel t) {
        entityManager.remove(t);    
    }
}
