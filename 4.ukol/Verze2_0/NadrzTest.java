
import org.junit.Test;
import static org.junit.Assert.*;

public class NadrzTest {

    @Test
    public void testConstructorAndGetKapacita() {
        Nadrz nadrz = new Nadrz(100.0);
        assertEquals(100.0, nadrz.get_kapacita(), 0.0001);
    }

    @Test
    public void testAddValidAmount() throws Exception {
        Nadrz nadrz = new Nadrz(100.0);
        nadrz.add(50.0);
    }

    @Test(expected = PlnaNadrzException.class)
    public void testAddTooMuch() throws Exception {
        Nadrz nadrz = new Nadrz(100.0);
        nadrz.add(120.0);
    }

    @Test
    public void testRemoveValidAmount() throws Exception {
        Nadrz nadrz = new Nadrz(100.0);
        nadrz.add(70.0);
        nadrz.remove(50.0);
    }

    @Test(expected = PrazdnaNadrzException.class)
    public void testRemoveTooMuch() throws Exception {
        Nadrz nadrz = new Nadrz(100.0);
        nadrz.add(30.0);
        nadrz.remove(40.0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNegativeAdd() throws Exception {
        Nadrz nadrz = new Nadrz(100.0);
        nadrz.add(-10.0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNegativeRemove() throws Exception {
        Nadrz nadrz = new Nadrz(100.0);
        nadrz.remove(-20.0);
    }
}
