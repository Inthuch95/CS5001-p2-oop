package towerdefence;

/**
 * @author Inthuch Therdchanakul
 * A class for the tower "Catapult"
 *
 */
public class Catapult extends Tower {
    private static final int DAMAGE = 5;
    private static final int COST = 20;
    /**
     * @param position corridor position
     * Place a catapult in the specified position along the corridor
     */
    public Catapult(int position) {
        this.setDamage(DAMAGE);
        this.setPosition(position);
        this.setWillFire(true);
        this.setCost(COST);
        this.setFired(false);
    }
}
