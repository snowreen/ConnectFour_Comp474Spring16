package com.connectfour.view;

import org.lwjgl.input.Mouse;
import org.newdawn.slick.opengl.Texture;

import com.connectfour.viewactions.StateManager;
import com.connectfour.viewactions.StateManager.GameState;
import com.connectfour.viewactions.UI;

import static com.connectfour.viewactions.Artist.*;

public class MainMenu {

	private Texture background;
	private Texture classButton;
	private UI menuUI;
	
	public MainMenu(){
		background = FastTex("MainMenu");
		classButton = FastTex("ClassEasy2");
		menuUI = new UI();
		//DrawQuadTex(classButton,36,239,116,44);
		menuUI.addButton("TwoPlayerReg", "Class", 36, 240);
		menuUI.addButton("SingleRegE", "ClassEasy", 198, 240);
		menuUI.addButton("SingleRegH", "ClassHard", 360, 240);
		menuUI.addButton("TwoPlayerPush", "Push", 36, 334);
		menuUI.addButton("SinglePushE", "PushEasy", 198, 334);
		menuUI.addButton("SinglePushH", "PushHard", 360, 334);
		
	}
	
	private void updateButtons(){
		if(Mouse.isButtonDown(0)){
			if (menuUI.isButtonClicked("TwoPlayerReg")){
				StateManager.setState(GameState.GAME);
			}
		}
	}
	
	public void update() {
		DrawQuadTex(background,0,0,512,512);		
		menuUI.draw();
		updateButtons();
		
	}

}
