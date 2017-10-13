
public class Rat extends Enemy {
	public Rat(int timeStep){
		this.setHealth(1);
		this.setPosition(1);
		this.setSpawnTime(timeStep);
	}
	
	public void advance(){
		this.setPosition(this.getPosition() + 2);
	}
}
