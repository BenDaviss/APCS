package general;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;

public class Printer implements Printable
{

	public int print(Graphics g, PageFormat pf, int page)
			throws PrinterException
	{
		if (page > 0)											//pages are 0-based, so this basically signifies that multiple page
																//documents are not allowed in this program
		{
			return NO_SUCH_PAGE;
		}

		Graphics2D g2 = (Graphics2D) g;
		g2.translate(pf.getImageableX(), pf.getImageableY());

		Run.frame.printAll(g);									//prints the entire contents of the frame (used because nothing
																//displayed on the screen was constructed using Graphics)

		return PAGE_EXISTS;										//(as opposed to NO_SUCH_PAGE)
	}

	public Printer()
	{
		PrinterJob job = PrinterJob.getPrinterJob();
		job.setPrintable(this);
		boolean ready = job.printDialog();
		if (ready)
		{
			try
			{
				job.print();									//you may notice that the 3 parameters identified in the "print"
																//method construction are absent... this is because the method is
																//auto-filled using input from the native operating system's default
																//printer dialog
			} catch (PrinterException ex)
			{
				System.out.println(ex);							//PrinterExceptions can occur if the printer runs out of ink or paper
			}
		}
	}

}
