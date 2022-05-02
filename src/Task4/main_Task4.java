package Task4;

public class main_Task4 {
	

	public static void main(String[] args) {
		
		
		int digits [] = generate_digit_array();
		char operators [] = generate_operators_array();
		char array [] = combinate_array(digits, operators);
		char actual [] = new char [5];
		int objective = ((int)(Math.random()*(99-(-9))))+(-9);
		
		System.out.print("Input array: ");
		
		for (int i=0; i<array.length; i++) {
			System.out.print(array[i]+", ");
		}
		
		System.out.println();
		System.out.println("Objective: "+objective);

		if (!backtracking (0, actual, array, objective)) {
			System.out.println("Result not found");
		}
		
		
		
	}
	
	/**********************************************************************
	* Method name: combinate_array
	* Description of the Method: combinate the array of int and the array of
	* operators, resulting an array of char.
	* Calling arguments: int [] digits, char [] operators.
	* Return value: array of char.
	*********************************************************************/
	
	
	public static char [] combinate_array (int [] digits, char [] operators) {
		char [] array = new char [9];
		int op = 0;
		
		for (int i=0; i<7; i++) {
			array[i]=(char)(digits[i]+'0');
		}
		
		for (int i=7; i<array.length;i++) {
			array[i]=operators[op];
			op++;
		}
		
		return array;
	}
	
	
	/**********************************************************************
	* Method name: generate_digit_array
	* Description of the Method: get an array of size 7 with non-repeated
	* numbers from 0 to 9 and ordered randomly.
	* Calling arguments: void.
	* Return value: array of integers.
	*********************************************************************/
	
	public static int [] generate_digit_array () {
		int array [] = new int [7];
		int num_generated = -1;
		for (int i = 0; i<array.length;i++) {
			if (i==0) {
				array[i] = ((int)(Math.random()*(9-0))+0);
			} else {
				do {
					num_generated = ((int)(Math.random()*(9-0))+0);
				} while (repeated(num_generated,array, i));
				array[i]=num_generated;
			}		
			
		}
		return array;
	}
	
	/**********************************************************************
	* Method name: generate_operators_array
	* Description of the Method: get an array of operators of size two.
	* Calling arguments: void.
	* Return value: array of characters..
	*********************************************************************/
	
	public static char [] generate_operators_array () {
		int operator_array [] = new int [2];
		int op_generated = -1;
		
		for (int i=0; i<2;i++) {
			if (i==0) {
				operator_array[i] = ((int)(Math.random()*(3-0))+0);
			} else {
				do {
					op_generated = ((int)(Math.random()*(3-0))+0);
				} while (repeated(op_generated,operator_array, i));		
				operator_array[i]=op_generated;
			}	
		}
		
		char operators [] = new char [2];
		 for (int j=0; j<2;j++) {
			 if (operator_array[j]==0) {
				 operators[j]='+';
			 } else if (operator_array[j]==1) {
				 operators[j]='-';
			 } else if (operator_array[j]==2) {
				 operators[j]='*';
			 } else if (operator_array[j]==3) {
				 operators[j]='/';
			 } 
		 }
		
		 return operators;
		
	}
	
	/**********************************************************************
	* Method name: repeated
	* Description of the Method: check if a number is already introduced 
	* in a given array.
	* Calling arguments: int numgenerated, int array[], int i.
	* Return value: boolean.
	*********************************************************************/
	
	public static boolean repeated (int num_generated, int array [], int i) {
		
		boolean check = false;
		
		for (int j=0; j<i;j++) {
			if (num_generated == array[j]) {
				check = true;
			}
		}
		
		return check;
	}
	
	/**********************************************************************
	* Method name: backtracking
	* Description of the Method: main method of the backtracking
	* Calling arguments: int stage, int [] actual, int digit_array [], 
	* int objective, char operators [],int stage_2.
	* Return value: boolean.
	*********************************************************************/
	
	public static boolean backtracking (int stage, char [] actual, char array [], int objective ) {
		boolean found = false;
		if (stage == actual.length) {
			if (isSolution(actual,objective)) {
				found = true;
				
				for (int k=0; k<actual.length;k++) {
					System.out.print(actual[k]+" ");
				}
					System.out.println();
			}
		} else {
			
				if (stage != 2) {
					for (int i=0; i<7 && !found;i++) {
						actual[stage]=array[i];
						found = backtracking (stage+1,actual, array,objective);
					}
				} else {
					for (int i=7;i<array.length && !found;i++) {
						actual[stage]=array[i];
						found = backtracking (stage+1,actual, array,objective);
					}
				}
			
		}
		return found;
		
		
		
		
	
	}
	
	/**********************************************************************
	* Method name: isSolution
	* Description of the Method: check if the operation results a given objective
	* Calling arguments: int [] actual, int [] digit_array, int objective, 
	* int stage_2, char operators[].
	* Return value: boolean.
	*********************************************************************/
	
	
	public static boolean isSolution (char [] actual, int objective) {
		
		boolean result = false;
		
		int first_op = (Integer.parseInt(String.valueOf(actual[0])))*10+Integer.parseInt(String.valueOf(actual[1]));
		int second_op = (Integer.parseInt(String.valueOf(actual[3])))*10+Integer.parseInt(String.valueOf(actual[4]));
		
		
		switch(actual[2]) {
		
		case '+':
			if ((first_op + second_op)==objective) {
				result = true;
			}
			break;
		case '-':
			if((first_op - second_op) == objective) {
				result = true;
			}
			break;
		case '*':
			if((first_op * second_op) == objective) {
				result = true;
			}
			break;
		case '/':
			if((first_op / second_op) == objective) {
				result = true;
			}
			break;
		}
		
		return result;
	}
	
}




