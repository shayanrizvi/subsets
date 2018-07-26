import java.util.*;

/**
 * This program takes a user entered list of integers and prints all possible subsets of the list.
 * The user can toggle between recursive and iterative mode to print the subsets recursively or iteratively.
 * The user can also toggle between matrix and print mode to print a matrix of the subsets or print each subset seperately.
 * 
 * (INCOMPLETE)
 * Some methods are pending additional implementation and comments.
 * See individual method javadoc for details.
 * 
 * @author Shayan
 *
 */
public class Subsets {
	
    public static void main(String[] args) {
    	
		// initialize variables
		boolean q = false;														// program state
		boolean r = false;														// recursive/iterative mode
		boolean m = false;														// matrix/print mode
		Scanner in = new Scanner(System.in);									// input scanner
		String input;															// user input
		
    	ArrayList<Integer> list = new ArrayList<Integer>();						// list of integers
		int n;																	// integer to add to the list
    	
		// user input loop
		do {
			
			System.out.println("Enter an integer to add to the list");			// input prompt
			System.out.println("Enter \"s\" to submit the list");
			System.out.println("Enter \"r\" to toggle between recursive and iterative mode");
			System.out.println("Enter \"m\" to toggle between matrix and print mode");
			System.out.println("Enter \"c\" to clear the list");
			System.out.println("Enter \"q\" to quit: ");
			System.out.println();
			
			input = in.nextLine();												// record user input
			System.out.println();												// print new line
			
			// check for command input
			if(input.equals("q")) {
				
				q = true;														// change program state to termination
				System.out.println("Program terminated.");						// program termination message

			} else if (input.equals("s")) {
				
				// check matrix/print mode
				if(m) {

					if(r) System.out.println(subsetsRM(list));					// submit list to recursive matrix method and print
					else System.out.println(subsetsIM(list));					// submit list to iterative matrix method and print

				} else {
					
					if(r) subsetsR(list);										// submit list to recursive method
					else subsetsI(list);										// submit list to iterative method

				}
				
			} else if (input.equals("r")) {
				
		    	r = !(r);														// toggle recursive/iterative mode
		    	
		    	if(r) System.out.println("Recursive mode");						// check and display mode
		    	else System.out.println("Iterative mode");
				
			} else if (input.equals("m")) {

		    	m = !(m);														// toggle recursive/iterative mode
		    	
		    	if(m) System.out.println("Matrix mode");						// check and display mode
		    	else System.out.println("Print mode");
				
			} else if (input.equals("c")) {
				
		    	list.clear();													// clear list
				System.out.println("list cleared");								// print list cleared message
				
			} else {
				
				// check for integer input
				try {
					
					n = Integer.parseInt(input);								// copy input to number variable
					list.add(n);												// add integer to list
					System.out.println("list: " + list);						// print list
					
				} catch (NumberFormatException e) {
					
					System.out.println("Invalid input.");						// invalid input prompt
					
				}
				
			}
			
			System.out.println();												// print new line
			
		} while(!(q));															// check for program termination
		
		in.close();																// close input
		
    }

    /**
     * This method takes a list of integers and prints all possible subsets of the list.
     * This method uses an iterative approach.
     * 
     * @param list the list of integers
     * 
     */
    public static void subsetsI(ArrayList<Integer> list) {

    	ArrayList<ArrayList<Integer>> matrix = new ArrayList<ArrayList<Integer>>();
    	ArrayList<ArrayList<Integer>> subsets;
    	ArrayList<Integer> subset = new ArrayList<Integer>();
    	matrix.add(subset);
    	System.out.println(subset);
    	
    	for(Integer i : list) {
    		
    		subsets = new ArrayList<ArrayList<Integer>>();
    		
    		for(ArrayList<Integer> set : matrix) {
    			
    			subset = new ArrayList<Integer>();
    			subset.addAll(set);
    			subset.add(i);
    			subsets.add(subset);
    			
    			System.out.println(subset);
    			
    		}
    		
    		matrix.addAll(subsets);
    		
    	}
    	
    }
    
    /**
     * This method takes a list of integers and prints all possible subsets of the list.
     * This method uses a recursive approach.
     * This is the helper method which passes the list and initialized subset and index on to the primary method.
     * 
     * @param list the list of integers
     * 
     */
    public static void subsetsR(ArrayList<Integer> list) {
    	
    	ArrayList<Integer> subset = new ArrayList<Integer>(list);			// initialize new subset with list elements
    	subsetsR(list, subset, list.size() - 1);							// submit list and subset to allSubsets
    	
    }
    
    /**
     * This method takes a list of integers and prints all possible subsets of the list.
     * This method uses a recursive approach.
     * This is the primary method which receives the list and initialized subset and index from the helper method.
     * 
     * @param list the list of integers
     * @param subset the most recent subset if the list
     * @param i current index
     */
    public static void subsetsR(ArrayList<Integer> list, ArrayList<Integer> subset, int i) {
    	
    	// check if current index is equal to list size
    	if(i < 0) {
    		
        	ArrayList<Integer> set = new ArrayList<Integer>();				// initialize new set
        	
        	// for each element in subset
    		for(Integer n : subset) {
    			
    			if(n != null) set.add(n);									// add all non-null elements to set
    			
    		};
    		
    		System.out.println(set);										// print set
    		
    	} else {
    		
    		subset.set(i, null);											// set current index value to null
    		subsetsR(list, subset, i - 1);									// recursively submit list, subset, and incremented index
    		subset.set(i, list.get(i));										// set current index value to list index value
    		subsetsR(list, subset, i - 1);									// recursively submit list, subset, and incremented index
    		
    	}
    	
    }

    /**
     * This method takes a list of integers and returns a matrix of all possible subsets of the list.
     * This method uses an iterative approach.
     * 
     * @param list the list of integers
     * 
     * @return a matrix of all possible subsets
     */
    public static ArrayList<ArrayList<Integer>> subsetsIM(ArrayList<Integer> list) {

    	ArrayList<ArrayList<Integer>> matrix = new ArrayList<ArrayList<Integer>>();
    	ArrayList<ArrayList<Integer>> subsets;
    	ArrayList<Integer> subset = new ArrayList<Integer>();
    	matrix.add(subset);
    	
    	for(Integer i : list) {
    		
    		subsets = new ArrayList<ArrayList<Integer>>();
    		
    		for(ArrayList<Integer> set : matrix) {
    			
    			subset = new ArrayList<Integer>();
    			subset.addAll(set);
    			subset.add(i);
    			subsets.add(subset);
    			
    		}
    		
    		matrix.addAll(subsets);
    		
    	}
    	
    	return matrix;																// return matrix
    	
    }

    /**
     * This method takes a list of integers and returns a matrix of all possible subsets of the list.
     * This method uses a recursive approach.
     * 
     * (INCOMPLETE)
     * not started
     * 
     * @param list the list of integers
     * 
     * @return a matrix of all possible subsets
     */
    public static ArrayList<ArrayList<Integer>> subsetsRM(ArrayList<Integer> list) {
    	
    	ArrayList<ArrayList<Integer>> matrix = new ArrayList<ArrayList<Integer>>();	// list of subsets
    	ArrayList<Integer> emptySet = new ArrayList<Integer>();						// empty list
    	matrix.add(emptySet);														// add empty list to matrix
    	
    	return matrix;
    	
    }
    
}