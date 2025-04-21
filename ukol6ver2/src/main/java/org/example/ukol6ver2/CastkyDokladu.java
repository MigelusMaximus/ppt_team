package org.example.ukol6ver2;

public class CastkyDokladu {
    private double cenaBezDph;
    private double cenaSDph;
    private String sazba;

    public CastkyDokladu(double cenaBezDph, double cenaSDph, String sazba) {
        this.cenaBezDph = cenaBezDph;
        this.cenaSDph = cenaSDph;
        this.sazba = sazba;
    }

    public double getCenaBezDph() {
        return cenaBezDph;
    }

    public double getCenaSDph() {
        return cenaSDph;
    }

    public String getSazba() {
        return sazba;
    }

    @Override
    public String toString() {
        return "Cena bez DPH: " + cenaBezDph + "\nCena s DPH: " + cenaSDph + "\nSazba: " + sazba;
    }
}
