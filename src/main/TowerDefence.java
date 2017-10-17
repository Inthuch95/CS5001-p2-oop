package main;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class TowerDefence {

    public static void main(String[] args) throws InterruptedException, IOException {
    	ProcessBuilder pb = new ProcessBuilder("cmd", "/c", "cls");
    	System.out.println("Welcome to tower defence!\n");
        Game towerDef = new Game(Integer.parseInt(args[0]));
        boolean gameOver = false;
        towerDef.startBuildingPhase();
        TimeUnit.SECONDS.sleep(1);
        while (!gameOver) {
            towerDef.spawnEnemies();
            towerDef.updateTowerStatus();
            TimeUnit.SECONDS.sleep(1);
            pb.inheritIO().start().waitFor();
            System.out.println("Time step " + towerDef.getTimeStep());
            System.out.println(towerDef);
            towerDef.advance();
            gameOver = towerDef.checkGameOver();
        }
        TimeUnit.SECONDS.sleep(1);
        pb.inheritIO().start().waitFor();
        System.out.println("End game summary");
        System.out.println("Time step " + towerDef.getTimeStep());
        System.out.println(towerDef);
        System.out.println("Game Over");
    }

}
