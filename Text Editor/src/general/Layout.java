package general;

import java.awt.Color;
import javax.swing.JFrame;

public class Layout extends JFrame
{

	/*This class contains the main framework for the program... it sets up and formats the frame
	and embeds the menubar (inherited from the Menu class).*/
	public Layout()
	{
		TextArea textAreaPanel = new TextArea();
		Menu menuBarPanel = new Menu();

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Ben's Text Editor");
		setBackground(Color.WHITE);
		setSize(800, 650);
		setResizable(false);
		setVisible(true);
		setLocationRelativeTo(null);
		add(textAreaPanel);
		setJMenuBar(menuBarPanel);

	}

private static final long serialVersionUID = 1L;
}
