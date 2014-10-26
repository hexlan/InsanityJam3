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
		JukeBox.load("/SFX/Beat.mp3", "Beat");
		
		JukeBox.load("/SFX/C1.mp3", "C1");
		JukeBox.load("/SFX/D.mp3", "D");
		JukeBox.load("/SFX/E.mp3", "E");
		JukeBox.load("/SFX/F.mp3", "F");
		JukeBox.load("/SFX/G.mp3", "G");
		JukeBox.load("/SFX/A.mp3", "A");
		JukeBox.load("/SFX/A Extended.mp3", "A Extended");
		JukeBox.load("/SFX/C2.mp3", "C2");
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
		//Renderer.draw(g);
	}
}
