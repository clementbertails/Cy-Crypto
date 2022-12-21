package fr.cytech.cy_crypto.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.cytech.cy_crypto.model.CryptoCurrency;
import fr.cytech.cy_crypto.repository.CurrencyRepository;

@Service
public class CurrencyService {

    @Autowired
    private CurrencyRepository currencyRepository;

    @Transactional
    public CryptoCurrency find(Object cryptoCurrency) {
        try {
            switch (cryptoCurrency.getClass().getSimpleName()) {

                case "Integer":
                case "int":
                case "Long":
                    return currencyRepository.findById((Long) cryptoCurrency).isPresent() ? currencyRepository.findById((Long) cryptoCurrency).get() 
                            : null;
            
                case "String":
                    return currencyRepository.findBySymbol((String) cryptoCurrency).isPresent() ? currencyRepository.findBySymbol((String) cryptoCurrency).get()
                            : null;

                case "CryptoCurrency":
                    return (CryptoCurrency) cryptoCurrency;

                default:
                    return null;
            }
        } catch (Exception e) {
            System.err.println("Error while getting user : " + e.getMessage());
            return null;
        }
    }

    @Transactional
    public boolean existsBySymbol(String symbol) {
        return currencyRepository.existsBySymbol(symbol);
    }

    @Transactional
    public List<CryptoCurrency> findAll() {
        return currencyRepository.findAll();
    }

    @Transactional
    public void save(CryptoCurrency currency) {
        currencyRepository.save(currency);
    }

    @Transactional
    public void delete(CryptoCurrency currency) {
        currencyRepository.delete(currency);
    }
}
