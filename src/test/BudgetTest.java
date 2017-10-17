package test;

import static org.junit.Assert.*;

import org.junit.Test;

import main.Game;
import towerdefence.Catapult;
import towerdefence.Slingshot;
import towerdefence.VacuumImploder;

public class BudgetTest {

	@Test
	public void testStartingBudget() {
		Game towerDef = new Game(10);
		assertEquals(100, towerDef.getBudget());
	}
	
	@Test
	public void testVICost() {
		Game towerDef = new Game(10);
		towerDef.buildTower(new VacuumImploder(1));
		assertEquals(70, towerDef.getBudget());
	}
	
	@Test
	public void testCatapultCost() {
		Game towerDef = new Game(10);
		towerDef.buildTower(new Catapult(1));
		assertEquals(80, towerDef.getBudget());
	}
	
	@Test
	public void testSlingshotCost() {
		Game towerDef = new Game(10);
		towerDef.buildTower(new Slingshot(1));
		assertEquals(95, towerDef.getBudget());
	}

}
