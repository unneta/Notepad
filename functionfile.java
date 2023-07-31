package Notepad;
import java.awt.FileDialog;
import java.io.*;
public class functionfile
{
	GUI gui;
	String filename;
	String fileaddress;
	
	public functionfile (GUI gui)
	{
		this.gui= gui;
	}
	
	public void newFile()
	{
		gui.textArea.setText("");
		gui.jf.setTitle("New");
		filename=null;
		fileaddress=null;
	}
	
	public void open()
	{
		FileDialog fd = new FileDialog(gui.jf, "Open", FileDialog.LOAD);
		fd.setVisible(true);
		
		if(fd.getFile()!=null)
		{
			filename = fd.getFile();
			fileaddress= fd.getDirectory();
			gui.jf.setTitle(filename);
		}
		System.out.println("File Address and File Name"+ fileaddress + filename);

		
		try
		{
			BufferedReader br= new BufferedReader(new FileReader(fileaddress+filename));
			
			gui.textArea.setText("");
			
			String line  =null;
			
			while((line= br.readLine())!=null)
			{
				gui.textArea.append(line + "\n");
			}
			
			br.close();
		}
		
		catch(Exception e)
		{
			System.out.println("File Not Opened");
		}
	}
	
	public void save()
	{
		if(filename==null)
			saveAs();
		else
		{
			try
			{
				FileWriter fw= new FileWriter(fileaddress+filename);
				fw.write(gui.textArea.getText());
				gui.jf.setTitle(filename);
				fw.close();
				
			}
			
			catch(Exception e)
			{
				System.out.println("Something Wrong!");
			}		
			
		
		}
	}
	
	
	public void saveAs()
	{
		FileDialog fd = new FileDialog(gui.jf, "Save", FileDialog.SAVE);
		fd.setVisible(true);
		
		if(fd.getFile()!=null)
		{
			filename = fd.getFile();
			fileaddress= fd.getDirectory();
			gui.jf.setTitle(filename);
		}
		
		try
		{
			FileWriter fw= new FileWriter(fileaddress+filename);
			fw.write(gui.textArea.getText());
			fw.close();
			
		}
		
		catch(Exception e)
		{
			System.out.println("Something Wrong!");
		}
	}
	
	public void exit()
	{
		System.exit(0);
	}
	
}