package Task4;

public class main {
	

	public static void main(String[] args) {
		
		
		int digit_array [] = generate_digit_array();
		char operators [] = generate_operators_array();
		char actual [] = new char [4];
		int objetivo = ((int)(Math.random()*(99-(-9))))+(-9);
		
		System.out.print("Input array: ");
		for (int i=0; i<digit_array.length; i++) {
			System.out.print(digit_array[i]+", ");
		}
		System.out.print(operators[0]+", "+operators[1]);
		System.out.println();
		System.out.println("Objetivo: "+objetivo);
		
		//backtracking (0, actual, digit_array, objetivo,operators,0);
		
		/*if (!backtracking (0, actual, digit_array, objetivo,operators,0)) {
			System.out.println("No hay posibles soluciones");
		}*/
		
		
			if (!backtracking (0, actual, digit_array, objetivo,operators,0)) {
				System.out.println("No hay posibles soluciones");
			}
	//	}
		
		
		
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
	* Method name: generate_digit_array
	* Description of the Method: get an array of size 7 with non-repeated
	* numbers from 0 to 9 and ordered randomly.
	* Calling arguments: void.
	* Return value: array of integers.
	*********************************************************************/
	
	/*public static boolean backtracking (int etapa, char [] actual, int digit_array [], int objetivo, char operators [],int etapa_2) {
		
		boolean finded = false;
		if (etapa == actual.length) {
			if (esSolucion(actual,digit_array,objetivo)) {
					finded = true;
					for (int k=0;k<actual.length;k++) {
						System.out.print(actual[k]+" ");
					}
					System.out.println();
			}
		} else {
			for (int i = 0; i<digit_array.length && !finded; i++ ) {
				if (etapa == 2) {
					actual[etapa]=operators[etapa_2];
					
					
				} else  {
					actual[etapa] = ((char)('0'+digit_array[i]));
				}
				
				finded = backtracking (etapa+1,actual, digit_array, objetivo,operators,0);
				finded = backtracking (etapa+1,actual, digit_array, objetivo,operators,1);
			
			}
				
		}
		
		return finded;
	
	}*/
	
	public static boolean backtracking (int etapa, char [] actual, int digit_array [], int objetivo, char operators [],int etapa_2) {
		
		boolean finded = false;
		if (etapa == actual.length) {
			if (esSolucion(actual,digit_array,objetivo, etapa_2, operators)) {
					finded = true;
					for (int k=0;k<actual.length;k++) {
						System.out.print(actual[k]+" ");
					}
					System.out.println();
			}
		} else {
			for (int i = 0; i<digit_array.length && !finded; i++ ) {
				
				actual[etapa] = ((char)('0'+digit_array[i]));
				
				finded = backtracking (etapa+1,actual, digit_array, objetivo,operators,0);
				finded = backtracking (etapa+1,actual, digit_array, objetivo,operators,1);
			
			}
				
		}
		
		return finded;
	
	}
	
	
	
	public static boolean esSolucion (char [] actual, int [] digit_array, int objetivo, int etapa_2, char operators[]) {
		
		boolean result = false;
		int first_op = Integer.parseInt(String.valueOf(actual[0])+String.valueOf(actual[1]));
		int second_op = Integer.parseInt(String.valueOf(actual[2])+String.valueOf(actual[3]));
		
		switch(operators[etapa_2]) {
		
		case '+':
			if ((first_op + second_op)==objetivo) {
				result = true;
			}
			break;
		case '-':
			if((first_op - second_op) == objetivo) {
				result = true;
			}
			break;
		case '*':
			if((first_op * second_op) == objetivo) {
				result = true;
			}
			break;
		case '/':
			if((first_op * second_op) == objetivo) {
				result = true;
			}
			break;
		}
		
		return result;
	}
	
	public static boolean Vale (int i, int etapa, int actual []) {
		boolean devolver = true;
		for (int t=0; t<etapa && devolver; t++)  {
			if (i==actual[t]) {
				devolver = false;
			}
		}
		return devolver;
		
	}
}




