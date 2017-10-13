
public class Godzilla extends Enemy {
	public Godzilla(int timeStep){
		this.setHealth(20);
		this.setPosition(1);
		this.setSpawnTime(timeStep);
	}
	
	public void advance(){
		this.setPosition(this.getPosition() + 2);
	}
}
