package com.connectfour.model;

public class Board {
	public char[][] checker;
	public char currentColor = 'B';
	private int height;
	private int width;
	
	
	/**
	  * Constructor
	  * 
	  * Takes no parameters and calls the overloaded constructor below
	  */
	public Board() {
		this(6,7);
	}
	
	/**
	  * Constructor
	  * 
	  * @param rows (required) Must integer greater than 0. 
	  * @param cols (required) Must integer greater than 0.
	  */
	public Board(int rows, int cols) {
		this.checker = new char[rows][cols];
		this.height = rows;
		this.width = cols;
	}
	
	/** 
	  * @return the height passed in from the constructor as 'rows'
	  */
	public int getHeight() {
		return height;
	}
	
	/** 
	  * @return the width passed in from the constructor as 'cols'
	  */
	public int getWidth() {
		return width;
	}

	/** 
	  * @return the last checker placed on the board
	  */
	public char[][] getChecker() {
		return checker;
	}
	
	/** 
	  * Fills our board with blank spaces so no index contains a null value
	  */
	public void initializeBoard() {
		// Initialize with spaces
        for (int i = 0; i < 7; ++i) {
        	for (int j = 0; j < 7; ++j) {
        		checker[i][j] = ' ';
        	}
        }
        printBoard();
	}	
	
	/** 
	  * Prints our board to the console output as a text representation
	  */
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
	
	/** 
	  * A private utility method for moving pieces on the board
	  * @param color (required) must be a char 'R' or 'B'.
	  * @return the opposite char given in the constructor
	  */
	protected char colorSwitch(char color){
		if(color=='R'){
			color='B';
		}
		else color = 'R';
		return color;
	}
	
	/** 
	  * A private utility method for moving pieces on the board
	  * @param column (required) an int corresponding to the column on the board
	  * @param color (required) must be a char 'R' or 'B'.
	  * @return false if piece not placed. True if placed successfully.
	  */
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
