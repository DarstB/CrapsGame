import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Random rnd = new Random();
        Scanner in = new Scanner(System.in);

        int point;
        String playAgain;
        boolean done = false;

        do {
            int die1 = rnd.nextInt(6) + 1;
            int die2 = rnd.nextInt(6) + 1;
            int totalRoll = die1 + die2;    // range is 2 to 12

            if (totalRoll == 2 || totalRoll == 3 || totalRoll == 12) {  // losing case
                System.out.println("You rolled a " + totalRoll + ". You lost!");

                System.out.print("Would you like to play again? [Y/N]: ");  // asking user to play again
                playAgain = in.nextLine().toUpperCase();
                if (playAgain.equals("N")) {
                    done = true;
                }
            }
            else if (totalRoll == 7 || totalRoll == 11) {   // winning case
                System.out.println("You rolled a " + totalRoll + ". You won!");

                System.out.print("Would you like to play again? [Y/N]: ");  // asking user to play again
                playAgain = in.nextLine().toUpperCase();
                if (playAgain.equals("N")) {
                    done = true;
                }
            }
            else {  // user rolled a point case
                point = totalRoll;
                System.out.println("You rolled a " + totalRoll + ", making it the point. Lets keep rolling.");

                do {
                    die1 = rnd.nextInt(6) + 1;
                    die2 = rnd.nextInt(6) + 1;
                    totalRoll = die1 + die2;

                    System.out.println("You rolled a " + totalRoll);

                    if (totalRoll == point) {   // user wins their point
                        System.out.println("You matched your point! You win!");

                        System.out.print("Would you like to play again? [Y/N]: ");
                        playAgain = in.nextLine().toUpperCase();
                        if (playAgain.equals("N")) {
                            done = true;
                        }

                        break;  // breaking this while loop
                    }
                    else if (totalRoll == 7) {  // user rolls a 7 and loses
                        System.out.println("You rolled a 7. You lose!");

                        System.out.print("Would you like to play again? [Y/N]: ");
                        playAgain = in.nextLine().toUpperCase();
                        if (playAgain.equals("N")) {
                            done = true;
                        }

                        break;  // breaking this while loop
                    }
                    System.out.println("Let's keep rolling...");
                } while (true);
            }
        } while (!done);
    }
}