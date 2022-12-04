package fr.cytech.cy_crypto.modele;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity(name = "currency_history")
@Table(name = "currency_history")
@Getter @Setter
public class CurrencyHistoryModel {
    
    @Id
    @Column(name = "id", unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "convertedTo", unique = true)
    private ClassicCurrency convertedTo;

    @Column(name = "time", unique = true)
    private Long time;

    @Column(name = "high", unique = true)
    private Double high;

    @Column(name = "low", unique = true)
    private Double low;

    @Column(name = "open", unique = true)
    private Double open;

    @Column(name = "volume_from", unique = true)
    private Double volume_from;

    @Column(name = "volume_to", unique = true)
    private Double volume_to;

    @Column(name = "close", unique = true)
    private Double close;
}
