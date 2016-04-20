package com.connectfour.view;
import static com.connectfour.viewactions.Artist.*;
import static com.connectfour.viewactions.UI.*;

import com.connectfour.model.Board;
import com.connectfour.viewactions.UI;

public class TileGrid {
	private UI boardUI;
	public Tile[][] map;
	
	public TileGrid(){
		map = new Tile[7][7];
		for (int i = 0; i <map.length; i++){
			for (int j = 0; j<map[i].length; j++){
				map[i][j] = new Tile(i * 64, j * 64, 64,64, TileType.EmptySlot);
			}
		}
	}
	
	public TileGrid(Board newMap){
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
	
	public void Draw(){
		boardUI = new UI();
		for (int i = 0; i < map.length; i++){
			for (int j = 0 ; j < map[i].length; j++){
				Tile t = map[i][j];
				DrawQuadTex(t.getTexture(), t.getX(), t.getY(), t.getWidth(), t.getHeight());
			}
		}
		//Draw line of buttons
		for (int k = 0; k < 448; k+=64){
			//boardUI.addButton("DropButton", "DropButton", k, 448);
			DrawQuadTex(FastTex("DropButton"),k,448,64,64);
			
		}
	}
}
