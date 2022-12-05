package fr.cytech.cy_crypto.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.cytech.cy_crypto.modele.CurrencyHistoryModel;
import fr.cytech.cy_crypto.modele.CurrencyModel;
import fr.cytech.cy_crypto.repository.CurrencyRepository;

@Service
public class CurrencyService {

    @Autowired
    private CurrencyRepository currencyRepository;

    @Transactional
    public CurrencyModel findById(Object currency) {
        return currencyRepository.findById((String) currency).isPresent() ? currencyRepository.findById((String) currency).get()
                : null;
    }

    @Transactional
    public CurrencyModel findBySymbol(String symbol) {
        return currencyRepository.findBySymbol(symbol);
    }

    @Transactional
    public List<CurrencyModel> findAll() {
        return currencyRepository.findAll();
    }

    @Transactional
    public void save(CurrencyModel currency) {
        currencyRepository.save(currency);
    }

    @Transactional
    public void delete(CurrencyModel currency) {
        currencyRepository.delete(currency);
    }
}
