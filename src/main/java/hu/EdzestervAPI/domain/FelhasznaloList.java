package hu.EdzestervAPI.domain;

import java.util.Date;

public class FelhasznaloList {

    private int id;
    private String email;
    private String nev;
    private Date szuldat;
    private int magassag;
    private String megjegyzes;

    public FelhasznaloList(int id, String email, String nev,Date szuldat,  int magassag, String megjegyzes) {
        this.id = id;
        this.email = email;
        this.nev = nev;
        this.szuldat = szuldat;
        this.magassag = magassag;
        this.megjegyzes = megjegyzes;
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
