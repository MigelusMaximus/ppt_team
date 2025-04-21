package org.example.fakturatrida;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.*;

public class FakturaTests {
    @Test
    void testToStringObsahujeCisloDokladu() {
        Faktura faktura = new Faktura(
                "M00005", LocalDate.now(), LocalDate.now().plusDays(14),
                "Pauline", "Deschamps", "Fritzova 123", "Jihlava", "58601",
                "123456789", "pauline@seznam.cz",
                2000.0, 0.21, "Z"
        );

        String vystup = faktura.toString();
        assertTrue(vystup.contains("M00005"));
        assertTrue(vystup.contains("Z (21.0%)"));
        assertTrue(vystup.contains("2420.0 Kč"));
    }
}
