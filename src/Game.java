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
	
	public void play(){
		boolean gameOver = false;
		buildTower();
		while(!gameOver){
			spawnEnemies();
			advance();
			System.out.println(this.timeStep);
			
			gameOver = true;
		}
	}
	
	private void spawnEnemies(){
		// get the random number of spawning enemies and random type of spawning enemies
		int numOfEnemies = this.generator.nextInt(3);
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
	
	private void buildTower(){
		boolean finishedBuilding = false;
		Scanner scanner = new Scanner(System.in);
		String cmd;
		String towerType;
		int towerPos, cost;
		
		System.out.println("Welcome to tower building phase!");
		System.out.println("Please add a tower in the command: "
				+ "tower_type tower_position");
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
					}
					else{
						System.out.println("You cannot afford this tower!");
					}
					break;
				case "done":
					System.out.println("Tower set up completed");
					finishedBuilding = true;
					break;
				default:
					System.out.println("Unknown command!");
					break;
			}
		}
		scanner.close();
	}
	
	public void advance(){
		this.timeStep += 1;
	}
}
