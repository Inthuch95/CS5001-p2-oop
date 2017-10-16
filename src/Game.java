import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Random;
import java.util.Scanner;

import towerdefence.Tower;
import towerdefence.Enemy;
import towerdefence.Rat;
import towerdefence.Elephant;
import towerdefence.Godzilla;
import towerdefence.Slingshot;
import towerdefence.Catapult;
import towerdefence.VacuumImploder;;

public class Game {
    private ArrayList<Enemy> enemies = new ArrayList<Enemy>();
    private ArrayList<Tower> towers = new ArrayList<Tower>();
    private ArrayList<Integer> occupiedPos = new ArrayList<Integer>();
    private Random generator = new Random();
    private int corridorLength, timeStep, budget;
    private static final int STARTING_BUDGET = 100;
    private static final int RND_MAX = 3;
    public Game(int corridorLength) {
        this.corridorLength = corridorLength;
        this.timeStep = 1;
        this.budget = STARTING_BUDGET;
    }

    public void advance() {
        shootEnemies();
        for (int i = 0; i < enemies.size(); i++) {
            enemies.get(i).setTimeStep(this.timeStep + 1);
            enemies.get(i).advance();
            if (enemies.get(i).getPosition() > this.corridorLength - 1) {
                enemies.get(i).setPosition(this.corridorLength - 1);
            }
        }
        this.timeStep += 1;
    }

    public boolean checkGameOver() {
        boolean gameOver = false;
        for (int i = 0; i < enemies.size(); i++) {
            if (enemies.get(i).getPosition() == this.corridorLength - 1) {
                gameOver = true;
                break;
            }
        }

        return gameOver;
    }

    public void updateTowerStatus() {
        for (int i = 0; i < this.towers.size(); i++) {
            if (this.towers.get(i).getFired()) {
                this.towers.get(i).willFire(this.timeStep);
            }
        }
    }

    private void shootEnemies() {
        // Each tower shoot the closest enemies
        int target;
        for (int i = 0; i < this.towers.size(); i++) {
            if (enemies.size() > 0) {
                target = this.chooseTarget(this.towers.get(i).getPosition());
                if (this.towers.get(i).getWillFire()) {
                    this.enemies.get(target).hit(this.towers.get(i));
                    if (this.towers.get(i).getFired()) {
                        this.towers.get(i).setFiredTime(this.timeStep);
                    }
                    if (!(this.towers.get(i) instanceof Slingshot)) {
                        this.towers.get(i).setWillFire(false);
                    }
                    // remove the enemy when it dies
                    if (this.enemies.get(target).getHealth() <= 0) {
                        this.enemies.remove(target);
                    }
                }
            }
        }
    }

    private int chooseTarget(int towerPos) {
        int target = 0;
        for (int i = 0; i < this.enemies.size(); i++) {
            if (this.enemies.get(i).getPosition() <= towerPos) {
                target = i;
                break;
            }
        }
        return target;
    }

    public void spawnEnemies() {
        // can spawn up to three enemies at each time step
        // can only spawn one type of enemy at each time step
        int numOfEnemies = this.generator.nextInt(RND_MAX) + 1;
        int enemyType = this.generator.nextInt(RND_MAX);
        for (int i = 0; i < numOfEnemies; i++) {
            switch (enemyType) {
            case 0:
                Rat r = new Rat();
                r.setTimeStep(this.timeStep);
                this.enemies.add(r);
                break;
            case 1:
                Elephant e = new Elephant();
                e.setTimeStep(this.timeStep);
                this.enemies.add(e);
                break;
            case 2:
                Godzilla g = new Godzilla();
                g.setTimeStep(this.timeStep);
                this.enemies.add(g);
                break;
            default:
                System.out.println("Unknown enemy!");
            }
        }

        // sort array based on enemy position
        Collections.sort(this.enemies, new Comparator<Enemy>() {
            @Override
            public int compare(Enemy e1, Enemy e2) {
                return e2.getPosition() - e1.getPosition();
            }

        });
    }

    public void buildTower() {
        boolean finishedBuilding = false;
        Scanner scanner = new Scanner(System.in);
        String cmd;
        String towerType;
        int towerPos, cost;

        System.out.println("Tower building phase");
        System.out.println("Usage: ");
        System.out.printf("%-30s %33s", "tower_type tower_position", "Build tower in " + "specified position\n");
        System.out.printf("%-30s %5s", "done", "Exit tower building phase\n\n");
        System.out.println("Remaining budget: " + Integer.toString(this.budget));
        while (!finishedBuilding && this.budget > 0) {
            System.out.println("Command: ");
            cmd = scanner.nextLine();
            String[] cmdSplitted = cmd.split("\\s+");
            towerType = cmdSplitted[0];

            switch (towerType) {
            // build the tower and update the budget
            case "S":
                towerPos = Integer.parseInt(cmdSplitted[1]);
                Slingshot slingshot = new Slingshot(towerPos);
                cost = slingshot.getCost();
                if (this.budget - cost >= 0 && !this.occupiedPos.contains(towerPos)) {
                    this.towers.add(slingshot);
                    this.budget = this.budget - cost;
                    this.occupiedPos.add(towerPos);
                    System.out.println("Remaining budget: " + Integer.toString(this.budget));
                } else {
                    System.out.println("You cannot build this tower!");
                }
                break;
            case "C":
                towerPos = Integer.parseInt(cmdSplitted[1]);
                Catapult catapult = new Catapult(towerPos);
                cost = catapult.getCost();
                if (this.budget - cost >= 0 && !this.occupiedPos.contains(towerPos)) {
                    this.towers.add(catapult);
                    this.budget = this.budget - cost;
                    this.occupiedPos.add(towerPos);
                    System.out.println("Remaining budget: " + Integer.toString(this.budget));
                } else {
                    System.out.println("You cannot build this tower!");
                }
                break;
            case "V":
                towerPos = Integer.parseInt(cmdSplitted[1]);
                VacuumImploder vi = new VacuumImploder(towerPos);
                cost = vi.getCost();
                if (this.budget - cost >= 0 && !this.occupiedPos.contains(towerPos)) {
                    this.towers.add(vi);
                    this.budget = this.budget - cost;
                    this.occupiedPos.add(towerPos);
                    System.out.println("Remaining budget: " + Integer.toString(this.budget));
                } else {
                    System.out.println("You cannot build this tower!");
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
        // small tower shoot first
        Collections.sort(this.towers, new Comparator<Tower>() {
            @Override
            public int compare(Tower t1, Tower t2) {
                return t1.getDamage() - t2.getDamage();
            }

        });
    }

    public int getTimeStep() {
        return this.timeStep;
    }

    @Override
    public String toString() {
        String output = "Tower status\n";
        for (int i = 0; i < this.towers.size(); i++) {
            output += this.towers.get(i);
        }
        output += "\nEnemies Status\n";
        for (int i = 0; i < this.enemies.size(); i++) {
            output += this.enemies.get(i);
        }

        return output;
    }
}
