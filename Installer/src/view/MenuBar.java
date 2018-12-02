package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.SwingUtilities;

import controller.ActionClose;
import controller.NewModulAction;
import controller.NewSoftwareAction;
import model.Modul;

/**
 * Prikaz Menu bara sa opcijama
 * 
 * @author Aca
 *
 */
public class MenuBar extends JMenuBar
{
	private JMenu file = new JMenu(DeveloperFrame.getInstance().getResourceBundle().getString("file"));
	private JMenu help = new JMenu(DeveloperFrame.getInstance().getResourceBundle().getString("help"));
	private JMenuItem itemExit = new JMenuItem(DeveloperFrame.getInstance().getResourceBundle().getString("itemExit"));
	private JMenuItem itemAbout = new JMenuItem(
			DeveloperFrame.getInstance().getResourceBundle().getString("itemAbout"));
	private JMenuItem itemCustomParametar = new JMenuItem(
			DeveloperFrame.getInstance().getResourceBundle().getString("itemCustomParametar"));
	private JMenuItem itemPredefinedParametar = new JMenuItem(
			DeveloperFrame.getInstance().getResourceBundle().getString("itemPredefinedParametar"));
	private JMenuItem itemAddNewSoftware = new JMenuItem(
			DeveloperFrame.getInstance().getResourceBundle().getString("itemAddNewSoftware"));
	private JMenuItem itemAddNewModul = new JMenuItem(
			DeveloperFrame.getInstance().getResourceBundle().getString("itemAddNewModul"));

	public MenuBar()
	{
		initialize();
	}

	public void initialize()
	{

		file.add(itemCustomParametar);
		file.add(itemPredefinedParametar);
		file.add(itemAddNewSoftware);
		file.add(itemAddNewModul);
		file.addSeparator();
		file.add(itemExit);

		help.add(itemAbout);

		itemAbout.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent e)
			{
				About about = new About();

			}
		});

		itemPredefinedParametar.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent e)
			{
				NewPredefinedParametar parameter = new NewPredefinedParametar();

				Object m = DeveloperFrame.getInstance().getWorkspaceTree().getLastSelectedPathComponent();
				if (m instanceof Modul)
				{

					SwingUtilities.updateComponentTreeUI(DeveloperFrame.getInstance().getWorkspaceTree());
				}

			}
		});

		itemCustomParametar.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent e)
			{
				NewCustomParametar parameter = new NewCustomParametar();

			}
		});

		itemExit.addActionListener(new ActionClose());

		itemAddNewSoftware.addActionListener(new NewSoftwareAction());

		itemAddNewModul.addActionListener(new NewModulAction());

		this.add(file);
		this.add(help);

	}

	public void initText()
	{
		file.setText(DeveloperFrame.getInstance().getResourceBundle().getString("file"));
		help.setText(DeveloperFrame.getInstance().getResourceBundle().getString("help"));
		itemExit.setText(DeveloperFrame.getInstance().getResourceBundle().getString("itemExit"));
		itemAbout.setText(DeveloperFrame.getInstance().getResourceBundle().getString("itemAbout"));
		itemCustomParametar.setText(DeveloperFrame.getInstance().getResourceBundle().getString("itemCustomParametar"));
		itemPredefinedParametar
				.setText(DeveloperFrame.getInstance().getResourceBundle().getString("itemPredefinedParametar"));
		itemAddNewSoftware.setText(DeveloperFrame.getInstance().getResourceBundle().getString("itemAddNewSoftware"));
		itemAddNewModul.setText(DeveloperFrame.getInstance().getResourceBundle().getString("itemAddNewModul"));

	}
}
