package test;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import main.Faktura;


import static org.junit.jupiter.api.Assertions.*;

class FakturaTest {

    @Test
    void testFakturaVytvoreni() {
        Faktura faktura = new Faktura(
                "2024-001",
                LocalDate.of(2024, 4, 27),
                LocalDate.of(2024, 5, 27),
                "Jan", "Novák", "Ulice 1", "Praha", "10000",
                "123456789", "jan.novak@email.cz",
                1000.0, 1210.0, "standardní", 21.0
        );

        assertNotNull(faktura); // ověříme, že objekt vznikl
    }

    @Test
    void testToStringNeniPrazdne() {
        Faktura faktura = new Faktura(
                "2024-002",
                LocalDate.now(),
                LocalDate.now().plusDays(14),
                "Petr", "Svoboda", "Náměstí 5", "Brno", "60200",
                "987654321", "petr.svoboda@email.cz",
                5000.0, 6050.0, "snížená", 10.0
        );

        String fakturaText = faktura.toString();
        assertNotNull(fakturaText); // ověříme, že toString něco vrací
        assertFalse(fakturaText.isEmpty()); // ověříme, že to není prázdné
        assertTrue(fakturaText.contains("main.Faktura č. 2024-002")); // ověříme, že tam je správné číslo dokladu
    }
}
