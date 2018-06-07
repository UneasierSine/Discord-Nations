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

public class War_Simulator {

    // Initialize global variables.
    int i = 0;
    boolean[] probableOutcomes;
    
    // Run the constructor function.
    public War_Simulator()
    {
        
    }
    
    // Run the main looping function.
    public void main(String[] args) 
    {
        System.out.println(chooseRandomResult(probableOutcomes));
    }

    // Add indices to the array with "true" boolean values.
    void addWinningIndices()
    {
    }
    
    // Add indices to the array with "false" boolean values.
    void addLosingIndices()
    {
        
    }
    
    // Return a random outcome from the variable.
    boolean chooseRandomResult(boolean[] given)
    {
        int indicesTotal = given.length;
        int randomIndex = (int)(Math.random() * indicesTotal);
        return given[randomIndex];
    }   
}
