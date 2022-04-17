package hu.EdzestervAPI.domain;

public class Edzesterv {
    private int id;
    private String nev;
    private String feladatNev;
    private String feladatLeiras;
    private int elerendoSuly;

    public Edzesterv() {
    }

    public Edzesterv(int id, String nev, String feladatNev, String feladatLeiras, int elerendoSuly) {
        this.id = id;
        this.nev = nev;
        this.feladatNev = feladatNev;
        this.feladatLeiras = feladatLeiras;
        this.elerendoSuly = elerendoSuly;
    }

    public String getFeladatLeiras() {
        return feladatLeiras;
    }

    public void setFeladatLeiras(String feladatLeiras) {
        this.feladatLeiras = feladatLeiras;
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

    public String getFeladatNev() {
        return feladatNev;
    }

    public void setFeladatNev(String feladat) {
        this.feladatNev = feladat;
    }

    public int getElerendoSuly() {
        return elerendoSuly;
    }

    public void setElerendoSuly(int elerendoSuly) {
        this.elerendoSuly = elerendoSuly;
    }
}
