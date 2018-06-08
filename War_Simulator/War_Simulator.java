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

import java.text.DecimalFormat;
import java.util.Scanner;

public class War_Simulator {
    
    public static int counter = 2;
    public static int aWinCounter = 1;
    public static int dWinCounter = 1;
    
    // Round numbers to the nearest integer value.
    public static int roundNumber(double value)
    {
        double leftOver = value % ((int)value);
        if(leftOver >= 0.5) return (int)value + 1;
        return (int)value;
    }
    
    // Choose a random value between two double variables.
    public static double randomDouble(double start, double end)
    {
        return ((Math.random() * (end - start)) + start);
    }
    
    // Clear the win numbers to prevent errors.
    public static void clearWins(int a, int b)
    {
        a = 0;
        b = 0;
    }
    
    // Add indices to the array with "true" boolean values.
    public static void addAWinningIndices(boolean[] given, int ordersToFill)
    {
        if(ordersToFill > 0)
        {    
            while(ordersToFill != 0){
                given[counter] = true;
                counter++;
                ordersToFill--;
                aWinCounter++;
            }
        }
    }
    
    // Add indices to the array with "false" boolean values.
    public static void addDWinningIndices(boolean[] given, int ordersToFill)
    {
        if(ordersToFill > 0)
        {    
            while(ordersToFill != 0){
                given[counter] = false;
                counter++;
                ordersToFill--;
                dWinCounter++;
            }
        }
    }
    
    // Return a random outcome from the variable.
    public static boolean chooseRandomResult(boolean[] given)
    {
        int indicesTotal = counter - 1;
        int randomIndex = (int)(Math.random() * indicesTotal);
        return given[randomIndex];
    }   
    
    // Run the main looping function.
    public static void main(String[] args) 
    {
        // Initialize variables and objects used in the program.
        Scanner scanner = new Scanner(System.in);
        DecimalFormat formatter = new DecimalFormat("#0.0");
        
        boolean probableOutcomes[] = new boolean[2000];
        
        for(int i = 0; i < probableOutcomes.length; i++){
            probableOutcomes[i] = false;
        }
        
        boolean attackSuccessful;
        double aCasualties, dCasualties;
        
        String attacker, defender, location;
        
        int aWins, dWins;
        double aMilitarySpending, dMilitarySpending;
        double aArmySize, dArmySize;
        int terrain, climate;
        int invadedVar, independenceVar;
        int aRebellious, dRebellious;
        int aFails, aSuccesses, dFails, dSuccesses;
        int aEquipment, dEquipment;
        int conscriptsAndReserves;
        int warReason;
        int aGuerrilaDamage;
        int aSupplyLine, dSupplyLine;
        int airSupport;
        int aGovernmentPopularity, dGovernmentPopularity;
        
        // Start both sides on an equal footing (and prevent errors).
        probableOutcomes[0] = true;
        probableOutcomes[1] = false;
        
        // Introduction text output and input.
        System.out.println("Welcome to the Discord Nations War Simulator.");
        System.out.println("After typing the respone for a question, hit ENTER on your keyboard to move onto the next parameter.");
        System.out.println("Follow commands exactly.");
        System.out.println("If asked to enter a decimal number, you must use the period key, and for whole numbers, make sure to add .0 to the end. Enter 321.0, not 321");
        System.out.println("If not asked to enter a decimal, use integers and round if needed.");
        System.out.println("If \"(1 or 0)\" is written, please type 1 or 0 as the answer. 1 means yes and 0 means no.");
        System.out.println("These first few prompts are not going affect the outcome. They are just to assign names to the belligerents and the region.");
        
        // Get the name of the attacking nation.
        System.out.println("Enter the name of the attacking nation.");
        attacker = scanner.nextLine();
        
        // Get the name of the defending nation.
        System.out.println("Enter the name of the defending nation.");
        defender = scanner.nextLine();
        
        // Get the name of the region or city of fighting.
        System.out.println("What region or city is this fighting taking place?");
        location = scanner.nextLine();
        
        /** These are the factors of the outcome of the battle or campaign.
         * The following are the parameters taken into account:
         * Military Spending
         * Army Size
         * Terrain
         * Climate
         * Hostilities in the Past and Colonialism/Imperialism
         * Morale from Recent Campaigns
         * Attacker equipment quality
         * Conscription and Reserve Morale
         * Casus belli
         * Guerrilla Fighting
         * Supply line quality
         * Government Public Support
         */ 
        
        // Compare the military spending of the two.
        System.out.println("These are now the factors that will affect the fighting outcome.");
        System.out.println("Give " + attacker + "\'s annual military spending in millions of USD. Use a decimal.");
        aMilitarySpending = scanner.nextDouble();
        System.out.println("Give " + defender + "\'s annual military spending in millions of USD. Use a decimal.");
        dMilitarySpending = scanner.nextDouble();
        
        aWins = roundNumber(10 * (aMilitarySpending / (aMilitarySpending + dMilitarySpending)));
        dWins = 10 - aWins;
        addAWinningIndices(probableOutcomes, aWins);
        addDWinningIndices(probableOutcomes, dWins);
        clearWins(aWins, dWins);
             
        // Compare the army sizes of the two.
        System.out.println("Give " + attacker + "\'s army size in thousands. Please use decimals.");
        aArmySize = scanner.nextDouble();
        System.out.println("Give " + defender + "\'s army size in thousands. Please use decimals.");
        dArmySize = scanner.nextDouble();
        
        aWins = roundNumber(50 * (aArmySize / (aArmySize + dArmySize)));
        dWins = 50 - aWins;
        addAWinningIndices(probableOutcomes, aWins);
        addDWinningIndices(probableOutcomes, dWins);
        clearWins(aWins, dWins);
        
        // Terrain and climate considerations are to be factored.
        System.out.println("Is the terrain of " + location + " in any part of " + attacker + "? (1 or 0)");
        terrain = scanner.nextInt();
        System.out.println("Is the climate of " + location + " in any part of " + attacker + "? (1 or 0)");
        climate = scanner.nextInt();
        
        if(terrain == 1){
            aWins += 2;
        }else{
            dWins += 2;
        }
        if(climate == 1){
            aWins += 2;
        }else{
            dWins += 2;
        }
        addAWinningIndices(probableOutcomes, aWins);
        addDWinningIndices(probableOutcomes, dWins);
        clearWins(aWins, dWins);
        
        // Take into account past hostilities and colonialist or imperialist happenings.
        System.out.println("Has " + defender + " been annexed, invaded, or puppeted by " + attacker + " in the past century? (1 or 0)");
        invadedVar = scanner.nextInt();
        System.out.println("Has " + defender + " been a colony or part of the empire of " + attacker + " in the past century? (1 or 0)");
        independenceVar = scanner.nextInt();
        
        if(invadedVar == 1) dWins += 5;
        if(independenceVar == 1) dWins +=5;
        addDWinningIndices(probableOutcomes, dWins);
        clearWins(aWins, dWins);
        
        // Investigate any rebellious activites on both sides.
        System.out.println("Is there a notable terrorist organization or separatist movement in " + attacker + "? (1 or 0)");
        aRebellious = scanner.nextInt();
        System.out.println("Is there a notable terrorist organization or separatist movement in " + defender + "? (1 or 0)");
        dRebellious = scanner.nextInt();
        
        if(aRebellious != 0) dWins += 5;
        if(dRebellious != 0) aWins += 5;
        addAWinningIndices(probableOutcomes, aWins);
        addDWinningIndices(probableOutcomes, dWins);
        clearWins(aWins, dWins);
        
        // Take into account morale from losing or winning recent combat.
        System.out.println("Has " + attacker + " failed more than 1 campaign or battle in the past year? (1 or 0)");
        aFails = scanner.nextInt();
        System.out.println("Has " + attacker + " won more than 1 campaign or battle in the past year? (1 or 0)");
        aSuccesses = scanner.nextInt();
        System.out.println("Has " + defender + " failed more than 1 campaign or battle in the past year? (1 or 0)");
        dFails = scanner.nextInt();
        System.out.println("Has " + defender + " won more than 1 campaign or battle in the past year? (1 or 0)");
        dSuccesses = scanner.nextInt();
        
        if(aFails != 0) dWins += 5;
        if(aSuccesses != 0) aWins += 5;
        if(dFails != 0) aWins += 5;
        if(dSuccesses != 0) dWins += 5;
        addAWinningIndices(probableOutcomes, aWins);
        addDWinningIndices(probableOutcomes, dWins);
        clearWins(aWins, dWins);
        
        // Analyze the equipment on both sides.
        System.out.println("Type in a rating from 0 - 10 on how well-equiped and how new that equipment is for " + attacker + ".");
        aEquipment = scanner.nextInt();
        System.out.println("Type in a rating from 0 - 10 on how well-equiped and how new that equipment is for " + defender + ".");
        dEquipment = scanner.nextInt();
        
        aWins = roundNumber(20.0 * (aEquipment / (aEquipment + dEquipment)));
        dWins = 20 - aWins;
        addAWinningIndices(probableOutcomes, aWins);
        addDWinningIndices(probableOutcomes, dWins);
        clearWins(aWins, dWins);
        
        // Account for lost morale from conscripts and reserves in the attacker army.
        System.out.println("Is the army of " + attacker + " army made up of any conscripted and reserve personnel? (1 or 0)");
        conscriptsAndReserves = scanner.nextInt();
        
        if(conscriptsAndReserves != 0) dWins += 3;
        addDWinningIndices(probableOutcomes, dWins);
        clearWins(aWins, dWins);
        
        // Account for the reason of war.
        System.out.println("Enter 1 if " + attacker + " was invaded by " + defender + " prior to this battle. If " + attacker + " is invading, is there a valid cassus belli? (1 or 0)");
        warReason = scanner.nextInt();
        
        if(warReason != 0) aWins += 4;
        addAWinningIndices(probableOutcomes, aWins);
        clearWins(aWins, dWins);
        
        // Analyze guerrila warfare.
        System.out.println("Does " + defender + " use guerrila warfare better than those of " + attacker + "? (1 or 0)");
        aGuerrilaDamage = scanner.nextInt();
        
        if(aGuerrilaDamage != 0) dWins += 10;
        addDWinningIndices(probableOutcomes, dWins);
        clearWins(aWins, dWins);
        
        // Account for logistics and supply lines.
        System.out.println("On a scale of 0-10 (use whole numbers), rate the quality of the supply lines of " + attacker + ".");
        aSupplyLine = scanner.nextInt();
        System.out.println("On a scale of 0-10 (use whole numbers), rate the quality of the supply lines of " + defender + ".");
        dSupplyLine = scanner.nextInt();
        
        aWins = roundNumber((7.0 * (aSupplyLine / (aSupplyLine + dSupplyLine))));
        dWins = 7 - aWins;
        addAWinningIndices(probableOutcomes, aWins);
        addDWinningIndices(probableOutcomes, dWins);
        clearWins(aWins, dWins);
        
        // Factor in air superiority.
        System.out.println("Does " + attacker + " have air superiority? (1 or 0)");
        airSupport = scanner.nextInt();
        
        if(airSupport != 0){
            aWins += 6;
        }else{
            dWins +=6;
        }
        addAWinningIndices(probableOutcomes, aWins);
        addDWinningIndices(probableOutcomes, dWins);
        clearWins(aWins, dWins);
        
        // Factor in government support and loyalty.
        System.out.println("Is there at least 50% popularity for the government of " + attacker + "? (1 or 0)");
        aGovernmentPopularity = scanner.nextInt();
        System.out.println("Is there at least 50% popularity for the government of " + defender + "? (1 or 0)");
        dGovernmentPopularity = scanner.nextInt();
        
        if(aGovernmentPopularity != 0) aWins += 9;
        if(dGovernmentPopularity != 0) dWins += 9;
        addAWinningIndices(probableOutcomes, aWins);
        addDWinningIndices(probableOutcomes, dWins);
        clearWins(aWins, dWins);
        
        // Get the country to output the winner and output the casualties on both sides.
        double totalWins = (double)(aWinCounter + dWinCounter);
        
        aCasualties = aArmySize * ((double)dWinCounter / totalWins);
        dCasualties = dArmySize * ((double)aWinCounter / totalWins);
                
        System.out.println();
        
        int aPhaseWins = 0; 
        int dPhaseWins = 0;
        for(int i = 0; i <= 5; i++){
            
            attackSuccessful = chooseRandomResult(probableOutcomes);
            if(attackSuccessful == true){
                aPhaseWins++;
                System.out.println(attacker + " won Phase " + (i+1) + " of the battle!");
            }else{
                dPhaseWins++;
                System.out.println(defender + " won Phase " + (i+1) + " of the battle!");
            }
        }
        if(aPhaseWins > dPhaseWins){
            System.out.println();
            System.out.println("The flag of " + attacker + " flies over " + location + "!");
            aCasualties *= 0.8;
            aCasualties = randomDouble((aCasualties * 0.3), (aCasualties * 0.75));
            dCasualties = randomDouble((dCasualties * 0.6), dCasualties);
        }
        if(aPhaseWins < dPhaseWins){
            System.out.println();
            System.out.println("The flag of " + defender + " flies over " + location + "!");
            dCasualties *= 0.8;
            aCasualties = randomDouble((aCasualties * 0.6), aCasualties);
            dCasualties = randomDouble((dCasualties * 0.3), (dCasualties * 0.75));
        }
        if(aPhaseWins == dPhaseWins){
            System.out.println();
            System.out.println("The battle of " + location + " ends in a stalemate!");
            aCasualties = randomDouble((aCasualties * 0.25), (aCasualties * 0.75));
            dCasualties = randomDouble((dCasualties * 0.25), (dCasualties * 0.75));
        }
        
        System.out.println();
        System.out.println("Casualties:");
        System.out.println(attacker + ": " + formatter.format(aCasualties) + "K");
        System.out.println(defender + ": " + formatter.format(dCasualties) + "K");
        System.out.println();
        
        System.out.println("This concludes the Battle of " + location + ".");
    }
}
