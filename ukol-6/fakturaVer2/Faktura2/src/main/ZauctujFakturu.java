package main;

public class ZauctujFakturu {
    public static CastkyDokladu vypocitejCastky(double cenaBezDPH, double sazbaHodnota) {

            // Výpočet DPH
            double dph = cenaBezDPH * sazbaHodnota / 100;
            // Výpočet ceny s DPH
            double cenaSDPH = cenaBezDPH + dph;
            // Určení názvu sazby DPH
            String sazbaNazev = sazbaHodnota == 21.0 ? "standardní" : "snížená";

            // Vytvoření a vrácení objektu main.CastkyDokladu
            return new CastkyDokladu(cenaBezDPH, cenaSDPH, sazbaNazev, sazbaHodnota);
        }

        // Varianta výpočtu pro sníženou sazbu
        public static CastkyDokladu vypocitejCastkySnížená(double cenaBezDPH) {
            return vypocitejCastky(cenaBezDPH, 10.0); // Příklad: Snížená sazba je 10%
        }

        // Varianta výpočtu pro standardní sazbu
        public static CastkyDokladu vypocitejCastkyStandardní(double cenaBezDPH) {
            return vypocitejCastky(cenaBezDPH, 21.0); // Příklad: Standardní sazba je 21%
        }
}
