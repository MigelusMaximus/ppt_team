package main;

public class CastkyDokladu {
    private double cenaBezDPH;
    private double cenaSDPH;
    private String sazbaNazev;
    private double sazbaHodnota;

    // Konstruktor
    public CastkyDokladu(double cenaBezDPH, double cenaSDPH, String sazbaNazev, double sazbaHodnota) {
        this.cenaBezDPH = cenaBezDPH;
        this.cenaSDPH = cenaSDPH;
        this.sazbaNazev = sazbaNazev;
        this.sazbaHodnota = sazbaHodnota;
    }

    // Getter metody pro získání hodnot
    public double getCenaBezDPH() {
        return cenaBezDPH;
    }

    public double getCenaSDPH() {
        return cenaSDPH;
    }

    public String getSazbaNazev() {
        return sazbaNazev;
    }

    public double getSazbaHodnota() {
        return sazbaHodnota;
    }

    @Override
    public String toString() {
        return "Cena bez DPH: " + cenaBezDPH + " Kč\n" +
                "Cena s DPH: " + cenaSDPH + " Kč\n" +
                "Sazba DPH: " + sazbaNazev + " (" + sazbaHodnota + "%)";
    }
}
