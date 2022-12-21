package fr.cytech.cy_crypto.modele;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity(name = "currency")
@Table(name = "currency")
@Getter @Setter 
public class CryptoCurrency {
    
    @Id
    @Column(name = "id", unique = true)
    private Long id;

    @Column(name = "symbol", unique = true)
    private String symbol;

    @Column(name = "name", unique = true)
    private String name;

    @Column(name = "icon_path", unique = true)
    private String icon_path;

    @OneToMany( cascade = CascadeType.ALL)
    @JoinTable( name = "currency_history_association",
                joinColumns = {@JoinColumn(name = "currency_id", nullable = false)},
                inverseJoinColumns = {@JoinColumn(name = "history_id", nullable = false)})
    private List<CurrencyHistory> history;

    @OneToMany( cascade = CascadeType.ALL)
    @JoinTable( name = "currency_information_association",
                joinColumns = {@JoinColumn(name = "currency_id", nullable = false)},
                inverseJoinColumns = {@JoinColumn(name = "information_id", nullable = false)})
    private List<CurrencyInformation> information;
}
