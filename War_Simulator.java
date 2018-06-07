/**
 * The purpose of the program is to create an application in order to create
 * a means of simulating wars in Discord Nations by taking into account the
 * factors of a war while also adding in the aspect of randomness to the war.
 *
 *
 * @author CannedBread
 * @dateStarted 06/07/2018
 * @betaRelease
 * @officialRelease
 */
package war_simulator;

import java.util.Scanner;

public class War_Simulator {

    public static int roundNumber(double value)
    {
        double leftOver = value % ((int)value);
        if(leftOver >= 0.5) return (int)value + 1;
        return (int)value;
    }
    
    // Add indices to the array with "true" boolean values.
    public static void addWinningIndices(boolean[] given, int startingIndex, int ordersToFill)
    {
        int i = 0;
    }
    
    // Add indices to the array with "false" boolean values.
    public static void addLosingIndices(boolean[] given, int startingIndex, int ordersToFill)
    {
        int i = 0;
    }
    
    // Return a random outcome from the variable.
    public static boolean chooseRandomResult(boolean[] given)
    {
        int indicesTotal = given.length;
        int randomIndex = (int)(Math.random() * indicesTotal);
        return given[randomIndex];
    }   
    
    // Run the main looping function.
    public static void main(String[] args) 
    {
        // Initialize variables and objects used in the program.
        Scanner scanner = new Scanner(System.in);
        
        int counter = 0;
        boolean[] probableOutcomes = new boolean[100];
        
        String attacker, defender, location;
        
        int aArmySize, dArmySize;
        double aMilitarySpending, dMilitarySpending;
        
        // Introduction text output and input.
        System.out.println("Welcome to the Discord Nations War Simulator.");
        System.out.println("After typing the respone for a question, hit ENTER on your keyboard to move onto the next parameter.");
        System.out.println("Follow commands exactly.");
        System.out.println("If asked to enter a decimal number, you must use the period key, and for whole numbers, make sure to add .0 to the end. Enter 321.0, not 321");
        System.out.println("If not asked to enter a decimal, use integers and round if needed.");
        System.out.println("These first few prompts are not going affect the outcome. They are just to assign names to the belligerents and the region.");
        
        // Get the name of the attacking nation.
        System.out.print("Enter the name of the attacking nation.");
        attacker = scanner.nextLine();
        
        // Get the name of the defending nation.
        System.out.print("Enter the name of the defending nation.");
        defender = scanner.nextLine();
        
        // Get the name of the region or city of fighting.
        System.out.print("What region or city is this fighting taking place?");
        location = scanner.nextLine();
        
        // Starting the factors of the outcome. Get the ratio of military spending of the two.
        System.out.println("These are now the factors that will affect the fighting outcome.");
        System.out.print("Give the attacker's annual military spending in millions of USD. Use a decimal.");
        aMilitarySpending = scanner.nextDouble();
        System.out.print("Give the attacker's annual military spending in millions of USD. Use a decimal.");
        dMilitarySpending = scanner.nextDouble();
        
        // Get the country to output the winner and output the casualties on both sides.
        System.out.println(chooseRandomResult(probableOutcomes));
    }

    
}
