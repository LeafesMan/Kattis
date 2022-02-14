import java.util.Scanner;
public class AListGame {

	public static void main(String[] args) {
		//Initialize Variables
		Scanner in = new Scanner(System.in);
		int currentNum =  in.nextInt(), numCount = 0;
		in.close();
		
		//Iterates through dividing by lowest num as often as possible
		while(currentNum != 1) {
			
			if(currentNum % 2 == 0) {
				currentNum /= 2;
				numCount++;
			}
			else {
				for(int i = 3; i <= currentNum ; i+=2){
					if(currentNum % i == 0) {
						currentNum /= i;
						numCount++;
						break;
					}
					else if(i*i > currentNum) {
						currentNum = 1;
						numCount++;
						break;
					}
				}
			}
		}
		
		System.out.print(numCount);
	}
}
