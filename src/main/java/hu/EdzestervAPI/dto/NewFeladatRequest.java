package hu.EdzestervAPI.dto;

import hu.EdzestervAPI.domain.Feladat;

public class NewFeladatRequest {
    private String nev;
    private int elegetettKcal;
    private String leiras;
    private String megjegyzes;
    private String izomcsoport;


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

    @Override
    public String toString() {
        return "NewFeladatRequest{" +
                "nev='" + nev + '\'' +
                ", elegetettKcal=" + elegetettKcal +
                ", leiras='" + leiras + '\'' +
                ", megjegyzes='" + megjegyzes + '\'' +
                ", izomcsoport='" + izomcsoport + '\'' +
                '}';
    }

    public Feladat toFeladat(){
        Feladat feladat = new Feladat();
        feladat.setNev(this.nev);
        feladat.setElegetett_kcal(this.elegetettKcal);
        feladat.setLeiras(this.leiras);
        feladat.setMegjegyzes(this.megjegyzes);
        feladat.setIzomcsoport(this.izomcsoport);
        return feladat;
    }
}
