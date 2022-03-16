package Task1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;


public class Generate_One_Dimensional_Array {
	
	private static Scanner sc = new Scanner(System.in);
	
	public static void main (String [] args) throws IOException {
		
		try {
			int option  = 0;
			int [] array;
			int array_size;
			
			while (option<1 || option>4) {	
				System.out.println("Select the mode of input. 1: By Keyboard; 2: by Text File; 3. Randomly generated; 4: Exit");
				option = sc.nextInt();
			}
				switch(option) {
				case 1:
					System.out.println("Introduce the size of the array");
					array_size = sc.nextInt();
					array = new int [array_size];
					for (int i = 0; i<array.length; i++) {
						System.out.println("Introduce the value of the position "+i+" of the array");
						array[i] = sc.nextInt();
					}
					break;
				case 2:
					System.out.println("Introduce the path of the file");
					array = readFile(sc.next());
					break;
				case 3:
					System.out.println("Introduce the size of the array");
					array_size = sc.nextInt();
					System.out.println("Introduce the maximum value of the numbers generated randomly");
					array = array_random (array_size, sc.nextInt());
					
					break;
				case 4:
					sc.close();
					System.out.println("Program finished");
				}
			
		} catch (Exception e) {
			System.out.println("Error. Introduce an Integer");
			sc.next();
			main(args);
		}
	
		
	}
	
	public static ArrayList<Integer> transform_array (int [] array) {
		ArrayList<Integer> list = new ArrayList<>();
		for(int i=0; i<array.length;i++) {
			list.add(array[i]);
		}
		return list;
	}
	
	public static int [] copy_array (int [] array) {
		int [] array_copy = new int[array.length];
		for (int i=0; i<array.length;i++) {
			array_copy[i]=array[i];
		}
		return array_copy;
	}
	
	public boolean equal_array (int [] array_1, int [] array_2) {
		boolean check = false;
		int counter =0;
		
		if (array_1.length == array_2.length) {
			for (int i=0; i<array_1.length;i++) {
				if(array_1[i] == array_2[i]) {
					counter++;
				}
			}
			if (counter == array_1.length) {
				check = true;
			}
		}
		
		return check;
	}
	
	public static int [] array_random(int array_size, int LS) {
		int [] array = new int[array_size];
		for (int i=0; i<array_size;i++) {
			array[i] = (int)(Math.random()*(LS-0+1)+0);
		}
		return array;
	}
	
	public static int [] readFile (String path) throws FileNotFoundException {
		int [] array = new int [numberOfElements (path)];
		
		try {
			
			File f = new File (path);
			Scanner sc = new Scanner (f);
			int counter = 0;
			
			while (sc.hasNext()) {
				array [counter] = sc.nextInt();
				counter++;
			}
			sc.close();
			
		} catch (FileNotFoundException e) {
			System.out.println("File not found");
		}
		
		
		return array;
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
