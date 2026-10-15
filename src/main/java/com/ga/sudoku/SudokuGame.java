package com.ga.sudoku;

import com.ga.sudoku.exceptions.InvalidCharacterException;
import com.ga.sudoku.exceptions.SudokuFileNotFoundException;

import java.io.IOException;
import java.util.Scanner;

public class SudokuGame {
    public static void main(String[] args) throws InvalidCharacterException, SudokuFileNotFoundException, IOException {
        Scanner scanner=new Scanner(System.in);

        boolean running= true;
        while (running){
            System.out.println("SUDOKU GAME");
            System.out.println("1. Start New Game.");
            System.out.println("2. Exit.");

            System.out.println("Choose an option: ");
            int choice= scanner.nextInt();

            switch (choice){
                case 1:
                        System.out.println("Select game from 1-4 : ");
                        int game= scanner.nextInt();

                        if (game<1 || game>4){
                            System.out.println("Invalid input. Try again.");
                            break;
                        }

                        Sudoku sudoku=new Sudoku();
                        sudoku.load("src/main/resources/puzzle"+game+".txt");
                        System.out.println("Starting Puzzle "+game+" ...");
                        sudoku.print();


                        SudokuSolver sudokuSolver=new SudokuSolver(sudoku);
                        boolean playing= true;

                        while (playing){
                            System.out.println("Enter column number [1-9] (0 to exit): ");
                            int column= scanner.nextInt();

                            if (column ==0){
                                playing= false;
                                break;
                            }

                            System.out.println("Enter row number [1-9] (0 to exit): ");
                            int row= scanner.nextInt();

                            if (row ==0){
                                playing= false;
                                break;
                            }

                            System.out.println("Enter value number [1-9] (0 to exit): ");
                            int value= scanner.nextInt();

                            if (value ==0){
                                playing= false;
                                break;
                            }


                            if (row<1 || row>9 || column<1 || column>9 || value < 1 || value>9){
                                System.out.println("Invalid input. Try again.");
                                continue;
                            }
                            int rowIndex= row-1;
                            int colIndex= column-1;

                            if (sudoku.getBoard()[rowIndex][colIndex].isFixed()){
                                System.out.println("You can't change a fixed cell.");
                            } else if (sudokuSolver.isConflict(rowIndex, colIndex, value)){
                                System.out.println("Invalid! Number conflict with sudoku rules.");
                            } else {
                                sudoku.placeNumber(rowIndex, colIndex, value);
                                sudoku.print();

                                if (sudokuSolver.isSolved()){
                                    System.out.println("Hehehehe! you made it.");
                                    playing=false;
                                }
                                }
                            }
                        break;

                case 2:
                    System.out.println("Bye!");
                    running= false;
                    break;

                    default:
                        System.out.println("Invalid option. Try again.");
            }
        }
    }
}
