package com.connectfour.model;

public class BoardPush extends Board {
	
	public BoardPush() {
		super();
	}
	
	public BoardPush(int rows, int cols) {
		super(rows, cols);
	}
	
	@Override
	public boolean putColorChar(int column, char color) {
        // If the first char is there, the column is filled, returning false.
        if (checker[0][column] != ' ') {
        	return false;
        }
        
        for (int row = 1; row < super.getHeight(); row++) {
        	//Move each char "up" one in the column
        	checker[row-1][column] = checker[row][column];
        	//Set the newest char at the bottom of the column
        	if (row == super.getHeight() - 1) {
                checker[row][column] = color;
                super.currentColor = colorSwitch(super.currentColor);
            }
        }
        return true;
    }
}
