import java.util.*;

/**
 * This program takes a user entered list of integers and prints all possible subsets of the list.
 * (INCOMPLETE)
 * Some methods are pending additional implementation.
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
		Scanner in = new Scanner(System.in);									// input scanner
		String input;															// user input
		
    	ArrayList<Integer> list = new ArrayList<Integer>();						// list of integers
		int n;																	// integer to add to the list
    	
		// user input loop
		do {
			
			System.out.println("Enter an integer to add to the list");			// input prompt
			System.out.println("Enter \"s\" to submit the list");
			System.out.println("Enter \"r\" to toggle between recursive and iterative mode");
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
				
				if(r) allSubsets(list);											// submit list to recursive method
				else subsets(list);												// submit list to iterative method

			} else if (input.equals("r")) {
				
		    	r = !(r);														// toggle recursive and iterative mode
		    	
		    	if(r) System.out.println("Recursive mode");						// check and display mode
		    	else System.out.println("Iterative mode");
				
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
     * This method takes a list of integers and returns a matrix of all possible subsets of the list.
     * This method uses an iterative approach.
     * 
     * (INCOMPLETE)
     * Currently only returns adjacent subsets.
     * Pending implementation:
     * 		-include nonadjacent subsets.
     * 
     * @param list the list of integers
     * 
     * @return a matrix of all possible subsets
     */
    public static ArrayList<ArrayList<Integer>> subsets(ArrayList<Integer> list) {
    	
    	ArrayList<ArrayList<Integer>> matrix = new ArrayList<ArrayList<Integer>>();	// list of sublists
    	ArrayList<Integer> emptySet = new ArrayList<Integer>();						// empty list
    	matrix.add(emptySet);														// add empty list to matrix
    	
    	// for the number of elements in the list
    	for(int j = 0; j < list.size(); j++) {
    		
        	ArrayList<Integer> subset = new ArrayList<Integer>();					// initialize new subset
        	
        	// for the number of elements in the list
			for(int i = j; i < list.size(); i++) {
				
				ArrayList<Integer> set = new ArrayList<Integer>();					// initialize new set
				
				subset.add(list.get(i));											// add integer in list index to subset
				set.addAll(subset);													// add subset to set
				matrix.add(set);													// add set to matrix
				
				System.out.println(subset);											// print subset
				
			}
			
    	}
    	
    	return matrix;																// return matrix
    	
    }

    /**
     * This method takes a list of integers and returns a matrix of all possible subsets of the list.
     * This method uses a recursive approach.
     * 
     * (INCOMPLETE)
     * 
     * @param list the list of integers
     * 
     * @return a matrix of all possible subsets
     */
    public static void subsetsR(ArrayList<Integer> list) {
    	
    	
    	
    }
    
    /**
     * This method takes a list of integers and prints all possible subsets of the list.
     * This method uses a recursive approach.
     * 
     * @param list the list of integers
     * 
     */
    public static void allSubsets(ArrayList<Integer> list) {
    	
    	ArrayList<Integer> subset = new ArrayList<Integer>();
    	subset.addAll(list);
    	allSubsets(list, subset, 0);
    	
    }
    
    /**
     * This method takes a list of integers and prints all possible subsets of the list.
     * This method uses a recursive approach.
     * 
     * @param list the list of integers
     * @param subset the most recent subset if the list
     * @param i current index
     */
    public static void allSubsets(ArrayList<Integer> list, ArrayList<Integer> subset, int i) {
    	
    	if(i == list.size()) {
    		
    		System.out.println(subset);
    		
    	} else {
    		
    		subset.set(i, null);
    		allSubsets(list, subset, i + 1);
    		subset.set(i, list.get(i));
    		allSubsets(list,subset, i + 1);
    		
    	}
    	
    }
    
}