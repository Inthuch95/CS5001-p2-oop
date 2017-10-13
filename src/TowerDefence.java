
public class TowerDefence {

	public static void main(String[] args) {
		System.out.println("Welcome to tower defence!\n");
		Game towerDef = new Game(Integer.parseInt(args[0]));
		boolean gameOver = false;
		towerDef.buildTower();
		while(!gameOver){
			towerDef.spawnEnemies();
			System.out.println("Time step " + towerDef.getTimeStep() + "\n");
			System.out.println(towerDef);
			towerDef.advance();
			
			gameOver = true;
		}
		System.out.println("Game Over");
	}

}
