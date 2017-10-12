import java.util.ArrayList;

public class Game {
	private ArrayList<Enemy> enemies = new ArrayList<Enemy>();
	private ArrayList<Tower> towers = new ArrayList<Tower>();
	private int corridorLength, timeStep; 
	
	public Game(int corridorLength){
		this.corridorLength = corridorLength;
		this.timeStep = 0;
	}
	
	public void advance(){
		this.timeStep += 1;
	}
}
