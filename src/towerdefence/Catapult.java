package towerdefence;

public class Catapult extends Tower {
    private static final int DAMAGE = 5;
    private static final int COST = 20;
    
    public Catapult(int position) {
        this.setDamage(DAMAGE);
        this.setPosition(position);
        this.setWillFire(true);
        this.setCost(COST);
        this.setFired(false);
    }
}
