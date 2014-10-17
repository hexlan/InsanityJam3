//   Class: GameState.java
//  Author: Reyer Swengel
//    Date: 10/17/2014
// Summary: Abstract class to be inherited by all GameStates.

package com.hexlan.gamestates;

import java.awt.Graphics2D;

public abstract class GameState 
{
	protected GameState() {}
	
	public abstract void handleInput();
	public abstract void update();
	public abstract void draw(Graphics2D g);
	public abstract void dispose();
}
