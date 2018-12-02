package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import model.Software;
import view.DeveloperFrame;

/**
 * Sluzi za kreiranje novog softvera, naziv softvera unosi korisnik
 * 
 * @author Aca
 *
 */
public class NewSoftwareAction implements ActionListener
{

	public void actionPerformed(ActionEvent arg0)
	{
		String value = JOptionPane.showInputDialog(null,
				DeveloperFrame.getInstance().getResourceBundle().getString("inputSoftvareName"));

		Software s = new Software(value);
		DeveloperFrame.getInstance().getWorkspaceTree().addSoftware(s);

	}
}
