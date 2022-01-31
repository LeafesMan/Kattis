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
					result = GetOperator(i, result);
					equation = GetOperator(i, equation);
					result = GetOperator(j, result);
					equation = GetOperator(j, equation);
					result = GetOperator(k, result);
					equation = GetOperator(k, equation);
					
					//Add solution to HashMap
					equation = equation + " = " + result;
					solutions.put(result, equation);
				}
			}
		}
		
		//Input and Output
		while(in.hasNextLine()) {
			String sol = (solutions.get(Integer.parseInt(in.nextLine())) == null) ? "no solution"   : solutions.get(Integer.parseInt(in.nextLine()));
			System.out.println(sol);
		}
	}

	//Gets operator and applies to number
	public static int GetOperator(int op, int num) {
		switch(op) {
		case 0:return num *4;
		case 1:return num /4;
		case 2:return num +4;
		case 3:return num -4;
		}
		return 0;
	}
	//Gets operator and applies to string
		public static String GetOperator(int op, String s) {
			switch(op) {
			case 0:return s + " * 4";
			case 1:return s + " / 4";
			case 2:return s + " + 4";
			case 3:return s + " - 4";
			}
			return "";
		}
}
