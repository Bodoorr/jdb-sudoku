package com.ga.sudoku;

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

    public void print(){
        for (int row=0; row<board.length; row++){
            for (int col=0; col<board[row].length; col++){
                System.out.print(board[row][col].getValue()+" ");
            }
            System.out.println();
        }
    }


}
