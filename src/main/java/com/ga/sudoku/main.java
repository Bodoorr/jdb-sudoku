package com.ga.sudoku;

import com.ga.sudoku.exceptions.InvalidCharacterException;
import com.ga.sudoku.exceptions.SudokuFileNotFoundException;
import com.ga.sudoku.utils.FileManager;

import java.io.IOException;
import java.util.List;

public class main {
    public static void main(String[] args) {
        Sudoku sudoku = new Sudoku();
        try {
            for (int i = 1; i <= 4; i++) {
                System.out.println("\nPuzzle " + i);
                sudoku.load("src/main/resources/puzzle" + i + ".txt");
                sudoku.print();
                SudokuSolver solver = new SudokuSolver(sudoku);

                if (solver.solve()) {
                    String solution= sudoku.toString();
                    List<String> lines=solution.lines().toList();
                    FileManager.overWriteFile("src/main/resources/puzzle" + i + ".solution.txt", lines);
                    System.out.println("\nPuzzle " + i+ " Solved");
                    sudoku.load("src/main/resources/puzzle" + i + ".solution.txt");
                    sudoku.print();
                } else {
                    System.out.println("No solution found for puzzle " + i);
                }
            }
        } catch (InvalidCharacterException | SudokuFileNotFoundException | IOException e) {
            System.out.println(e.getMessage());
        }
    }
}