
public class Enemy {
	private int health, position;
	
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
	
	public void hit(Tower t){
		
	}
	
	public void advance(){
		
	}
	
	@Override
	public String toString(){
		String enemy;
		String health = "Health: " + Integer.toString(this.health);
		String position = "Position: " + Integer.toString(this.position);
		
		if(this.health == 20){
			enemy = "Enemy: Godzilla";
		}
		else if(this.health == 10){
			enemy = "Enemy: Elephant";
		}
		else{
			enemy = "Enemy: Rat";
		}
		String output = String.format("%-20s %-20s %-20s\n", enemy, 
				health, position);
		
		return output;
	}
}
