package com.connectfour.model;

public class Board {
	private Checker[][] board;
	private int height;
	private int width;
	private int lastX;
	private int lastY;
	
	public Board() {
		this.board = new Checker[6][7];
		this.height = 6;
		this.width = 7;
		
	}
	
	public Board(int rows, int cols) {
		this.board = new Checker[rows][cols];
		this.height = rows;
		this.width = cols;
	}
	
	public int getHeight() {
		return height;
	}
	public int getWidth() {
		return width;
	}
	public int getLastX() {
		return lastX;
	}
	public int getLastY() {
		return lastY;
	}
	
	public Checker get (int row, int col) {
		return this.board[row][col];
	}
	
	public void set (Checker checker, int col) {
		int rowPointer = height - 1;
		boolean slotEmpty = true;
		
		while (slotEmpty) {
			
			if (rowPointer < 0) {
				System.err.println("Column is full. Checker not placed...");
				break;
			}
			if (board[rowPointer][col] == null) {
				
				System.err.println("space is empty. Placing checker...");
				board[rowPointer][col] = checker;
				lastX = col;
				lastY = rowPointer;
				slotEmpty = false;
				
			}
			rowPointer--;
		}
	}
	
	private boolean checkWin(int row, int col) {
		boolean isWin = false;
		int xp = col;
		int yp = row;
		int count = 0;
		int color = board[row][col].getColor();
		
		//Check L
		while (board[row][xp].getColor() == color && count != 4) {
			if (board[row][xp].getColor() == color) {
				count++;
				xp--;
			}
			else {
				break;
			}
		}
		
		//Check R
		while (xp <  width) {
			xp++;
			if (board[row][xp].getColor() == board[row][col].getColor()) {
				count++;
			}
		}
		
		
		//Check U
		//Check D
		
		//Check LU
		//Check RD
		
		//Check LD
		//Check RU
		return isWin;
	}
	
	public void printBoard() {
		for (int r = 0; r < board.length; r++) {
			for (int c = 0; c < board[0].length; c++) {
				if (board[r][c] == null) {
					System.out.print("- ");
				} else {
					System.out.print(board[r][c] + " ");
				}
			}
			System.out.println();
		}
	}
	
}
