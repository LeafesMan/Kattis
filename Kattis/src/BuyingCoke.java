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
		
		//Loop for buying cokes until all cokes needed have been purchased
		while(cokesWanted > 0) {
			if(c3 > 0) {
				coinsIn++;
				c3--;
				c1+=2;
			}
			//							Decides whether buying coke with all 5 coins is better than buying with 1 5 and 3 1's
			else if(c2 > 0 && c1 > 2 &&  c2 /2 < cokesWanted && (cokesWanted - c2) * 8 + c2 < (cokesWanted - c2/2) * 8 + (c2/2) * 2 + (c2 - c2/2*2) * 4) {
				coinsIn+=4;
				c2-=1;
				c1-=3;
			}
			else if(c2 > 1) {
				coinsIn+=2;
				c2-=2;
				c1+=2;
			}
			else {
				coinsIn+=8;
				c1 -=8;
			}
			cokesWanted--;
		}
		return coinsIn;
	}
	
}


