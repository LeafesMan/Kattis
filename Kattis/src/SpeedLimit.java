import java.util.*;
public class SpeedLimit {

	public static void main(String[] args) {
		// Initialize variables
		Scanner in = new Scanner(System.in);
		int miles = 0, prevHours = 0, hours = 0 , speed = 0;

		//While loop adds up miles until out of entries then prints miles and gets
		//the next number of entries repeating until receives -1
		int numEntries = in.nextInt();
		while(numEntries != -1) {
			if(numEntries != 0) {
				speed = in.nextInt();
				prevHours = hours;
				hours = in.nextInt();
				miles += speed * (hours - prevHours);
				numEntries--;
			}
			else {
				System.out.println(miles + " miles");
				numEntries = in.nextInt();
				hours = 0;
				miles = 0;
			}
		}
	}
}
