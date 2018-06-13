package Economy_Simulator;

import java.util.Scanner;

public class Economy_Simulator {

	//Gets a random number from 0 to 9
	public static int randomNumber() {
		return ((int)((Math.random()) * 10));
	}
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		String selection, growth;
		int gdpA, gdpB, tradeValue, total;
		float percentOfExport;
		
		System.out.println("Would you like the use Economy or Research Simulation? Y/N");
		selection = scanner.nextLine();
		if(selection == "Y") {
			System.out.println("Do you want to calculate Growth from Trade or Building?");
			growth = scanner.nextLine();
			if(growth == "Trade") {
				System.out.println("Please input the GDP of the country recieving the trade.");
				gdpA = scanner.nextInt();
				System.out.println("Please input the GDP of the country giving the trade.");
				gdpB = scanner.nextInt();
			}
		}
		else {
			
		}
	}

}
