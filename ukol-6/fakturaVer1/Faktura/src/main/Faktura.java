package main;

import java.time.LocalDate;


public class Faktura {
    private final String cisloDokladu;
    private final LocalDate datumVystaveni;
    private final LocalDate datumSplatnosti;

    private final String jmeno;
    private final String prijmeni;
    private final String ulice;
    private final String mesto;
    private final String psc;
    private final String telefon;
    private final String email;

    private final double cenaBezDPH;
    private final double cenaSDPH;
    private final String sazbaNazev;
    private final double sazbaHodnota;

    // Konstruktor
    public Faktura(String cisloDokladu, LocalDate datumVystaveni, LocalDate datumSplatnosti,
                   String jmeno, String prijmeni, String ulice, String mesto, String psc,
                   String telefon, String email,
                   double cenaBezDPH, double cenaSDPH, String sazbaNazev, double sazbaHodnota) {
        this.cisloDokladu = cisloDokladu;
        this.datumVystaveni = datumVystaveni;
        this.datumSplatnosti = datumSplatnosti;
        this.jmeno = jmeno;
        this.prijmeni = prijmeni;
        this.ulice = ulice;
        this.mesto = mesto;
        this.psc = psc;
        this.telefon = telefon;
        this.email = email;
        this.cenaBezDPH = cenaBezDPH;
        this.cenaSDPH = cenaSDPH;
        this.sazbaNazev = sazbaNazev;
        this.sazbaHodnota = sazbaHodnota;
    }

    @Override
    public String toString() {
        return "main.Faktura č. " + cisloDokladu + "\n" +
                "Datum vystavení: " + datumVystaveni + "\n" +
                "Datum splatnosti: " + datumSplatnosti + "\n" +
                "Příjemce: " + jmeno + " " + prijmeni + ", " + ulice + ", " + mesto + " " + psc + "\n" +
                "Kontakt: tel: " + telefon + ", email: " + email + "\n" +
                "Částka bez DPH: " + cenaBezDPH + " Kč\n" +
                "Částka s DPH: " + cenaSDPH + " Kč\n" +
                "Sazba: " + sazbaNazev + " (" + sazbaHodnota + "%)";
    }
}
