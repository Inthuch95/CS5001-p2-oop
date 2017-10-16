package towerdefence;

public class Slingshot extends Tower {
    private static final int DAMAGE = 1;
    private static final int COST = 5;
    
    public Slingshot(int position) {
        this.setDamage(DAMAGE);
        this.setPosition(position);
        this.setWillFire(true);
        this.setCost(COST);
        this.setFired(false);
    }
}
