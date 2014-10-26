package com.hexlan.entities;

import java.awt.Graphics2D;

import com.hexlan.core.Game;
import com.hexlan.utils.Animation;
import com.hexlan.utils.Animation.PlayMode;
import com.hexlan.utils.Content;
import com.hexlan.utils.JukeBox;

public class Elf 
{
	Animation anim;
	int x, y, w, h, dy, dx;
	String sound;
	
	public Elf(String init)
	{
		String[] stuff = init.split(" ");
		
		sound = stuff[0];
		w = h = 40;
		
		if(stuff[1].equalsIgnoreCase("right"))
		{
			dx = 4;
			dy = 0;
			x = 20;
			y = Game.SCREEN_HEIGHT/2;
			anim = new Animation(-1, Content.idleRight, PlayMode.NORMAL);
		}
		else if(stuff[1].equalsIgnoreCase("left"))
		{
			dx = -4;
			dy = 0;
			x = Game.SCREEN_WIDTH - 20;
			y = Game.SCREEN_HEIGHT/2;
			anim = new Animation(-1, Content.idleLeft, PlayMode.NORMAL);
		}
		else if(stuff[1].equalsIgnoreCase("up"))
		{
			dx = 0;
			dy = -4;
			x = Game.SCREEN_WIDTH/2;
			y = Game.SCREEN_HEIGHT - 20;
			anim = new Animation(-1, Content.idleUp, PlayMode.NORMAL);
		}
		else if(stuff[1].equalsIgnoreCase("down"))
		{
			dx = 0;
			dy = 4;
			x = Game.SCREEN_WIDTH/2;
			y = 20;
			anim = new Animation(-1, Content.idleDown, PlayMode.NORMAL);
		}
		
		JukeBox.play(sound);
	}
	
	public void update()
	{
		x += dx;
		y += dy;
		
		anim.update();
	}
	
	public void draw(Graphics2D g)
	{
		g.drawImage(anim.getImage(), x -anim.getImage().getWidth()/2, y -anim.getImage().getHeight()/2, null);
	}
}