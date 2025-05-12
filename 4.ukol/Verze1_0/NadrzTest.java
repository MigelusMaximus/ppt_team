
// File: NadrzTest.java
import org.junit.Test;
import static org.junit.Assert.*;

public class NadrzTest {

    @Test
    public void testConstructorAndGetKapacita() {
        Nadrz nadrz = new Nadrz(100.0);
        assertEquals(100.0, nadrz.get_kapacita(), 0.0001);
    }

    @Test
    public void testAddValidAmount() {
        Nadrz nadrz = new Nadrz(100.0);
        assertTrue(nadrz.add(50.0));
    }

    @Test
    public void testAddTooMuch() {
        Nadrz nadrz = new Nadrz(100.0);
        assertFalse(nadrz.add(120.0));
    }

    @Test
    public void testRemoveValidAmount() {
        Nadrz nadrz = new Nadrz(100.0);
        nadrz.add(70.0);
        assertTrue(nadrz.remove(50.0));
    }

    @Test
    public void testRemoveTooMuch() {
        Nadrz nadrz = new Nadrz(100.0);
        nadrz.add(30.0);
        assertFalse(nadrz.remove(40.0));
    }

    @Test
    public void testNegativeAdd() {
        Nadrz nadrz = new Nadrz(100.0);
        assertFalse(nadrz.add(-10.0));
    }

    @Test
    public void testNegativeRemove() {
        Nadrz nadrz = new Nadrz(100.0);
        assertFalse(nadrz.remove(-20.0));
    }
}
