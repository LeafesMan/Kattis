import java.util.Scanner;

public class BuyingCoke {

	public static void main(String[] args) {
		//Initialize Variables
		Scanner in = new Scanner(System.in);
		int numCases = in.nextInt(), cokesWanted, oneCoin, fiveCoin, tenCoin;
		
		//Loops to get coins needed for each input
		while(numCases > 0) {
		    cokesWanted = in.nextInt(); 
			oneCoin = in.nextInt(); 
			fiveCoin = in.nextInt(); 
			tenCoin = in.nextInt();
			System.out.println(coinsNeeded(cokesWanted, oneCoin, fiveCoin, tenCoin));
			numCases--;
		}
	}
	//Gets Coins needed given inputs
	private static int coinsNeeded(int cokesWanted, int c1, int c2, int c3) {
		int coinsIn = 0; 
		boolean isFourBetter = false;
		
		//Loop for buying cokes until all cokes needed have been purchased
		while(cokesWanted > 0) {
			//Once out of dimes find whether prioritizing 2 nickels or 1 is better
			if(c3 == 0)
				return Math.min(minCoinsUsingBoth(c1, c2, cokesWanted), Math.min(minCoinsUsing4(c1, c2, cokesWanted), minCoinsUsing2(c1, c2, cokesWanted)))+ coinsIn;
			if(c3 > 0) {
				coinsIn++;
				c3--;
				c1+=2;
				cokesWanted --;
			}
		}
		return coinsIn;
	}
	
	//Finds the number of coins spent when buying with 1 nickel and 3 pennies whenever it can
	public static int minCoinsUsing4(int c1, int c2, int cokes){
		int leastCoins = 0;
		while(cokes > 0){
			if(c2 > 0 && c1 > 2){
				leastCoins += 4;
				c2--;
				c1 -=3;
			}
			else if(c2 > 1){
				leastCoins += 2;
				c2 -= 2;
				c1 += 2;
			}
			else {
				leastCoins += cokes * 8;
				break;
			}
			cokes--;
		}
		return leastCoins;
	}
	
	//Finds the number of coins spent when buying with 1 nickel and 3 pennies whenever it can
	public static int minCoinsUsing2(int c1, int c2, int cokes){
		int leastCoins = 0;
		while(cokes > 0){
			if(c2 > 1){
				leastCoins += 2;
				c2 -= 2;
				c1 += 2;
			}
			else if(c2 > 0 && c1 > 2){
				leastCoins += 4;
				c2--;
				c1 -=3;
			}

			else {
				leastCoins += cokes * 8;
				break;
			}
			cokes--;
		}
		return leastCoins;
	}
	//Finds the number of coins spent when buying with 1 nickel and 3 pennies whenever it can
		public static int minCoinsUsingBoth(int c1, int c2, int cokes){
			int leastCoins = 0;
			while(cokes > 0){
				if(c2 > 0 && c1 > 2 && c2 <= cokes){
					leastCoins += 4;
					c2--;
					c1 -=3;
				}
				else if(c2 > 1){
					leastCoins += 2;
					c2 -= 2;
					c1 += 2;
				}
				else {
					leastCoins += cokes * 8;
					break;
				}
				cokes--;
			}
			return leastCoins;
		}
	
}
