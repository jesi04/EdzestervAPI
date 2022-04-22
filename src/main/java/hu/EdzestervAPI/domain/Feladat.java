package hu.EdzestervAPI.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Feladat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nev;
    private int elegetettKcal;
    private String leiras;
    private String megjegyzes;
    private String izomcsoport;

    public Feladat(int id, String nev, int elegetettKcal, String leiras, String megjegyzes, String izomcsoport) {
        this.id = id;
        this.nev = nev;
        this.elegetettKcal = elegetettKcal;
        this.leiras = leiras;
        this.megjegyzes = megjegyzes;
        this.izomcsoport = izomcsoport;
    }

    public Feladat() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNev() {
        return nev;
    }

    public void setNev(String nev) {
        this.nev = nev;
    }

    public int getElegetettKcal() {
        return elegetettKcal;
    }

    public void setElegetettKcal(int elegetettKcal) {
        this.elegetettKcal = elegetettKcal;
    }

    public String getLeiras() {
        return leiras;
    }

    public void setLeiras(String leiras) {
        this.leiras = leiras;
    }

    public String getMegjegyzes() {
        return megjegyzes;
    }

    public void setMegjegyzes(String megjegyzes) {
        this.megjegyzes = megjegyzes;
    }

    public String getIzomcsoport() {
        return izomcsoport;
    }

    public void setIzomcsoport(String izomcsoport) {
        this.izomcsoport = izomcsoport;
    }
}
