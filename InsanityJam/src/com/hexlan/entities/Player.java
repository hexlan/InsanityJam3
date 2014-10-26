package com.hexlan.entities;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;

import com.hexlan.core.Game;
import com.hexlan.gamestates.TestState;
import com.hexlan.utils.Animation;
import com.hexlan.utils.Content;
import com.hexlan.utils.Input;

public class Player 
{
	int x, y, w, h, delay;
	Animation state;
	String dir;
	boolean attacking;
	
	public Player()
	{
		x = Game.SCREEN_WIDTH/2;
		y = Game.SCREEN_HEIGHT/2;
		
		w = h = 40;
		state = new Animation(-1, Content.idleUp, Animation.PlayMode.NORMAL);
		dir = "up";
		attacking = false;
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
			attacking = false;
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
			attacking = true;
			
			elfCollision();
		}
		
		if(Input.isPressed(KeyEvent.VK_DOWN) && delay >= 10)
		{
			state = new Animation(-1, Content.attackDown, Animation.PlayMode.NORMAL);
			dir = "down";
			delay = 0;
			attacking = true;
			
			elfCollision();
		}
		
		if(Input.isPressed(KeyEvent.VK_LEFT) && delay >= 10)
		{
			state = new Animation(-1, Content.attackLeft, Animation.PlayMode.NORMAL);
			dir = "left";
			delay = 0;
			attacking = true;
			
			elfCollision();
		}
		
		if(Input.isPressed(KeyEvent.VK_RIGHT) && delay >= 10)
		{
			state = new Animation(-1, Content.attackRight, Animation.PlayMode.NORMAL);
			dir = "right";
			delay = 0;
			attacking = true;
			
			elfCollision();
		}
	}
	
	public Rectangle getRec()
	{
		return new Rectangle(x - w/4, y - h/4, w/2, h/2);
	}
	
	private void elfCollision() 
	{
		for(int i = 0; i < TestState.elves.size(); i++)
		{
			if(dir.equals("right"))
			{
				Rectangle r = new Rectangle(x + w/2, y - 1, w, 3);
				if(TestState.elves.get(i).getRec().intersects(r))
				{
					TestState.elves.get(i).playSound();
					TestState.elves.remove(i);
				}
			}
			
			if(dir.equals("up"))
			{
				Rectangle r = new Rectangle(x -1, y - (int)(h*1.5), 3, h);
				if(TestState.elves.get(i).getRec().intersects(r))
				{
					TestState.elves.get(i).playSound();
					TestState.elves.remove(i);
				}
			}
			
			if(dir.equals("down"))
			{
				Rectangle r = new Rectangle(x -1, y + h/2, 3, h);
				if(TestState.elves.get(i).getRec().intersects(r))
				{
					TestState.elves.get(i).playSound();
					TestState.elves.remove(i);
				}
			}
			
			if(dir.equals("left"))
			{
				Rectangle r = new Rectangle(x - (int)(w*1.5), y - 1, w, 3);
				if(TestState.elves.get(i).getRec().intersects(r))
				{
					TestState.elves.get(i).playSound();
					TestState.elves.remove(i);
				}
			}
		}
	}

	public void draw(Graphics2D g)
	{
		g.drawImage(state.getImage(), x-state.getImage().getWidth()/2, y-state.getImage().getHeight()/2, null);
	}
}
