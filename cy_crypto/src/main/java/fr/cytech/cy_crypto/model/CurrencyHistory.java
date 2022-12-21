package fr.cytech.cy_crypto.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity(name = "currency_history")
@Table(name = "currency_history")
@Getter @Setter
public class CurrencyHistory {
    
    @Id
    @Column(name = "id", unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "convertedTo")
    @Enumerated(EnumType.STRING)
    private ClassicCurrency convertedTo;

    @Column(name = "time")
    private Long time;

    @Column(name = "high")
    private Double high;

    @Column(name = "low")
    private Double low;

    @Column(name = "open")
    private Double open;

    @Column(name = "volumefrom")
    private Double volumefrom;

    @Column(name = "volumeto")
    private Double volumeto;

    @Column(name = "close")
    private Double close;
}
