/*
 * Author:  Dean E. Peterson
 * License: GPLv3 (see LICENSE file)
 * For:     Concordia CSC 422 - Software Engineering - Week 2
 * What:    Guessing Game/git test project
 * Created: 2019-01-23
 */
package edu.csp.csc422;

import java.util.Scanner;

/**
 * Guessing game class.
 */
public class GuessGame {
    private static final int MIN_GUESS = 0;
    private static final int MAX_GUESS = 100;
    private static final String PROMPT_FIRST =
            "I'm thinking of a number between %d-%d.  What is the number?  ";
    private static final String PROMPT_NEXT = "Nope.  Too %s.  Try again:  ";
    private static final String CORRECT = "You got it!\n";

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Generate random number to guess.
        // Range is plus 1 to include both endpoints.
        int range = MAX_GUESS - MIN_GUESS + 1;
        int number = MIN_GUESS + (int)(Math.random() * range);
        
        try (Scanner in = new Scanner(System.in)) {
            int guess;

            // Prompt for first guess.
            System.out.printf(PROMPT_FIRST, MIN_GUESS, MAX_GUESS);
            
            while (true) {
                // Get guess.
                guess = in.nextInt();

                // Check guess.
                if (guess < number) {
                    System.out.printf(PROMPT_NEXT, "low");
                }
                else if (guess > number) {
                    System.out.printf(PROMPT_NEXT, "high");                    
                }
                else { // guess == number
                    break;
                }
            }
            
            // User guessed correctly.  Congratulate and exit.
            System.out.printf(CORRECT);
        }
    }
    
}
