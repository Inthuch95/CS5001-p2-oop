
public class Tower {
	private int damage, position;
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
	
	public void setDamage(int damage){
		this.damage = damage;	
	}
		
	public void setPosition(int position){
		this.position = position;
	}
	
	public void setWillFire(boolean willFire){
		this.willFire = willFire;
	}
	
}
