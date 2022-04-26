package Task4;

public class main {
	
	public static void main(String[] args) {
		int digit_array [] = generate_digit_array();
		
		System.out.println("Output array");
		for (int i=0; i<digit_array.length; i++) {
			System.out.print(digit_array[i]+" ");
		}
		System.out.println();
		char operators [] = generate_operators_array();
		char actual [] = new char [5];
		int objetivo = ((int)(Math.random()*(99-(-9))))+(-9);
		
		backtracking (0, actual, digit_array, objetivo,operators,operators[0]);
		
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
	
	public static void backtracking (int etapa, char [] actual, int digit_array [], int objetivo, char operators [],char op) {
		if (etapa == actual.length) {
			if (esSolucion(actual,digit_array,objetivo)) {
					for (int k=0;k<actual.length;k++) {
						System.out.print(actual[k]+" ");
					}
					System.out.println();
				//System.arraycopy(actual, 0, solucion, 0, solucion.length);
			} else {
				System.out.print("Combinación fallida: ");
				for (int k=0;k<actual.length;k++) {
					System.out.print(actual[k]+" ");
				}
				System.out.println();
			}
		} else {
			for (int i = 0; i<digit_array.length; i++ ) {
				if (etapa == 2) {
					actual[etapa]=operators[0];
					backtracking (etapa+1,actual, digit_array, objetivo,operators,operators[1]);
					
				} else if (etapa < 2){
					actual[etapa] = ((char)('0'+digit_array[i]));
					backtracking (etapa+1,actual, digit_array, objetivo,operators,operators[0]);
				} else if (etapa > 2){
					actual[etapa] = ((char)('0'+digit_array[i]));
					backtracking (etapa+1,actual, digit_array, objetivo,operators,operators[1]);
				}
			}
				
		}
	
	}
	
	
	
	public static boolean esSolucion (char [] actual, int [] digit_array, int objetivo) {
		
		boolean result = false;
		int first_op = Integer.valueOf(actual[0]+actual[1]);
		int second_op = Integer.valueOf(actual[3]+actual[4]);
		
		switch(actual[2]) {
		
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




