
public class TowerDefence {

	public static void main(String[] args) {
		System.out.println("Welcome to tower defence!\n");
		Game towerDef = new Game(Integer.parseInt(args[0]));
		boolean gameOver = false;
		towerDef.buildTower();
		while(!gameOver){
			towerDef.spawnEnemies();
			towerDef.updateTowerStatus();
			System.out.println("Time step " + towerDef.getTimeStep());
			System.out.println(towerDef);
			towerDef.advance();
			gameOver = towerDef.checkGameOver();
		}
		System.out.println("End game summary");
		System.out.println(towerDef);
		System.out.println("Game Over");
	}

}
