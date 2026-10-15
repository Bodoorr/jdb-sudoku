package com.ga.sudoku;

import java.util.Scanner;

public class SudokuGame {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

        boolean running= true;
        while (running){
            System.out.println("SUDOKU GAME");
            System.out.println("1. Start New Game.");
            System.out.println("2. Load Saved Game.");
            System.out.println("3. Exit.");

            System.out.println("Choose an option: ");
            int choice= scanner.nextInt();

            switch (choice){
                case 1:
                    System.out.println("Starting a new game...");
                    break;

                case 2:
                    System.out.println("Loading saved game...");
                    break;

                case 3:
                    System.out.println("Bye!");
                    running= false;
                    break;

                    default:
                        System.out.println("Invalid option. Try again.");
            }
        }
    }
}
