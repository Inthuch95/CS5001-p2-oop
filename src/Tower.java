
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
		if(timeStep == 0){
			this.willFire = true;
		}
		else{
			this.willFire = checkTowerStatus(this, timeStep);
		}
		
		return this.willFire;
	}
	
	public boolean getWillFire(){
		return this.willFire;
	}
	
	private boolean checkTowerStatus(Tower t, int timeStep){
		boolean willFire = false;
		if(t instanceof VacuumImploder && (timeStep % 5) == 0){
			willFire = true;
		}
		else if(t instanceof Catapult && (timeStep % 3) == 0){
			willFire = true;
		}
		else if(t instanceof Slingshot){
			willFire = true;
		}
		
		
		return willFire;
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
		String tower = "";
		
		if(this.getWillFire()){
			status = "Status: Ready";
		}
		else{
			status = "Status: Loading";
		}
		
		if(this instanceof VacuumImploder){
			tower = "Tower: Vacuum Imploder";
		}
		else if(this instanceof Catapult){
			tower = "Tower: Catapult";
		}
		else if(this instanceof Slingshot){
			tower = "Tower: Slingshot";
		}
		String output = String.format("%-25s %-15s %-15s %-15s\n", tower, damage, 
				position, status);
		
		return output;
	}
	
}
