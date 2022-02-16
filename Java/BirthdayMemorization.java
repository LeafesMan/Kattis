import java.util.*;
public class BirthdayMemorization {

	public static void main(String[] args) {
		//Initialize Variables
		Scanner in = new Scanner(System.in);
		String[] birthdayInfo = new String[3];
		HashMap<String,String[]> birthdays = new HashMap<String,String[]>();
		
		//Take Inputs and place higher weights into hashmap
		int birthdayCount = Integer.parseInt(in.nextLine());
		while(birthdayCount > 0) {
			birthdayInfo = in.nextLine().split(" ");
			//if key is not used add birthday to map
			if(birthdays.get(birthdayInfo[2]) == null)
				birthdays.put(birthdayInfo[2], new String[]{birthdayInfo[0], birthdayInfo[1]});
			//If two inputs have same birthday replace old friend if new input has higher weight
			else if( Integer.parseInt(birthdays.get(birthdayInfo[2])[1]) < Integer.parseInt(birthdayInfo[1]) )
				birthdays.put(birthdayInfo[2], new String[]{birthdayInfo[0], birthdayInfo[1]});
			birthdayCount--;
		}
		
		//Alphabetize final array of birthdays
		String[] finalBirthdays = new String[birthdays.size()];
		//Extracts names into final birthdays array
		int i = 0, j = 0;
		for(String[] f : birthdays.values()) {
			finalBirthdays[i] = f[0];
			i++;
		}
		//Sorter
		i = 0;
		String temp;
		while(i < finalBirthdays.length-1) {
			while(j < finalBirthdays.length-1) {
				if(finalBirthdays[j].compareTo(finalBirthdays[j+1]) > 0) {
					temp = finalBirthdays[j+1];
					finalBirthdays[j+1] = finalBirthdays[j];
					finalBirthdays[j] = temp;
				}
				j++;
			}
			j = 0;
			i++;
		}
		
		//Output
		System.out.println(birthdays.size());
		for(String s : finalBirthdays) {
			System.out.println(s);
		}
	}
}