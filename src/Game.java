import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Game {
	private ArrayList<Enemy> enemies = new ArrayList<Enemy>();
	private ArrayList<Tower> towers = new ArrayList<Tower>();
	private Random generator = new Random();
	private int corridorLength, timeStep;
	private int budget = 100;
	
	public Game(int corridorLength){
		this.corridorLength = corridorLength;
		this.timeStep = 0;
	}
	
	public void spawnEnemies(){
		// can spawn up to three enemies at each time step
		// can only spawn one type of enemy at each time step
		int numOfEnemies = this.generator.nextInt(3) + 1;
		int enemyType = this.generator.nextInt(3);
		for(int i=0;i<numOfEnemies;i++){
			switch(enemyType){
				case 0:
					this.enemies.add(new Rat());
					break;
				case 1:
					this.enemies.add(new Elephant());
					break;
				case 2:
					this.enemies.add(new Godzilla());
					break;
				default:
					System.out.println("Unknown enemy!");
			}
		}
	}
	
	public void buildTower(){
		boolean finishedBuilding = false;
		Scanner scanner = new Scanner(System.in);
		String cmd;
		String towerType;
		int towerPos, cost;
		
		System.out.println("Tower building phase");
		System.out.println("Usage: " );
		System.out.printf("%-30s %33s", "tower_type tower_position", "Build tower in "
				+ "specified position\n");
		System.out.printf("%-30s %5s", "done", "Exit tower building phase\n\n");
		System.out.println("Remaining budget: " + Integer.toString(this.budget));
		while(!finishedBuilding){
			System.out.println("Command: ");
			cmd = scanner.nextLine();
			String[] cmdSplitted = cmd.split("\\s+");
			towerType = cmdSplitted[0];
			
			switch(towerType){
				// build the tower and update the budget
				case "S":
					towerPos = Integer.parseInt(cmdSplitted[1]);
					Slingshot slingshot = new Slingshot(towerPos);
					cost = slingshot.getCost();
					if(this.budget-cost >= 0){
						this.towers.add(slingshot);
						this.budget = this.budget - cost;
						System.out.println("Remaining budget: " + 
								Integer.toString(this.budget));
					}
					else{
						System.out.println("You cannot afford this tower!");
					}
					break;
				case "C":
					towerPos = Integer.parseInt(cmdSplitted[1]);
					Catapult catapult = new Catapult(towerPos);
					cost = catapult.getCost();
					if(this.budget-cost >= 0){
						this.towers.add(catapult);
						this.budget = this.budget - cost;
						System.out.println("Remaining budget: " + 
								Integer.toString(this.budget));
					}
					else{
						System.out.println("You cannot afford this tower!");
					}
					break;
				case "V":
					towerPos = Integer.parseInt(cmdSplitted[1]);
					VacuumImploder vi = new VacuumImploder(towerPos);
					cost = vi.getCost();
					if(this.budget-cost >= 0){
						this.towers.add(vi);
						this.budget = this.budget - cost;
						System.out.println("Remaining budget: " + 
								Integer.toString(this.budget));
					}
					else{
						System.out.println("You cannot afford this tower!");
					}
					break;
				case "done":
					System.out.println("Tower set up completed\n");
					finishedBuilding = true;
					break;
				default:
					System.out.println("Unknown command!");
					break;
			}
		}
		scanner.close();
	}
	
	public int getTimeStep(){
		return this.timeStep;
	}
	
	public void advance(){
		this.timeStep += 1;
	}
	
	@Override
	public String toString(){
		String output = "Tower status:\n";
		for(int i=0;i<this.towers.size();i++){
			output += this.towers.get(i);
		}
		output += "\nEnemies Status:\n";
		for(int i=0;i<this.enemies.size();i++){
			output += this.enemies.get(i);
		}
		
		return output;
	}
}
