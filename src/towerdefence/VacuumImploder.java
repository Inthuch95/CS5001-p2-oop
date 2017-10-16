package towerdefence;

public class VacuumImploder extends Tower {
    private static final int DAMAGE = 20;
    private static final int COST = 30;
    
    public VacuumImploder(int position) {
        this.setDamage(DAMAGE);
        this.setPosition(position);
        this.setWillFire(true);
        this.setCost(COST);
        this.setFired(false);
    }
}
