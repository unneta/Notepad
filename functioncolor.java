package Notepad;

import java.awt.Color;

public class functioncolor 
{

	GUI gui;
	
	public functioncolor(GUI gui)
	{
		this.gui=gui;
	}
	
	public void changecolor(String color)
	{
		switch(color)
		{
		case "White":
			gui.jf.getContentPane().setBackground(Color.white);
			gui.textArea.setBackground(Color.white);
			gui.textArea.setForeground(Color.black);
			break;
		case "Red":
			gui.jf.getContentPane().setBackground(Color.red);
			gui.textArea.setBackground(Color.red);
			gui.textArea.setForeground(Color.white);
			break;
		case "Blue":
			gui.jf.getContentPane().setBackground(Color.blue);
			gui.textArea.setBackground(Color.blue);
			gui.textArea.setForeground(Color.white);
			break;
		}
	}
}
