package com.connectfour.model;

public class Board {
	public char[][] checker;
	public char currentColor = 'B';
	private int height;
	private int width;
	
	public Board() {
		this(6,7);
	}
	
	public Board(int rows, int cols) {
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
            System.out.print("| ");
            for (int col = 0; col < width; ++col) {
            	System.out.print(checker[row][col] + "| ");
            }
            System.out.println();
        }
        
        for (int col = 0; col < 7; ++col) {
        	System.out.print("---");
        }
        System.out.println();
    }
	
	private char colorSwitch(char color){
		if(color=='R'){
			color='B';
		}
		else color = 'R';
		return color;
	}
	
	public boolean putColorChar(int column, char color) {
        // If the first char is there, the column is filled, returning false.
        if (checker[0][column] != ' ') {
        	return false;
        }
        
        for (int row = 0; row < height; ++row) {
            if (checker[row][column] != ' ') {
                // Putting the char on top of the current one.
            	checker[row-1][column] = color;
            	this.currentColor=colorSwitch(this.currentColor);    
                return true;
            }
        }
        // If no other char found, then place this char at the bottom.
        checker[height-1][column] = color;
        this.currentColor=colorSwitch(this.currentColor);       	
        
        return true;
    }
}
