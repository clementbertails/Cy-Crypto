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

    @Column(name = "convertedTo")
    private ClassicCurrency convertedTo;

    @Column(name = "price")
    private Double price;

    @Column(name = "median")
    private Double median;
    
    @Column(name = "volume_day")
    private Double volume_day;

    @Column(name = "volume_day_to")
    private Double volume_day_to;

    @Column(name = "volume_24hour")
    private Double volume_24hour;

    @Column(name = "volume_24hour_to")
    private Double volume_24hour_to;

    @Column(name = "open_day")
    private Double open_day;

    @Column(name = "high_day")
    private Double high_day;

    @Column(name = "low_day")
    private Double low_day;

    @Column(name = "volume_hour")
    private String volume_hour;

    @Column(name = "volume_hour_to")
    private String volume_hour_to;

    @Column(name = "open_hour")
    private String open_hour;

    @Column(name = "high_hour")
    private String high_hour;

    @Column(name = "low_hour")
    private String low_hour;
}
