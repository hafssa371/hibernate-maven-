package entities;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedNativeQuery;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@NamedNativeQuery (name = "findBetweenDateNative", query = "select * from machine where dateAchat between :di and :d2", resultClass = Machine. class)

@NamedQuery (name = "findBetweenDate" , query = "from Machine where dateAchat between :d1 and :d2")



@Table(name = "machines")
public class Machine {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "reference")
    private String ref;
    @Temporal(TemporalType.DATE)
    private Date dateAchat;
    private double prix;

    @ManyToOne
    private Salle salle;

    public Machine() {
    }

    public Machine(String ref, Date dateAchat, double prix, Salle salle) {
        this.ref = ref;
        this.dateAchat = dateAchat;
        this.prix = prix;
        this.salle = salle;
    }

    public Machine(String ref, Date dateAchat, Salle salle) {
        this.ref = ref;
        this.dateAchat = dateAchat;
        this.salle = salle;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRef() {
        return ref;
    }

    public void setRef(String ref) {
        this.ref = ref;
    }

    public Date getDateAchat() {
        return dateAchat;
    }

    public void setDateAchat(Date dateAchat) {
        this.dateAchat = dateAchat;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public Salle getSalle() {
        return salle;
    }

    public void setSalle(Salle salle) {
        this.salle = salle;
    }




}