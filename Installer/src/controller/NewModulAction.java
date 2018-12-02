package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

import model.Modul;
import model.Parametar;
import model.Software;
import view.DeveloperFrame;

/**
 * Sluzi za kreiranje novog softvera, naziv softvera unosi korisnik
 * @author Aca
 *
 */
public class NewModulAction implements ActionListener
{

	@Override
	public void actionPerformed(ActionEvent e)
	{

		Object s = DeveloperFrame.getInstance().getWorkspaceTree().getLastSelectedPathComponent();
		if (s  instanceof Software)
		{
			String value = JOptionPane.showInputDialog(null, DeveloperFrame.getInstance().getResourceBundle().getString("inputModulName"));

			Modul m = new Modul(value);
			((Software)s).addModul(m);

			SwingUtilities.updateComponentTreeUI(DeveloperFrame.getInstance().getWorkspaceTree());
		}
	}

}
