package test;

import static org.junit.Assert.*;

import org.junit.Test;

import towerdefence.Catapult;
import towerdefence.Godzilla;
import towerdefence.Slingshot;
import towerdefence.VacuumImploder;

public class GodzillaTest {


	@Test
	public void testCreate() {
		Godzilla g = new Godzilla();
		assertEquals(20, g.getHealth());
	}

	@Test
	public void testHit() {
		Godzilla g = new Godzilla();
		Slingshot t = new Slingshot(5);
		g.hit(t);
		assertEquals(19, g.getHealth());
		g.hit(t);
		g.hit(t);
		g.hit(t);
		assertEquals(16, g.getHealth());
	}

	@Test
	public void testHeavyHit() {
		Godzilla g = new Godzilla();
		Catapult t = new Catapult(5);
		g.hit(t);
		assertEquals(15, g.getHealth());
		g.hit(t);
		assertEquals(10, g.getHealth());
	}
	
	@Test
	public void testUltraHeavyHit() {
		Godzilla g = new Godzilla();
		VacuumImploder t = new VacuumImploder(5);
		g.hit(t);
		assertEquals(0, g.getHealth());
	}

	@Test
	public void testAdvance() {
		Godzilla g = new Godzilla();
		assertEquals(0, g.getPosition());
		g.advance();
		assertEquals(0, g.getPosition());
		g.advance();
		assertEquals(0, g.getPosition());
		g.advance();
		assertEquals(0, g.getPosition());
		g.advance();
		assertEquals(0, g.getPosition());
		g.advance();
		assertEquals(2, g.getPosition());
		g.advance();
		assertEquals(2, g.getPosition());
		g.advance();
		assertEquals(2, g.getPosition());
		g.advance();
		assertEquals(2, g.getPosition());
		g.advance();
		assertEquals(2, g.getPosition());
		g.advance();
		assertEquals(4, g.getPosition());
	}

	@Test
	public void testAdvanceHit() {
		Godzilla g = new Godzilla();
		assertEquals(0, g.getPosition());
		assertEquals(20, g.getHealth());
		
		Slingshot t = new Slingshot(3);
		g.hit(t);
		assertEquals(0, g.getPosition());
		assertEquals(19, g.getHealth());
	}

	@Test
	public void testAdvanceNoHit() {
		Godzilla g = new Godzilla();
		assertEquals(0, g.getPosition());
		assertEquals(20, g.getHealth());
		
		g.advance();
		g.advance();
		g.advance();
		g.advance();
		g.advance();
		assertEquals(2, g.getPosition());
		assertEquals(20, g.getHealth());
		
		Slingshot t = new Slingshot(3);
		g.hit(t);
		assertEquals(2, g.getPosition());
		assertEquals(19, g.getHealth());
	}

}
