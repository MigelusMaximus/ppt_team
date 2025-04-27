package tests;
import main.CastkyDokladu;
import main.Faktura;
import main.Prijemce;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;
public class FakturaTest {
    @Test
    void testVytvoreniFaktury() {
        Prijemce prijemce = new Prijemce(
                "Jan", "Novák", "Ulice 1", "Praha", "10000", "123456789", "jan.novak@email.cz"
        );
        CastkyDokladu castky = new CastkyDokladu(
                1000.0, 1210.0, "standardní", 21.0
        );

        Faktura faktura = new Faktura.Builder()
                .cisloDokladu("2024-001")
                .datumVystaveni(LocalDate.now())
                .datumSplatnosti(LocalDate.now().plusDays(14))
                .prijemce(prijemce)
                .castky(castky)
                .build();

        assertNotNull(faktura);
    }

    @Test
    void testFakturaToString() {
        Prijemce prijemce = new Prijemce(
                "Petr", "Svoboda", "Náměstí 5", "Brno", "60200", "987654321", "petr.svoboda@email.cz"
        );
        CastkyDokladu castky = new CastkyDokladu(
                5000.0, 6050.0, "snížená", 10.0
        );

        Faktura faktura = new Faktura.Builder()
                .cisloDokladu("2024-002")
                .datumVystaveni(LocalDate.now())
                .datumSplatnosti(LocalDate.now().plusDays(30))
                .prijemce(prijemce)
                .castky(castky)
                .build();

        String text = faktura.toString();
        assertNotNull(text);
        assertFalse(text.isEmpty());
        assertTrue(text.contains("2024-002"));
        assertTrue(text.contains("Petr"));
        assertTrue(text.contains("Brno"));
        assertTrue(text.contains("5000.0"));
        assertTrue(text.contains("6050.0"));
    }
}

