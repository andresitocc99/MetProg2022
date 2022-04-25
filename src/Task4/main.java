package Task4;

public class main {
	
	public static void main(String[] args) {
		int digit_array [] = new int [7];
		char operators [] = new char [2];
		char actual [] = new char [4];
		int solucion [] = new int [4];
		int objetivo = 0;
		
		//for (int i=0; i<operators_array.length; i++ ) {
			backtracking (0, actual, digit_array, objetivo,operators,operators[0]);
		//}
		
	}
	
	public static int [] generate_digit_array () {
		int array [] = new int [4];
		int num_generated = 0;
		for (int i = 0; i<array.length;i++) {
			if (i==0) {
				array[i] = (int)(Math.random()*(9-0+1)+0);;
			} else {
				do {
					num_generated = (int)(Math.random()*(9-0+1)+0);;
				} while (repeated(num_generated,array, i));		
			}		
			
		}
		return array;
	}
	
	public static boolean repeated (int num_generated, int array [], int i) {
		
		boolean check = false;
		
		for (int j=0; j<i;j++) {
			if (num_generated == array[j]) {
				check = true;
			}
		}
		
		return check;
	}
	
	public static void backtracking (int etapa, char [] actual, int digit_array [], int objetivo, char operators [],char op) {
		if (etapa == actual.length) {
			if (esSolucion(actual,digit_array,objetivo) {
				
				//System.arraycopy(actual, 0, solucion, 0, solucion.length);
			}
		} else {
			for (int i = 0; i<digit_array.length; i++ ) {
				/*if (Vale (i, etapa, actual)) {
					actual[etapa+1] = i;
					backtracking (etapa+1,actual, digit_array, objetivo);
				}*/
				
				if (etapa == 3 ) {
					actual[etapa]=operators[0];
					backtracking (etapa+1,actual, digit_array, objetivo,operators,operators[1]);
				} else {
					actual[etapa+1] = i;
					backtracking (etapa+1,actual, digit_array, objetivo,operators,operators[0]);
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




