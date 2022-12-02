package fr.cytech.cy_crypto.repository;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository
public interface DAO<T> {
    
    public T get(Object t);
    
    public List<T> getAll();

    public List<T> findAllByAttribute(String attribute, Object value);
    
    public void save(T t);
    
    public void update(T t);

    public void delete(T t);
}
