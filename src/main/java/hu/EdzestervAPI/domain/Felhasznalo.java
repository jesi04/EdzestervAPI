package hu.EdzestervAPI.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Felhasznalo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String email;
    private String nev;
    private Date szuldat;
    private int magassag;
    private String megjegyzes;

    public Felhasznalo(int id, String email, String nev, Date szuldat,  int magassag, String megjegyzes) {
        this.id = id;
        this.email = email;
        this.nev = nev;
        this.szuldat = szuldat;
        this.magassag = magassag;
        this.megjegyzes = megjegyzes;
    }

    public Felhasznalo() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNev() {
        return nev;
    }

    public void setNev(String nev) {
        this.nev = nev;
    }

   public Date getSzuldat() {
        return szuldat;
    }

    public void setSzuldat(Date szuldat) {
        this.szuldat = szuldat;
    }

    public int getMagassag() {
        return magassag;
    }

    public void setMagassag(int magassag) {
        this.magassag = magassag;
    }

    public String getMegjegyzes() {
        return megjegyzes;
    }

    public void setMegjegyzes(String megjegyzes) {
        this.megjegyzes = megjegyzes;
    }
}