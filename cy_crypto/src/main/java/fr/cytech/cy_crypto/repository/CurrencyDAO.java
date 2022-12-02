package fr.cytech.cy_crypto.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import fr.cytech.cy_crypto.modele.CurrencyModel;

@Repository
public class CurrencyDAO implements DAO<CurrencyModel>{

    @Override
    public CurrencyModel get(Object t) {
        return null;
    }

    @Override
    public List<CurrencyModel> getAll() {
        return null;
    }

    @Override
    public List<CurrencyModel> findAllByAttribute(String attribute, Object value) {
        return null;
    }

    @Override
    public void save(CurrencyModel t) {
        
    }

    @Override
    public void update(CurrencyModel t) {
        
    }

    @Override
    public void delete(CurrencyModel t) {
        
    }
}
