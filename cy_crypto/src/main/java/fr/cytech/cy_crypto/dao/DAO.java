package fr.cytech.cy_crypto.dao;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface DAO<T> {
    
    public T get(Object t);
    
    public List<T> getAll();
    
    public void save(T t);
    
    public void update(T t);

    public void delete(T t);
}
