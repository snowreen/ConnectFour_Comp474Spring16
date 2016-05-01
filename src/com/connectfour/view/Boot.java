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

		System.err.println("booting up view now...");

		BeginSession();
		while(StateManager.gameState==GameState.MAINMENU){
        	StateManager.update();
        	Display.update();
			Display.sync(60);
        }
		 if(StateManager.gameState==GameState.GAMEPUSH)
         	this.map=new BoardPush();
		 else
			 this.map = gameBoard;
		map.initializeBoard();		
		grid = new TileGrid(map);		
		while(!Display.isCloseRequested()&&map.isFinished==false){
		 
			
			
			WinCheck winCheck = new WinCheck(map);
            this.result = winCheck.getWinner(map);
            if (result == 'D') {
                System.out.println("It is a draw!");
                
            }
            else if (result == 'R') {
                System.out.println("Red wins!");
               
            }
            else if (result == 'B') {
                System.out.println("Black wins!");
                               
            }
            
            /*
             * Originally starts game in main menu 
             * when button is clicked state changes
             * then starts game
             */
            
            
            
           
			//grid.Draw();
			//DrawQuadTex(FastTex("RedPiece"), 0, 0, 64, 64);
			
		
			grid.update(map); 			
			Display.update();
			Display.sync(60);
			
			
			
            
            if (result=='B'){
            	Display.update();
            	DrawQuadTex(FastTex("BlackWinner"),0,0,512,512);
            	Display.update();
            	
            	try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}            	
            	map.isFinished=true;
            }
            //below will display who won the game for two seconds before closing
            if (result=='R'){
            	Display.update();
            	DrawQuadTex(FastTex("RedWinner"),0,0,512,512);
            	Display.update();
            	
            	try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}            	
            	map.isFinished=true;
            }
            
            if (result=='D'){
            	Display.update();
            	DrawQuadTex(FastTex("NoWinner"),0,0,512,512);
            	Display.update();
            	
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
	
	/*public static void main(String[] args){
		new Boot(new Board(7,7) );
	}*/
}
