package view;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Locale;

import javax.imageio.ImageIO;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

import controller.ActionClose;

/**
 * Sastavni deo pripreme za instalaciju
 * 
 * @author Aca
 *
 */
public class Preview extends JFrame
{

	private JButton bBack = new JButton(DeveloperFrame.getInstance().getResourceBundle().getString("bBack"));
	private JButton bNext = new JButton(DeveloperFrame.getInstance().getResourceBundle().getString("bNext"));
	private JButton bCancel = new JButton(DeveloperFrame.getInstance().getResourceBundle().getString("bCancel"));
	JPanel panel1 = new JPanel();
	JPanel panel = new JPanel();
	JLabel lWelcome = new JLabel(DeveloperFrame.getInstance().getResourceBundle().getString("lWelcome"));
	JLabel lText = new JLabel(DeveloperFrame.getInstance().getResourceBundle().getString("lText"));
	JLabel lText1 = new JLabel(DeveloperFrame.getInstance().getResourceBundle().getString("lText1"));
	JPanel cards = new JPanel();
	BoxLayout boxlayout = new BoxLayout(panel, BoxLayout.Y_AXIS);
	Font font = new Font("Calibri", Font.BOLD, 40);
	Font font1 = new Font("Calibri", Font.ITALIC, 15);
	BufferedImage myPicture;

	public Preview()
	{
		super();
		setSize();
		initialize();

	}

	private void initialize()
	{
		setSize();
		setLocationRelativeTo(null);
		setVisible(true);
		setTitle("Installer");
		setResizable(false);

		GridBagConstraints cb = new GridBagConstraints();
		panel.setLayout(new GridBagLayout());

		cb.gridx = 3;
		cb.gridy = 0;
		panel.add(lWelcome, cb);

		cb.gridx = 3;
		cb.gridy = 2;
		panel.add(lText, cb);

		cb.gridx = 3;
		cb.gridy = 4;
		panel.add(lText1, cb);

		lWelcome.setFont(font);
		lText.setFont(font1);
		lText1.setFont(font1);

		cards.setLayout(new CardLayout());

		panel1.setLayout(new FlowLayout(FlowLayout.RIGHT, 10, 10));
		panel1.add(bBack);
		panel1.add(bNext);
		panel1.add(bCancel);

		bNext.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent e)
			{
				FirstCard fr = new FirstCard();
				setVisible(false);

			}
		});

		bCancel.addActionListener(new ActionClose());

		panel.setBackground(Color.LIGHT_GRAY);
		this.add(panel);
		this.add(panel1, BorderLayout.SOUTH);

	}

	public void setSize()
	{
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		setBounds(0, 0, screenSize.width * 3 / 5, screenSize.height * 3 / 5);
	}

	public JPanel getCards()
	{
		return cards;
	}

}
