// This program is copyright VUW.
// You are granted permission to use it to construct your answer to a SWEN131 assignment.
// You may not distribute it in any other way without permission.

/* Code for SWEN131 Individual Project - if
 * Name:
 * Usercode:
 * ID:
 */

import ecs100.*;


public class HigherLower {

    /**
     * Asks user for a guess.
     * Tells them if the target is higher or lower than the guess.
     * If they guessed the target correctly, they win.
     * Otherwise, asks for another guess until they get the right answer.
     */
    public void higherLowerCore(){
    	// Target is a random number from 1 to 100 for the user to guess.
    	int target = (int)Math.floor(Math.random() * 100) + 1;
        int userGuess = UI.askInt("Pick a number between 1 and 100:");
        
        if (userGuess != target) {
        	if (userGuess < target) {
        		UI.println("Your guess was too low");
        	} else if (userGuess > target) {
        		UI.println("Your guess was too high");
        	}
			while (userGuess != target) {
				userGuess = UI.askInt("Take another guess");
				if (userGuess < target) {
					UI.println("Your guess is too low");
					}
				else if (userGuess > target) {
					UI.println("Your guess is too high");
				} else {
					UI.println("Your guess is correct! Game over");
				}
			}
		} else {
			UI.println("Your guess is correct! Game over");
		}
    }
        	
       
    /**
     * Asks user for the number of rounds to play, then lets them play the
     * guessing game that many times.
     * Each game has a new target and the player has 10 guesses.
     * At the end, reports to the user how many times they guessed correctly
     * and how many guesses they used in total.
     */
    public void higherLowerCompletion(){
    	
    	int numRounds = UI.askInt("How many rounds would you like to play?");
    	int roundNumber = 1;
    	int correctGuesses = 0;
    	int numGuesses = 0;
    	
    	while (roundNumber <= numRounds) {
    		int target = (int)Math.floor(Math.random() * 100) + 1;
        	int userGuess = UI.askInt("Pick a number between 1 and 100:");
        	roundNumber++;
        	numGuesses++;
        	int guessNumber = 1;
        	
        	if (userGuess != target) {
     			if (userGuess < target) {
        			UI.println("Your guess was too low");
        		} else if (userGuess > target) {
        			UI.println("Your guess was too high");
        		}
     			while (userGuess != target && guessNumber < 10) {
     				userGuess = UI.askInt("Take another guess");
     				numGuesses++;
     				if (userGuess < target) {
     					UI.println("Your guess is too low");
     				} else if (userGuess > target) {
     					UI.println("Your guess is too high");
     				} else {
    					UI.println("Your guess is correct! Game over");
     					correctGuesses++;
     				}
     			guessNumber++;
     			if (guessNumber == 10) {
     				UI.println("You've used all your guesses, game over");
     			}
     			}
        	} else {
        		UI.println("Your guess is correct! Game over");
        		correctGuesses++;
        	}
        }
    	UI.println("You used " + numGuesses + " guesses");
    	UI.println("Rounds won: " + correctGuesses);
    }
    
    /**
     * Make the game more complicated and record more information about the game.
     *
     */
    public void higherLowerChallenge(){
        /*# YOUR CODE HERE */

    }

    /** ---------- The code below is already written for you ---------- **/
    /** Constructor: set up user interface */
    public HigherLower(){
        UI.initialise();
        UI.addButton("Clear", UI::clearText );
        UI.addButton("Higher or Lower Core", this::higherLowerCore );
        UI.addButton("Higher or Lower Completion", this::higherLowerCompletion );
        UI.addButton("Quit", UI::quit );
        UI.setDivider(1);       // Expand the text area
    }

    public static void main(String[] args) {
    	new HigherLower();
    }
}

