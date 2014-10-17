package com.hexlan.utils;

import java.awt.Color;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.Collections;

import com.hexlan.entities.Sprite;

public class Renderer 
{
	private static ArrayList<Sprite> targets = new ArrayList<Sprite>();
	
	public static void register(Sprite target) 
	{
		if(!targets.contains(target))
		{
			targets.add(target);
		}
		sort();
	}
	
	public static void unregister(Sprite target) { targets.remove(target); }
	public static void sort() { Collections.sort(targets); }
	
	public static void draw(Graphics2D g)
	{
		for(Sprite s : targets)
		{
			s.draw(g);
		}
		
		g.setColor(Color.black);
		for (int i = -1; i < 2; i++) 
		{
			for (int j = -1; j < 2; j++) 
			{
				g.drawString("Size: " + targets.size(), 2 + i, 12 + j);
			}
		}
		g.setColor(Color.white);
		g.drawString("Size: "+targets.size(), 2, 12);
	}
}