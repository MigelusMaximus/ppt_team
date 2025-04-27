package main;

import java.time.LocalDate;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        // Vytvoření příjemce
        Prijemce prijemce = new Prijemce("Jan", "Novák", "Ulice 1", "Praha", "10000", "123456789", "jan.novak@email.cz");

        // Výpočet částek (například pro standardní sazbu)
        CastkyDokladu castky = ZauctujFakturu.vypocitejCastky(1000.0, 21.0);

        // Použití Builderu pro vytvoření faktury
        Faktura faktura = new Faktura.Builder()
                .cisloDokladu("2024-001")
                .datumVystaveni(LocalDate.now())
                .datumSplatnosti(LocalDate.now().plusDays(14))
                .prijemce(prijemce)
                .castky(castky)
                .build();

        // Výpis faktury
        System.out.println(faktura.toString());
    }
}