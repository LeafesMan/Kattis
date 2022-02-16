import java.util.Scanner;
public class Arrangement {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int rooms = in.nextInt();
		int teams = in.nextInt();
		
		int teamPerRoom = teams/rooms;
		int remainder = teams % rooms;
		
		
		for(int i = 0; i < rooms; i ++) {
			for(int j = 0; j < teamPerRoom; j ++)
				System.out.print("*");
			if(remainder-- > 0)
				System.out.print("*");
			System.out.println();
		}
	}
}
