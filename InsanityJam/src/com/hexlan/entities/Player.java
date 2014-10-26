package com.hexlan.entities;

import java.awt.Graphics2D;
import java.awt.event.KeyEvent;

import com.hexlan.core.Game;
import com.hexlan.utils.Animation;
import com.hexlan.utils.Content;
import com.hexlan.utils.Input;

public class Player 
{
	int x, y, w, h, delay;
	Animation state;
	String dir;
	
	public Player()
	{
		x = Game.SCREEN_WIDTH/2;
		y = Game.SCREEN_HEIGHT/2;
		
		w = h = 40;
		state = new Animation(-1, Content.idleUp, Animation.PlayMode.NORMAL);
		dir = "up";
	}

	public void update()
	{
		state.update();
		if(delay < 10)
		{
			delay++;
		}
		else
		{
			if(dir.equals("up"))
			{
				state = new Animation(-1, Content.idleUp, Animation.PlayMode.NORMAL);
			}
			else if(dir.equals("down"))
			{
				state = new Animation(-1, Content.idleDown, Animation.PlayMode.NORMAL);
			}
			else if(dir.equals("left"))
			{
				state = new Animation(-1, Content.idleLeft, Animation.PlayMode.NORMAL);
			}
			else
			{
				state = new Animation(-1, Content.idleRight, Animation.PlayMode.NORMAL);
			}
		}
		
		if(Input.isPressed(KeyEvent.VK_UP) && delay >= 10)
		{
			state = new Animation(-1, Content.attackUp, Animation.PlayMode.NORMAL);
			dir = "up";
			delay = 0;
		}
		
		if(Input.isPressed(KeyEvent.VK_DOWN) && delay >= 10)
		{
			state = new Animation(-1, Content.attackDown, Animation.PlayMode.NORMAL);
			dir = "down";
			delay = 0;
		}
		
		if(Input.isPressed(KeyEvent.VK_LEFT) && delay >= 10)
		{
			state = new Animation(-1, Content.attackLeft, Animation.PlayMode.NORMAL);
			dir = "left";
			delay = 0;
		}
		
		if(Input.isPressed(KeyEvent.VK_RIGHT) && delay >= 10)
		{
			state = new Animation(-1, Content.attackRight, Animation.PlayMode.NORMAL);
			dir = "right";
			delay = 0;
		}
	}
	public void draw(Graphics2D g)
	{
		g.drawImage(state.getImage(), x-state.getImage().getWidth()/2, y-state.getImage().getHeight()/2, null);
	}
}
