
public class Tower {
	private int damage, position, cost;
	private boolean willFire;
	
	public int getDamage(){
	return this.damage;	
	}
	
	public int getPosition(){
		return this.position;
	}
	
	public boolean willFire(int timeStep){
		return this.willFire;
	}
	
	public int getCost(){
		return this.cost;
	}
	
	public void setDamage(int damage){
		this.damage = damage;	
	}
		
	public void setPosition(int position){
		this.position = position;
	}
	
	public void setWillFire(boolean willFire){
		this.willFire = willFire;
	}
	
	public void setCost(int cost){
		this.cost = cost;
	}
	
	@Override
	public String toString(){
		String damage = "Damage: " + Integer.toString(this.damage);
		String position = "Position: " + Integer.toString(this.position);
		String status;
		String tower;
		
		if(this.willFire){
			status = "Status: Ready";
		}
		else{
			status = "Status: Loading";
		}
		
		if(this.damage == 10){
			tower = "Tower: Vacuum Imploder";
		}
		else if(this.damage == 5){
			tower = "Tower: Catapult";
		}
		else{
			tower = "Tower: Slingshot";
		}
		String output = String.format("%-25s %-15s %-15s %-15s\n", tower, damage, 
				position, status);
		
		return output;
	}
	
}
