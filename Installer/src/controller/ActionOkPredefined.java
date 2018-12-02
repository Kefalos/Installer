package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

import model.CustomParametar;
import model.Modul;
import model.PredefinedParametar;
import view.DeveloperFrame;
import view.NewPredefinedParametar;

/**
 * Uzima korisnicki unos iz NewPredefinedParametar, ubacuje te vrednosti u model
 * i u drvo
 * 
 * @author Aca
 *
 */
public class ActionOkPredefined implements ActionListener
{
	private NewPredefinedParametar p;
	private Modul modul;

	public ActionOkPredefined(NewPredefinedParametar p)
	{
		super();
		this.p = p;
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		StringBuilder text = new StringBuilder("");
		boolean flag = false;

		if (p.gettName().getText().isEmpty())
		{
			text.append(DeveloperFrame.getInstance().getResourceBundle().getString("warningCustomParametarName"));
			flag = true;
		}

		if (p.getTaDescription().getText().isEmpty())
		{
			text.append(
					DeveloperFrame.getInstance().getResourceBundle().getString("warningCustomParametarDescription"));
			flag = true;
		}

		if (flag)
		{
			JOptionPane.showConfirmDialog(null, text,
					DeveloperFrame.getInstance().getResourceBundle().getString("warning"),
					JOptionPane.OK_CANCEL_OPTION);
			text.delete(0, text.length());
			flag = false;
		} else
		{

			Object m = DeveloperFrame.getInstance().getWorkspaceTree().getLastSelectedPathComponent();

			if (m instanceof Modul)
			{
				this.modul = (Modul) m;
				this.modul.addParametar(new PredefinedParametar(p.gettName().getText(), p.getTaDescription().getText(),
						"predefined", "", p.getCompanyName().isSelected(), p.getSystem().isSelected(),
						p.getLogo().isSelected(), p.getLangauge().isSelected(), p.getLookAndFeel().isSelected(),
						p.getVersion().isSelected(), p.getSoftware().isSelected()));

				SwingUtilities.updateComponentTreeUI(DeveloperFrame.getInstance().getWorkspaceTree());

				p.dispose();
			}
		}
	}
}
