import java.util.Scanner;
public class Lektira {
	
	public static void main(String[]args) {
		//Get input String and declare vars
		Scanner in = new Scanner(System.in);
		String input = in.next(), firstInDictionary = "", cutReversed = "";
		int length = input.length();
		
		//Loops through all possible splits finding first in dictionary
		for(int i = 1; i < length-1; i++) {
			for(int j = i + 1; j < length; j++) { //Splits string into 3 words reverses them then concats strings
				cutReversed = reverseString(input.substring(0,i)) + reverseString(input.substring(i,j)) + reverseString(input.substring(j));
				if(cutReversed.compareTo(firstInDictionary) <0 || firstInDictionary == "")
					firstInDictionary = cutReversed;
			}
		}
		
		System.out.println(firstInDictionary);
	}

	//Return revered string
	public static String reverseString(String s) {
		String r = "";
		for(int i = 0; i < s.length(); i++) {
			r = s.substring(i, i + 1) + r;
		}
		return r;
	}
}
