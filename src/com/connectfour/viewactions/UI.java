package com.connectfour.viewactions;

import java.util.ArrayList;
import static com.connectfour.viewactions.Artist.*;

import org.newdawn.slick.opengl.Texture;

public class UI {
	
	private ArrayList<Button> buttonList;
	
	public UI(){
		buttonList = new ArrayList<Button>();
	}
	
	public void addButton(String name, String texName, int x, int y){
		buttonList.add(new Button(name, FastTex(texName), x, y));
	}
	
	public void draw(){
		for (Button b: buttonList){
			DrawQuadTex(b.getTexture(), b.getX(), b.getY(), b.getWidth(), b.getHeight());
		}
	}

}
