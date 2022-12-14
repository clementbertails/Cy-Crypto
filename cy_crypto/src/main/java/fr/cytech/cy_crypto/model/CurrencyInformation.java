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

@Entity(name = "currency_information")
@Table(name = "currency_information")
@Getter @Setter
public class CurrencyInformation {
    
    @Id
    @Column(name = "id", unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "convertedTo")
    @Enumerated(EnumType.STRING)
    private ClassicCurrency convertedTo;

    @Column(name = "price")
    private Double price;

    @Column(name = "median")
    private Double median;
    
    @Column(name = "volumeDay")
    private Double volumeDay;

    @Column(name = "volumeDayTo")
    private Double volumeDayTo;

    @Column(name = "volume24hour")
    private Double volume24hour;

    @Column(name = "volume24hourTo")
    private Double volume24hourTo;

    @Column(name = "openDay")
    private Double openDay;

    @Column(name = "highDay")
    private Double highDay;

    @Column(name = "lowDay")
    private Double lowDay;

    @Column(name = "volumeHour")
    private Double volumeHour;

    @Column(name = "volumeHourTo")
    private Double volumeHourTo;

    @Column(name = "openHour")
    private Double openHour;

    @Column(name = "highHour")
    private Double highHour;

    @Column(name = "lowHour")
    private Double lowHour;
}
