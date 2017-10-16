package towerdefence;

public class Elephant extends Enemy {
    private static final int HEALTH = 10;
    public Elephant() {
        this.setHealth(HEALTH);
        this.setPosition(0);
        this.setDelay(0);
    }

    public void advance() {
        this.setDelay(this.getDelay() + 1);
        this.willAdvance(this.getTimeStep());
        if (this.getWillAdvance()) {
            this.setPosition(this.getPosition() + 1);
            this.setDelay(0);
        }
    }

}
