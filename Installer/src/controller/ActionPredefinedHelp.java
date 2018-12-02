package controller;

import java.awt.Desktop;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

/**
 * Klikom na dugme "help" otvara se tekstualni fajl u kome stoje uputstva za
 * kreiranje predefinisanog parametra
 * 
 * @author Aca
 *
 */
public class ActionPredefinedHelp implements ActionListener
{

	@Override
	public void actionPerformed(ActionEvent e)
	{

		File file = new File("src/resources/Predefined parametar help.txt");

		Desktop desktop = Desktop.getDesktop();
		if (file.exists())
		{
			try
			{
				desktop.open(file);
			} catch (IOException e1)
			{
				e1.printStackTrace();
			}
		} else
		{
		}
		/**
		 * Proverava da li platforma podrzava Desktop
		 */
		if (!Desktop.isDesktopSupported())
		{
			System.out.println("Desktop is not supported");
			return;
		}

	}

}
