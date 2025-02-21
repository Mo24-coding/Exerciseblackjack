import java.util.Scanner;
import java.util.Random;
public class BlackJackDiceGame {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // 1. USER THROWS
        // 2. COMPUTER THROWS
        // 3. WHO WON?
        winner(userThrows(scanner), computerThrows());
    }

    public static int userThrows(Scanner scanner) {
        Random random = new Random();
        int sum = 0;

        System.out.println("You start with the number: " + sum);


        while (true) {
            int dice1 = random.nextInt(6) + 1;
            int dice2 = random.nextInt(6) + 1;
            sum += dice1 + dice2;
            System.out.println("You rolled: " + dice1 + " and " + dice2 + " You got: " + sum);
            if (sum == 21) {
                System.out.println("Blackjack, you win automatically!");
                return sum;
            } else if (sum > 21) {
                System.out.println("Bust! your number exceeded 21");
                return sum;
            }
            System.out.println("Your sum is: " + sum + " do you want to throw the dice again? (y/n)");
            String answer = scanner.next();
            if (!answer.equals("y")) {
                System.out.println("Your final sum is: " + sum);
                break;
            }

        }
        return sum;
    }

    public static int computerThrows() {
        Random random = new Random();
        int computerSum = 0;
        boolean playing = true;
        System.out.println("Computer starts with: " + computerSum);

        while (playing) {
            int dice1 = random.nextInt(6) + 1;
            int dice2 = random.nextInt(6) + 1;
            computerSum += dice1 + dice2;
            if (computerSum == 21) {
                System.out.println("Blackjack! computer wins! " + computerSum);
                playing = false;
            } else if (computerSum > 21) {
                System.out.println("User wins! Computer busted! " + computerSum);
                playing = false;
            } else if (computerSum >= 16){
                System.out.println("Computer stands! " + computerSum);
                playing = false;
            }

        }
        return computerSum;
    }
    public static void winner(int userThrows, int computerThrows){

        if (userThrows == 21) {
            System.out.println("You win! User hit a blackjack! ");
        } else if (userThrows > 21) {
            System.out.println("You busted! Computer wins! ");
        } else if (computerThrows > 21) {
            System.out.println("Computer busted! you win! ");
        } else if (userThrows > computerThrows) {
            System.out.println("User wins!" + userThrows + "\nComputer got: " + computerThrows);
        } else if (computerThrows > userThrows){
            System.out.println("Computer wins! " + computerThrows + "\nYou got: " + userThrows);
        } else if (userThrows == computerThrows){
            System.out.println("Computer wins! " + computerThrows + "\nYou got: " + userThrows);
        }
    }
}
