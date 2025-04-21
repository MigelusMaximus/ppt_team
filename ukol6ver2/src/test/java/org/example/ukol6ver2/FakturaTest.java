package org.example.ukol6ver2;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.*;

public class FakturaTest {
    @Test
    public void testToString() {
        Prijemce prijemce = new Prijemce("Jan", "Novák", "Hlavní 123", "Praha", "10000", "123456789", "jan.novak@example.com");
        CastkyDokladu castky = new CastkyDokladu(2000.0, 2420.0, "21%");
        Faktura faktura = new Faktura("F001", LocalDate.now(), LocalDate.now().plusDays(14), prijemce, castky);

        String expected = "Faktura: F001\nDatum vystavení: " + LocalDate.now() + "\nDatum splatnosti: " + LocalDate.now().plusDays(14) +
                "\n\nPříjemce:\nJan Novák\nHlavní 123, Praha 10000\nTel: 123456789\nEmail: jan.novak@example.com\n\nČástky:\nCena bez DPH: 2000.0\nCena s DPH: 2420.0\nSazba: 21%";

        assertEquals(expected, faktura.toString());
    }
}
