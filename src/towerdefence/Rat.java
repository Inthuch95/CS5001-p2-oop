package towerdefence;

public class Rat extends Enemy {
    private static final int HEALTH = 1;
    public Rat() {
        this.setHealth(HEALTH);
        this.setPosition(0);
    }

    public void advance() {
        this.setDelay(this.getDelay() + 1);
        this.willAdvance(this.getTimeStep());
        if (this.getWillAdvance()) {
            this.setPosition(this.getPosition() + 2);
        }
    }

}
