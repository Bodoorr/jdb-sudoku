package com.ga.sudoku;

public class SudokuCell {
    private int value; //value of the cell
    private boolean fixed; //if its already provided

    public SudokuCell(int value, boolean fixed) {
        this.value = value;
        this.fixed = fixed;
    }

    public int getValue() {
        return value;
    }

    public boolean isFixed() {
        return fixed;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
