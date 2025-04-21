package org.example.fakturatrida;
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
    private final double sazbaDPH; // např. 0.21
    private final double cenaSDPH;
    private final String zkratkaSazby;

    public Faktura(String cisloDokladu, LocalDate datumVystaveni, LocalDate datumSplatnosti,
                   String jmeno, String prijmeni, String ulice, String mesto, String psc,
                   String telefon, String email,
                   double cenaBezDPH, double sazbaDPH, String zkratkaSazby) {

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
        this.sazbaDPH = sazbaDPH;
        this.zkratkaSazby = zkratkaSazby;
        this.cenaSDPH = cenaBezDPH * (1 + sazbaDPH);
    }

    @Override
    public String toString() {
        return "Faktura č. " + cisloDokladu +
                "\nVystaveno: " + datumVystaveni +
                "\nSplatnost: " + datumSplatnosti +
                "\nPříjemce: " + jmeno + " " + prijmeni +
                ", " + ulice + ", " + mesto + ", " + psc +
                "\nKontakt: Tel: " + telefon + ", Email: " + email +
                "\nČástka bez DPH: " + cenaBezDPH + " Kč" +
                "\nSazba DPH: " + zkratkaSazby + " (" + (sazbaDPH * 100) + "%)" +
                "\nČástka s DPH: " + cenaSDPH + " Kč";
    }
}
