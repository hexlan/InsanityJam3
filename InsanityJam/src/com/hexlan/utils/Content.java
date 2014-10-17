//   Class: Content.java
//  Author: Reyer Swengel
//    Date: 10/17/2014
// Summary: Loads in content for the game and provides global access.

package com.hexlan.utils;

import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;
import javax.swing.JOptionPane;

public class Content 
{
	// Static Variables
	public static BufferedImage imgLoadExample = loadImage("/images/Java.png");
	
	public static BufferedImage[] sheetLoadExample = loadSheet("/images/SpriteSheet.png", 50);
	
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
