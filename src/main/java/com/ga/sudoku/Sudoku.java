package com.ga.sudoku;

import com.ga.sudoku.exceptions.InvalidCharacterException;
import com.ga.sudoku.exceptions.SudokuFileNotFoundException;
import com.ga.sudoku.utils.FileManager;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Sudoku {
    private SudokuCell[][] board;

    public Sudoku(){
        board= new SudokuCell[9][9];
        for (int row=0; row<board.length; row++){
            new SudokuCell(0,false);
            for (int col=0; col<board.length; col++){
                board[row][col]=new SudokuCell(0,false);
            }
        }
    }

    public void load(String filePath)throws InvalidCharacterException, SudokuFileNotFoundException, IOException {
        List<String> lines=new ArrayList<>();
        try {
            lines=FileManager.readAllLines(filePath);
        } catch (FileNotFoundException e){
            throw new SudokuFileNotFoundException("File not found: "+filePath);
        }
        if (lines.size()!=9){
                throw new InvalidCharacterException("Puzzle must have 9 rows.");
            }

        //loop inside rows
        for (int row=0; row< lines.size(); row++){
            String line= lines.get(row);

            if (line.length()!=9){
                    throw new InvalidCharacterException("Invalid number of columns.");
                }

            for (int col=0; col<line.length(); col++){
                    char character=line.charAt(col);

                    if (character<'0' || character>'9'){
                        throw new InvalidCharacterException("Invalid character: "+ character);
                    }

                    //change the value to numeric type
                    int value= Character.getNumericValue(character);
                    board[row][col]=new SudokuCell(value,value!=0);
                }

        }
    }

//    public void load(String filePath) throws IOException, InvalidCharacterException, SudokuFileNotFoundException {
//        List<String> lines=new ArrayList<>();
//        try {
//            lines = FileManager.readAllLines(filePath);
//        } catch (FileNotFoundException e) {
//            throw new SudokuFileNotFoundException("File not found.");
//        }
//
//        if (lines.size() !=9){
//            throw new InvalidCharacterException("Puzzle must have 9 rows.");
//        }
//
//        for (int row=0; row<9; row++){
//            String[] characters= lines.get(row).split("");
//
//            if (characters.length !=9){
//                throw new InvalidCharacterException("Invalid number of columns.");
//            }
//
//            for (int col=0; col<9; col++){
//                if (!characters[col].matches("[0-9]]")){
//                    throw new InvalidCharacterException("Invalid input: "+characters[col]);
//                }
//
//                int value= Integer.parseInt(characters[col]);
//                board[row][col]= new SudokuCell(value,value!=0);
//            }
//        }
//    }


    public void print(){
        for (int row=0; row<board.length; row++){
            if (row%3==0 && row>0){
                System.out.println("---------------------");
            }
            for (int col=0; col<board[row].length; col++){
                if (col%3==0 && col>0){
                    System.out.print("| ");
                }
                System.out.print(board[row][col].getValue()+" ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Sudoku sudoku=new Sudoku();
    try {
        sudoku.load("src/main/resources/puzzle1.txt");
        sudoku.print();
    } catch (InvalidCharacterException | SudokuFileNotFoundException | IOException e){
        System.out.println(e.getMessage());
    }
    }


}
