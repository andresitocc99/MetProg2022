package Task3;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class main_Task3 {
	
	private static Scanner sc = new Scanner (System.in);
	
	public static void main (String[] args) throws IOException, FileNotFoundException {
		
		try {
			String path = "D:\\Documentos\\GitHub\\MetProg2022\\src\\Task3\\data.txt"; // Path of the File	
			City [] Cities = readFile(path);
			
			int sledge_capacity =  input_capacity_sledge(); // Capacity of the sledge
			int M = input_max_visited_villages (Cities.length); // TimeToVisit;
			
			quicksort(Cities,0,Cities.length); // Apply Quicksort to order the vector
			
			ArrayList<City> CitiesList = new ArrayList<City>(Arrays.asList(Cities));
			
			ArrayList<City> visited_Cities = greedy_algorithm(CitiesList,sledge_capacity,M);
			
			for (int i=0;i<visited_Cities.size();i++) {
				visited_Cities.get(i).toString();
			}
			
			
			
			System.out.println("Program finished");
			
		} catch (InputMismatchException e) {
            System.out.println("Write numbers please");
        }
		
	}
	
	public static ArrayList<City> greedy_algorithm(ArrayList<City>Cities, int sledge_capacity, int M) {
		int food_taken = 0;
		ArrayList<City> visited_Cities = new ArrayList<City>();
		
		
		while (Cities.size()!=0 && visited_Cities.size() <M && food_taken < sledge_capacity) {
			City city = Cities.get(Cities.size()-1);
			Cities.remove(Cities.size()-1);
			if ((sledge_capacity-food_taken)>=city.getSupplie()) {
				visited_Cities.add(city);
			}
			
		}
		return visited_Cities;
	}
	
	public static void quicksort (City [] city, int li, int ls) {
		if (li < ls) {
			int pos = partition (city, li, ls);
			quicksort(city,li,pos);
			quicksort(city,pos+1,ls);
		}
	}
	
	public static int partition (City [] city, int li, int ls) {
		int piv = city[ls].getSupplie();
		int i = li-1;
		int j = ls+1;
		
		do {
			do {
				j=j-1;
			} while (city[j].getSupplie()>piv);
			
			do {
				i=i-1;
			} while (city[i].getSupplie()<piv);
			
			if (i<j) {
				replace(city,i,j);
			}
		} while (i<j);
		
		return j;
		
	}
	
	public static void replace (City[] city, int i, int j) {
		int aux_1 = city[i].getId();
		int aux_2 = city[i].getSupplie();
		
		city[i].setId(city[j].getId());
		city[i].setSupplie(city[j].getSupplie());
		city[j].setId(aux_1);
		city[j].setSupplie(aux_2);
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
	* Method name: readFile
	* Description of the Method: read the data of a file and add it to an
	* array.
	* Calling arguments: path of the file, and number of files of the file.
	* Return value: array of integers.
	*********************************************************************/
	
	public static City [] readFile (String path) throws FileNotFoundException {
		
		City[] cities = new City [numberOfElements (path)];
		
		try {
			File f = new File (path);
			Scanner sc = new Scanner (f);
			int counter = 0;
			while (sc.hasNext()) {
				int supplie = sc.nextInt();
				cities[counter] = new City (counter,supplie);
				counter++;
			}
			sc.close();
		} catch (FileNotFoundException e) {
			System.out.println("File not Found");
		}
		return cities;
	}
	
	public static int numberOfElements (String path) throws FileNotFoundException {
		Scanner sc = new Scanner (new File(path));
		int count = 0;
		while (sc.hasNext()) {
			sc.nextLine();
			count++;
		}
		sc.close();
		return count;
}
	
	
}
