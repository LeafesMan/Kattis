import java.util.Scanner;

public class Lamps2 {

	public static void main(String[]args) {
		//Initialize Vars
		Scanner in = new Scanner(System.in);
		int hoursPerDay = in.nextInt(), pricePerHour = in.nextInt(), day, i, priceForBulbs = 5;
		in.close();

		//Finds max number of days and starts at half
		day = i = 8000 / hoursPerDay / 2;
		
		//Search for day where increasing day makes new bulb better than incandescent
		while(true) {
			if(isLowEnergyCheaper(day, pricePerHour, hoursPerDay)){
				if(isLowEnergyCheaper(day-1, pricePerHour, hoursPerDay)) {
					i = (i == 1) ? 1 : i/2;
					day -= i;
				}
				else
					break;
			}
			else {
				if(isLowEnergyCheaper(day+1, pricePerHour, hoursPerDay)) {
					day++;
					break;
				}
				else {
					i = (i == 1) ? 1 : i/2;
					day += i;
				}
			}
		}

		System.out.print(day);
	}
	
	//Returns true if low energy lamp is cheaper
	private static boolean isLowEnergyCheaper(int day, int pricePerHour, int hoursPerDay) {
		return 60 + (float)(11 * pricePerHour * day * hoursPerDay)/100000 <= 5 + ((hoursPerDay*day-1)/1000) * 5 + (float)(60 * pricePerHour * day * hoursPerDay)/100000;
	}

}
