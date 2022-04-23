package hu.EdzestervAPI.domain;

public class Edzesnap {

    private int id;
    private String izomcsport;

    public Edzesnap() {
    }

    public Edzesnap(int id, String izomcsport) {
        this.id = id;
        this.izomcsport = izomcsport;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIzomcsport() {
        return izomcsport;
    }

    public void setIzomcsport(String izomcsport) {
        this.izomcsport = izomcsport;
    }
}
