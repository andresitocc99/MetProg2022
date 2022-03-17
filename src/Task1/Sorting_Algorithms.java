package Task1;

import java.util.*;

public class Sorting_Algorithms {

	public static void main (String [] args) {
		
	}
	
	public static long direct_insertion_sort_array (int [] array) {
		
		long time = System.currentTimeMillis();
		int n = array.length;
		for (int i=1; i<n; ++i) {
			int temp = array[i];
			int j = i-1;
			while (j>=0 && temp <= array[j]) {
				array[j+1] = array[j];
				j = j-1;
			}
			array[j+1] = temp;
		}
		return time;
	}
	
	public static long direct_insertion_sort_arraylist (ArrayList<Integer> array) {
		long time = System.currentTimeMillis();
		for (int i=1; i< array.size();i++) {
			int key = array.get(i);
			for (int j=i-1; j>=0; j--) {
				if (key < array.get(j)) {
					array.set(j+1, array.get(j));
					if (j==0) {
						array.set(0, key);
					}
				} else {
					array.set(j+1,  key);
					break;
				}
			}
		}
		return time;
	}
	
	
	public static long direct_selection_sort_array (int [] array) {
		long time = System.currentTimeMillis();
		int n= array.length;
		for (int i=0; i<n-1; i++) {
			int minimum_number = i;
			for (int j=i+1; j<n; j++) {
				minimum_number = j;
			}
			int temp = array[minimum_number];
			array[minimum_number] = array[i];
			array[i]=temp;
		}
		return time;
	}
	
	public static long direct_selection_sort_arraylist (ArrayList<Integer> array) {
		long time = System.currentTimeMillis();
		for (int i=0; i<array.size();i++) {
			int pos = i;
			for (int j=i; j<array.size();j++) {
				if (array.get(j) < array.get(pos)) {
					pos = j;
					
				}
			}
			int min = array.get(pos);
			array.set(pos, array.get(i));
			array.set(i,  min);
		}
		return time;
	}
	
	public static long bubble_sort_array (int [] array) {
		long time = System.currentTimeMillis();
		int n = array.length;
		for (int i=0; i< n-1; i++) {
			for (int j=0; j<n-i-1; j++) {
				if (array[j] > array[j+1]) {
					int temp = array[j];
					array[j]=array[j+1];
					array[j+1]= temp;
				}
			}
		}
		
		return time;
	}
	
	public static long bubble_sort_arraylist (ArrayList<Integer> array) {
		int j;
		boolean flag = true;
		int temp;
		long time = System.currentTimeMillis();
		while (flag) {
			flag = false;
			for (j=0; j<array.size(); j++) {
				if (array.get(j)> array.get(j+1)){
					temp = array.get(j);
					array.set(j, array.get(j+1));
					array.set(j+1, temp);
					flag = true;
				}
			}
		}
		
		return time;
	}
}
