package fr.cytech.cy_crypto.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.cytech.cy_crypto.modele.CurrencyModel;
import fr.cytech.cy_crypto.repository.CurrencyRepository;

@Service
public class CurrencyService {

    @Autowired
    private CurrencyRepository currencyRepository;

    public CurrencyModel findById(Object currency) {
        return currencyRepository.findById((String) currency).isPresent() ? currencyRepository.findById((String) currency).get()
                : null;
    }

    public List<CurrencyModel> findAll() {
        return currencyRepository.findAll();
    }

    public void save(CurrencyModel currency) {
        currencyRepository.save(currency);
    }

    public void delete(CurrencyModel currency) {
        currencyRepository.delete(currency);
    }
}
