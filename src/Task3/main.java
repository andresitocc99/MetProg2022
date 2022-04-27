package Task3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class main {
	
	public static void main (String[] args) throws FileNotFoundException {
		String path = ""; // Path of the File
		int sledge = 0; // Capacity of the sledge
		int N = numberOfVillages(path); // Total of villages
		int [] villages = readFile (path, N);
		//int P = 0; // Maximum of Kg offered by a Villageç
		int M = 0; // TimeToVisit;
		
	}
	
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
