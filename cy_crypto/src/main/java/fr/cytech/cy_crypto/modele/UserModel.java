package fr.cytech.cy_crypto.modele;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity(name = "user")
@Table(name = "user")
@Getter @Setter
public class UserModel {

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
    // @Enumerated
    private Role role;

    @ManyToMany(cascade = CascadeType.MERGE)
    @JoinTable( name = "favorite_currencies_association",
                joinColumns = {@JoinColumn(name = "user_id") },
                inverseJoinColumns = { @JoinColumn(name = "currency_id") })
    private List<CurrencyModel> favoriteCurrencies;
}
