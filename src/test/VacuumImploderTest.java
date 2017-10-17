package test;

import static org.junit.Assert.*;

import org.junit.Test;

import towerdefence.VacuumImploder;

public class VacuumImploderTest {

	@Test
	public void testFire() {
		VacuumImploder t = new VacuumImploder(10);
		assertFalse(t.willFire(1));
		assertTrue(t.willFire(5));
		assertTrue(t.willFire(10));
		assertFalse(t.willFire(13));
	}

	@Test
	public void testDamage() {
		VacuumImploder t = new VacuumImploder(10);
		assertEquals(20, t.getDamage());
	}

	@Test
	public void testPosition() {
		VacuumImploder t = new VacuumImploder(10);
		assertEquals(10, t.getPosition());
	}

}
