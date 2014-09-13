package general;


/*Ben Davis
Mr Willis
AP Computer Programming 3-4
5 September 2014

This is a text editor I made, comprised of 10 classes that are handle things like font handling, photo
insertion, printing, and even opening/saving files.  I used a JTextPane for text input, and handled page layout
with a JScrollBar.  The 'Menu' class is the largest, as it inherits JMenuBar properties and implements all other
classes that handle menu components.  Public/static variables were important in this project, as cross-class
access is vital because of the way I organized the project.  I only needed one custom method (changeFont), as most
of the functionality of the program was easily achievable with methods from the JDK.*/

public class Run
{


	//this class just tethers everything together with the main method
	public static void main(String[] args)
	{
		frame = new Layout();
	}
public static Layout frame;
}