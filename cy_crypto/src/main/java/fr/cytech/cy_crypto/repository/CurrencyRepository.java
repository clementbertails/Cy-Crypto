package fr.cytech.cy_crypto.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.cytech.cy_crypto.model.CryptoCurrency;

@Repository
public interface CurrencyRepository extends JpaRepository<CryptoCurrency, Long> {

    public Optional<CryptoCurrency> findBySymbol(String symbol);
    public boolean existsBySymbol(String symbol);
}
