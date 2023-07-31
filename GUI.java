package Notepad;
import javax.swing.*;
import javax.swing.event.UndoableEditEvent;
import javax.swing.event.UndoableEditListener;
import javax.swing.undo.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI implements ActionListener
{

	JFrame jf;
	JTextArea textArea;
	JScrollPane scrollpane;
	JMenuBar menubar;
	JMenu menufile, menuedit, menuformat, menucolor;
	JMenuItem inew, iopen, isave, isaveas, iexit;
	JMenuItem iwrap, ifArial,ifCSMS, ifTNR, ifs8, ifs12, ifs16, ifs20, ifs24, ifs28;
	JMenuItem ic1,ic2,ic3;
	JMenuItem iundo,iredo;
	JMenu menufont, menufontsize;
	
	boolean wordwrapon= false;
	
	UndoManager um = new UndoManager();
	
	functionfile file= new functionfile(this);
	functionformat format= new functionformat(this);
	functioncolor color= new functioncolor(this);
	functionedit edit= new functionedit(this);
	
	keyhandler kh= new keyhandler(this);
	
	public static void main(String args[]) 
	{
		new GUI();
	}
	
	public GUI()
	{
		createWindow();
		createTextArea();
		createmenubar();
		createfilemenu();
		createformatmenu();
		createcolormenu();
		createeditmenu();
		
		format.selectedfont="Arial";
		format.createfont(16);
		format.wordwrap();
		
		jf.setVisible(true);
	}
	
	public void createWindow() 
	{
		jf= new JFrame("Notepad");
		jf.setSize(800,600);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void createTextArea()
	{
		textArea = new JTextArea();
		
		textArea.addKeyListener(kh);
		
		textArea.getDocument().addUndoableEditListener(
				new UndoableEditListener() {
					public void undoableEditHappened(UndoableEditEvent e) {
						um.addEdit(e.getEdit());
					}		
		});
		
		scrollpane =new JScrollPane (textArea, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollpane.setBorder(BorderFactory.createEmptyBorder());
		jf.add(scrollpane);
	}
	
	public void createmenubar()
	{
		menubar= new JMenuBar();
		jf.setJMenuBar(menubar);
		
		menufile= new JMenu("File");
		menubar.add(menufile);
		
		menuedit= new JMenu("Edit");
		menubar.add(menuedit);
		
		menuformat= new JMenu("Format");
		menubar.add(menuformat);
		
		menucolor= new JMenu("Color");
		menubar.add(menucolor);
	}
	
	public void createfilemenu()
	{
		inew= new JMenuItem("New");
		inew.addActionListener(this);
		inew.setActionCommand("New");
		menufile.add(inew);
		
		iopen= new JMenuItem("Open");
		iopen.addActionListener(this);
		iopen.setActionCommand("Open");
		menufile.add(iopen);
		
		isave= new JMenuItem("Save");
		isave.addActionListener(this);
		isave.setActionCommand("Save");
		menufile.add(isave);
		
		isaveas= new JMenuItem("Save As");
		isaveas.addActionListener(this);
		isaveas.setActionCommand("SaveAs");
		menufile.add(isaveas);
		
		iexit= new JMenuItem("Exit");
		iexit.addActionListener(this);
		iexit.setActionCommand("Exit");
		menufile.add(iexit);
	}
	
	public void createformatmenu()
	{
		iwrap= new JMenuItem("Word Wrap: Off");
		iwrap.addActionListener(this);
		iwrap.setActionCommand("Wordwrap");
		menuformat.add(iwrap);
		
		menufont = new JMenu("Font");
		menuformat.add(menufont);
		
		menufontsize= new JMenu("Font size");
		menuformat.add(menufontsize);
		
		ifArial = new JMenuItem("Arial");
		ifArial.addActionListener(this);
		ifArial.setActionCommand("Arial");
		menufont.add(ifArial);
		
		ifCSMS = new JMenuItem("Comic Sans MS");
		ifCSMS.addActionListener(this);
		ifCSMS.setActionCommand("CSMS");
		menufont.add(ifCSMS);
		
		ifTNR = new JMenuItem("Times New Roman");
		ifTNR.addActionListener(this);
		ifTNR.setActionCommand("TNR");
		menufont.add(ifTNR);
		
		ifs8 = new JMenuItem("8");
		ifs8.addActionListener(this);
		ifs8.setActionCommand("8");
		menufontsize.add(ifs8);
		
		ifs12 = new JMenuItem("12");
		ifs12.addActionListener(this);
		ifs12.setActionCommand("12");
		menufontsize.add(ifs12);
		
		ifs16 = new JMenuItem("16");
		ifs16.addActionListener(this);
		ifs16.setActionCommand("16");
		menufontsize.add(ifs16);
		
		ifs20 = new JMenuItem("20");
		ifs20.addActionListener(this);
		ifs20.setActionCommand("20");
		menufontsize.add(ifs20);
		
		ifs24 = new JMenuItem("24");
		ifs24.addActionListener(this);
		ifs24.setActionCommand("24");
		menufontsize.add(ifs24);
		
		ifs28 = new JMenuItem("28");
		ifs28.addActionListener(this);
		ifs28.setActionCommand("28");
		menufontsize.add(ifs28);
	
	}
	
	public void createcolormenu()
	{
		
		ic1= new JMenuItem("White");
		ic1.addActionListener(this);
		ic1.setActionCommand("White");
		menucolor.add(ic1);
		
		ic2= new JMenuItem("Red");
		ic2.addActionListener(this);
		ic2.setActionCommand("Red");
		menucolor.add(ic2);
		
		ic3= new JMenuItem("Blue");
		ic3.addActionListener(this);
		ic3.setActionCommand("Blue");
		menucolor.add(ic3);
		
		
	}
	
	public void createeditmenu()
	{
		iundo= new JMenuItem("Undo");
		iundo.addActionListener(this);
		iundo.setActionCommand("Undo");
		menuedit.add(iundo);
		
		iredo= new JMenuItem("Redo");
		iredo.addActionListener(this);
		iredo.setActionCommand("Redo");
		menuedit.add(iredo);
	
	}

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String command = e.getActionCommand();
		
		switch(command)
		{
		 case "New": file.newFile(); break;
		 case "Open": file.open(); break;
		 case "SaveAs": file.saveAs(); break;
		 case "Save":file.save(); break;
		 case "Exit":file.exit();break;
		 case "Wordwrap": format.wordwrap(); break;
		 case "8": format.createfont(8);break;
		 case "12": format.createfont(12);break;
		 case "16": format.createfont(16);break;
		 case "20": format.createfont(20);break;
		 case "24": format.createfont(24);break;
		 case "28": format.createfont(28);break;
		 case "Arial": format.setfont(command);break;
		 case "CSMS": format.setfont(command);break;
		 case "TNR": format.setfont(command);break;
		 case "White": color.changecolor(command);break;
		 case "Red": color.changecolor(command);break;
		 case "Blue": color.changecolor(command);break;
		 case "Undo": edit.undo();break;
		 case "Redo": edit.redo();break;
		}
		
	}
	
	 
	
	
		
		
		
	
	
}
