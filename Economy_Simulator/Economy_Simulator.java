package Economy_Simulator;

import java.util.Scanner;

public class Economy_Simulator {

	public static int randomNumber() {
		return ((int)((Math.random()) * 10));
	}
	
	public static float economicGrowth() {
		
	}
	
	public static int researchTime() {
		
	}
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		String selection;
		
		System.out.println("Would you like the use Economy or Research Simulation? Y/N");
		selection = scanner.nextLine();
		if(selection == "Y") {
			economicGrowth();
		}
		else {
			researchTime();
		}
	}

}
