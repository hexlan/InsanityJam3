package com.hexlan.gamestates;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;

import com.hexlan.audio.JukeBox;
import com.hexlan.core.Game;
import com.hexlan.entities.JavaGuy;
import com.hexlan.utils.Content;
import com.hexlan.utils.Input;

public class TestState extends GameState
{
	JavaGuy jg;
	
	public TestState() 
	{
		JukeBox.init();
		jg = new JavaGuy();
	}
	
	public void handleInput() 
	{
		if(Input.isPressed(KeyEvent.VK_ESCAPE)) { System.exit(0); }
		if(Input.isPressed(KeyEvent.VK_ENTER)) { dispose(); }
	}
	
	public void update() 
	{
		jg.update();
	}
	
	public void draw(Graphics2D g) 
	{
		g.setColor(new Color(230, 230, 230));
		g.fillRect(0, 0, Game.SCREEN_WIDTH, Game.SCREEN_HEIGHT);
		
		g.setColor(new Color(140, 140, 230));
		for(int i = 0; i < Game.SCREEN_WIDTH; i += 32)
		{
			g.fill3DRect(i, Game.SCREEN_HEIGHT-16, 32, 16, true);
		}
		
		g.drawImage(Content.imgLoadExample, Game.SCREEN_WIDTH/2 - 60, 0, 120, 120, null);
		
	}
	
	public void dispose() 
	{
		jg.dipose();
	}
}