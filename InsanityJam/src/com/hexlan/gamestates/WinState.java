package com.hexlan.gamestates;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;

import com.hexlan.core.Game;
import com.hexlan.utils.GSM;
import com.hexlan.utils.Input;

public class WinState extends GameState
{

	@Override
	public void handleInput() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update() {
		if(Input.isPressed(KeyEvent.VK_ENTER))
		{
			GSM.setState(new TestState());
		}
	}

	@Override
	public void draw(Graphics2D g) {
		g.setColor(Color.BLACK);
		g.drawString("You Win!", Game.SCREEN_WIDTH/2 - 20, Game.SCREEN_HEIGHT/2);
		g.drawString("Trivia: What is the 201st digit of pi?", Game.SCREEN_WIDTH/2 - 20, Game.SCREEN_HEIGHT/2+20);
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		
	}

}
