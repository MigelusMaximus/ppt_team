package org.example.ukol6ver2;
import java.time.LocalDate;

public class Faktura {
    private String cisloDokladu;
    private LocalDate datumVystaveni;
    private LocalDate datumSplatnosti;
    private Prijemce prijemce;
    private CastkyDokladu castky;

    public Faktura(String cisloDokladu, LocalDate datumVystaveni, LocalDate datumSplatnosti, Prijemce prijemce, CastkyDokladu castky) {
        this.cisloDokladu = cisloDokladu;
        this.datumVystaveni = datumVystaveni;
        this.datumSplatnosti = datumSplatnosti;
        this.prijemce = prijemce;
        this.castky = castky;
    }

    public Prijemce getPrijemce() {
        return prijemce;
    }

    public CastkyDokladu getCastky() {
        return castky;
    }

    @Override
    public String toString() {
        return "Faktura: " + cisloDokladu + "\nDatum vystavení: " + datumVystaveni + "\nDatum splatnosti: " + datumSplatnosti +
                "\n\nPříjemce:\n" + prijemce + "\n\nČástky:\n" + castky;
    }
}
