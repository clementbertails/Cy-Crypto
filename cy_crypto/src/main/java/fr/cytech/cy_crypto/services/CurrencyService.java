package fr.cytech.cy_crypto.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.cytech.cy_crypto.modele.CurrencyModel;
import fr.cytech.cy_crypto.repository.CurrencyDAO;

@Service
public class CurrencyService {

    @Autowired
    private CurrencyDAO currencyDao;

    public CurrencyModel get(Object currency) {
        return currencyDao.get(currency);
    }

    public List<CurrencyModel> getAll() {
        return currencyDao.getAll();
    }

    public List<CurrencyModel> findAllByAttribute(String attribute, Object value){
        return currencyDao.findAllByAttribute(attribute, value);
    }

    public void save(CurrencyModel currency) {
        currencyDao.save(currency);
    }

    public void update(CurrencyModel currency) {
        currencyDao.update(currency);
    }

    public void delete(CurrencyModel currency) {
        currencyDao.delete(currency);
    }
}
