package com.connectfour.view;

import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.newdawn.slick.opengl.Texture;

import com.connectfour.model.Board;
import com.connectfour.viewactions.UI;

import static org.lwjgl.opengl.GL11.*;

import static com.connectfour.viewactions.Artist.*;






public class Boot {
	
	//private UI gameUI;
	public Board map;
	public TileGrid grid;

	//take in board variable from main
	public Boot(Board gameBoard){	

		System.err.println("booting up view now...");

		BeginSession();
		
		this.map = gameBoard;
		map.initializeBoard();		
		grid = new TileGrid(map);
		//Tile empTile = new Tile(0, 0, 64, 64, TileType.EmptySlot);
		while(!Display.isCloseRequested()){
		 
			grid.update();
			//grid.Draw();
			//DrawQuadTex(redPiece, 0, 0, 64, 64);
			
			Display.update();
			Display.sync(60);
			
		}
		Display.destroy();
	}	
	
	/*public static void main(String[] args){
		new Boot(new Board(7,7) );
	}*/
}
