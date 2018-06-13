package Economy_Simulator;

import java.util.Scanner;

public class Economy_Simulator {

	static Scanner scanner = new Scanner(System.in);
	
	static String growth, selection;
	static double percentOfExport, average, last, gdpA, gdpB, tradeValue, total;;
	
	//Gets a random number from 1 to 10
	public static int randomNumber() {
		return ((int)(((Math.random()) * 10) + 1));
	}
	
	public static void economySimulation() {
		System.out.println("Please input the GDP of the first country in dollars:");
		gdpA = scanner.nextDouble();
		System.out.println("Please input the GDP of the second country in dollars:");
		gdpB = scanner.nextDouble();
		System.out.println("Please input the value of the trade deal in dollars:");
		tradeValue = scanner.nextDouble();
		System.out.println("Please input the total imports/exports of the country that is recieving the trade deal in dollars:");
		total = scanner.nextDouble();
		
		percentOfExport = tradeValue / total;
		average = (gdpA + gdpB) / 2;
		last = (average * percentOfExport) % randomNumber();
		
		System.out.println(last);
	}
	
	public static void researchSimulation() {
		
	}
	
	public static void main(String[] args) {
		System.out.println("Would you like the use Economy or Research Simulation? Y/N");
		selection = scanner.nextLine();
		if(selection.equals("Y")) {
			economySimulation();
		}
		else {
			researchSimulation();
		}
	}

}
