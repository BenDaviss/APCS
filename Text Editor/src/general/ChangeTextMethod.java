package general;

import java.awt.Font;

public class ChangeTextMethod
{

	public ChangeTextMethod()
	{

	}

	public void changeFont()
	{
		TextArea.textPane.setFont(new Font(Menu.fontStyle,		//for some reason, the program crashed if this method was not kept
																//in a class other than "TextArea" (which would have been ideal)
				Menu.boldItalicState, Menu.fontSize));
	}
}