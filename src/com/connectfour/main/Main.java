package com.connectfour.main;

import javax.swing.JFrame;

import com.connectfour.model.*;

public class Main {

	public static void main(String[] args) {
	
		Board board = new Board();
		System.err.println("Board height = " + board.getHeight());
		System.err.println("Board width = " + board.getWidth());
		
		board.set(new Checker(1), 0);
		board.set(new Checker(1), 0);
		board.set(new Checker(0), 0);
		board.set(new Checker(0), 0);
		board.set(new Checker(1), 0);
		board.set(new Checker(1), 0);
		board.set(new Checker(1), 0);
		board.printBoard();
		
		Board board2 = new Board(10,10);
		System.err.println("Board height = " + board.getHeight());
		System.err.println("Board width = " + board.getWidth());
		
		board2.set(new Checker(1), 4);
		board2.set(new Checker(1), 4);
		board2.set(new Checker(0), 4);
		board2.set(new Checker(0), 5);
		board2.set(new Checker(1), 5);
		board2.set(new Checker(1), 6);
		board2.printBoard();
		
		Board board3 = new Board(20,20);
		System.err.println("Board height = " + board.getHeight());
		System.err.println("Board width = " + board.getWidth());
		
		for(int i = 0; i < 25; i++) {
			board3.set(new Checker(1), 0);
		}
		board3.set(new Checker(1), 1);
		board3.set(new Checker(0), 3);
		board3.set(new Checker(0), 12);
		board3.set(new Checker(1), 15);
		board3.set(new Checker(1), 18);
		board3.set(new Checker(1), 18);
		board3.printBoard();
	}
}
