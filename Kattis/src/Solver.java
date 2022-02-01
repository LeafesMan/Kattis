
public class Solver {
	
	//Main solver function evaluates a string equation to an integer value
	public static int evaluate(String eq) {
		//Initialize Variables
		int pPos = 0, nPos = 0, overload = 0;
		boolean twoOperators = false;
		
		//First remove spaces and evaluate any parentheses
		eq = removeSpaces(eq);
		eq = removeSubtraction(eq);
		eq = evaluateParentheses(eq);
		
		//Evaluate Exponents DO LATER
		
		//Evaluate * / 
		while(true) {
			//Set up variables and break if there are no operators
			pPos = eq.indexOf("*"); nPos = eq.indexOf("/");
			if(pPos == -1 && nPos == -1) break;
			if(pPos != -1 && nPos != -1) twoOperators = true;
			else twoOperators = false;
			
			
			//Finds first Operator and evaluates it
			if(twoOperators)
				eq = parseOperator(eq, (pPos < nPos) ? pPos : nPos);
			else
				eq = parseOperator(eq, (pPos != -1) ? pPos : nPos);
			
			
			//Breaks if over 500 iterations
			if(overload++ > 500) break;
		}
		overload = 0;
		
		//Evaluate + -
		while(true) {
			//Set up variables and break if there are no operators
			pPos = eq.indexOf("+");
			if(pPos == -1) break;

	
			//Evaluates all addition and subtraction
			eq = parseOperator(eq, pPos);
			
			
			//Breaks if over 500 iterations
			if(overload++ > 500) break;
		}
		
		//Returns equation parsed to integer
		return Integer.parseInt(eq);
	}
	
	
	
	//Evaluates Parentheses by finding them and passing contents into evaluate returning result
	private static String evaluateParentheses(String eq) {
		return ( (eq.indexOf("(") == -1) ? eq : String.valueOf( eq.substring(0,eq.indexOf("("))) + evaluate( eq.substring(eq.indexOf("(")+1, eq.lastIndexOf(")")) ) + eq.substring(eq.lastIndexOf(')'), eq.length()) ) ;
	}
	
	
	
	//Applies operator to number to left of pos and number right of pos
	private static String parseOperator(String eq, int opPos) {
		//Get number before and after operator and their lengths
		int prevNum = getNextNum(eq, opPos, -1), postNum = getNextNum(eq, opPos, 1);
		int prevNumLength = String.valueOf(prevNum).length(), postNumLength = String.valueOf(postNum).length();
		int result = 0;
		
		//Gets result of operation
		switch(eq.charAt(opPos)) {
		case '*': result = prevNum * postNum; break;
		case '/': result = prevNum / postNum; break;
		case '+': result = prevNum + postNum; break;
		case '-': result = prevNum - postNum; break;
		}
		
		//Insert result of operation removing numbers and operator and return the remaining expression
		return  eq.substring(0, opPos - prevNumLength) + result + eq.substring(opPos+ postNumLength + 1);
	}
	
	
	//Given a string and the operator position finds the number prior to the operator
	private static int getNextNum(String eq, int opPos, int dir) {
		String num = "";
		int i = 1;
		
		//finds start of number
		/*while( (eq.substring(opPos + i * dir, opPos + i * dir + 1).equals(" ")) ){
			i++;
		}*/
		
		//Loops through number and places into an output string
		//      		While index is in the bounds of the string  and the character is a '.' or '-' or an int 																						
		while( dir == 1 && opPos + i < eq.length() &&
				((tryParse(eq.substring(opPos + i, opPos + i + 1)) || eq.charAt(opPos +i) == '.') || eq.charAt(opPos +i) == '-')  ){
				num = num + eq.substring(opPos + i, opPos + i +1);
				i++;	
		}
		while( dir == -1 && eq.length() - opPos + i <= eq.length() &&
				((tryParse(eq.substring(opPos - i, opPos - i + 1)) || eq.charAt(opPos -i) == '.') || eq.charAt(opPos -i) == '-') ){
				num = eq.substring(opPos - i, opPos - i + 1) + num;
				i++;	
		}
		
		return Integer.parseInt(num);
	}
	
	
	//Tries to parse number returns true if is an int
	private static boolean tryParse(String num) {
		try {
			Integer.parseInt(num);
			return true;
		}
		catch(Exception e){
			return false;
		}
	}
	
	//Removes spaces from the input string
	private static String removeSpaces(String s) {
		for(int i = 0; i < s.length(); i ++) {
			if(s.substring(i, i+1).equals(" "))
				s = s.substring(0, i) + s.substring(i+1, s.length());
		}
		return s;
	}
	
	//places a + infront of - between numbers
	private static String removeSubtraction(String eq) {
		//Variable initialization
		boolean prevIsNum = false;
		int i = 0;
		
		while(i < eq.length()) {
			//if there is a number before the - insert a + in front of the -
			if(eq.charAt(i) == '-' && prevIsNum) {
				eq = eq.substring(0,i) + '+' + eq.substring(i);
				i++;
			}
			//if is num set prevIsNum to true
			prevIsNum = tryParse(eq.substring(i, i +1));
			i++;
		}
		
		return eq;
	}
}
