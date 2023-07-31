package Notepad;

public class functionedit
{
	GUI gui;
	
	public functionedit(GUI gui)
	{
		this.gui=gui;
	}
	
	public void undo()
	{
		gui.um.undo();
	}
	
	public void redo()
	{
		gui.um.redo();
	}
}
