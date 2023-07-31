package Notepad;

import java.awt.Font;

public class functionformat
{
	GUI gui;
	Font arial,csms,tnr;
	String selectedfont;
	
	public functionformat(GUI gui)
	{
		this.gui=gui;
	}
	
	public void wordwrap()
	{
		if(gui.wordwrapon==false)
		{
			gui.wordwrapon=true;
			gui.textArea.setLineWrap(true);
			gui.textArea.setWrapStyleWord(true);
			gui.iwrap.setText("Word Wrap: On");
		}
		
		else if(gui.wordwrapon==true)
		{
			gui.wordwrapon=false;
			gui.textArea.setLineWrap(false);
			gui.textArea.setWrapStyleWord(false);
			gui.iwrap.setText("Word Wrap: Off");
		}
		
	}
	
	public void createfont(int fontsize)
	{
		arial = new Font("Arial", Font.PLAIN, fontsize);
		csms = new Font("Comic Sans MS", Font.PLAIN, fontsize);
		tnr = new Font("Times New Roman", Font.PLAIN, fontsize);
		
		setfont(selectedfont);

	}
	
	public void setfont(String font)
	{
		selectedfont=font;
		switch(selectedfont)
		{
		case "Arial":
			gui.textArea.setFont(arial);
			break;
		case "CSMS":
			gui.textArea.setFont(csms);
			break;
		case "TNR":
			gui.textArea.setFont(tnr);
			break;

		}
	}
}