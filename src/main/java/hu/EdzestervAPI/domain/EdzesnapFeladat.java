package hu.EdzestervAPI.domain;

public class EdzesnapFeladat {

    private int id;
    private String nev;
    private String leiras;
    private String megjegyzes;

    public EdzesnapFeladat() {
    }

    public EdzesnapFeladat(int id, String nev, String leiras, String megjegyzes) {
        this.id = id;
        this.nev=nev;
        this.leiras = leiras;
        this.megjegyzes = megjegyzes;
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
}
