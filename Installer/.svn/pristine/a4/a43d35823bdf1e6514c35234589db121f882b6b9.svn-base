package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import view.DeveloperFrame;

/**
 * Akcija za izlazak iz programa
 * 
 * @author Aca
 *
 */
public class ActionClose implements ActionListener
{

	public void actionPerformed(ActionEvent e)
	{
		int value = JOptionPane.showConfirmDialog(null,
				DeveloperFrame.getInstance().getResourceBundle().getString("sure"),
				DeveloperFrame.getInstance().getResourceBundle().getString("warning"), JOptionPane.YES_NO_OPTION);
		if (value == JOptionPane.YES_OPTION)
			System.exit(0);
	}

}
