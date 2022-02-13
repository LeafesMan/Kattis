import java.util.Scanner;
public class Lamps1 {

	public static void main(String[]args) {
		//Initialize Vars
		Scanner in = new Scanner(System.in);
		int hoursPerDay = in.nextInt(), pricePerHour = in.nextInt(), day = 0, priceForBulbs = 5;
		

		
		//Increment days until buying iradescent lamp is cheaper
		while(60 + (float)(11 * pricePerHour * day * hoursPerDay)/100000 > 5 + priceForBulbs + (float)(60 * pricePerHour * day * hoursPerDay)/100000 ){
			day ++;
			priceForBulbs = (int)((hoursPerDay*day-1)/1000) * 5;
		}
		
		System.out.print(day);
	}
}
