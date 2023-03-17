package org.howard.edu.lsp.midterm;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class IntegerRangeTest {
	@Test
	public void testContains() {
		IntegerRange r = new IntegerRange(1, 5);
		assertTrue(r.contains(3));
		assertFalse(r.contains(6));
		assertFalse(r.contains(0));
	}
	
	@Test
	public void testOverlaps() throws EmptyRangeException {
		IntegerRange r1 = new IntegerRange(1, 5);
		IntegerRange r2 = new IntegerRange(3, 7);
		IntegerRange r3 = new IntegerRange(5, 7);
		IntegerRange r4 = new IntegerRange(7, 9);
		IntegerRange r5 = new IntegerRange(0, 0);
		
		assertTrue(r1.overlaps(r2));
		assertTrue(r2.overlaps(r1));
		assertTrue(r2.overlaps(r3));
		assertTrue(r3.overlaps(r2));
		assertFalse(r1.overlaps(r4));
		assertFalse(r2.overlaps(r4));
		assertFalse(r3.overlaps(r4));
		assertFalse(r4.overlaps(r1));
		assertFalse(r4.overlaps(r2));
		assertFalse(r4.overlaps(r3));
		assertTrue(r1.overlaps(r1));
		assertFalse(r4.overlaps(r4));
		
		EmptyRangeException thrown = assertThrows(EmptyRangeException.class, () -> {
            r5.overlaps(r4);
        });
        assertTrue(thrown.getMessage().contentEquals("Range object is null"));
	}

	@Test
	public void testSize() {
		IntegerRange r1 = new IntegerRange(1, 5);
		IntegerRange r2 = new IntegerRange(0, 15);
		IntegerRange r3 = new IntegerRange(1, 10);
		assertEquals(5, r1.size());
		assertEquals(16, r2.size());
		assertEquals(10, r3.size());
	}
	
}
