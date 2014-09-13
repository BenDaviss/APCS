package general;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.ScrollPaneConstants;

public class TextArea extends JPanel
{

	public TextArea()
	{
		textPane = new JTextPane();
		textPane.setFont(new Font(Menu.fontStyle, Menu.boldItalicState,								//sets font characteristics to
																									//their defaults (instantiated in
																									//the Menu class)
				Menu.fontSize));
		textPane.setSize(new Dimension(800, 590));
		textPane.requestFocusInWindow();															//user can type in the pane w/o
																									//having to click inside it first
		textPane.setMargin(new Insets(5, 5, 5, 5));

		areaScrollPane = new JScrollPane(textPane);													//allows the user to type beyond
																									//the size of the windows without
																									//the text disappearing and becoming
																									//unreachable
		areaScrollPane.setBorder(BorderFactory.createEmptyBorder());
		areaScrollPane
				.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);	//only if a word is longer than the
																									//length of the page
		areaScrollPane.setPreferredSize(new Dimension(800, 590));

		setBackground(Color.white);
		setSize(800, 590);
		add(areaScrollPane);
	}
	
private static final long serialVersionUID = 1L;

public static JTextPane textPane;
JScrollPane areaScrollPane;
public static boolean fontIsBold = false;															//controls the decisions made in the
																									//Menu class
public static boolean fontIsItalic = false;
}
