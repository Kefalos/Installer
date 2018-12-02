package view;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Locale;

import javax.swing.JButton;
import javax.swing.JPanel;

import controller.ActionCustomHelp;
import controller.ActionOKCustom;

/**
 * South panel za Custom parametar sa 3 dugmeta
 * 
 * @author Aca
 *
 */
public class NewCustomParametarSouth extends JPanel
{
	private JButton bOK = new JButton(DeveloperFrame.getInstance().getResourceBundle().getString("bOK"));
	private JButton bCancel = new JButton(DeveloperFrame.getInstance().getResourceBundle().getString("bCancel"));
	private JButton bHelp = new JButton(DeveloperFrame.getInstance().getResourceBundle().getString("bHelp"));

	public NewCustomParametarSouth(NewCustomParametar np)
	{
		super();
		this.add(bOK);
		this.add(bCancel);
		this.add(bHelp);
		setLayout(new FlowLayout(FlowLayout.RIGHT, 10, 10));
		bCancel.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent e)
			{
				np.dispose();
			}
		});
		bOK.addActionListener(new ActionOKCustom(np));
		bHelp.addActionListener(new ActionCustomHelp());
	}
}
