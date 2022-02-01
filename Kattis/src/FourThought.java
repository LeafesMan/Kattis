import java.util.*;

public class FourThought {

	public static void main(String[] args) {
		//Initialize variables
		HashMap<Integer, String> solutions = new HashMap<Integer, String>();
		Scanner in = new Scanner(System.in);
		int result = 4;
		String equation = "4";
		
		//Generate solution set Looping through each operator
		for(int i = 0; i < 4; i ++) {
			for(int j = 0; j < 4; j ++) {
				for(int k = 0; k < 4; k++) {
					//Generate Solution
					equation = GetEquation(i,j,k);
					result = Solver.evaluate(equation);
					
					//Add solution to HashMap
					solutions.put(result, equation);
				}
			}
		}
		
		//Input and Output
		int i = 0;
		int numLines = Integer.parseInt(in.nextLine());
		while(i < numLines) {
			int sol = Integer.parseInt(in.nextLine());
			String eq = solutions.get(sol);
			System.out.println( (eq == null) ? "no solution" : eq + " = " + sol);
			i++;
		}
	}
	
	
	//Solves the equation Multiplying and dividing first
	public static int SolveEquation(int i, int j, int k) {
		int num = 4;
		if (i < 2) num = ParseOperator(i, num);
		if (j < 2) num = ParseOperator(j, num);
		if (k < 2) num = ParseOperator(k, num);
		if (i > 1) num = ParseOperator(i, num);
		if (j > 1) num = ParseOperator(j, num);
		if (k > 1) num = ParseOperator(k, num);
		return num;
	}
	
	//Returns the string equation
	public static String GetEquation(int i, int j, int k) {
		String eq = "4";
		eq = ParseOperator(i, eq);
		eq = ParseOperator(j, eq);
		eq = ParseOperator(k, eq);
		return eq;
	}
	
	
	//Gets operator and applies to number
	public static int ParseOperator(int op, int num) {
		switch(op) {
		case 0:return num *4;
		case 1:return num /4;
		case 2:return num +4;
		case 3:return num -4;
		}
		return 0;
	}
	//Gets operator and applies to string
		public static String ParseOperator(int op, String s) {
			switch(op) {
			case 0:return s + " * 4";
			case 1:return s + " / 4";
			case 2:return s + " + 4";
			case 3:return s + " - 4";
			}
			return "";
		}
}