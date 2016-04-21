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
	
	public TileGrid(){
		map = new Tile[7][7];
		for (int i = 0; i <map.length; i++){
			for (int j = 0; j<map[i].length; j++){
				map[i][j] = new Tile(i * 64, j * 64, 64,64, TileType.EmptySlot);
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
				switch(newMap.checker[j][i]){
				case ' ':
					map[i][j] = new Tile(i * 64, j * 64, 64,64, TileType.EmptySlot);
					break;
					
				case 'r':
					map[i][j] = new Tile(i * 64, j * 64, 64,64, TileType.RedPiece);
					break;
				case 'b':
					map[i][j] = new Tile(i * 64, j * 64, 64,64, TileType.BlackPiece);
					break;				
				}				
			}
		}				
	}
	
	
	//to be placed in boot while loop to update the view of the board
	public void update(Board board){
		this.Draw();
		updateButtons(board);
	}
	//lets us set actions when buttons are pressed
	private void updateButtons(Board board){
		//if (Mouse.isButtonDown(0)){
		while(Mouse.next()){
			if(Mouse.getEventButton() > -1){
				if(Mouse.getEventButtonState()){
			
					if(boardUI.isButtonClicked("DropButton0")){							
						board.putColorChar(0, board.currentColor);
					}
					if(boardUI.isButtonClicked("DropButton1")){							
						board.putColorChar(1, board.currentColor);
					}
					if(boardUI.isButtonClicked("DropButton2")){							
						board.putColorChar(2, board.currentColor);
					}
					if(boardUI.isButtonClicked("DropButton3")){							
						board.putColorChar(3, board.currentColor);
					}
					if(boardUI.isButtonClicked("DropButton4")){							
						board.putColorChar(4, board.currentColor);
					}
					if(boardUI.isButtonClicked("DropButton5")){							
						board.putColorChar(5, board.currentColor);
					}
					if(boardUI.isButtonClicked("DropButton6")){							
						board.putColorChar(6, board.currentColor);
					}
				}
			}
		}
	}
	
	public void Draw(){
		boardUI = new UI();
		for (int i = 0; i < map.length; i++){
			for (int j = 0 ; j < map[i].length; j++){
				Tile t = map[i][j];
				DrawQuadTex(t.getTexture(), t.getX(), t.getY(), t.getWidth(), t.getHeight());
			}
		}
		//Draw line of buttons
		for (int k = 0; k < 7; k++){
			boardUI.addButton("DropButton"+k, "DropButton", k*64, 448);
			//DrawQuadTex(FastTex("DropButton"),k,448,64,64);
			
		}
		boardUI.draw();	
	}
}
