package org.howard.edu.assignment5;

import java.util.ArrayList;
import java.util.List;

public class IntegerSet {
	// Hint: probably best to use an array list.  You will need to do a little research
	private List<Integer> set = new ArrayList<Integer>();

	// Default Constructor
	public IntegerSet() {
	}

	// Clears the internal representation of the set
	public void clear() {
		set.clear();
	};

	// Returns the length of the set
	public int length() {
		return set.size();
		
	}; // returns the length
	
	

	public List<Integer> getSet() {
		return set;
	}

	/*
	 * Returns true if the 2 sets are equal, false otherwise;
	 * Two sets are equal if they contain all of the same values in ANY order.
	*/
	public boolean equals(IntegerSet b) {
		List<Integer> set2 = b.getSet();
		if (set.size() != set2.size()) {
			return false;
		}
		
		for (int i = 0; i < set.size(); i++) {
			if (!set2.contains(set.get(i))) {
				return false;
			}
		}
		return true;
	}; 

	// Returns true if the set contains the value, otherwise false
	public boolean contains(int value) {
		if (set.contains(value)) {
			return true;
		}
		return false;
	};    

	// Returns the largest item in the set; Throws a IntegerSetException if the set is empty 
	public int largest() throws IntegerSetException {
		if (set.isEmpty()) {
			throw new IntegerSetException("The set is empty.");
		}
		int largest = 0;
		for (int i = 0; i < set.size(); i++) {
			if (set.get(i) > largest) {
				largest = set.get(i);
			}
		}
		return largest;
		
	}; 

	// Returns the smallest item in the set; Throws a IntegerSetException if the set is empty
	public int smallest() throws IntegerSetException {
		if (set.isEmpty()) {
			throw new IntegerSetException("The set is empty.");
		}
		int smallest = set.get(0);
		for (int i = 0; i < set.size(); i++) {
			if (set.get(i) < smallest) {
				smallest = set.get(i);
			}
		}
		return smallest;
		
	};

	// Adds an item to the set or does nothing it already there	
	 public void add(int item) {
		 if (!set.contains(item)) {
			 set.add(item);
		 }
	 }; // adds item to the set or does nothing if it is in set

	// Removes an item from the set or does nothing if not there
	public void remove(int item) {
		set.remove(Integer.valueOf(item));
	}; 

	// Set union
	public void union(IntegerSet intSetb) {
		List<Integer> set2 = intSetb.getSet();
		for (int i = 0; i < intSetb.length(); i++) {
			if (!set.contains(set2.get(i))) {
				 set.add(set2.get(i));
			 }
		}
	};

	// Set intersection
	public void intersect(IntegerSet intSetb) {
		List<Integer> tempSet = new ArrayList<Integer>(); 
		List<Integer> set2 = intSetb.getSet();
		for (int i=0; i < intSetb.length(); i ++) {
			if (set.contains(set2.get(i))) {
				tempSet.add(set2.get(i));
			}
		}
		set = tempSet;
	}; 

	// Set difference, i.e., s1 – s2
	public void diff(IntegerSet intSetb) {
		List<Integer> set2 = intSetb.getSet();
		for (int i=0; i < intSetb.length(); i ++) {
			if (set.contains(set2.get(i))) {
				set.remove(Integer.valueOf(set2.get(i)));
			}
		}
	}; // set difference, i.e. s1 - s2

	// Returns true if the set is empty, false otherwise
	public boolean isEmpty() {
		return set.isEmpty();
	}; 

	// Return String representation of your set
	public String toString() {
		return set.toString();
	};	// return String representation of your set

}