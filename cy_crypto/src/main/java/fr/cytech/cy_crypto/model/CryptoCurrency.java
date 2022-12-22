package fr.cytech.cy_crypto.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import lombok.Getter;
import lombok.Setter;

@Entity(name = "currency")
@Table(name = "currency")
@Getter @Setter 
public class CryptoCurrency {
    
    @Id
    @Column(name = "id", unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "symbol", unique = true)
    private String symbol;

    @Column(name = "name", unique = true)
    private String name;

    @Column(name = "icon_path", unique = true)
    private String iconPath;

    @OneToMany( cascade = CascadeType.ALL)
    @LazyCollection(LazyCollectionOption.FALSE)
    @JoinTable( name = "currency_history_association",
                joinColumns = {@JoinColumn(name = "currency_id", nullable = false)},
                inverseJoinColumns = {@JoinColumn(name = "history_id", nullable = false)})
    private List<CurrencyHistory> history;

    @OneToMany( cascade = CascadeType.ALL)
    @LazyCollection(LazyCollectionOption.FALSE)
    @JoinTable( name = "currency_information_association",
                joinColumns = {@JoinColumn(name = "currency_id", nullable = false)},
                inverseJoinColumns = {@JoinColumn(name = "information_id", nullable = false)})
    private List<CurrencyInformation> information;
}
