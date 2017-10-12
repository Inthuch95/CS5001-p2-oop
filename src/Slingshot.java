
public class Slingshot extends Tower {
	public Slingshot(int position){
		this.setDamage(1);
		this.setPosition(position);
		this.setWillFire(true);
		this.setCost(5);
	}
}
