package org.howard.edu.lsp.midterm;

public class IntegerRange implements Range {
	private int lower;
	private int upper;

// Hint: implement getters for lower and upper

	 public int getLower() {
		return lower;
	}

	public int getUpper() {
		return upper;
	}

	IntegerRange(int lower, int upper) { 	// Constructor
		 this.lower = lower;
		 this.upper = upper;
	 }
	
public boolean contains(int value) {
	if (value >= lower && value <= upper) {
		return true;
	}
	return false;
	// implement
}
public boolean overlaps(Range other) throws EmptyRangeException {
	int otherUpper = other.getUpper();
	int otherLower = other.getLower();
	
	if(other == null || upper > lower || otherUpper > otherLower) {
		throw new EmptyRangeException("Cannot compare range with null");
	}
	
	if(lower <= otherUpper && otherLower <= upper) {
		return true;
	}
	return false;
	// implement
}

public int size()  {
	return upper - lower + 1;
	// implement
}


}