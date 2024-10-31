import java.util.Random;
import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        Random random = new Random();
        boolean playAgain = false;
        boolean userResponse = false;

        do
        {
            System.out.println("\nStarting a new game...");
            int rollSum = rollDice(random);

            if (rollSum == 2 || rollSum == 3 || rollSum == 12)
            {
                System.out.println("Craps! You crapped out and lost!");
            }
            else if (rollSum == 7 || rollSum == 11)
            {
                System.out.println("Natural! You win!");
            }
            else
            {
                int point = rollSum;
                System.out.println("The point is now: " + point);
                boolean pointMade = false;

                do
                {
                    System.out.println("\nRolling again...");
                    rollSum = rollDice(random);

                    if (rollSum == 7)
                    {
                        System.out.println("Rolled a 7! You lost!");
                        break;
                    }
                    else if (rollSum == point)
                    {
                        System.out.println("You made the point and won!");
                        pointMade = true;
                    }
                    else
                    {
                        System.out.println("Trying for point...");
                    }
                }while (!pointMade);
            }

            userResponse = SafeInput.getYNConfirm(in, "Do you want to play again?");
            if (!userResponse)
            {
                playAgain = true;
                System.out.println("Thanks for playing Craps!");
            }
            else
                playAgain = false;

        }while(!playAgain);
    }


    public static int rollDice(Random random) {
        int die1 = random.nextInt(6) + 1;
        int die2 = random.nextInt(6) + 1;
        int rollSum = die1 + die2;

        System.out.printf("Rolled %d and %d, sum is %d\n", die1, die2, rollSum);
        return rollSum;
    }
}
