package towerdefence;

/**
 * @author Inthuch Therdchanakul
 *A class of enemy godzilla
 */
public class Godzilla extends Enemy {
    private static final int HEALTH = 20;
    /**
     * Spawn a godzilla in the game
     */
    public Godzilla() {
        this.setHealth(HEALTH);
        this.setPosition(0);
        this.setDelay(0);
    }

    public void advance() {
        this.setDelay(this.getDelay() + 1);
        this.willAdvance(this.getTimeStep());
        if (this.getWillAdvance()) {
            this.setPosition(this.getPosition() + 2);
            this.setDelay(0);
        }
    }

}
