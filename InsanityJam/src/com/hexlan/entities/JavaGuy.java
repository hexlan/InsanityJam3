package com.hexlan.entities;

import java.awt.Graphics2D;
import java.awt.event.KeyEvent;

import com.hexlan.audio.JukeBox;
import com.hexlan.core.Game;
import com.hexlan.utils.Animation;
import com.hexlan.utils.Content;
import com.hexlan.utils.Input;

public class JavaGuy extends Sprite
{
	Animation testAnim;
	double dy;
	boolean jumping;
	
	public JavaGuy()
	{
		register();
		testAnim = new Animation(10, Content.sheetLoadExample);
		testAnim.setPlayMode(Animation.PlayMode.LOOP);
		x = Game.SCREEN_WIDTH/2;
		y = Game.SCREEN_HEIGHT - (34 + 16);
		JukeBox.load("/SFX/playerjump.mp3", "playerjump");
		jumping = false;
	}
	
	public void update()
	{
		if(Input.isPressed(KeyEvent.VK_SPACE)) { register(); }
		if(Input.isDown(KeyEvent.VK_LEFT)) { x-=3; }
		if(Input.isDown(KeyEvent.VK_RIGHT)) { x+=3; }
		if(Input.isDown(KeyEvent.VK_UP) && !jumping) { 
			dy = -8; 
			jumping = true;
			JukeBox.play("playerjump");
		}
		
		testAnim.update();
		
		dy += 0.25;
		y += dy;
		
		if(x - 25 < 0) x = 25;
		if(x + 25 > Game.SCREEN_WIDTH) x = Game.SCREEN_WIDTH - 25;
		if(y > Game.SCREEN_HEIGHT - (34 + 16)) 
		{
			y = Game.SCREEN_HEIGHT - (34 + 16);
			dy = 0;
			jumping = false;
		}
	}
	
	public void draw(Graphics2D g) 
	{
		g.drawImage(testAnim.getImage(), (int)x - 25, (int)y - 34, null);
	}
	
	public void dipose()
	{
		unregister();
		//testAnim.setKeyFrames(null);
	}
}
