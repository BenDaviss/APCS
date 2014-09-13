package general;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class FontSizeInput extends JPanel implements ActionListener
{

	public FontSizeInput()
	{
		setLocation(0, 0);
		setSize(250, 125);
		setVisible(true);

		sizeInput = new JTextField(String.valueOf(Menu.fontSize));
		sizeInput.setCaretPosition(2);
		sizeInput.addActionListener(this);
		sizeInput.setColumns(2);									//formats the text field where you enter size

		enter = new JButton("Enter");
		enter.setPreferredSize(new Dimension(80, 19));
		enter.addActionListener(this);

		add(sizeInput);
		add(enter);
	}

	public void actionPerformed(ActionEvent e)
	{
		int requestedTextSize = Integer.parseInt(sizeInput.getText());	//changes the string the user entered into a workable int
																		//and sets the static fontSize from the Menu class to what
																		//they desired
		Menu.fontSize = requestedTextSize;
		textAreaMethod.changeFont();									//invokes "changeFont" to update the display
	}
	
	private static final long serialVersionUID = 1L;

	JTextField sizeInput;
	JButton enter;

	ChangeTextMethod textAreaMethod = new ChangeTextMethod();

}
