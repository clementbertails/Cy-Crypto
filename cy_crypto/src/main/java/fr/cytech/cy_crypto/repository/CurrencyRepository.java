package fr.cytech.cy_crypto.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.cytech.cy_crypto.modele.CurrencyModel;

@Repository
public interface CurrencyRepository extends JpaRepository<CurrencyModel, String> {

}
