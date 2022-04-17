package hu.EdzestervAPI.dto;

import hu.EdzestervAPI.domain.Felhasznalo;

import java.util.Date;

public class NewFelhasznaloRequest {
    private String email;
    private String nev;
    private Date szuldat;
    private int magassag;
    private String megjegyzes;

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

    @Override
    public String toString() {
        return "NewFelhasznaloRequest{" +
                "email='" + email + '\'' +
                ", nev='" + nev + '\'' +
                ", szuldat=" + szuldat +
                ", magassag=" + magassag +
                ", megjegyzes='" + megjegyzes + '\'' +
                '}';
    }

    public Felhasznalo toFelhasznalo(){
        Felhasznalo felhasznalo = new Felhasznalo();
        felhasznalo.setEmail(this.email);
        felhasznalo.setNev(this.nev);
        felhasznalo.setSzuldat(this.szuldat);
        felhasznalo.setMagassag(this.magassag);
        felhasznalo.setMegjegyzes(this.megjegyzes);
        return felhasznalo;
    }
}
