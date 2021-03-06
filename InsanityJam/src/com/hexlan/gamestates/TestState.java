package com.hexlan.gamestates;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import com.hexlan.core.Game;
import com.hexlan.entities.Elf;
import com.hexlan.entities.Player;
import com.hexlan.utils.Content;
import com.hexlan.utils.GSM;
import com.hexlan.utils.Input;
import com.hexlan.utils.JukeBox;

public class TestState extends GameState
{
	Player p;
	int timer, count;
	Rectangle slashArea;
	public static ArrayList<Elf> elves;
	boolean game = true;
	
	public TestState() 
	{
		elves = new ArrayList<Elf>();
		slashArea = new Rectangle(Game.SCREEN_WIDTH/2 - 60, Game.SCREEN_HEIGHT/2 - 60, 120, 120);
		p = new Player();
		timer = 0;
		count = 0;
	}
	
	public void handleInput() 
	{
		if(Input.isPressed(KeyEvent.VK_ESCAPE)) { System.exit(0); }
		if(Input.isPressed(KeyEvent.VK_ENTER)) { dispose(); }
	}
	
	public void update() 
	{
		if(game)
		{
			timer++;
			if(timer >= 30)
			{
				timer = 0;
				count++;
				if(count < Content.song.length)
				{
					if(Content.song[count].equals("NULL NULL")) {}
					else
					{
						elves.add(new Elf(Content.song[count]));
					}
				}
				else if(count > Content.song.length+3)
				{
					GSM.setState(new WinState());
				}
				JukeBox.play("Beat");
			}
			for(int i = 0; i < elves.size(); i++)
			{
				elves.get(i).update();
			}
			p.update();
			
			for(int i = 0; i < elves.size(); i++)
			{
				if(elves.get(i).getRec().intersects(p.getRec())) 
				{
					game = false;
				}
			}
		}
		else
		{
			if(Input.isPressed(KeyEvent.VK_ENTER)) { GSM.setState(new TestState());}
		}
	}
	
	public void draw(Graphics2D g) 
	{
		g.setColor(new Color(230, 230, 230));
		g.fillRect(0, 0, Game.SCREEN_WIDTH, Game.SCREEN_HEIGHT);
		
		//g.drawImage(Content.imgLoadExample, Game.SCREEN_WIDTH/2 - 60, 0, 120, 120, null);
		if(game)
		{
			g.drawImage(Content.map, -14, 0, null);
		g.setColor(new Color(80, 80, 80, 80));
		//g.fillRect(slashArea.x, slashArea.y, slashArea.width, slashArea.height);
		//g.fillRect(Game.SCREEN_WIDTH/2 - 20, 0, 40, Game.SCREEN_HEIGHT);
		//g.fillRect(0, Game.SCREEN_HEIGHT/2 - 20, Game.SCREEN_WIDTH, 40);
		//g.drawString("Size: "+elves.size(), 10, 10);
		for(int i = 0; i < elves.size(); i++)
		{
			elves.get(i).draw(g);
		}
		p.draw(g);
		}
		else
		{
			g.setColor(new Color(0, 0, 0));
			g.drawString("You Lose", Game.SCREEN_WIDTH/2 - 20, Game.SCREEN_HEIGHT/2);
		}
	}
	
	public void dispose() 
	{
		//jg.dipose();
	}
}