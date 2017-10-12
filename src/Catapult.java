
public class Catapult extends Tower {
	public Catapult(int position){
		this.setDamage(5);
		this.setPosition(position);
		this.setWillFire(true);
		this.setCost(20);
	}
}
