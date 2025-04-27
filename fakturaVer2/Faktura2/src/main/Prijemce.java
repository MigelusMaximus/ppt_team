package main;

public class Prijemce {
    private String jmeno;
    private String prijmeni;
    private String ulice;
    private String mesto;
    private String psc;
    private String telefon;
    private String email;

    public Prijemce(String jmeno, String prijmeni, String ulice, String mesto, String psc, String telefon, String email) {
        this.jmeno = jmeno;
        this.prijmeni = prijmeni;
        this.ulice = ulice;
        this.mesto = mesto;
        this.psc = psc;
        this.telefon = telefon;
        this.email = email;
    }

    @Override
    public String toString() {
        return jmeno + " " + prijmeni + ", " + ulice + ", " + mesto + " " + psc + "\n" +
                "Telefon: " + telefon + ", Email: " + email;
    }
}
