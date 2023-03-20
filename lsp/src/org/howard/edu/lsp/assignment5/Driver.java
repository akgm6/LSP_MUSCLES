package org.howard.edu.lsp.assignment5;

public class Driver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		IntegerSet set1 = new IntegerSet();
		set1.add(4);
		set1.add(2);
		set1.add(3);
		set1.add(3);
		set1.add(1);

		System.out.println("Value of Set1 is:" + set1.toString());
		System.out.println("Smallest value in Set1 is: " + set1.smallest());
		System.out.println("Largest value in Set1 is: " + set1.largest());
		
		set1.remove(0);
		System.out.println("Value of Set1 is:" + set1.toString());

		IntegerSet set2 = new IntegerSet();
		set2.add(4);
		set2.add(5);
		set2.add(1);
		set2.add(6);

		System.out.println("\nUnion of Set1 and Set2");
        System.out.println("Value of Set1 is: " + set1.toString());
        System.out.println("Value of Set2 is: " + set2.toString());
        set1.union(set2);
        System.out.println("Result of union of Set1 and Set2");
        System.out.println("Value of Set1 is: " + set1.toString());
        
        System.out.println("\nIntersection of Set1 and Set2");
        System.out.println("Value of Set1 is: " + set1.toString());
        System.out.println("Value of Set3 is: " + set2.toString());
        set1.intersect(set2);
        System.out.println("Result of intersection of Set1 and Set2");
        System.out.println("Value of Set1 is: " + set1.toString());
        
        set1.clear();
        set2.clear();
        
        set2.add(2);
        set2.add(3);
        set2.add(4);

        set1.add(1);
        set1.add(2);
        set1.add(3);
        
        System.out.println("\nDifference of Set1 and Set2");
        System.out.println("Value of Set1 is: " + set1.toString());
        System.out.println("Value of Set4 is: " + set2.toString());
        set1.diff(set2);
        System.out.println("Result of difference of Set1 and Set4");
        System.out.println("Value of Set1 is: " + set1.toString());
        
        // testing clear method
        set1.clear();
        System.out.println("\nValue of Set1 after clear: " + set1.toString());
        
        // testing isEmpty method
        System.out.println("Is Set1 empty? " + set1.isEmpty());
	}
}

class IntegerSetException extends RuntimeException{
	public IntegerSetException(String message) {
		super(message);
	}
}