package general;

import java.awt.Font;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class Menu extends JMenuBar implements ActionListener
{
	/*The Menu class creates a myriad of menu items that are added to a Jmenubar which all point to the action
	listener implemented in this class.*/
	public Menu()
	{
		file = new JMenu("File");
		openOrSave = new JMenuItem("Open/Save");
		openOrSave.setMnemonic(KeyEvent.VK_O);		//mnemonics offer an alternative method of triggering the action
													//besides clicking
		
		openOrSave.setActionCommand("Open/Save");	//action commands separate the class action listener into different
													//parts so that it isn't necessary to create 8 more classes with
													//different action listeners
		openOrSave.addActionListener(this);
		print = new JMenuItem("Print");
		print.setMnemonic(KeyEvent.VK_P);
		print.setActionCommand("Print");
		print.addActionListener(this);
		file.setMnemonic(KeyEvent.VK_F);
		file.add(openOrSave);
		file.add(print);

		font = new JMenu("Font");
		size = new JMenuItem("Size");
		size.setMnemonic(KeyEvent.VK_S);
		size.setActionCommand("Size");
		size.addActionListener(this);
		style = new JMenuItem("Style");
		style.setMnemonic(KeyEvent.VK_T);
		style.setActionCommand("Style");
		style.addActionListener(this);
		bold = new JMenuItem("Bold");
		bold.setMnemonic(KeyEvent.VK_B);
		bold.setActionCommand("Bold");
		bold.addActionListener(this);
		italicize = new JMenuItem("Italicize");
		italicize.setMnemonic(KeyEvent.VK_I);
		italicize.setActionCommand("Italicize");
		italicize.addActionListener(this);
		font.setMnemonic(KeyEvent.VK_O);
		font.add(size);
		font.add(style);
		font.add(bold);
		font.add(italicize);

		insert = new JMenu("Insert");
		photo = new JMenuItem("Photo");
		photo.setMnemonic(KeyEvent.VK_P);
		photo.setActionCommand("Photo");
		photo.addActionListener(this);
		insert.setMnemonic(KeyEvent.VK_I);
		insert.add(photo);

		add(file);
		add(font);
		add(insert);
	}

	public void actionPerformed(ActionEvent e)
	{
		String command = e.getActionCommand();

		if (command.equals("Open/Save"))
		{
			FileHandler fh = new FileHandler();	//the other class handles it from here
		}

		else if (command.equals("Print"))
		{
			Printer printPage = new Printer();	//same as above ^
		}

		else if (command.equals("Size"))
		{
			sizeEditor = new JFrame("Size");		//sizeEditor (instantiated below) is a frame for the size editing
													//panel to but embedded in
			sizeEditor.setSize(250, 100);
			sizeEditor.setLocationRelativeTo(null);
			sizeEditor.setVisible(true);
			sizeEditor.add(sizeIndicatorPanel);
		}

		else if (command.equals("Style"))
		{
			styleEditor = new JFrame("Style");					//the style editor frame operates for the same reason
																//as the size editor frame
			JComponent contentPane = new StyleRadioButtons();
			contentPane.setOpaque(true);

			Point frameLocation = new Point(600, 275);			//for some reason, styleEditor.setLocationRelatvieTo(null)
																//bugged out, so a "Point" was used to center the
																//frame on the screen
			styleEditor.setLocation(frameLocation);
			styleEditor.setContentPane(contentPane);
			styleEditor.setSize(250, 250);
			styleEditor.setVisible(true);
		}

		else if (command.equals("Bold"))						//Bolding and italicizing was the only thing not handled
																//by another class because clicking on the menu item
																//immediately designates what action is to be taken,
																//so no other UI is necessary to prompt for additional
																//options
		{
			if (TextArea.fontIsBold && !TextArea.fontIsItalic)			//all of these blocks of decisions are necessary
																		//because the font bolding/italicization depends
																		//on whether the font is already bolded or italicized
			{
				boldItalicState = Font.PLAIN;
				textAreaMethod.changeFont();
				TextArea.fontIsBold = false;
			} else if (!TextArea.fontIsBold && TextArea.fontIsItalic)
			{
				boldItalicState = Font.BOLD + Font.ITALIC;
				textAreaMethod.changeFont();
				TextArea.fontIsBold = true;
			} else if (TextArea.fontIsBold && TextArea.fontIsItalic)
			{
				boldItalicState = Font.ITALIC;
				textAreaMethod.changeFont();
				TextArea.fontIsBold = false;
			} else
			{
				boldItalicState = Font.BOLD;
				textAreaMethod.changeFont();
				TextArea.fontIsBold = true;
			}
		}

		else if (command.equals("Italicize"))
		{
			if (TextArea.fontIsItalic && !TextArea.fontIsBold)
			{
				boldItalicState = Font.PLAIN;
				textAreaMethod.changeFont();
				TextArea.fontIsItalic = false;
			} else if (!TextArea.fontIsItalic && TextArea.fontIsBold)
			{
				boldItalicState = Font.BOLD + Font.ITALIC;
				textAreaMethod.changeFont();
				TextArea.fontIsItalic = true;
			} else if (TextArea.fontIsItalic && TextArea.fontIsBold)
			{
				boldItalicState = Font.BOLD;
				textAreaMethod.changeFont();
				TextArea.fontIsItalic = false;
			} else
			{
				boldItalicState = Font.ITALIC;
				textAreaMethod.changeFont();
				TextArea.fontIsItalic = true;
			}

		}

		else
		{
			InsertPhoto photoInserter = new InsertPhoto();	//handled by the InsertPhoto class
			photoInserter.insertPhotoInJTextPane();
		}
	}
	
private static final long serialVersionUID = 1L;

JMenu file, font, insert;
JMenuItem openOrSave, print, size, style, bold, italicize, photo;
JFrame styleEditor, sizeEditor;
public static int boldItalicState = Font.PLAIN;
public static String fontStyle = "TIMES NEW ROMAN";
public static int fontSize = 16;

ChangeTextMethod textAreaMethod = new ChangeTextMethod();

FontSizeInput sizeIndicatorPanel = new FontSizeInput();
}