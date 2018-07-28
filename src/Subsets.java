import java.util.*;

/**
 * This program takes a user entered list of integers and prints all possible subsets of the list.
 * The user can toggle between recursive and iterative mode to print the subsets recursively or iteratively.
 * The user can also toggle between matrix and print mode to print a matrix of the subsets or print each subset seperately.
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

    	ArrayList<ArrayList<Integer>> matrix = new ArrayList<ArrayList<Integer>>();	// matrix of subsets
    	ArrayList<ArrayList<Integer>> subsets;										// set of subsets
    	ArrayList<Integer> subset = new ArrayList<Integer>();						// subset
    	matrix.add(subset);															// add empty subset to matrix
    	System.out.println(subset);													// print empty subset
    	
    	// for each element in list
    	for(Integer i : list) {
    		
    		subsets = new ArrayList<ArrayList<Integer>>();							// initialize new set of subsets
    		
    		// for each subset in matrix
    		for(ArrayList<Integer> set : matrix) {
    			
    			subset = new ArrayList<Integer>(set);								// initialize new subset with matrix element
    			subset.add(i);														// add list element to subset
    			subsets.add(subset);												// add subset to set of subsets
    			
    			System.out.println(subset);											// print subset
    			
    		}
    		
    		matrix.addAll(subsets);													// add subsets to matrix
    		
    	}
    	
    }
    
    /**
     * This method takes a list of integers and returns a matrix of all possible subsets of the list.
     * This method uses a recursive approach.
     * This is the helper method which passes the list and initialized parameters on to the primary method.
     * 
     * 
     * @param list the list of integers
     * 
     * @return a matrix of all possible subsets
     */
    public static void subsetsR(ArrayList<Integer> list) {
    	
    	ArrayList<ArrayList<Integer>> matrix = new ArrayList<ArrayList<Integer>>();	// list of subsets
    	ArrayList<ArrayList<Integer>> subsets = new ArrayList<ArrayList<Integer>>();// set of subsets
    	ArrayList<Integer> subset = new ArrayList<Integer>();						// empty subset
    	matrix.add(subset);															// add empty subset to matrix
    	System.out.println(subset);													// print empty subset
    	subsetsR(list, subsets, matrix, 0, 0);										// recursively submit with initialized parameters and return
    	    			
    }

    /**
     * This method takes a list of integers and returns a matrix of all possible subsets of the list.
     * This method uses a recursive approach.
     * This is the primary method which recieves the list and initialized subset and index from the helper method.
     * 
     * @param list the list of integers
     * @param subsets the current set of subsets
     * @param matrix the matrix of subsets
     * @param i the current list index
     * @param s the current matrix index
     * 
     * @return a matrix of all possible subsets
     */
    public static void subsetsR(ArrayList<Integer> list, ArrayList<ArrayList<Integer>> subsets, ArrayList<ArrayList<Integer>> matrix, int i, int s) {

    	// check if list index is valid
    	if(i < list.size()) {
    		
    		// check if matrix index is valid
    		if(s < matrix.size()) {
    			
    			ArrayList<Integer> subset = new ArrayList<Integer>(matrix.get(s));	// initialize new subset with current matrix index value
    			subset.add(list.get(i));											// add current list index value to subset
    			subsets.add(subset);												// add subset to set of subsets
    			System.out.println(subset);											// print subset
    	    	subsetsR(list, subsets, matrix, i, s + 1);							// increment matrix index and recursively submit with updated parameters
    			
    		} else {

        		matrix.addAll(subsets);												// add all subsets to matrix
        		subsets = new ArrayList<ArrayList<Integer>>();						// initialize new subset
    			subsetsR(list, subsets, matrix, i + 1, 0);							// increment list index and recursively submit with updated parameters
        		
    		}
    		
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
    	
    	ArrayList<ArrayList<Integer>> matrix = new ArrayList<ArrayList<Integer>>();	// matrix of subsets
    	ArrayList<ArrayList<Integer>> subsets;										// set of subsets
    	ArrayList<Integer> subset = new ArrayList<Integer>();						// subset
    	matrix.add(subset);															// add empty subset to matrix
    	
    	// for each element in list
    	for(Integer i : list) {
    		
    		subsets = new ArrayList<ArrayList<Integer>>();							// initialize new set of subsets
    		
    		// for each element in matrix
    		for(ArrayList<Integer> set : matrix) {
    			
    			subset = new ArrayList<Integer>(set);								// initialize new subset with matrix element
    			subset.add(i);														// add list element
    			subsets.add(subset);												// add subset to set of subsets
    			
    		}
    		
    		matrix.addAll(subsets);													// add subsets to matrix
    		
    	}
    	
    	return matrix;																// return matrix
    	
    }

    /**
     * This method takes a list of integers and returns a matrix of all possible subsets of the list.
     * This method uses a recursive approach.
     * This is the helper method which passes the list and initialized parameters on to the primary method.
     * 
     * 
     * @param list the list of integers
     * 
     * @return a matrix of all possible subsets
     */
    public static ArrayList<ArrayList<Integer>> subsetsRM(ArrayList<Integer> list) {
    	
    	ArrayList<ArrayList<Integer>> matrix = new ArrayList<ArrayList<Integer>>();	// list of subsets
    	ArrayList<ArrayList<Integer>> subsets = new ArrayList<ArrayList<Integer>>();// set of subsets
    	ArrayList<Integer> subset = new ArrayList<Integer>();						// empty subset
    	matrix.add(subset);															// add empty subset to matrix
    	
    	return subsetsRM(list, subsets, matrix, 0, 0);								// recursively submit with initialized parameters and return
    	    			
    }

    /**
     * This method takes a list of integers and returns a matrix of all possible subsets of the list.
     * This method uses a recursive approach.
     * This is the primary method which recieves the list and initialized subset and index from the helper method.
     * 
     * @param list the list of integers
     * @param subsets the current set of subsets
     * @param matrix the matrix of subsets
     * @param i the current list index
     * @param s the current matrix index
     * 
     * @return a matrix of all possible subsets
     */
    public static ArrayList<ArrayList<Integer>> subsetsRM(ArrayList<Integer> list, ArrayList<ArrayList<Integer>> subsets, ArrayList<ArrayList<Integer>> matrix, int i, int s) {

    	// check if list index is valid
    	if(i < list.size()) {
    		
    		// check if matrix index is valid
    		if(s < matrix.size()) {
    			
    			ArrayList<Integer> subset = new ArrayList<Integer>(matrix.get(s));	// initialize new subset with current matrix index value
    			subset.add(list.get(i));											// add current list index value to subset
    			subsets.add(subset);												// add subset to set of subsets
    			matrix = subsetsRM(list, subsets, matrix, i, s + 1);				// increment matrix index and recursively submit with updated parameters
    			  		
    		} else {

        		matrix.addAll(subsets);												// add all subsets to matrix
        		subsets = new ArrayList<ArrayList<Integer>>();						// initialize new subset
    			matrix = subsetsRM(list, subsets, matrix, i + 1, 0);				// increment list index and recursively submit with updated parameters
        		    
    		}
    		
    	}
    	
    	return matrix;																// return matrix
    	
    }
    
}