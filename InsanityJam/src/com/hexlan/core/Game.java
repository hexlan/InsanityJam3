//   Class: Game.java
//  Author: Reyer Swengel
//    Date: 10/17/2014
// Summary: Initializes certain game variables and manages the game loop.

package com.hexlan.core;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

import com.hexlan.utils.GSM;
import com.hexlan.utils.Input;

@SuppressWarnings("serial")
public class Game extends JPanel implements KeyListener, Runnable
{
	public static final int SCREEN_WIDTH = 850;
	public static final int SCREEN_HEIGHT = 850;
	
	private Thread thread;
	private boolean running;
	private int FPS = 60;
	private long targetTime = 1000/FPS;
	
	BufferedImage img;
	Graphics2D g;
	
	GSM gsm;
	
	public Game()
	{
		super();
		setPreferredSize(new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT));
		setFocusable(true);
		requestFocus();
	}
	
	public void addNotify()
	{
		super.addNotify();
		if(thread == null)
		{
			thread = new Thread(this);
			addKeyListener(this);
			thread.start();
		}
	}
	
	private void init()
	{
		gsm = new GSM();
		
		img = new BufferedImage(SCREEN_WIDTH, SCREEN_HEIGHT, BufferedImage.TYPE_INT_RGB);
		g = (Graphics2D)img.getGraphics();
		
		running = true;
	}
	
	private void update()
	{
		gsm.update();
		Input.update();
	}
	
	private void draw()
	{
		g.setColor(new Color(140, 140, 250));
		g.fillRect(0, 0, SCREEN_WIDTH, SCREEN_HEIGHT);
		
		gsm.draw(g);
		
		Graphics g2 = getGraphics();
		g2.drawImage(img, 0, 0, null);
		g2.dispose();
	}

	public void keyPressed(KeyEvent key) { Input.setKey(key.getKeyCode(), true); }
	public void keyReleased(KeyEvent key) { Input.setKey(key.getKeyCode(), false); }
	public void keyTyped(KeyEvent key) {}

	// Game Loop
	public void run() 
	{
		init();
		
		long start;
		long elapsed;
		long wait;
		
		while(running)
		{
			start = System.nanoTime();
			
			update();
			draw();
			
			elapsed = System.nanoTime() - start;
			wait = targetTime - elapsed/1000000;
			
			try
			{
				Thread.sleep(wait);
			}
			catch(Exception e) {}
		}
	}
}