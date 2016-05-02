package com.connectfour.view;
import static com.connectfour.viewactions.Artist.*;
import static com.connectfour.viewactions.UI.*;

import org.lwjgl.input.Mouse;

import com.connectfour.model.Board;
import com.connectfour.viewactions.Button;
import com.connectfour.viewactions.UI;

public class TileGrid {
	public UI boardUI;
	public Tile[][] map;
	private Board boardDisplay;
	
	public static boolean isWinChecked = false;
	public static boolean isUpdateNeeded = false;
	public static boolean isReset = false;
	
	public TileGrid(){
		map = new Tile[7][7];
		for (int i = 0; i <map.length; i++){
			for (int j = 0; j<map[i].length; j++){
				map[i][j] = new Tile(j * 64, i * 64, 64,64, TileType.EmptySlot);
			}
		}
	}
	
	public TileGrid(Board newMap){
		this.boardDisplay = newMap;
		map = new Tile [7][7];
		for (int i = 0; i <map.length; i++){
			
			for (int j = 0; j<map[i].length; j++){
				/* 
				 * Checks the value board location 
				 * blank is empty square 
				 * r is red piece
				 * b is black piece
				 */
				switch(newMap.checker[i][j]){
				case ' ':
					map[i][j] = new Tile(j * 64, i * 64, 64,64, TileType.EmptySlot);
					break;					
				case 'R':
					map[i][j] = new Tile(j * 64, i * 64, 64,64, TileType.RedPiece);
					break;
				case 'B':
					map[i][j] = new Tile(j * 64, i * 64, 64,64, TileType.BlackPiece);
					break;				
				}				
			}
		}				
	}
	
	
	//to be placed in boot while loop to update the view of the board
	public void updateBoard(Board board){
		for (int i = 0; i <map.length; i++){
			
			for (int j = 0; j<map[i].length; j++){
				/* 
				 * Checks the value board location 
				 * blank is empty square 
				 * r is red piece
				 * b is black piece
				 */
				switch(board.checker[i][j]){
				case ' ':
					map[i][j] = new Tile(j * 64, i * 64, 64,64, TileType.EmptySlot);
					break;					
				case 'R':
					map[i][j] = new Tile(j * 64, i * 64, 64,64, TileType.RedPiece);
					break;
				case 'B':
					map[i][j] = new Tile(j * 64, i * 64, 64,64, TileType.BlackPiece);
					break;				
				}				
			}
		}
		this.Draw(board);
	}
	//lets us set actions when buttons are pressed
	public void takeInput(Board board){
		
		//if (Mouse.isButtonDown(0)){
		while(Mouse.next()){
			if(Mouse.getEventButton() > -1){
				if(Mouse.getEventButtonState()){
					
					if (board.currentColor=='B')
		                System.out.println("Red's turn now!");            
		            else 
		                System.out.println("Black's turn now!");
			
					if(boardUI.isButtonClicked("DropButton0")){							
						board.putColorChar(0, board.currentColor);
						isWinChecked = false;
						isUpdateNeeded = true;
					}
					if(boardUI.isButtonClicked("DropButton1")){							
						board.putColorChar(1, board.currentColor);
						isWinChecked = false;
						isUpdateNeeded = true;
					}
					if(boardUI.isButtonClicked("DropButton2")){							
						board.putColorChar(2, board.currentColor);
						isWinChecked = false;
						isUpdateNeeded = true;
					}
					if(boardUI.isButtonClicked("DropButton3")){							
						board.putColorChar(3, board.currentColor);
						isWinChecked = false;
						isUpdateNeeded = true;
					}
					if(boardUI.isButtonClicked("DropButton4")){							
						board.putColorChar(4, board.currentColor);
						isWinChecked = false;
						isUpdateNeeded = true;
					}
					if(boardUI.isButtonClicked("DropButton5")){							
						board.putColorChar(5, board.currentColor);
						isWinChecked = false;
						isUpdateNeeded = true;
					}
					if(boardUI.isButtonClicked("DropButton6")){							
						board.putColorChar(6, board.currentColor);
						isWinChecked = false;
						isUpdateNeeded = true;
					}
					if(boardUI.isButtonClicked("Reset")){
						isWinChecked = true;
						isUpdateNeeded = false;
						isReset = true;
					}
				}
            }
		}
	}
	
	public void Draw(Board board){
		boardUI = new UI();
		
		DrawQuadTex(FastTex("CurrentPlayer"), (float)448, (float)0, (float)64, (float)64);
		//Display current player
		if (board.currentColor=='R'){
			DrawQuadTex(FastTex("RedPlayer"), (float)448, (float)64, (float)64, (float)64);
		}
		else{
			DrawQuadTex(FastTex("BlackPlayer"), (float)448, (float)64, (float)64, (float)64);
		}
		for (int i = 0; i < map.length; i++){
			for (int j = 0 ; j < map[i].length; j++){
				Tile t = map[i][j];
				DrawQuadTex(t.getTexture(), t.getX(), t.getY(), t.getWidth(), t.getHeight());
			}
		}
		//Draw line of buttons
		for (int k = 0; k < 7; k++){
			boardUI.addButton("DropButton"+k, "DropButton", k*64, 448);						
		}
		boardUI.addButton("Reset", "Reset", 448, 128,64,384);
		boardUI.draw();	
	}
}
