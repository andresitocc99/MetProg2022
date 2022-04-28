package Task3;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class main_Task3 {
	
	private static Scanner sc = new Scanner (System.in);
	
	public static void main (String[] args) throws IOException, FileNotFoundException {
		
		try {
			String path = "D:\\Documentos\\GitHub\\MetProg2022\\src\\Task3\\data.txt"; // Path of the File
			int N = numberOfVillages(path); // Total of villages
			
			
			int sledge_capacity =  input_capacity_sledge(); // Capacity of the sledge
			int [] villages = readFile (path, N);
			int M = input_max_visited_villages (N); // TimeToVisit;
			
			
			int [] actual = new int [M];
			int [] sol = new int [M];
			
			backtrackingSledge(0, actual, sol, villages, sledge_capacity);
			
			
			for (int i=0; i<sol.length;i++) {
				if (villages[sol[i]]!=0) {
					System.out.println("Village Nº "+sol[i] + ": "+villages[sol[i]]+" ");
				}
			}
			
			System.out.println("Program finished");
			
		} catch (InputMismatchException e) {
            System.out.println("Write numbers please");
        }
		
	}
	
	/**********************************************************************
	* Method name: input_max_visited_villages
	* Description of the Method: request the number of visited villages, checking
	* if bigger than 0 and lower than the number of existing villages
	* Calling arguments: N (number of existing villages.
	* Return value: integer
	*********************************************************************/

	public static int input_max_visited_villages (int N) throws IOException {
		int input = 0;
		do {
			System.out.println("Introduce a number bigger than 0 for numbers of villages visited, and lower or equal than the number of existing villages ["+N+"]");
			try {
				 input = sc.nextInt();
			} catch(InputMismatchException e) {
				 System.out.println("Error. Not valid input. Only integers allowed");
	             sc.next();
	             input = input_capacity_sledge();
			}
		} while (input <=0 || input > N);
		
		return input;
	}
	
	/**********************************************************************
	* Method name: input_capacity_sledge
	* Description of the Method: request the capacity of the sledge, checking
	* that be bigger than 0.
	* Calling arguments: 
	* Return value: integer
	*********************************************************************/
	
	public static int input_capacity_sledge () throws IOException {
		int input = 0;
		do {
			System.out.println("Introduce a number bigger than 0 for the Capacity of the Sledge");
			try {
				 input = sc.nextInt();
			} catch(InputMismatchException e) {
				 System.out.println("Error. Not valid input. Only integers allowed");
	             sc.next();
	             input = input_capacity_sledge();
			}
		} while (input <=0);
		
		return input;
	}
	
	/**********************************************************************
	* Method name: backtrackingSledge
	* Description of the Method: main method of the backtracking. We get 
	* all the possible combinations, but when the sum of the array is equal
	* or bigger than a the sledge capacity, the combination done is stopped. 
	* Calling arguments: int stage, int actual [], int sol [], 
	* int villages [], int sledge_capacity
	* Return value: void
	*********************************************************************/
	
	public static void backtrackingSledge (int stage, int actual [], int sol [], int villages [], int sledge_capacity) {
		if (stage == actual.length || full  (actual,sledge_capacity,villages)) {
			if (isBetter(actual, sol, villages, sledge_capacity)) {
				
				for (int k=0;k<actual.length;k++) {
					sol[k]=actual[k];
				}
			}
		} else {
			for (int i=0; i<villages.length; i++) {
				if (isValid (stage, i, actual) && !full (actual,sledge_capacity,villages)) {
					//actual[stage] = villages[i];
					actual[stage] = i;
							
					backtrackingSledge(stage+1, actual, sol, villages, sledge_capacity);
				}
			}
		}
	}
	
	/**********************************************************************
	* Method name: isValid
	* Description of the Method: check if a number that is going to be added
	* the array is already 
	* Calling arguments:  int stage, int i, int actual[],int villages[]
	* Return value: boolean
	*********************************************************************/
	
	public static boolean isValid (int stage, int i, int actual[]) {
		boolean isValid = true;
		for (int k=0; k<stage && isValid; k++) {
			isValid = (actual[k] != i);
		}
		return isValid;
	}
	
	/**********************************************************************
	* Method name: occupied_capacity
	* Description of the Method: calculate the occupied capacity of an array
	* Calling arguments: int array [], int villages []
	* Return value: integer
	*********************************************************************/
	
	public static int occupied_capacity (int array [], int villages []) {
		int occupied_capacity = 0;
		for (int i=0; i<array.length; i++) {
			occupied_capacity += villages[array[i]];
		}
		return occupied_capacity;
	}
	
	/**********************************************************************
	* Method name: visited_villages
	* Description of the Method: calculate the number of villages visited
	* Calling arguments: int array[], int villages[]
	* Return value: integer
	*********************************************************************/
	
	public static int visited_villages (int array[], int villages[]) {
		int visited_villages = 0;
		
		for (int i=0; i< array.length; i++) {
			if (villages[array[i]] !=0 ) { 
				visited_villages++;
			}
		}
		
		return visited_villages;
	}
	
	/**********************************************************************
	* Method name: isBetter
	* Description of the Method: check if the actual array is better than
	* the solution array saved
	* Calling arguments: int actual [], int sol [], int []  villages, 
	* int sledge_capacity
	* Return value: boolean
	*********************************************************************/
	
	public static boolean isBetter (int actual [], int sol [], int []  villages, int sledge_capacity) {
		int volume_actual = occupied_capacity (actual,villages);
		int visited_villages_actual = 0, visited_villages_solution = 0;
		
		boolean isBetter = true;
		
		
		if (volume_actual != sledge_capacity) {
			isBetter = false;
		} else {
			if (sol[0]!= sol[1]) {
				visited_villages_actual = visited_villages (actual,villages);
				visited_villages_solution = visited_villages (sol,villages);
				isBetter = (visited_villages_actual < visited_villages_solution);
			}
		}
		return isBetter;
	}
	
	/**********************************************************************
	* Method name: full
	* Description of the Method: check if the actual array adds already the
	* a given sledge capacity.
	* Calling arguments: int actual [], int sledge_capacity, int villages []
	* Return value: boolean
	*********************************************************************/
	
	public static boolean full (int actual [], int sledge_capacity, int villages []) {
		boolean full = false;
		int sum = 0;
		
		for (int i=0; i<actual.length && !full;i++) {
			if (sum>=sledge_capacity) {
				full = true;
			} else {
				//sum += actual[i];
				sum += villages[actual[i]];
			}
		}
		
		return full;
	}
	
	/**********************************************************************
	* Method name: readFile
	* Description of the Method: read the data of a file and add it to an
	* array.
	* Calling arguments: path of the file, and number of files of the file.
	* Return value: array of integers.
	*********************************************************************/
	
	public static int [] readFile (String path, int N) throws FileNotFoundException {
		int [] villages = new int [N];
		try {
			File f = new File (path);
			Scanner sc = new Scanner (f);
			int counter = 0;
			while (sc.hasNext()) {
				int village_kilos = sc.nextInt();
				villages [counter] = village_kilos;
				counter++;
			}
			sc.close();
		} catch (FileNotFoundException e) {
			System.out.println("File not Found");
		}
		return villages;
	}
	
	/**********************************************************************
	* Method name: numberOfVillages
	* Description of the Method: calculate the number of written lines 
	* of the txt file
	* Calling arguments: path of the file
	* Return value: integer
	*********************************************************************/
	
	public static int numberOfVillages (String path) throws FileNotFoundException {
		int count = 0;
		try {
			Scanner sc = new Scanner (new File (path));
			while (sc.hasNext()) {
				sc.nextLine();
				count++;
			}
			sc.close();
		} catch (FileNotFoundException e) {
			System.out.println("File not Found");
		}
		return count;
	
	}
}
