package com.connectfour.model;

public class BoardPush extends Board {

	private char[][] checker;
	private int height;
	private int width;
	
	public BoardPush(int rows, int cols) {
		this.checker = new char[rows][cols];
		this.height = rows;
		this.width = cols;
	}
	
	public int getHeight() {
		return height;
	}
	public int getWidth() {
		return width;
	}

	public char[][] getChecker() {
		return checker;
	}
	
	public void initializeBoard() {
		// Initialize with spaces
        for (int i = 0; i < 7; ++i) {
        	for (int j = 0; j < 7; ++j) {
        		checker[i][j] = ' ';
        	}
        }
        printBoard();
	}
	
	public void printBoard() {
        for (int row = 0; row < height; ++row) {
            System.out.print("|");
            for (int col = 0; col < width; ++col) {
            	System.out.print(checker[row][col] + "|");
            }
            System.out.println();
        }
        
        for (int col = 0; col < 7; ++col) {
        	System.out.print("---");
        }
        System.out.println();
    }
	
	public boolean putColorChar(int column, char color) {
        // If the first char is there, the column is filled, returning false.
        if (checker[0][column] != ' ') {
        	return false;
        }
        
        for (int row = 1; row < height; row++) {
        	//Move each char "up" one in the column
        	checker[row-1][column] = checker[row][column];
        	//Set the newest char at the bottom of the column
        	if (row == height - 1) {
                checker[row][column] = color;
            }
        }
        return true;
    }
}
