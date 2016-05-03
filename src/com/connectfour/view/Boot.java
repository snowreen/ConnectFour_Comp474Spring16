package com.connectfour.view;

import org.lwjgl.LWJGLException;

import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.newdawn.slick.opengl.Texture;

import com.connectfour.model.Board;
import com.connectfour.model.BoardPush;
import com.connectfour.model.WinCheck;
import com.connectfour.viewactions.StateManager;
import com.connectfour.viewactions.StateManager.GameState;
import com.connectfour.viewactions.UI;

import static org.lwjgl.opengl.GL11.*;

import static com.connectfour.viewactions.Artist.*;



public class Boot {
	
	//private UI gameUI;
	public Board map;
	public TileGrid grid;
	public boolean isPlayed = true;
	String value = null;
	public char result;

	//take in board variable from main
	public Boot(Board gameBoard){
		this.map = gameBoard;
	}
	
	public void playGame() {
		System.err.println("booting up view now...");

		BeginSession();
		
		while(StateManager.gameState==GameState.MAINMENU && !Display.isCloseRequested()){
			glClear(GL_COLOR_BUFFER_BIT);
			StateManager.initializeMainMenu();
        	StateManager.stateUpdate();
        	Display.update();
			Display.sync(60);
        } 
		if (Display.isCloseRequested()) {
			Display.destroy();
			System.err.println("Display destroyed");
		}
		 if(StateManager.gameState==GameState.GAMEPUSH) {
			 this.map=new BoardPush(); 
		 }
		map.initializeBoard();		
		grid = new TileGrid(map);
		
		glClear(GL_COLOR_BUFFER_BIT);
		grid.updateBoard(map);
		grid.Draw(map);
		Display.update();
		Display.sync(60);
		while(!Display.isCloseRequested() && map.isFinished==false) {
            /*
             * Originally starts game in main menu 
             * when button is clicked state changes
             * then starts game
             */
			
			grid.takeInput(map);
			Display.update();
			Display.sync(60);
			if (TileGrid.isReset) {
				map = new Board();
				map.initializeBoard();
				grid = new TileGrid(map);
				glClear(GL_COLOR_BUFFER_BIT);
				grid.updateBoard(map);
				grid.Draw(map);
				Display.update();
				Display.sync(60);
				TileGrid.isReset = false;
			}
			
			if (TileGrid.isUpdateNeeded) {
				glClear(GL_COLOR_BUFFER_BIT);
				grid.updateBoard(map);
				grid.Draw(map);
				Display.update();
				Display.sync(60);
				TileGrid.isUpdateNeeded = false;
			}
			
			if (! TileGrid.isWinChecked) {
				WinCheck winCheck = new WinCheck(map);
	            this.result = winCheck.getWinner(map);
	            TileGrid.isWinChecked = true;
			}
            
            if (result=='B'){
            	System.out.println("Black wins!");
            	glClear(GL_COLOR_BUFFER_BIT);
            	grid.Draw(map);
            	DrawQuadTex(FastTex("BlackWinner"),0,0,512,512);
            	Display.update();
            	Display.sync(60);
            	try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}            	
            	map.isFinished=true;
            }
            //below will display who won the game for two seconds before closing
            if (result=='R'){
            	System.out.println("Red wins!");
            	glClear(GL_COLOR_BUFFER_BIT);
            	grid.Draw(map);
            	DrawQuadTex(FastTex("RedWinner"),0,0,512,512);
            	Display.update();
            	Display.sync(60);
            	try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}            	
            	map.isFinished=true;
            }
            
            if (result=='D'){
            	System.out.println("It is a draw!");
            	glClear(GL_COLOR_BUFFER_BIT);
            	grid.Draw(map);
            	DrawQuadTex(FastTex("NoWinner"),0,0,512,512);
            	Display.update();
            	Display.sync(60);
            	try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}            	
            	map.isFinished=true;
            }
        }
		
		
		Display.destroy();
		System.err.println("Display destroyed");
	}
}
