package com.connectfour.model;

public class WinCheck {
	
	private Board board;
	private boolean win = false;
	
	public WinCheck(Board board) {
		this.board = board;
	}
	
	public boolean check() {
		if (checkHorizontal()) { win = true; }
		if (checkVertical()) { win = true; }
		if (checkDiagonals()) { win = true; }
		return win;
	}
	
	private boolean checkHorizontal() {
		int xp = board.getLastX();
		int yp = board.getLastY();
		
		int count = 0;
		int color = board.get(yp,xp).getColor();
		
		//Count consecutive pieces of the same color to the LEFT of initial checker
		while (board.get(yp, xp).getColor() == color && count != 4) {
			if (board.get(yp, xp).getColor() == color) {
				count++;
				xp--;
			}
			else {
				break;
			}
		}
		
		//Count consecutive pieces of the same color to the RIGHT of initial checker
		while (board.get(yp, xp).getColor() == color && count != 4) {
			if (board.get(yp, xp).getColor() == color) {
				count++;
				xp--;
			}
			else {
				break;
			}
		}
		return false;
	}
	private boolean checkVertical() {
		return false;
	}
	private boolean checkDiagonals() {
		return false;
	}
}
