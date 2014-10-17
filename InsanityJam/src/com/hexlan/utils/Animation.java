//   Class: Animation.java
//  Author: Reyer Swengel
//    Date: 10/17/2014
// Summary: Stores animation data.

package com.hexlan.utils;

import java.awt.image.BufferedImage;

public class Animation 
{
	public enum PlayMode 
	{
		NORMAL,
		REVERSED,
		LOOP,
		LOOP_REVERSED,
		LOOP_PINGPONG,
	}
	
	private BufferedImage[] keyFrames;
	
	private boolean direction;
	private int frameDuration;
	private int currentFrame = 0;
	private int count = 0;
	private int timesPlayed;
	
	private PlayMode playMode = PlayMode.NORMAL;
	
	public Animation(int frameDuration, BufferedImage[] keyFrames)
	{
		this.frameDuration = frameDuration;
		this.keyFrames = keyFrames;
		this.playMode = PlayMode.NORMAL;
	}
	
	public Animation(int frameDuration, BufferedImage[] keyFrames, PlayMode playMode)
	{
		this.frameDuration = frameDuration;
		this.keyFrames = keyFrames;
		this.playMode = playMode;
	}
	
	// Next Frame Logic
	public void nextFrame()
	{
		switch (playMode) 
		{
		case NORMAL:
			if(currentFrame == keyFrames.length-1) { timesPlayed = 1; }
			else { currentFrame++; }
			break;
		case LOOP:
			if(currentFrame == keyFrames.length-1) 
			{ 
				currentFrame = 0;
				timesPlayed++;
			}
			else { currentFrame++; }
			break;
		case LOOP_PINGPONG:
			if(direction)
			{
				if(currentFrame == keyFrames.length-1) 
				{ 
					currentFrame--;
					direction = !direction;
					timesPlayed++;
				}
				else { currentFrame++; }
			}
			else
			{
				if(currentFrame == 0) 
				{ 
					currentFrame++;
					direction = !direction;
				}
				else { currentFrame--; }
			}
			break;
		case REVERSED:
			if(currentFrame == 0) { timesPlayed = 1; }
			else { currentFrame--; }
			break;
		case LOOP_REVERSED:
			if(currentFrame == 0) 
			{ 
				currentFrame = keyFrames.length-1;
				timesPlayed++;
			}
			else { currentFrame--; }
			break;
		}
	}
	
	// Update
	public void update()
	{
		count++;
		if(count == frameDuration)
		{
			nextFrame();
			count = 0;
		}
	}
	
	// Setters
	public void setKeyFrames(BufferedImage[] keyFrames) { this.keyFrames = keyFrames; }
	public void setFrameDuration(int frameDuration) { this.frameDuration = frameDuration; }
	public void setCurrentFrame(int currentFrame) { this.currentFrame = currentFrame; }
	public void setPlayMode(PlayMode playMode) { this.playMode = playMode; }
	
	// Getters
	public int getFrame() { return currentFrame; }
	public int getCount() { return count; }
	public BufferedImage getImage() { return keyFrames[currentFrame]; }
	public boolean hasPlayedOnce() { return timesPlayed > 0; }
	public boolean hasPlayed(int i) { return timesPlayed == i; }
}