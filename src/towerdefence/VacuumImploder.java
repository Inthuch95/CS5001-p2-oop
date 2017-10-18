package towerdefence;

/**
 * @author Inthuch Therdchanakul
 *A class for the tower Vacuum imploder
 */
public class VacuumImploder extends Tower {
    private static final int DAMAGE = 20;
    private static final int COST = 30;
    /**
     * @param position corridor position
     * Place a vacuum imploder in the specified position
     */
    public VacuumImploder(int position) {
        this.setDamage(DAMAGE);
        this.setPosition(position);
        this.setWillFire(true);
        this.setCost(COST);
        this.setFired(false);
    }
}
