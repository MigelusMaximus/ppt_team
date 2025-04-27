    package tests;

    import main.CastkyDokladu;
    import main.ZauctujFakturu;
    import org.junit.jupiter.api.Test;
    import static org.junit.jupiter.api.Assertions.*;

    public class ZauctujFakturuTest {
        @Test
        void testVypocetCastky() {
            // Test pro výpočet pro standardní sazbu
            CastkyDokladu castky = ZauctujFakturu.vypocitejCastky(1000.0, 21.0);

            assertNotNull(castky); // Ověříme, že vrácený objekt není null
            assertEquals(1000.0, castky.getCenaBezDPH()); // Cena bez DPH musí být 1000.0
            assertEquals(1210.0, castky.getCenaSDPH(), 0.01); // Cena s DPH (1000 + 21%) = 1210.0
            assertEquals("standardní", castky.getSazbaNazev()); // Sazba by měla být standardní
            assertEquals(21.0, castky.getSazbaHodnota(), 0.01); // Sazba DPH by měla být 21%
        }

        @Test
        void testVypocetCastkySnizena() {
            // Test pro výpočet pro sníženou sazbu
            CastkyDokladu castky = ZauctujFakturu.vypocitejCastkySnížená(1000.0);

            assertNotNull(castky);
            assertEquals(1000.0, castky.getCenaBezDPH());
            assertEquals(1100.0, castky.getCenaSDPH(), 0.01); // Cena s DPH pro sníženou sazbu (1000 + 10%)
            assertEquals("snížená", castky.getSazbaNazev());
            assertEquals(10.0, castky.getSazbaHodnota(), 0.01);
        }
    }
