package Task4;

public class main_Task4 {
	

	public static void main(String[] args) {
		
		
		int digit_array [] = generate_digit_array();
		char operators [] = generate_operators_array();
		int actual [] = new int [4];
		int objective = ((int)(Math.random()*(99-(-9))))+(-9);
		
		System.out.print("Input array: ");
		
		for (int i=0; i<digit_array.length; i++) {
			System.out.print(digit_array[i]+", ");
		}
		
		System.out.print(operators[0]+", "+operators[1]);
		System.out.println();
		System.out.println("objective: "+objective);

		backtracking (0, actual, digit_array, objective,operators,0);
		
		
		
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
	* Return value: void.
	*********************************************************************/
	
	public static void backtracking (int stage, int [] actual, int digit_array [], int objective, char operators [],int stage_2) {
		
		
		if (stage == actual.length) {
			if (isSolution(actual,digit_array,objective, stage_2, operators)) {
										
					for (int k=0;k<actual.length;k++) {
						System.out.print(digit_array[actual[k]]+" ");
						if (k==1) {
							System.out.print(operators[stage_2]+" ");
						}
					}
					System.out.println();
			}
		} else {
			for (int i = 0; i<digit_array.length; i++ ) {
				
				actual[stage] = i;
				
				backtracking (stage+1,actual, digit_array, objective,operators,0);
				backtracking (stage+1,actual, digit_array, objective,operators,1);
			
			}
				
		}
		
	
	}
	
	/**********************************************************************
	* Method name: isSolution
	* Description of the Method: check if the operation results a given objective
	* Calling arguments: int [] actual, int [] digit_array, int objective, 
	* int stage_2, char operators[].
	* Return value: boolean.
	*********************************************************************/
	
	
	public static boolean isSolution (int [] actual, int [] digit_array, int objective, int stage_2, char operators[]) {
		
		boolean result = false;
		int first_op = (digit_array[actual[0]]*10)+digit_array[actual[1]];
		int second_op = (digit_array[actual[2]]*10)+digit_array[actual[3]];
		
		switch(operators[stage_2]) {
		
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
			if((first_op * second_op) == objective) {
				result = true;
			}
			break;
		}
		
		return result;
	}
	
}




