package main;

import java.time.LocalDate;

public class Faktura {
    private final String cisloDokladu;
    private final LocalDate datumVystaveni;
    private final LocalDate datumSplatnosti;
    private final Prijemce prijemce;  // Kompozice
    private final CastkyDokladu castky; // Kompozice

    // Konstruktor třídy main.Faktura
    private Faktura(Builder builder) {
        this.cisloDokladu = builder.cisloDokladu;
        this.datumVystaveni = builder.datumVystaveni;
        this.datumSplatnosti = builder.datumSplatnosti;
        this.prijemce = builder.prijemce;
        this.castky = builder.castky;
    }

    @Override
    public String toString() {
        return "main.Faktura č. " + cisloDokladu + "\n" +
                "Datum vystavení: " + datumVystaveni + "\n" +
                "Datum splatnosti: " + datumSplatnosti + "\n" +
                "Příjemce: \n" + prijemce.toString() + "\n" +
                "Částky: \n" + castky.toString();
    }

    // Builder třída pro konstrukci main.Faktura
    public static class Builder {
        private String cisloDokladu;
        private LocalDate datumVystaveni;
        private LocalDate datumSplatnosti;
        private Prijemce prijemce;
        private CastkyDokladu castky;

        public Builder cisloDokladu(String cisloDokladu) {
            this.cisloDokladu = cisloDokladu;
            return this;
        }

        public Builder datumVystaveni(LocalDate datumVystaveni) {
            this.datumVystaveni = datumVystaveni;
            return this;
        }

        public Builder datumSplatnosti(LocalDate datumSplatnosti) {
            this.datumSplatnosti = datumSplatnosti;
            return this;
        }

        public Builder prijemce(Prijemce prijemce) {
            this.prijemce = prijemce;
            return this;
        }

        public Builder castky(CastkyDokladu castky) {
            this.castky = castky;
            return this;
        }

        public Faktura build() {
            return new Faktura(this);
        }
    }
}
