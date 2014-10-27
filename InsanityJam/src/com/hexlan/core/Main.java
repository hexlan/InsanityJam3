//   Class: Main.java
//  Author: Reyer Swengel
//    Date: 10/17/2014
// Summary: Creates a window and attaches Game to the window.

package com.hexlan.core;

import javax.swing.JFrame;

public class Main 
{
	public static void main(String[] args)
	{
		JFrame window = new JFrame("Elf Attack");
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.add(new Game());
		window.setResizable(false);
		window.pack();
		window.setLocationRelativeTo(null);
		window.setVisible(true);
	}
}