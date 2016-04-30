package com.connectfour.viewactions;

import com.connectfour.model.Board;
import com.connectfour.view.Boot;
import com.connectfour.view.MainMenu;

public class StateManager {
	
	public static enum GameState {
		MAINMENU, GAME
	}
	
	public static GameState gameState = GameState.MAINMENU;
	public static MainMenu mainMenu;
	public static Boot game;
	public static Board board;
	
	public static void update(){
		switch(gameState){
		case MAINMENU:
			if(mainMenu==null)
				mainMenu=new MainMenu();
			mainMenu.update();
			break;
		case GAME:
			break;
		}
	}
	
	public static void setState(GameState newState){
		gameState = newState;
	}

}
