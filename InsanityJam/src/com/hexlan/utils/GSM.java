//   Class: GSM.java
//  Author: Reyer Swengel
//    Date: 10/17/2014
// Summary: Game State Manager - manages the different states of the game.

package com.hexlan.utils;

import java.awt.Graphics2D;

import com.hexlan.gamestates.GameState;
import com.hexlan.gamestates.TestState;

public class GSM 
{
	private static GameState currentState;
	
	public GSM()
	{
		JukeBox.init();
		currentState = new TestState();
	}
	
	public static void setState(GameState newState)
	{
		if(currentState != null)
		{
			currentState.dispose();
		}
		
		currentState = newState;
	}
	
	public void update()
	{
		currentState.handleInput();
		currentState.update();
	}
	
	public void draw(Graphics2D g)
	{
		currentState.draw(g);
		Renderer.draw(g);
	}
}
