package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Locale;

import javax.imageio.ImageIO;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * Klasa za prikaz podataka o clanovima tima
 * 
 * @author Aca
 *
 */
public class About extends JFrame
{

	JPanel panelNorth = new JPanel();
	JPanel panelNorth1 = new JPanel();
	JPanel panelCenter = new JPanel();
	JLabel teamName = new JLabel(DeveloperFrame.getInstance().getResourceBundle().getString("teamName"));
	JLabel first = new JLabel(DeveloperFrame.getInstance().getResourceBundle().getString("firstName"));
	JLabel second = new JLabel(DeveloperFrame.getInstance().getResourceBundle().getString("secondName"));
	JLabel third = new JLabel(DeveloperFrame.getInstance().getResourceBundle().getString("thirdName"));
	JLabel fourth = new JLabel(DeveloperFrame.getInstance().getResourceBundle().getString("fourthName"));
	JLabel projectName = new JLabel(DeveloperFrame.getInstance().getResourceBundle().getString("projectName"));
	JLabel teamLeader = new JLabel(DeveloperFrame.getInstance().getResourceBundle().getString("teamLeader"));
	JLabel teamMember1 = new JLabel(DeveloperFrame.getInstance().getResourceBundle().getString("teamLeader1"));
	JLabel teamMember2 = new JLabel(DeveloperFrame.getInstance().getResourceBundle().getString("teamLeader2"));
	JLabel teamMember3 = new JLabel(DeveloperFrame.getInstance().getResourceBundle().getString("teamLeader3"));
	Font font = new Font("Calibri", Font.BOLD, 30);
	Font font1 = new Font("Calibri", Font.ITALIC, 15);
	Font font2 = new Font("Calibri", Font.BOLD, 15);
	BoxLayout boxlayout = new BoxLayout(panelCenter, BoxLayout.Y_AXIS);
	BoxLayout boxlayout1 = new BoxLayout(panelNorth, BoxLayout.Y_AXIS);
	BufferedImage myPicture;

	public About()
	{
		super();

		setSize();
		setVisible(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		setTitle("About");

		panelCenter.setLayout(boxlayout);
		panelNorth.setLayout(boxlayout1);

		teamName.setFont(font);
		projectName.setFont(font1);

		panelNorth.add(teamName);
		panelNorth.add(projectName);
		panelNorth1.add(panelNorth);

		panelCenter.add(first);
		panelCenter.add(Box.createVerticalStrut(10));

		teamLeader.setFont(font2);
		panelCenter.add(teamLeader);
		panelCenter.add(Box.createVerticalStrut(10));
		try
		{
			myPicture = ImageIO.read(new File("Aleksandar.jpg"));
			JLabel picLabel = new JLabel(new ImageIcon(myPicture));
			Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
			picLabel.setPreferredSize(new Dimension(0, 5));
			panelCenter.add(picLabel);

		} catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		panelCenter.add(Box.createVerticalStrut(10));

		panelCenter.add(second);
		panelCenter.add(Box.createVerticalStrut(10));

		teamMember1.setFont(font2);
		panelCenter.add(teamMember1);

		panelCenter.add(Box.createVerticalStrut(10));
		try
		{
			myPicture = ImageIO.read(new File("Vuk.jpg"));
			JLabel picLabel = new JLabel(new ImageIcon(myPicture));
			Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
			picLabel.setPreferredSize(new Dimension(0, 5));
			panelCenter.add(picLabel);

		} catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		panelCenter.add(Box.createVerticalStrut(10));

		panelCenter.add(third);
		panelCenter.add(Box.createVerticalStrut(10));

		teamMember2.setFont(font2);
		panelCenter.add(teamMember2);
		panelCenter.add(Box.createVerticalStrut(10));
		try
		{
			myPicture = ImageIO.read(new File("Matija.jpg"));
			JLabel picLabel = new JLabel(new ImageIcon(myPicture));
			Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
			picLabel.setPreferredSize(new Dimension(0, 5));
			panelCenter.add(picLabel);

		} catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		panelCenter.add(Box.createVerticalStrut(10));

		panelCenter.add(fourth);
		panelCenter.add(Box.createVerticalStrut(10));

		teamMember3.setFont(font2);
		panelCenter.add(teamMember3);

		panelCenter.add(Box.createVerticalStrut(10));
		try
		{
			myPicture = ImageIO.read(new File("Andrija.jpg"));
			JLabel picLabel = new JLabel(new ImageIcon(myPicture));
			Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
			picLabel.setPreferredSize(new Dimension(0, 5));
			panelCenter.add(picLabel);

		} catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		this.add(panelNorth1, BorderLayout.NORTH);
		this.add(panelCenter, BorderLayout.CENTER);

	}

	public void setSize()
	{
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		setBounds(0, 0, screenSize.width * 3 / 8, screenSize.height * 3 / 4);
	}

}
