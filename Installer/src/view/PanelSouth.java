package view;

import java.awt.Desktop;
import java.awt.FlowLayout;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

//import controller.ActionBack;
import controller.ActionClose;
//import controller.ActionNext;
import controller.ActionSave;
import model.WorkspaceModel;

/**
 * Panel za BorderLayout.SOUTH sa dugmicima: cancel izlazi iz programa finish
 * pokrece preview
 * 
 * @author Aca
 *
 */
public class PanelSouth extends JPanel
{
	private JButton bHelp = new JButton("Help");
	private JButton bCancel = new JButton("Cancel");
	private JButton bSave = new JButton("Save");
	private JButton bFinish = new JButton("Finish");

	public PanelSouth()
	{
		super();
		initialize();

	}

	public void initialize()
	{

		setLayout(new FlowLayout(FlowLayout.RIGHT, 10, 10));

		this.add(bSave);
		this.add(bFinish);
		this.add(bHelp);
		this.add(bCancel);
		bHelp.addActionListener(new ActionListener()
		{
			
			@Override
			public void actionPerformed(ActionEvent e)
			{
				File file = new File("src/resources/Instaler help.txt");

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
		});
		bSave.addActionListener(new ActionSave());
		bCancel.addActionListener(new ActionClose());
		bFinish.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent e)
			{
				Preview pw = new Preview();

			}
		});

	}

	public void initText()
	{
		bHelp.setText(DeveloperFrame.getInstance().getResourceBundle().getString("help"));
		bCancel.setText(DeveloperFrame.getInstance().getResourceBundle().getString("bCancel"));
		bSave.setText(DeveloperFrame.getInstance().getResourceBundle().getString("bSave"));
		bFinish.setText(DeveloperFrame.getInstance().getResourceBundle().getString("bFinish"));
	}
}
