package com.connectfour.model;

public class Checker {
	//Black is represented by 0
	//Red is represented by 1
	
	private int color;
	public Checker() {
		this.color = 0;
	}
	
	public Checker(int color) {
		this.color = color;
	}

	public int getColor() {
		return this.color;
	}
	
	public void setColor(int color) {
		this.color = color;
	}

	@Override
	public String toString() {
		String s = "checker: null";
		if(this.color == 0) {s = "B";}
		if(this.color == 1) {s = "R";}
		return s;
	}
	
	
}
