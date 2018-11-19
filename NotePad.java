import java.awt.event.*;
import java.io.*;
import java.awt.*;
import java.awt.datatransfer.*;


import javax.swing.*;
public class NotePad extends Frame {
	String filename;
	TextArea texta;
	Clipboard clip = getToolkit().getSystemClipboard();
	NotePad()
	{
		setLayout(new GridLayout(1,1));
		texta = new TextArea();
		add(texta);
		MenuBar mbar = new MenuBar();
		Menu MF = new Menu("file");

		MenuItem open = new MenuItem("Open");
		MenuItem save = new MenuItem("Save");
		MenuItem exit = new MenuItem("Exit");


		open.addActionListener(new Open());
		open.setShortcut(new MenuShortcut(KeyEvent.VK_L, false)); 
		MF.add(open);
		save.addActionListener(new Save());
		save.setShortcut(new MenuShortcut(KeyEvent.VK_M, false)); 
		MF.add(save);
		exit.addActionListener(new Exit());
		exit.setShortcut(new MenuShortcut(KeyEvent.VK_G, false)); 
		MF.add(exit);
		mbar.add(MF);

		Menu E = new Menu("Edit");
		MenuItem cut = new MenuItem("Cut");
		MenuItem copy = new MenuItem("Copy");
		MenuItem paste = new MenuItem("Paste");
		cut.addActionListener(new Cut());
		cut.setShortcut(new MenuShortcut(KeyEvent.VK_H, false)); 
		E.add(cut);
		copy.addActionListener(new Copy());
		copy.setShortcut(new MenuShortcut(KeyEvent.VK_A, false)); 
		E.add(copy);
		paste.addActionListener(new Paste());
		paste.setShortcut(new MenuShortcut(KeyEvent.VK_B, false));
		E.add(paste);
		mbar.add(E);


		Menu H=new Menu("help");
		MenuItem about=new MenuItem("about");
		about.addActionListener(new About());

		H.add(about);
		mbar.add(H);
		setMenuBar(mbar);

		mylistener mylist = new mylistener();
		addWindowListener(mylist);
	}



	class mylistener extends WindowAdapter
	{
		public void windowClosing (WindowEvent e)
		{
			System.exit(0);
		}
	}

	class New implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			texta.setText(" ");
			setTitle(filename);
		}
	}

	class Open implements ActionListener
	{

		public void actionPerformed(ActionEvent e)
		{
			FileDialog fd = new FileDialog(NotePad.this, "select File",FileDialog.LOAD);
			fd.show();
			if (fd.getFile()!=null)
			{
				filename = fd.getDirectory() + fd.getFile();
				setTitle(filename);
				ReadFile();
			}
			texta.requestFocus();
		}
	}

	class Save implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			FileDialog fd = new FileDialog(NotePad.this,"Save File",FileDialog.SAVE);
			fd.show();
			if (fd.getFile()!=null)
			{
				filename = fd.getDirectory() + fd.getFile();
				setTitle(filename);
				try
				{
					DataOutputStream d = new DataOutputStream(new FileOutputStream(filename));
					String line = texta.getText();
					BufferedReader br = new BufferedReader(new StringReader(line));
					while((line = br.readLine())!=null)
					{
						d.writeBytes(line + "\r\n");
						d.close();
					}
				}
				catch(Exception ex)
				{
					System.out.println("File not found");
				}
				texta.requestFocus();
			}
		}
	}

	class Exit implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			System.exit(0);
		}
	}
	void ReadFile()
	{
		BufferedReader d;
		StringBuffer sb = new StringBuffer();
		try
		{
			d = new BufferedReader(new FileReader(filename));
			String line;
			while((line=d.readLine())!=null)
				sb.append(line + "\n");
			texta.setText(sb.toString());
			d.close();
		}
		catch(FileNotFoundException fe)
		{
			System.out.println("File not Found");
		}
		catch(IOException ioe){}
	}

	class Cut implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			String sel = texta.getSelectedText();
			StringSelection ss = new StringSelection(sel);
			clip.setContents(ss,ss);
			texta.replaceRange(" ",texta.getSelectionStart(),texta.getSelectionEnd());
		}
	}

	class Copy implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			String sel = texta.getSelectedText();
			StringSelection clipString = new StringSelection(sel);
			clip.setContents(clipString,clipString);
		}
	}

	class Paste implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			Transferable cliptran = clip.getContents(NotePad.this);
			try
			{
				String sel = (String) cliptran.getTransferData(DataFlavor.stringFlavor);
				texta.replaceRange(sel,texta.getSelectionStart(),texta.getSelectionEnd());
			}
			catch(Exception exc)
			{
				System.out.println("not string flavour");
			}
		}
	}

	class About implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			JLabel label= new JLabel ("my simple editor product version 1.0.0");	
		}
	}



}

