package general;

import java.io.File;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;

public class InsertPhoto extends JFrame
{
	public InsertPhoto()
	{
		fc = new JFileChooser();
		
		int returnVal = fc.showOpenDialog(InsertPhoto.this);			//works in the same way as the FileHandler class

		if (returnVal == JFileChooser.APPROVE_OPTION)					//it's a lot easier because the file path is the
		{																//only thing that is needed from the file chooser...
			File file = fc.getSelectedFile();							//no data needs to be scanned from files

	        String filePath = file.getPath();
		
		icon = new ImageIcon(filePath);									//uses the file path to create an image icon
		}																//which is then inserted into the text pane
		else 
		{
			System.out.println("Something went wrong");
		}
	}

	public void insertPhotoInJTextPane()
	{
		TextArea.textPane.insertIcon(icon);										//displaying an image in the textPane is very easy..
																				//the image icon is inserted at the predetermined
																				//dimension at the caret position
	}
	
private static final long serialVersionUID = 1L;

JFileChooser fc;
ImageIcon icon;
}