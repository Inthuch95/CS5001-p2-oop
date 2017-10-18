package towerdefence;

/**
 * @author Inthuch Therdchanakul
 *A class for the tower slingshot
 */
public class Slingshot extends Tower {
    private static final int DAMAGE = 1;
    private static final int COST = 5;
    /**
     * @param position Corridor position
     * Place a slingshot in the specified position
     */
    public Slingshot(int position) {
        this.setDamage(DAMAGE);
        this.setPosition(position);
        this.setWillFire(true);
        this.setCost(COST);
        this.setFired(false);
    }
}
