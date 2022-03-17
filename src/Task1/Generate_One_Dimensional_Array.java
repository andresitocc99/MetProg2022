package Task1;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import java.util.Scanner;


public class Generate_One_Dimensional_Array {
	
	private static Scanner sc = new Scanner(System.in);
	
	public static void main (String [] args) throws IOException {
		
		// IO = Increasing Order - DO = Decreasing Order - RO = Random Order
		// SS = Selection Sort - IS = Insertion Sort - BS = Bubble Sort
		
		int [] sizes = {100, 500, 1000, 5000, 8000, 9000, 10000, 11000, 20000, 50000};
		long time_SS = 0;
		long time_IS = 0;
		long time_BS = 0;;
		System.out.println("SIZE  ORDER      INSERTION        SELECTION         BUBBLE      ");
		for (int i=0; i<sizes.length;i++){
			for (int j=0; j<3;j++) { // LOOP FOR INCREASING-DECREASING-RANDOM ORDER
				if (j == 0) {
					time_IS = Sorting_Algorithms.direct_insertion_sort_array(ascending_sort(array_random(sizes[i],sizes[i])));
					time_SS = Sorting_Algorithms.direct_selection_sort_array(ascending_sort(array_random(sizes[i],sizes[i])));
					time_BS = Sorting_Algorithms.bubble_sort_array(ascending_sort(array_random(sizes[i],sizes[i])));
					System.out.println(sizes[i]+"    AO     "+(System.currentTimeMillis()-time_IS)+"     "+(System.currentTimeMillis()-time_SS)+"     "+(System.currentTimeMillis()-time_BS));
					
				} if (j == 1) {
					time_IS = Sorting_Algorithms.direct_insertion_sort_array(descending_sort(array_random(sizes[i],sizes[i])));
					time_SS = Sorting_Algorithms.direct_selection_sort_array(descending_sort(array_random(sizes[i],sizes[i])));
					time_BS = Sorting_Algorithms.bubble_sort_array(descending_sort(array_random(sizes[i],sizes[i])));
					System.out.println(sizes[i]+"    DO     "+(System.currentTimeMillis()-time_IS)+"     "+(System.currentTimeMillis()-time_SS)+"     "+(System.currentTimeMillis()-time_BS));
					
					
				} if (j==2) {
					time_IS = Sorting_Algorithms.direct_insertion_sort_array(array_random(sizes[i],sizes[i]));
					time_SS = Sorting_Algorithms.direct_selection_sort_array(array_random(sizes[i],sizes[i]));
					time_BS = Sorting_Algorithms.bubble_sort_array(array_random(sizes[i],sizes[i]));
					System.out.println(sizes[i]+"    RO     "+(System.currentTimeMillis()-time_IS)+"     "+(System.currentTimeMillis()-time_SS)+"     "+(System.currentTimeMillis()-time_BS));
				}
					
			}
		}
	}
	
	
	public static int [] input_array_keyboard () {
		System.out.println("Introduce the size of the array");
		int array_size = sc.nextInt();
		int [] array = new int [array_size];
		for (int i = 0; i<array.length; i++) {
			System.out.println("Introduce the value of the position "+i+" of the array");
			array[i] = sc.nextInt();
		}
		return array;
	}
	
	public static int [] descending_sort (int [] array) {
		int temp = 0;
		for (int i=0; i<array.length;i++) {
			for (int j=i+1; j<array.length;j++) {
				if (array[i]<array[j]) {
					temp = array[i];
					array[i] = array[j];
					array[j] = temp;
				}
			}
		}
		
		return array;
	}
	
	public static int [] ascending_sort (int [] array) {
		int temp = 0;
		for (int i=0; i<array.length;i++) {
			for (int j=i+1; j<array.length;j++) {
				if (array[i]>array[j]) {
					temp = array[i];
					array[i] = array[j];
					array[j] = temp;
				}
			}
		}
		
		return array;
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
	
	public static void print_array (int [] array) {
		System.out.println("The array is the following one: ");
		for (int i=0; i<array.length; i++) {
			System.out.print("["+array[i]+"], ");
		}
	}
	
	public static void create_TXT (int LS, int Size, String name_txt) throws IOException {
		File file = new File (name_txt);
		BufferedWriter bw = new BufferedWriter(new FileWriter(file,true));
		for (int i=0; i<Size;i++) {
			bw.write((int)(Math.random()*(LS-0+1)+0));
			bw.newLine();
		}
		bw.close();
	}
	
	
}
