//   Class: Input.java
//  Author: Reyer Swengel
//    Date: 10/17/2014
// Summary: "Static" class for tracking keyboard state.

package com.hexlan.utils;

import java.util.ArrayList;
import java.util.HashMap;

public class Input 
{
	private static ArrayList<Integer> indices = new ArrayList<Integer>();
	
	private static HashMap<Integer, Boolean> keys = new HashMap<Integer, Boolean>();
	private static HashMap<Integer, Boolean> prevkeys = new HashMap<Integer, Boolean>();
	
	public static void update()
	{
		for(int i = 0; i < indices.size(); i++)
		{
			prevkeys.put(indices.get(i), keys.get(indices.get(i)));
		}
	}
	
	public static void setKey(int i, boolean b) 
	{ 
		if(keys.containsKey(i))
		{
			keys.put(i, b);
		}
		else
		{
			indices.add(i);
			keys.put(i, b);
			prevkeys.put(i, !b);
		}
	}
	
	public static boolean isDown(int i) 
	{ 
		if(!keys.containsKey(i))
		{
			setKey(i, false);
		}
		return keys.get(i); 
	}
	
	public static boolean isPressed(int i) 
	{ 
		if(!keys.containsKey(i))
		{
			setKey(i, false);
		}
		return keys.get(i) && !prevkeys.get(i); 
	}
	
	public static boolean isReleased(int i) 
	{ 
		if(!keys.containsKey(i))
		{
			setKey(i, false);
		}
		return !keys.get(i) && prevkeys.get(i); 
	}
}