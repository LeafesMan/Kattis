import java.util.*;
public class Modulo {

	public static void main(String[] args) {
		//Initialize variables
		Scanner in = new Scanner(System.in);
		HashMap<Integer, Integer> modulos = new HashMap<Integer,Integer>();
		
		//Add input%42 to hashmap
		while(in.hasNextInt()) {
			modulos.put(in.nextInt()%42, null);
		}
		
		//Outpus
		System.out.println( modulos.keySet().size() );
	}
}
