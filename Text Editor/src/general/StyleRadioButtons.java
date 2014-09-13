package general;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class StyleRadioButtons extends JPanel implements ActionListener
{

	public StyleRadioButtons()
	{
		super(new BorderLayout());

		setVisible(true);

		sansSerif = new JRadioButton("Sans Serif");
		sansSerif.setActionCommand("SS");
		sansSerif.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 16));			//the font style of the radio button labels match the
																				//font that the text pane will become if that option
																				//is selected
		sansSerif.addActionListener(this);
		dialogInput = new JRadioButton("Dialog Input");
		dialogInput.setActionCommand("DI");
		dialogInput.setFont(new Font(Font.DIALOG_INPUT, Font.PLAIN, 16));
		dialogInput.addActionListener(this);
		timesNewRoman = new JRadioButton("Times New Roman");
		timesNewRoman.setActionCommand("TNR");
		timesNewRoman.setFont(new Font("TIMES NEW ROMAN", Font.PLAIN, 16));
		timesNewRoman.setSelected(true);										//"set selected" because that is the default font of
																				//the text editor
		timesNewRoman.addActionListener(this);

		radioButtonGroup = new ButtonGroup();									//the only purpose of a button group is to identify
																				//that only one radio button may be selected at a
																				//time (characteristic of radio buttons)... otherwise
																				//they would perform like checkboxes
		radioButtonGroup.add(sansSerif);
		radioButtonGroup.add(dialogInput);
		radioButtonGroup.add(timesNewRoman);

		JPanel radioPanel = new JPanel(new GridLayout(0, 1));
		radioPanel.add(sansSerif);
		radioPanel.add(dialogInput);
		radioPanel.add(timesNewRoman);

		add(radioPanel, BorderLayout.LINE_START);
		setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
	}

	public void actionPerformed(ActionEvent e)
	{
		String command = e.getActionCommand();

		if (command.equals("SS"))				//a switch would be used here but switches with strings are not supported until
												//Java 7 (this applies to other classes where decisions inside an action listener
												//were also implemented
		{
			Menu.fontStyle = Font.SANS_SERIF;
			textAreaMethod.changeFont();
		} else if (command.equals("DI"))
		{
			Menu.fontStyle = Font.DIALOG_INPUT;
			textAreaMethod.changeFont();
		} else
		{
			Menu.fontStyle = "TIMES NEW ROMAN";
			textAreaMethod.changeFont();
		}
	}
	
private static final long serialVersionUID = 1L;

JRadioButton sansSerif, dialogInput, timesNewRoman;
ButtonGroup radioButtonGroup;

ChangeTextMethod textAreaMethod = new ChangeTextMethod();
}
