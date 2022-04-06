package Task4;

public class main {
	
	public static void main (String [] args) {
		int digit_array [] = new int [7];
		char operators_array [] = new char [2];
		int actual [] = new int [4];
		int solucion [] = new int [4];
		int objetivo = 0;
		
		for (int i=0; i<operators_array.length; i++ ) {
			backtracking (0, actual, digit_array, objetivo, operators_array[i]);
		}
		
	}
	
	public static void backtracking (int etapa, int [] actual, int digit_array [], int objetivo, char operator) {
		if (etapa == actual.length) {
			if (esSolucion(actual,digit_array,objetivo, operator)) {
				
				//System.arraycopy(actual, 0, solucion, 0, solucion.length);
			}
		} else {
			for (int i = 0; i<digit_array.length; i++ ) {
				if (Vale (i, etapa, actual)) {
					actual[etapa] = i;
					backtracking (etapa+1,actual, digit_array, objetivo,operator);
				}
			}
				
		}
	
	}
	
	
	
	public static boolean esSolucion (int [] actual, int [] digit_array, int objetivo, char operator) {
		
		boolean result = false;
		int first_op = Integer.valueOf(String.valueOf(actual[0])+String.valueOf(actual[1]));
		int second_op = Integer.valueOf(String.valueOf(actual[2])+String.valueOf(actual[3]));
		
		switch(operator) {
		
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




