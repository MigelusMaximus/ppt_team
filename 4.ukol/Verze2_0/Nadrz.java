
/**
 * Class representing a fuel tank with limited capacity.
 * Supports adding and removing liquid, with overflow and underflow protection
 * via exceptions.
 */
public class Nadrz {

    private double kapacita;
    private double stav;

    /**
     * Constructor to create a tank with a given capacity.
     * 
     * @param kapacita the maximum capacity of the tank
     */
    public Nadrz(double kapacita) {
        set_kapacita(kapacita);
        stav = 0.0;
    }

    private void set_kapacita(double kapacita) {
        if (kapacita > 0.0)
            this.kapacita = kapacita;
    }

    /**
     * @return the capacity of the tank
     */
    public double get_kapacita() {
        return kapacita;
    }

    /**
     * Adds a given amount of liquid to the tank.
     * 
     * @param kolik amount to add
     * @throws IllegalArgumentException if amount is negative
     * @throws PlnaNadrzException       if adding would exceed capacity
     */
    public void add(double kolik) throws PlnaNadrzException {
        if (kolik < 0.0)
            throw new IllegalArgumentException("Cannot add negative amount.");
        if (stav + kolik > kapacita)
            throw new PlnaNadrzException("Tank overflow.");
        stav += kolik;
    }

    /**
     * Removes a given amount of liquid from the tank.
     * 
     * @param kolik amount to remove
     * @throws IllegalArgumentException if amount is negative
     * @throws PrazdnaNadrzException    if removing more than is available
     */
    public void remove(double kolik) throws PrazdnaNadrzException {
        if (kolik < 0.0)
            throw new IllegalArgumentException("Cannot remove negative amount.");
        if (stav - kolik < 0.0)
            throw new PrazdnaNadrzException("Tank underflow.");
        stav -= kolik;
    }
}
