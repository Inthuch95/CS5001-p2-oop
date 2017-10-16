package towerdefence;

public class Enemy {
    private int health, position, timeStep, delay;
    private boolean willAdvance;
    private static final int GODZILLA_DELAY = 5;
    private static final int ELEPHANT_DELAY = 2;

    public int getHealth() {
        return this.health;
    }

    public int getPosition() {
        return this.position;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public void setTimeStep(int timeStep) {
        this.timeStep = timeStep;
    }

    public int getTimeStep() {
        return this.timeStep;
    }

    public int getDelay() {
        return this.delay;
    }

    public void setDelay(int delay) {
        this.delay = delay;
    }

    public void hit(Tower t) {
        if (this.getPosition() <= t.getPosition()) {
            setHealth(this.health - t.getDamage());
            t.setFired(true);
        }
    }

    public void advance() {
        this.delay++;
        this.willAdvance(this.timeStep);
        if (this.willAdvance) {
            this.setPosition(this.getPosition() + 1);
        }
    }

    public void willAdvance(int timeStep) {
        if (timeStep == 1 && !(this instanceof Rat)) {
            this.willAdvance = false;
        } else {
            this.willAdvance = this.checkAdvanceStatus(this);
        }
    }

    public boolean getWillAdvance() {
        return this.willAdvance;
    }

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
