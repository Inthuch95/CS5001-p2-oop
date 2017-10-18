package towerdefence;

/**
 * @author User
 *Enemy super class
 */
public class Enemy {
    private int health, position, timeStep, delay;
    private boolean willAdvance;
    private static final int GODZILLA_DELAY = 5;
    private static final int ELEPHANT_DELAY = 2;
    /**
     * @return The remaining health point
     */
    public int getHealth() {
        return this.health;
    }

    /**
     * @return Current position
     */
    public int getPosition() {
        return this.position;
    }

    /**
     * @param health Value of health point to assign
     * Assign health to the enemy
     */
    public void setHealth(int health) {
        this.health = health;
    }

    /**
     * @param position Value of position to assign
     * Assign position to an enemy
     */
    public void setPosition(int position) {
        this.position = position;
    }

    /**
     * @param timeStep Duration that the enemy remain in the game
     * Set the duration that the enemy remain in the game
     */
    public void setTimeStep(int timeStep) {
        this.timeStep = timeStep;
    }

    /**
     * @return Duration that the enemy remain in the game
     */
    public int getTimeStep() {
        return this.timeStep;
    }

    /**
     * @return Delay associate with the enemy (used to decide if it can advance)
     */
    public int getDelay() {
        return this.delay;
    }

    /**
     * @param delay Time since last advancement
     * Set the time since the enemy's last advancement
     */
    public void setDelay(int delay) {
        this.delay = delay;
    }

    /**
     * @param t Tower that hit the enemy
     * Hit the enemy and update health
     */
    public void hit(Tower t) {
        if (this.getPosition() <= t.getPosition()) {
            setHealth(this.health - t.getDamage());
            t.setFired(true);
        }
    }

    /**
     * Advance to the next position
     */
    public void advance() {
        this.delay++;
        this.willAdvance(this.timeStep);
        if (this.willAdvance) {
            this.setPosition(this.getPosition() + 1);
        }
    }

    /**
     * @param timeStep Current time step of the game
     * Check if the enemy can advance
     */
    public void willAdvance(int timeStep) {
        if (timeStep == 1 && !(this instanceof Rat)) {
            this.willAdvance = false;
        } else {
            this.willAdvance = this.checkAdvanceStatus(this);
        }
    }

    /**
     * @return The boolean that indicate the ability to advance
     */
    public boolean getWillAdvance() {
        return this.willAdvance;
    }

    /**
     * @param e Enemy that is being checked
     * @return The boolean value that indicate the ability to advance
     */
    private boolean checkAdvanceStatus(Enemy e) {
        boolean willAdvance = false;
        if (e instanceof Godzilla && this.delay == GODZILLA_DELAY) {
            willAdvance = true;
            this.delay = 0;
        } else if (e instanceof Elephant && this.delay == ELEPHANT_DELAY) {
            willAdvance = true;
            this.delay = 0;
        } else if (e instanceof Rat) {
            willAdvance = true;
        }

        return willAdvance;
    }

    @Override
    public String toString() {
        String enemy = "";
        String health = "Health: " + Integer.toString(this.health);
        String position = "Position: " + Integer.toString(this.position);

        if (this instanceof Godzilla) {
            enemy = "Enemy: Godzilla";
        } else if (this instanceof Elephant) {
            enemy = "Enemy: Elephant";
        } else if (this instanceof Rat) {
            enemy = "Enemy: Rat";
        }
        String output = String.format("%-20s %-20s %-20s\n", enemy, health, position);

        return output;
    }
}
