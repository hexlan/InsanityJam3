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
	
	public static BufferedImage map = loadImage("/images/Map.png");
	
	public static BufferedImage[] elfUp = loadSheet("/images/south_elf_sprite_sheet.png", 40);
	public static BufferedImage[] elfDown = loadSheet("/images/north_elf_sprite_sheet.png", 40);
	public static BufferedImage[] elfLeft = loadSheet("/images/east_elf_sprite_sheet.png", 40);
	public static BufferedImage[] elfRight = loadSheet("/images/west_elf_sprite_sheet.png", 40);
	
	public static BufferedImage[] idleUp = loadSheet("/images/hero_back_1.png", 40);
	public static BufferedImage[] idleDown = loadSheet("/images/hero_front_2.png", 40);
	public static BufferedImage[] idleLeft = loadSheet("/images/hero_left_1.png", 40);
	public static BufferedImage[] idleRight = loadSheet("/images/hero_right_1.png", 40);
	
	public static BufferedImage[] attackUp = loadSheet("/images/hero_back_attack.png", 80);
	public static BufferedImage[] attackDown = loadSheet("/images/hero_front_attack.png", 80);
	public static BufferedImage[] attackLeft = loadSheet("/images/hero_left_attack.png", 80);
	public static BufferedImage[] attackRight = loadSheet("/images/hero_right_attack.png", 80);
	
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
				"A LEFT",
				"NULL NULL",
				"G UP",
				"F LEFT",
				"E RIGHT",
				"D DOWN",
				"C1 UP",
				"NULL NULL",
				"C2 DOWN",
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
