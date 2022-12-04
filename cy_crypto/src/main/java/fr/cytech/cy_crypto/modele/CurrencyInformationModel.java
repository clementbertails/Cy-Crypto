package fr.cytech.cy_crypto.modele;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity(name = "currency_information")
@Table(name = "currency_information")
@Getter @Setter
public class CurrencyInformationModel {
    
    @Id
    @Column(name = "id", unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "convertedTo", unique = true)
    private ClassicCurrency convertedTo;

    @Column(name = "price", unique = true)
    private Double price;

    @Column(name = "median", unique = true)
    private Double median;
    
    @Column(name = "volume_day", unique = true)
    private Double volume_day;

    @Column(name = "volume_day_to", unique = true)
    private Double volume_day_to;

    @Column(name = "volume_24hour", unique = true)
    private Double volume_24hour;

    @Column(name = "volume_24hour_to", unique = true)
    private Double volume_24hour_to;

    @Column(name = "open_day", unique = true)
    private Double open_day;

    @Column(name = "high_day", unique = true)
    private Double high_day;

    @Column(name = "low_day", unique = true)
    private Double low_day;

    @Column(name = "volume_hour", unique = true)
    private String volume_hour;

    @Column(name = "volume_hour_to", unique = true)
    private String volume_hour_to;

    @Column(name = "open_hour", unique = true)
    private String open_hour;

    @Column(name = "high_hour", unique = true)
    private String high_hour;

    @Column(name = "low_hour", unique = true)
    private String low_hour;
}
