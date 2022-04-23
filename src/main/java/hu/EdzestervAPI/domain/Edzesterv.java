package hu.EdzestervAPI.domain;

public class Edzesterv {
    private int id;
    private String nev;
    private int elerendoSuly;
    private String celMegjegyzes;
    public Edzesterv() {
    }

    public Edzesterv(int id, String nev,  int elerendoSuly, String celMegjegyzes) {
        this.id = id;
        this.nev = nev;
        this.elerendoSuly = elerendoSuly;
        this.celMegjegyzes = celMegjegyzes;

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

    public int getElerendoSuly() {
        return elerendoSuly;
    }

    public void setElerendoSuly(int elerendoSuly) {
        this.elerendoSuly = elerendoSuly;
    }
    public String getCelMegjegyzes() {
        return celMegjegyzes;
    }

    public void setCelMegjegyzes(String celMegjegyzes) {
        this.celMegjegyzes = celMegjegyzes;
    }

    @Override
    public String toString() {
        return "Edzesterv{" +
                "id=" + id +
                ", nev='" + nev + '\'' +
                ", celMegjegyzes='" + celMegjegyzes + '\'' +
                ", elerendoSuly=" + elerendoSuly +
                '}';
    }
}
