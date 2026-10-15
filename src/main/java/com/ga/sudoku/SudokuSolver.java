package com.ga.sudoku;

public class SudokuSolver {
    private SudokuCell[][] board;

    public SudokuSolver(Sudoku sudoku) {
        this.board = sudoku.getBoard();
    }

    public boolean isValid(int row, int col, int character){
    for (int i=0; i<9; i++){
        if (board[row][i].getValue() == character){
            return false;
        }

        if (board[i][col].getValue()== character){
            return false;
        }
    }
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
                if (board[row][col].getValue()==0){
                    for (int number=1; number<=9; number++){

                        if (isValid(row,col,number)){
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

    public boolean isConflict(int row, int col, int number){
        return !isValid(row, col, number);
    }

    public boolean isSolved(){
        for (int row=0; row<9; row++){
            for (int col=0; col<9; col++){
                int value= board[row][col].getValue();

                if (value==0 || !isValid(row,col,value)){
                    return false;
                }
            }
        }
        return true;
    }

}
