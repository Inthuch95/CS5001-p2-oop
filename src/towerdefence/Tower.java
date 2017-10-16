package towerdefence;

public class Tower {
    private int damage, position, cost, firedTime;
    private boolean willFire, fired;
    private static final int CATAPULT_DELAY = 3;
    private static final int VI_DELAY = 5;

    public int getDamage() {
        return this.damage;
    }

    public int getPosition() {
        return this.position;
    }

    public boolean willFire(int timeStep) {
        this.willFire = checkTowerStatus(this, timeStep);

        return this.willFire;
    }

    public boolean getWillFire() {
        return this.willFire;
    }

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

    public int getCost() {
        return this.cost;
    }

    public int getFiredTime() {
        return this.firedTime;
    }

    public boolean getFired() {
        return this.fired;
    }

    public void setFired(boolean fired) {
        this.fired = fired;
    }

    public void setFiredTime(int firedTime) {
        this.firedTime = firedTime;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public void setWillFire(boolean willFire) {
        this.willFire = willFire;
    }

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
