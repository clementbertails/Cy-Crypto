package fr.cytech.cy_crypto.modele;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

@Entity(name = "currency")
@Table(name = "currency")
@Getter @Setter 
public class CurrencyModel {
    
    @Id
    @Column(name = "id", unique = true)
    @NotNull
    private String id;

    @Column(name = "name")
    @NotNull
    private String name;

    @Column(name = "icon_path")
    @NotNull
    @NotBlank
    private String icon_path;
}
