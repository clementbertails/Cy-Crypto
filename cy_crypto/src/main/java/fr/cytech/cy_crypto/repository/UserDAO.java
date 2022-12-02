package fr.cytech.cy_crypto.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import fr.cytech.cy_crypto.modele.UserModel;
import fr.cytech.cy_crypto.modele.Role;

@Repository
public class UserDAO implements DAO<UserModel> {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public UserModel get(Object t) {
        if(t instanceof Integer) {
            TypedQuery<UserModel> query = entityManager.createQuery("FROM user WHERE id = :id", UserModel.class);
            query.setParameter("id", t);
            try {
                return query.getSingleResult();
            } catch (Exception e) {
                return null;
            }
        } else if (t instanceof String) {
            TypedQuery<UserModel> query = entityManager.createQuery("FROM user WHERE username = :username OR email = :email", UserModel.class);
            query.setParameter("username", t);
            query.setParameter("email", t);
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
    public List<UserModel> getAll() {
        TypedQuery<UserModel> query = entityManager.createQuery("FROM user", UserModel.class);
        return query.getResultList();
    }

    public List<UserModel> findAllByAttribute(String attribute, Object value) {
        List<UserModel> result = null;
        if (value instanceof Role) {
            TypedQuery<UserModel> query;
            switch ((Role) value) {
                case USER:
                case ADMIN:
                    query = entityManager.createQuery("FROM user WHERE role = :value", UserModel.class);
                    query.setParameter("value", value);
                    result = query.getResultList();
                    break;
                
                default:
                    result = null;
                    break;
            }
        }
        return result;
    }

    @Override
    public void save(UserModel t) {
        entityManager.persist(t);
    }

    @Override
    public void update(UserModel t) {
        entityManager.merge(t);
    }

    @Override
    public void delete(UserModel t) {
        entityManager.remove(t);
    }
}
