//   Class: Content.java
//  Author: Reyer Swengel
//    Date: 10/17/2014
// Summary: Loads in content for the game and provides global access.

package com.hexlan.utils;

import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.JOptionPane;

public class Content 
{
	// Static Variables
	public static String[] song = loadSong();
	
	public static BufferedImage imgLoadExample = loadImage("/images/Java.png");
	
	public static BufferedImage[] idleUp = loadSheet("/images/idleUp.png", 40);
	public static BufferedImage[] idleDown = loadSheet("/images/idleDown.png", 40);
	public static BufferedImage[] idleLeft = loadSheet("/images/idleLeft.png", 40);
	public static BufferedImage[] idleRight = loadSheet("/images/idleRight.png", 40);
	
	public static BufferedImage[] attackUp = loadSheet("/images/attackUp.png", 80);
	public static BufferedImage[] attackDown = loadSheet("/images/attackDown.png", 80);
	public static BufferedImage[] attackLeft = loadSheet("/images/attackLeft.png", 80);
	public static BufferedImage[] attackRight = loadSheet("/images/attackRight.png", 80);
	
	// Methods
	public static BufferedImage loadImage(String s)
	{
		try
		{
			return ImageIO.read(Content.class.getResourceAsStream(s));
		}
		catch(Exception e)
		{
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Problem Loading: "+s, "Content Error", JOptionPane.INFORMATION_MESSAGE);
			System.exit(0);
		}
		
		return null;
	}
	
	private static String[] loadSong() 
	{
		String[] song = 
			   {"NULL NULL",
				"NULL NULL",
				"NULL NULL",
				"NULL NULL",
				"C1 RIGHT",
				"NULL NULL",
				"C1 RIGHT",
				"NULL NULL",
				"C1 RIGHT",
				"NULL NULL",
				"C1 RIGHT",
				"NULL NULL",
				"D DOWN",
				"NULL NULL",
				"D DOWN",
				"NULL NULL",
				"D DOWN",
				"NULL NULL",
				"D DOWN",
				"NULL NULL",
				"E LEFT",
				"NULL NULL",
				"E LEFT",
				"NULL NULL",
				"E LEFT",
				"NULL NULL",
				"E LEFT",
				"NULL NULL",
				"F UP",
				"NULL NULL",
				"F UP",
				"NULL NULL",
				"F UP",
				"NULL NULL",
				"F UP",
				"NULL NULL",
				"C1 RIGHT",
				"E LEFT",
				"C1 RIGHT",
				"E LEFT",
				"D DOWN",
				"F UP",
				"D DOWN",
				"F UP",
				"E RIGHT",
				"G DOWN",
				"E LEFT",
				"G UP",
				"F LEFT",
				"A RIGHT",
				"F DOWN",
				"A UP",
				"C1 RIGHT",
				"E LEFT",
				"C1 RIGHT",
				"E LEFT",
				"D DOWN",
				"F UP",
				"D DOWN",
				"F UP",
				"E RIGHT",
				"G DOWN",
				"E LEFT",
				"G UP",
				"F LEFT",
				"A RIGHT",
				"F DOWN",
				"A UP",
			    "NULL NULL"};
		return song;
	}

	public static BufferedImage[] loadSheet(String s, int w)
	{
		BufferedImage[] temp;
		try
		{
			BufferedImage spriteSheet = ImageIO.read(Content.class.getResourceAsStream(s));
			int width = spriteSheet.getWidth() / w;
			int h = spriteSheet.getHeight();
			temp = new BufferedImage[width];
			for(int i = 0; i < width; i++) 
			{
				temp[i] = spriteSheet.getSubimage(i * w, 0, w, h);
			}
			return temp;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Problem Loading Images", "Content Error", JOptionPane.INFORMATION_MESSAGE);
			System.exit(0);
		}
		
		return null;
	}
}
