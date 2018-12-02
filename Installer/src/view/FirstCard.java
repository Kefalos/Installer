package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.TexturePaint;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Locale;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

import controller.ActionClose;
import model.CustomParametar;
import model.PredefinedParametar;

/**
 * Sastavni deo pripreme za instalaciju
 * 
 * @author Aca
 *
 */
public class FirstCard extends JFrame
{

	private JPanel panel = new JPanel();
	private JTextArea textArea = new JTextArea();
	private JRadioButton radio1 = new JRadioButton(
			DeveloperFrame.getInstance().getResourceBundle().getString("radio1"));
	private JRadioButton radio2 = new JRadioButton(
			DeveloperFrame.getInstance().getResourceBundle().getString("radio2"));
	private JLabel labelNorth = new JLabel(DeveloperFrame.getInstance().getResourceBundle().getString("labelNorth"));
	private JLabel labelNorth1 = new JLabel(DeveloperFrame.getInstance().getResourceBundle().getString("labelNorth1"));
	private Font font = new Font("Calibri", Font.BOLD, 20);
	private Font font1 = new Font("Calibri", Font.ITALIC, 25);

	private JButton bBack = new JButton(DeveloperFrame.getInstance().getResourceBundle().getString("bBack"));
	private JButton bNext = new JButton(DeveloperFrame.getInstance().getResourceBundle().getString("bNext"));
	private JButton bCancel = new JButton(DeveloperFrame.getInstance().getResourceBundle().getString("bCancel"));
	JPanel panel1 = new JPanel();

	public FirstCard()
	{
		super();
		setSize();
		setLocationRelativeTo(null);
		setVisible(true);
		setTitle(DeveloperFrame.getInstance().getResourceBundle().getString("naslov"));
		setResizable(false);

		initialize();

	}

	private void initialize()
	{
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

		ButtonGroup group = new ButtonGroup();
		group.add(radio1);
		group.add(radio2);

		labelNorth.setFont(font);
		labelNorth1.setFont(font);
		panel.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		c.insets = new Insets(5, 5, 5, 5);

		textArea.setText(DeveloperFrame.getInstance().getResourceBundle().getString("textArea"));

		textArea.setFont(font1);
		textArea.setPreferredSize(new Dimension(900, 250));

		c.gridx = 0;
		c.gridy = 0;
		panel.add(labelNorth, c);

		c.gridx = 0;
		c.gridy = 1;
		panel.add(labelNorth1, c);

		c.gridx = 0;
		c.gridy = 2;
		panel.add(textArea, c);

		c.anchor = GridBagConstraints.WEST;
		c.gridx = 0;
		c.gridy = 3;
		panel.add(radio1, c);

		c.gridx = 0;
		c.gridy = 4;
		panel.add(radio2, c);

		panel1.setLayout(new FlowLayout(FlowLayout.RIGHT, 10, 10));
		panel1.add(bBack);
		panel1.add(bNext);
		panel1.add(bCancel);

		panel.setBackground(Color.LIGHT_GRAY);
		bBack.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent e)
			{
				Preview pw = new Preview();
				setVisible(false);

			}
		});

		bCancel.addActionListener(new ActionClose());
		bNext.setEnabled(false);

		radio1.addChangeListener(new ChangeListener()
		{

			@Override
			public void stateChanged(ChangeEvent arg0)
			{
				if (radio1.isSelected())
					bNext.setEnabled(true);

			}
		});

		bNext.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent e)
			{
				if (radio1.isSelected())
				{
					// Pravi sledeci panel
					SecondCard sc = new SecondCard();

					try
					{
						BufferedReader br;
						br = new BufferedReader(new InputStreamReader(
								new FileInputStream(new File(DeveloperFrame.getInstance().getSource()))));
						JSONTokener tokener = new JSONTokener(br);
						JSONArray allParametars = new JSONArray(tokener);
						// Petlja prolazi kroz sve parametre u json-u
						// i pravi odgovarajuce panele
						for (int i = 0; i < allParametars.length(); i++)
						{
							JSONObject tmp = (JSONObject) allParametars.get(i);
							if (tmp.getString("type").equals("custom"))
							{
								CustomParametar para = new CustomParametar(tmp.getString("name"),
										tmp.getString("description"), tmp.getString("type"), tmp.getString("value"),
										tmp.getString("loc"), tmp.getString("comboBoxOptions"),
										tmp.getBoolean("userInput"), tmp.getBoolean("hasTextFile"),
										tmp.getBoolean("comboBox"), tmp.getBoolean("hasImage"));
								// kada se naprave, paneli se dodaju u card
								// layour u SecondCard
								sc.getPanelCenter().add(new CustomPreview(para));
							} else if (tmp.getString("type").equals("predefined"))
							{
								PredefinedParametar para = new PredefinedParametar(tmp.getString("name"),
										tmp.getString("description"), tmp.getString("type"), tmp.getString("value"),
										tmp.getBoolean("companyName"), tmp.getBoolean("system"), tmp.getBoolean("logo"),
										tmp.getBoolean("langauge"), tmp.getBoolean("lookAndFeel"),
										tmp.getBoolean("version"), tmp.getBoolean("software"));
								sc.getPanelCenter().add(new PredefinedPreview(para));
							}

						}
						br.close();
					} catch (FileNotFoundException e1)
					{
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (IOException e1)
					{
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}

					sc.setVisible(true);
					dispose();
				}

			}
		});

		this.add(panel);
		this.add(panel1, BorderLayout.SOUTH);
		this.setBackground(Color.LIGHT_GRAY);

	}

	public void setSize()
	{
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		setBounds(0, 0, screenSize.width * 3 / 5, screenSize.height * 3 / 5);
	}

	public JRadioButton getRadio1()
	{
		return radio1;
	}

}
