import java.util.*;

/**
 * This program takes a user entered list of integers and prints all possible subsets of the list.
 * 
 * @author Shayan
 *
 */
public class Subsets {
	
    public static void main(String[] args) {

    	ArrayList<Integer> list = new ArrayList<Integer>();
    	list.add(1);
    	list.add(2);
    	list.add(3);
    	list.add(4);
    	
    	System.out.println(subSets(list));
    	
    }
    
    /**
     * This method takes a list of integers and returns a matrix of all possible subsets of the list.
     * 
     * @param list the list of integers
     * 
     * @return a matrix of all possible subsets
     */
    public static ArrayList<ArrayList<Integer>> subSets(ArrayList<Integer> list) {
    	
    	ArrayList<ArrayList<Integer>> matrix = new ArrayList<ArrayList<Integer>>();
    	ArrayList<Integer> emptyRow = new ArrayList<Integer>();
    	matrix.add(emptyRow);
    	
    	for(int j = 0; j < list.size(); j++) {
    		
        	ArrayList<Integer> tempRow = new ArrayList<Integer>();
        	
			for(int i = j; i < list.size(); i++) {
				
				ArrayList<Integer> row1 = new ArrayList<Integer>();
				
				tempRow.add(list.get(i));
				row1.addAll(tempRow);
				matrix.add(row1);
				
	        	System.out.println("tempRow = " + tempRow);
	        	System.out.println("row1 = " + row1);
	        	System.out.println("matrix = " + matrix);
	        	System.out.println();
	        	
			}
			
			System.out.println("j loop iteration: " + (j + 1));
        	System.out.println();
			
    	}
    	
    	return matrix;
    	
    }
    
}