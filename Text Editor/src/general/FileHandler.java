package general;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class FileHandler extends JFrame implements ActionListener
{

	public FileHandler()
	{
		JPanel buttonPanel = new JPanel();
		JButton open = new JButton("Open");
		open.setActionCommand("Open");
		open.addActionListener(this);
		JButton save = new JButton("Save");		//buttons with action listeners in a JFrame are the only thing necessary
		save.setActionCommand("Save");
		save.addActionListener(this);
		buttonPanel.add(open);
		buttonPanel.add(save);

		setSize(200, 65);
		setResizable(false);
		setVisible(true);
		setLocationRelativeTo(null);
		add(buttonPanel);

		fc = new JFileChooser();				//default java file chooser GUI
	}

	public void actionPerformed(ActionEvent e)
	{
		String command = e.getActionCommand();	//determines whether "Open" or "Save" was Selected

		if (command.equals("Open"))
		{
			setVisible(false);

			int returnVal = fc.showOpenDialog(FileHandler.this);

			if (returnVal == JFileChooser.APPROVE_OPTION)
			{
				File file = fc.getSelectedFile();

				try {
		            s = new Scanner(new BufferedReader(new FileReader(file.getPath())));	//the file path includes
		            																		//the absolute path as well
		            																		//as the file name
		            while (s.hasNext()) {
		                TextArea.textPane.setText(s.next());								//displays the content of
		                																	//the file in the text
		                																	//pane
		            }
		        } catch (FileNotFoundException e1)
				{
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} finally {
		            if (s != null) {														//closes the scanner after
		            																		//it's finished being used
		                s.close();
		            }
		        }
			} else
			{
				System.out.println("Something went wrong");
			}
		}

		else if (command.equals("Save"))
		{
			setVisible(false);

			int returnVal = fc.showOpenDialog(FileHandler.this);

			if (returnVal == JFileChooser.APPROVE_OPTION)
			{
				File file = fc.getSelectedFile();
				System.out.println("Saved!");
			} else
			{
				System.out.println("Something went wrong");
			}
		}
	}

	private static final long serialVersionUID = 1L;
	JFileChooser fc;
	Scanner s;
}