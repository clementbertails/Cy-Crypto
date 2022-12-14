package fr.cytech.cy_crypto.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.springframework.lang.Nullable;

import lombok.Getter;
import lombok.Setter;

@Entity(name = "user")
@Table(name = "user")
@Getter @Setter
public class User {

    public User() {
        role = Role.USER;
        favoriteConversion = ClassicCurrency.USD;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "lastName")
    private String lastName;

    @Column(name = "username", unique = true)
    private String username;

    @Column(name = "email", unique = true)
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "role")
    @Enumerated(EnumType.STRING)
    private Role role;

    @Column(name = "favoriteConversion")
    @Enumerated(EnumType.STRING)
    private ClassicCurrency favoriteConversion;

    @Nullable
    @ManyToMany(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    @JoinTable( name = "favorite_currencies_association",
                joinColumns = {@JoinColumn(name = "user_id") },
                inverseJoinColumns = { @JoinColumn(name = "currency_id") })
    private List<CryptoCurrency> favoriteCurrencies;
}
