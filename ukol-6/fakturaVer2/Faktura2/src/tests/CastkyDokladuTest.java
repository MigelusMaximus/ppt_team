package tests;
import main.CastkyDokladu;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CastkyDokladuTest {
    @Test
    void testVytvoreniCastkyDokladu() {
        CastkyDokladu castky = new CastkyDokladu(1000.0, 1210.0, "standardní", 21.0);

        assertNotNull(castky);
    }

    @Test
    void testGettery() {
        CastkyDokladu castky = new CastkyDokladu(2000.0, 2420.0, "standardní", 21.0);

        assertEquals(2000.0, castky.getCenaBezDPH());
        assertEquals(2420.0, castky.getCenaSDPH());
        assertEquals("standardní", castky.getSazbaNazev());
        assertEquals(21.0, castky.getSazbaHodnota());
    }

    @Test
    void testToString() {
        CastkyDokladu castky = new CastkyDokladu(500.0, 605.0, "snížená", 21.0);

        String text = castky.toString();
        assertNotNull(text);
        assertFalse(text.isEmpty());
        assertTrue(text.contains("Cena bez DPH"));
        assertTrue(text.contains("Cena s DPH"));
        assertTrue(text.contains("Sazba DPH"));
    }
}
