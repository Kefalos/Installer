package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

import model.CustomParametar;
import model.Modul;
import model.PredefinedParametar;
import view.NewCustomParametar;
import view.DeveloperFrame;
import view.Installation;

/**
 * Akcija koja vrsi sve provere pre nego sto pokupi korisnicki unos i od svega
 * toga napravi novi proizvoljni parametar
 * 
 * @author Aca
 *
 */
public class ActionOKCustom implements ActionListener
{

	private NewCustomParametar pView;
	private Modul modul;

	public ActionOKCustom(NewCustomParametar pView)
	{
		super();
		this.pView = pView;
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		StringBuilder text = new StringBuilder("");
		boolean flag = false;
		/*
		 * if
		 * (Model.getInstance().getParametars().containsKey(pView.getTfName().
		 * getText())) { text.
		 * append("The name already exists!\n Choose another name, please!\n");
		 * }
		 */
		if (pView.getTfName().getText().isEmpty())
		{
			text.append(DeveloperFrame.getInstance().getResourceBundle().getString("warningCustomParametarName"));
			flag = true;
		}
		if (pView.getTaDescription().getText().isEmpty())
		{
			text.append(
					DeveloperFrame.getInstance().getResourceBundle().getString("warningCustomParametarDescription"));
			flag = true;
		}
		if (pView.getRbBrowseText().isSelected()
				&& (pView.getTfLocation().getText().isEmpty() || !pView.getTfLocation().getText().endsWith(".txt")))
		{
			text.append(DeveloperFrame.getInstance().getResourceBundle().getString("warningCustomParametarFile"));
			flag = true;
		}
		if (pView.getRbBrowseImage().isSelected()
				&& (pView.getTfLocation().getText().isEmpty() || (!pView.getTfLocation().getText().endsWith(".img")
						&& !pView.getTfLocation().getText().endsWith(".png")
						&& !pView.getTfLocation().getText().endsWith(".gif")
						&& !pView.getTfLocation().getText().endsWith(".jpg")
						&& !pView.getTfLocation().getText().endsWith(".jpeg"))))
		{
			text.append(DeveloperFrame.getInstance().getResourceBundle().getString("warningCustomParametarImg"));
			flag = true;
		}
		if (pView.getRbComboBox().isSelected() && pView.getTaComboBoxOptions().getText().isEmpty())
		{
			text.append(DeveloperFrame.getInstance().getResourceBundle().getString("warningCustomParametarCB"));
			flag = true;
		}
		if (!pView.getRbComboBox().isSelected() && !pView.getRbUserInput().isSelected()
				&& !pView.getRbBrowseText().isSelected() && !pView.getRbBrowseText().isSelected()
				&& !pView.getRbBrowseImage().isSelected())
		{
			text.append(DeveloperFrame.getInstance().getResourceBundle().getString("warningCustomParametarOption"));
			flag = true;
		}
		if (flag)
		{
			JOptionPane.showConfirmDialog(null, text,
					DeveloperFrame.getInstance().getResourceBundle().getString("warning"),
					JOptionPane.OK_CANCEL_OPTION);
			text.delete(0, text.length());
			flag = false;
		} else // Ako prodje sve provere novi parametar se dodaje u drvo
		{

			Object m = DeveloperFrame.getInstance().getWorkspaceTree().getLastSelectedPathComponent();

			if (m instanceof Modul)
			{
				this.modul = (Modul) m;
				this.modul.addParametar(
						new CustomParametar(pView.getTfName().getText(), pView.getTaDescription().getText(), "custom",
								"", pView.getTfLocation().getText(), pView.getTaComboBoxOptions().getText(),
								pView.getRbUserInput().isSelected(), pView.getRbBrowseText().isSelected(),
								pView.getRbComboBox().isSelected(), pView.getRbBrowseImage().isSelected()));

				SwingUtilities.updateComponentTreeUI(DeveloperFrame.getInstance().getWorkspaceTree());

				pView.dispose();

			}
		}
	}
}
