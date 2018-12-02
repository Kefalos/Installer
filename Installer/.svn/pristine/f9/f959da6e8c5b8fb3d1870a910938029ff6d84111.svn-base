package view;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.Locale;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

//import other.AppStarter;
import controller.ActionClose;

/**
 * Sadrzi sve parametre koje je korisnik izabrao
 * 
 * @author Aca
 *
 */
public class SecondCard extends JFrame
{
	private JButton bInstall = new JButton(DeveloperFrame.getInstance().getResourceBundle().getString("bInstall"));
	private JButton bCancel = new JButton(DeveloperFrame.getInstance().getResourceBundle().getString("bCancel"));
	private JPanel panelSouth = new JPanel();
	private JPanel panelCenter = new JPanel();
	private JButton bNext = new JButton(DeveloperFrame.getInstance().getResourceBundle().getString("bNext"));
	private CardLayout card = new CardLayout();

	public SecondCard()
	{
		super();
		setSize();
		setLocationRelativeTo(null);
		setVisible(false);
		setTitle(DeveloperFrame.getInstance().getResourceBundle().getString("naslov"));
		setResizable(false);

		initialize();

	}

	private void initialize()
	{
		panelCenter.setLayout(card);
		panelSouth.setLayout(new FlowLayout(FlowLayout.RIGHT, 10, 10));
		panelSouth.add(bNext);
		panelSouth.add(bInstall);
		panelSouth.add(bCancel);

		this.add(panelCenter, BorderLayout.CENTER);
		this.add(panelSouth, BorderLayout.SOUTH);

		bNext.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent e)
			{
				card.next(panelCenter);
			}
		});
		bCancel.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent e)
			{
				dispose();
			}
		});

		bInstall.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent e)
			{

				setVisible(false);
				Installation install = new Installation();

			}
		});

	}

	public void setSize()
	{
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		setBounds(0, 0, screenSize.width * 3 / 5, screenSize.height * 3 / 5);
	}

	public JPanel getPanelCenter()
	{
		return panelCenter;
	}

	public void setPanelCenter(JPanel panelCenter)
	{
		this.panelCenter = panelCenter;
	}

}
