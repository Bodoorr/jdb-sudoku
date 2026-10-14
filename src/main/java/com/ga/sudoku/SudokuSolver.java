package com.ga.sudoku;

public class SudokuSolver {
    private SudokuCell[][] board;

    public SudokuSolver(Sudoku sudoku) {
        this.board = sudoku.getBoard();
    }

    public boolean isValid(int row, int col, int character){
    for (int i=0; i<9; i++){
        //check the row if it got the same value as character
        if (board[row][i].getValue() == character){
            return false;
        }
        //check the column if it got the same value as character
        if (board[i][col].getValue()== character){
            return false;
        }
    }
        //check 3x3 box
        int startRow= row - (row % 3);
        int startCol= col - (col % 3);
        // 4 - (4 % 3) = 3
        // 7 - (7 % 3) = 6
        for (int r= startRow; r< startRow+3; r++){
            for (int c= startCol; c< startCol+3; c++){
            if (board[r][c].getValue()== character){
                return false;
            }
            }
        }
    return true;
    }

    public boolean solve(){
        for (int row=0; row<9; row++){
            for (int col=0; col<9; col++){
                //check for the cells that got 0 value
                if (board[row][col].getValue()==0){
                    //number to add in the cell
                    for (int number=1; number<=9; number++){
                        //check if the number valid to add there
                        if (isValid(row,col,number)){
                            //then set the value(number) in the row
                            board[row][col].setValue(number);
                            if (solve()){
                                return true;
                            }
                            board[row][col].setValue(0);
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }




}
