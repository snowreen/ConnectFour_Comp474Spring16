package com.connectfour.main;

import java.util.Scanner;

import com.connectfour.model.Board;
import com.connectfour.model.WinCheck;

public class Main {

	public static void main(String[] args) {
<<<<<<< HEAD
	
		Board board = new Board();
		System.err.println("Board height = " + board.getHeight());
		System.err.println("Board width = " + board.getWidth());
		
		board.set(new Checker(1), 1);
		board.set(new Checker(0), 2);
		board.set(new Checker(1), 3);
		board.set(new Checker(1), 4);
		board.printBoard();
		
		WinCheck wc = new WinCheck(board);
		
		System.out.println("Game status: " + wc.check());
		
		
		
//		Board board2 = new Board(10,10);
//		System.err.println("Board height = " + board.getHeight());
//		System.err.println("Board width = " + board.getWidth());
//		
//		board2.set(new Checker(1), 4);
//		board2.set(new Checker(1), 4);
//		board2.set(new Checker(0), 4);
//		board2.set(new Checker(0), 5);
//		board2.set(new Checker(1), 5);
//		board2.set(new Checker(1), 6);
//		board2.printBoard();
//		
//		Board board3 = new Board(20,20);
//		System.err.println("Board height = " + board.getHeight());
//		System.err.println("Board width = " + board.getWidth());
//		
//		for(int i = 0; i < 25; i++) {
//			board3.set(new Checker(1), 0);
//		}
//		board3.set(new Checker(1), 1);
//		board3.set(new Checker(0), 3);
//		board3.set(new Checker(0), 12);
//		board3.set(new Checker(1), 15);
//		board3.set(new Checker(1), 18);
//		board3.set(new Checker(1), 18);
//		board3.printBoard();
=======
		
		Scanner input = new Scanner(System.in);
	
		Board board = new Board(7, 7);
		playConnectFour(input, board);
	}

	private static void playConnectFour(Scanner input, Board board) {
		
		board.initializeBoard();
		
		// This variable will alternate and mean whose turn is it. It is Red's turn now.
        boolean isRed = true;
        String value = null;
        while (true) {
        	System.out.println("Please type \"reset\" to restart the game anytime!");
            if (isRed)
                System.out.println("Red's turn now!");            
            else 
                System.out.println("Blue's turn now!");
            System.out.print("Pick a spot from column 1 to 7:");
            value = input.next();
            if (value.equalsIgnoreCase("reset")) {
            	break;
            }
            int column = Integer.parseInt(value);
            if (column < 1 || column > 7) {
                System.out.println("Column should be from 1 to 7");
                continue;
            }
            if (!board.putColorChar(column - 1, isRed ? 'R' : 'B')) {
                System.out.println("This column is filled! Choose another one.");
                continue;
            }

            board.printBoard();
            WinCheck winCheck = new WinCheck(board);
            char result = winCheck.getWinner();
            if (result == 'D') {
                System.out.println("It is a draw!");
                break;
            }
            else if (result == 'R') {
                System.out.println("Red wins!");
                break;
            }
            else if (result == 'B') {
                System.out.println("Blue wins!");
                break;
            }
            
            isRed = !isRed;
        }
        
        if (value.equalsIgnoreCase("reset")) {
        	playConnectFour(input, board);
        }
>>>>>>> origin/master
	}
}
