import java.util.*;
public class BirthdayMemorization {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		ArrayList<String[]> birthdays = new ArrayList<String[]>();
		
		int birthdayCount = Integer.parseInt(in.nextLine());
		while(birthdayCount > 0) {
			birthdays.add(in.nextLine().split(" "));
			for(String[] b : birthdays) {
				if(b[2].equals(birthdays.get(birthdays.size()-1)[2])) {
					if( Integer.parseInt(b[1]) > Integer.parseInt(birthdays.get(birthdays.size()-1)[1]) )
						birthdays.remove(b);
					break;
				}
			}
			birthdayCount--;
		}
		
		//Output
		System.out.println(birthdays.size());
		for(String[] birthday : birthdays) {
			System.out.println(birthday[0]);
		}
	}
}