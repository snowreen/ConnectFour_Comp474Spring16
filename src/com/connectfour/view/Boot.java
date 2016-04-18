package com.connectfour.view;

import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.newdawn.slick.opengl.Texture;

import static org.lwjgl.opengl.GL11.*;

import static com.connectfour.viewactions.Artist.*;

public class Boot {

	public Boot(){
	
		BeginSession();
		
		
		
		Tile empTile = new Tile(0, 0, 64, 64, TileType.EmptySlot);
		while(!Display.isCloseRequested()){
		 
			
			DrawQuadTex(empTile.getTexture(),empTile.getX(), empTile.getY(), empTile.getWidth(), empTile.getHeight());
			//DrawQuadTex(redPiece, 0, 0, 64, 64);
			
			Display.update();
			Display.sync(60);
			
		}
		Display.destroy();
	}
	public static void main(String[] args){
		new Boot();
	}
}
