package com.connectfour.robot;

import java.util.Random;

public class EasyRobot {
	
	public static int getRandomColumn() {
		Random rn = new Random();
		return rn.nextInt(7);
	}

}
