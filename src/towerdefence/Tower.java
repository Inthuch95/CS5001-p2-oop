package towerdefence;

/**
 * @author Inthuch Therdchanakul
 *Tower super class
 */
public class Tower {
    private int damage, position, cost, firedTime;
    private boolean willFire, fired;
    private static final int CATAPULT_DELAY = 3;
    private static final int VI_DELAY = 5;
    /**
     * @return The damage of the tower
     */
    public int getDamage() {
        return this.damage;
    }

    /**
     * @return The position of the tower
     */
    public int getPosition() {
        return this.position;
    }

    /**
     * @param timeStep Current time step of the game
     * @return The boolean value that determine the ability to fire
     */
    public boolean willFire(int timeStep) {
        this.willFire = checkTowerStatus(this, timeStep);

        return this.willFire;
    }

    /**
     * @return The boolean value that determine the ability to fire 
     */
    public boolean getWillFire() {
        return this.willFire;
    }

    /**
     * @param t The tower that is being checked
     * @param timeStep Current time step of the game
     * @return The status of the tower
     */
    private boolean checkTowerStatus(Tower t, int timeStep) {
        boolean willFire = false;
        if (t instanceof VacuumImploder && ((timeStep - this.firedTime) % VI_DELAY) == 0) {
            willFire = true;
        } else if (t instanceof Catapult && ((timeStep - this.firedTime) % CATAPULT_DELAY) == 0) {
            willFire = true;
        } else if (t instanceof Slingshot) {
            willFire = true;
        }

        return willFire;
    }

    /**
     * @return The cost of the tower
     */
    public int getCost() {
        return this.cost;
    }

    /**
     * @return The time step that the tower fired
     */
    public int getFiredTime() {
        return this.firedTime;
    }

    /**
     * @return The boolean value that indicate if the tower 
     * did fire or not in the current time step
     */
    public boolean getFired() {
        return this.fired;
    }

    /**
     * @param fired Boolean value that indicate the state of the tower
     * Indicate that the tower did fire in the current time step
     */
    public void setFired(boolean fired) {
        this.fired = fired;
    }

    /**
     * @param firedTime The latest time step that the tower fired at an enemy
     * Assign the latest time step that the tower fired at an enemy 
     */
    public void setFiredTime(int firedTime) {
        this.firedTime = firedTime;
    }

    /**
     * @param damage The damage that the tower can do to an enemy
     * Assign the damage to the tower
     */
    public void setDamage(int damage) {
        this.damage = damage;
    }

    /**
     * @param position Position of the tower
     * Assign the position to the tower
     */
    public void setPosition(int position) {
        this.position = position;
    }

    /**
     * @param willFire The boolean value that indicate the status of the tower
     * Change the tower status
     */
    public void setWillFire(boolean willFire) {
        this.willFire = willFire;
    }

    /**
     * @param cost The cost of the tower
     * Assign cost to the tower
     */
    public void setCost(int cost) {
        this.cost = cost;
    }

    @Override
    public String toString() {
        String damage = "Damage: " + Integer.toString(this.damage);
        String position = "Position: " + Integer.toString(this.position);
        String status;
        String tower = "";

        if (this.getWillFire()) {
            status = "Status: Ready";
        } else {
            status = "Status: Loading";
        }

        if (this instanceof VacuumImploder) {
            tower = "Tower: Vacuum Imploder";
        } else if (this instanceof Catapult) {
            tower = "Tower: Catapult";
        } else if (this instanceof Slingshot) {
            tower = "Tower: Slingshot";
        }
        String output = String.format("%-25s %-15s %-15s %-15s\n", tower, damage, position, status);

        return output;
    }

}
