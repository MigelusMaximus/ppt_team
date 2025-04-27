package tests;
import main.Prijemce;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PrijemceTest {
    @Test
    void testVytvoreniPrijemce() {
        Prijemce prijemce = new Prijemce(
                "Jan", "Novák", "Ulice 1", "Praha", "10000", "123456789", "jan.novak@email.cz"
        );

        assertNotNull(prijemce);
    }

    @Test
    void testToString() {
        Prijemce prijemce = new Prijemce(
                "Petr", "Svoboda", "Náměstí 5", "Brno", "60200", "987654321", "petr.svoboda@email.cz"
        );

        String text = prijemce.toString();
        assertNotNull(text);
        assertFalse(text.isEmpty());
        assertTrue(text.contains("Petr"));
        assertTrue(text.contains("Svoboda"));
        assertTrue(text.contains("Brno"));
        assertTrue(text.contains("987654321"));
        assertTrue(text.contains("petr.svoboda@email.cz"));
    }
}
