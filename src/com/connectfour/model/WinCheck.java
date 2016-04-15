package com.connectfour.model;

public class WinCheck {
	
	private Board board;
	private boolean win = false;
	
	public WinCheck(Board board) {
		this.board = board;
	}
	
	public boolean check() {
		checkHorizontal();
		checkVertical();
		checkDiagonals();
		return win;
	}
	
	private void checkHorizontal() {
		
		//initialize x and y pointers to origin of last checker
		int xp = board.getLastX();
		int yp = board.getLastY();
		
		int count = 0;
		int color = board.get(yp,xp).getColor();
		
//		//Count consecutive pieces of the same color to the LEFT of initial checker
//		while (xp > 0 && count != 4) {
//			if (board.get(yp, xp) != null) {
//				if (board.get(yp, xp).getColor() == color) {
//					count++;
//					xp--;
//				} else {
//					break;
//				}
//			}
//		}
//		
//		//Reset x and y pointers to check neighbor checkers to right of origin
//		xp = board.getLastX();
//		yp = board.getLastY();
//		
//		//Count consecutive pieces of the same color to the RIGHT of initial checker
//		while (xp < board.getWidth() && count != 4) {
//			if (board.get(yp, xp) != null && board.get(yp, xp).getColor() == color) {
//				count++;
//				xp++;
//			}
//		}
//		if (count == 4) { win = true; }
		
	}
	
	private void checkVertical() {
		return;
	}
	private void checkDiagonals() {
		return;
	}
}
