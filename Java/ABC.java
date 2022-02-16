import java.util.Scanner;
public class ABC {

	public static void main(String[] args) {
		//initialize variables
		int[] nums = new int[3];
		Scanner input = new Scanner(System.in);
		
		//Setup letter and number arrays
		String[] letters = input.nextLine().split(" ");
		for(int i = 0; i <3; i++)
			nums[i] = Integer.parseInt(letters[i]);
		letters = input.nextLine().split("");
		
		//Sort number array
		int temp;
		for(int i = 0; i < 2; i++) {
			for(int j = 0; j < 2; j++) {
				if(nums[j] > nums[j+1]) {
					temp = nums[j+1];
					nums[j+1] = nums[j];
					nums[j] = temp;
				}
			}
		}
		
		//print output
		for(int i = 0; i < 3; i++) {
			if(letters[i].equals("A"))
				System.out.print(nums[0]);
			else if(letters[i].equals("B"))
				System.out.print(nums[1]);
			else if(letters[i].equals("C"))
				System.out.print(nums[2]);
			System.out.print(" ");
		}
	}
}
