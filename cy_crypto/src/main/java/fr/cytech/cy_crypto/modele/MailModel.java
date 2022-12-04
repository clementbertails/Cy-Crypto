package fr.cytech.cy_crypto.modele;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

@Entity(name = "mail")
@Table(name = "mail")
@Getter @Setter
public class MailModel {

    @Id
    @Column(name = "id", unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "date", unique = true)
	@Temporal(value=TemporalType.TIMESTAMP)
    private Date date;
    
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable( name = "mail_association",
                joinColumns = {@JoinColumn(name = "mail_id", nullable = false, updatable = false) },
                inverseJoinColumns = { @JoinColumn(name = "receiver_id", nullable = false, updatable = false) })
    private List<UserModel> receivers = new ArrayList<UserModel>();

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable( name = "mail_association",
                joinColumns = {@JoinColumn(name = "mail_id", nullable = false, updatable = false) },
                inverseJoinColumns = { @JoinColumn(name = "sender_id", nullable = false, updatable = false) })
    private UserModel sender;

    @Column(name = "subject", unique = true)
    @Size(min = 1, message = "Field required !")
    private String subject;

    @Column(name = "content", unique = true)
    @Lob
    @Size(min = 1, message = "Field required !")
    private String content;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "previousMail")
    private MailModel previousMail;
}
