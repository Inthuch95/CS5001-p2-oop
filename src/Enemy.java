
public class Enemy {
	private int health, position, spawnTime;
	private boolean willAdvance;
	
	public int getHealth(){
		return this.health;
	}
	
	public int getPosition(){
		return this.position;
	}
	
	public void setHealth(int health){
		this.health = health;
	}
	
	public void setPosition(int position){
		this.position = position;
	}
	
	public void setSpawnTime(int timeStep){
		this.spawnTime = timeStep;
	}
	
	public void hit(Tower t){
		setHealth(this.health-t.getDamage());
	}
	
	public void advance(){
		if(this instanceof Godzilla || this instanceof Rat){
			this.setPosition(this.getPosition() + 2);
		}
		else if(this instanceof Elephant){
			this.setPosition(this.getPosition() + 1);
		}
	}
	
	public void willAdvance(int timeStep){
		if(timeStep == 0){
			this.willAdvance = true;
		}
		else{
			this.willAdvance = checkAdvanceStatus(this, timeStep);
		}
	}
	
	public boolean getWillAdvance(){
		return this.willAdvance;
	}
	
	public void setWillAdvance(boolean willAdvance){
		this.willAdvance = willAdvance;
	}
	
	private boolean checkAdvanceStatus(Enemy e, int timeStep){
		boolean willAdvance = false;
		if(e instanceof Godzilla && ((timeStep-this.spawnTime) % 5) == 0){
			willAdvance = true;
		}
		else if(e instanceof Elephant && ((timeStep-this.spawnTime) % 2) == 0){
			willAdvance = true;
		}
		else if(e instanceof Rat){
			willAdvance = true;
		}
		
		
		return willAdvance;
	}
	
	@Override
	public String toString(){
		String enemy = "";
		String health = "Health: " + Integer.toString(this.health);
		String position = "Position: " + Integer.toString(this.position);
		
		if(this instanceof Godzilla){
			enemy = "Enemy: Godzilla";
		}
		else if(this instanceof Elephant){
			enemy = "Enemy: Elephant";
		}
		else if(this instanceof Rat){
			enemy = "Enemy: Rat";
		}
		String output = String.format("%-20s %-20s %-20s\n", enemy, 
				health, position);
		
		return output;
	}
}
