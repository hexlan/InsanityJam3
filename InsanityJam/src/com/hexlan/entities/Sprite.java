package com.hexlan.entities;

import java.awt.Graphics2D;

import com.hexlan.utils.Renderer;

public abstract class Sprite implements Comparable<Sprite>
{
	protected double x, y;
	protected int width, height, z = 0;
	
	protected void register()
	{
		Renderer.register(this);
	}
	
	protected void unregister()
	{
		Renderer.unregister(this);
	}
	
	public int compareTo(Sprite s)
	{
		if(this.z < s.z) { return -1; }
		if(this.z > s.z) { return 1; }
		return 0;
	}
	
	public abstract void draw(Graphics2D g);
	
	public void setZ(int z)
	{
		this.z = z;
		Renderer.sort();
	}
}
