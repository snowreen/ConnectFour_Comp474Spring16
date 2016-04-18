package com.connectfour.view;
/*
 * We set each tile texture here and if the tile is pressable
 * We can add more attributes to pieces if needed
 */
public enum TileType {
	
	EmptySlot("emptySlot", false), RedPiece("RedPiece",false), 
	BlackPiece("BlackPiece",false), DropButton("DropButton",true);

	String textureName;
	boolean pressable;
	
	TileType(String textureName, boolean pressable){
		this.textureName= textureName;
		this.pressable = pressable;
	}
}
