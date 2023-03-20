package org.howard.edu.assignment5;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

public class IntegerSetTest {

    private IntegerSet set;

    @Before
    public void setUp() {
        set = new IntegerSet();
        
    }
    
    @Test
    @DisplayName("Tests for add")
    public void testAdd() {
        set.add(1);
        set.add(2);
        set.add(1);
        
        assertEquals(2, set.length());
    }

    @Test
    @DisplayName("Tests for remove")
    public void testRemove() {
        set.add(1);
        set.add(2);
        set.remove(1);

        assertFalse(set.contains(1));
        assertEquals(1, set.length());
    }
    
    @Test
    @DisplayName("Tests for clear")
    public void testClear() {
        set.add(1);
        set.clear();
        assertEquals(0, set.length());
    }

    @Test
    @DisplayName("Tests for length")
    public void testLength() {
        set.add(1);
        set.add(2);
        set.add(3);
        assertEquals(3, set.length());
    }

    @Test
    @DisplayName("Tests for equals")
    public void testEquals() {
    	set.add(3);
        set.add(2);
        set.add(1);
        
        IntegerSet set2 = new IntegerSet();
        set2.add(1);
        set2.add(2);
        set2.add(3);


        assertTrue(set.equals(set2));
    }

    @Test
    @DisplayName("Tests for contains")
    public void testContains() {
        set.add(1);
        set.add(2);
        set.add(3);

        assertTrue(set.contains(1));
        assertFalse(set.contains(4));
    }
    
    @Test
    @DisplayName("Tests for largest")
    public void testLargest() throws IntegerSetException {
        set.add(1);
        set.add(5);
        set.add(3);

        assertEquals(5, set.largest());
    }
    
    @Test(expected = IntegerSetException.class)
    @DisplayName("Tests for largest with IntegerSetException thrown")
    public void testLargestException() throws IntegerSetException {
        set.largest();
    }
    
    @Test
    @DisplayName("Tests for smallest")
    public void testSmallest() throws IntegerSetException {
        set.add(1);
        set.add(5);
        set.add(3);

        assertEquals(1, set.smallest());
    }

    @Test(expected = IntegerSetException.class)
    @DisplayName("Tests for smallest with IntegerSetException thrown")
    public void testSmallestException() throws IntegerSetException {
        set.smallest();
    }


    @Test
    @DisplayName("Tests for union")
    public void testUnion() {
    	set.add(1);
        set.add(2);
        set.add(3);
        
        IntegerSet set2 = new IntegerSet();
        set2.add(2);
        set2.add(3);
        set2.add(4);


        set.union(set2);

        List<Integer> expectedSet = new ArrayList<Integer>();
        expectedSet.add(1);
        expectedSet.add(2);
        expectedSet.add(3);
        expectedSet.add(4);

        assertEquals(expectedSet, set.getSet());
    }

    @Test
    @DisplayName("Tests for intersect")
    public void testIntersect() {
    	set.add(1);
        set.add(2);
        set.add(3);
        
        IntegerSet set2 = new IntegerSet();
        set2.add(2);
        set2.add(3);
        set2.add(4);

        set.intersect(set2);

        List<Integer> expectedSet = new ArrayList<Integer>();
        expectedSet.add(2);
        expectedSet.add(3);

        assertEquals(expectedSet, set.getSet());
    }

    @Test
    @DisplayName("Tests for diff")
    public void testDiff() {
    	set.add(1);
        set.add(2);
        set.add(3);
        
        IntegerSet set2 = new IntegerSet();
        set2.add(2);
        set2.add(3);
        set2.add(4);
        
        set.diff(set2);
        
        List<Integer> expectedSet = new ArrayList<Integer>();
        expectedSet.add(1);

        assertEquals(expectedSet, set.getSet());
    }

}
