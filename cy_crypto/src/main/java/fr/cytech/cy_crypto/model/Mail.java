package fr.cytech.cy_crypto.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
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
public class Mail {

    @Id
    @Column(name = "id", unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "date", unique = true)
	@Temporal(value=TemporalType.TIMESTAMP)
    private Date date;
    
    @ManyToMany(cascade = CascadeType.MERGE)
    @JoinTable( name = "mail_association_receivers",
                joinColumns = {@JoinColumn(name = "mail_id") },
                inverseJoinColumns = { @JoinColumn(name = "receiver_id") })
    private List<User> receivers;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinTable( name = "mail_association_sender",
                joinColumns = {@JoinColumn(name = "mail_id") },
                inverseJoinColumns = { @JoinColumn(name = "sender_id") })
    private User sender;

    @Column(name = "subject", unique = true)
    @Size(min = 1, message = "Field required !")
    private String subject;

    @Column(name = "content", unique = true)
    @Lob
    @Size(min = 1, message = "Field required !")
    private String content;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "previousMail")
    private Mail previousMail;
}
