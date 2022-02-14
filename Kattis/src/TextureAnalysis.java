import java.util.Scanner;
public class TextureAnalysis {
	public static void main(String[]args) {
		//Initialize Variables
		Scanner in = new Scanner(System.in);
		String nextLine;
		int lineCount = 0, pixelCount = 0, patternCount = -1;

		while(true) {
			//Get input and check break condition
			nextLine = in.nextLine();
			if(nextLine.equalsIgnoreCase("END"))
				break;
			
			//Reset Variables for new Line
			lineCount++;
			patternCount = -1;
			pixelCount = 0;
			System.out.print(lineCount);
			//print even or not
			for(int i = 1; i < nextLine.length(); i++) {
				//BlackPixelLogic
				if(nextLine.charAt(i) == '*') {
					if(patternCount == -1)
						patternCount = pixelCount;
					else if(patternCount != pixelCount) {
						System.out.print(" NOT");
						break;
					}
					pixelCount = 0;
				}
				//WhitePixelLogic
				else
					pixelCount++;
			}
			System.out.println(" EVEN");
		}
		in.close();
	}
}
