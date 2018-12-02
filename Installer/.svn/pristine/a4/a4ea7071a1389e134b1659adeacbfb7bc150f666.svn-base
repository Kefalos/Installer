package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Locale;

import javax.swing.Box;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 * Novi prozor koji omogucava biranje jednog od predefinisanih parametara
 * 
 * @author Aca
 *
 */
public class NewPredefinedParametar extends JFrame
{

	private JTextField tName = new JTextField();
	private JTextArea taDescription = new JTextArea();
	private JRadioButton companyName = new JRadioButton(
			DeveloperFrame.getInstance().getResourceBundle().getString("companyName"));
	private JRadioButton system = new JRadioButton(
			DeveloperFrame.getInstance().getResourceBundle().getString("system"));
	private JRadioButton logo = new JRadioButton(DeveloperFrame.getInstance().getResourceBundle().getString("logo"));
	private JRadioButton langauge = new JRadioButton(
			DeveloperFrame.getInstance().getResourceBundle().getString("langauge"));
	private JRadioButton lookAndFeel = new JRadioButton(
			DeveloperFrame.getInstance().getResourceBundle().getString("lookAndFeel"));
	private JRadioButton version = new JRadioButton(
			DeveloperFrame.getInstance().getResourceBundle().getString("version"));
	private JRadioButton software = new JRadioButton(
			DeveloperFrame.getInstance().getResourceBundle().getString("software"));
	private JPanel parametars = new JPanel();

	public NewPredefinedParametar()
	{
		super();
		setSize();
		setLocationRelativeTo(null);
		setVisible(true);
		setTitle(DeveloperFrame.getInstance().getResourceBundle().getString("predefinedParametarTitle"));

		setParametars();
		add(parametars, BorderLayout.CENTER);
		add(new NewPredefinedParametarSouth(this), BorderLayout.SOUTH);

	}

	private void setParametars()
	{
		tName.setPreferredSize(new Dimension(300, 20));
		taDescription.setPreferredSize(new Dimension(300, 100));
		parametars.setLayout(new GridBagLayout());
		ButtonGroup bg = new ButtonGroup();
		bg.add(this.companyName);
		bg.add(this.langauge);
		bg.add(this.logo);
		bg.add(this.lookAndFeel);
		bg.add(this.software);
		bg.add(this.system);
		bg.add(this.version);
		GridBagConstraints c = new GridBagConstraints();
		c.insets = new Insets(5, 5, 5, 5);
		c.gridx = 1;
		c.gridy = 0;
		parametars.add(tName, c);

		c.gridx = 0;
		c.gridy = 0;
		parametars.add(new JLabel(DeveloperFrame.getInstance().getResourceBundle().getString("name")), c);

		c.gridx = 1;
		c.gridy = 1;
		parametars.add(taDescription, c);

		c.gridx = 0;
		c.gridy = 1;
		parametars.add(new JLabel(DeveloperFrame.getInstance().getResourceBundle().getString("description")), c);

		c.gridx = 0;
		c.gridy = 2;
		parametars.add(
				new JLabel(DeveloperFrame.getInstance().getResourceBundle().getString("predefinedParametarTitle")), c);

		c.gridx = 1;
		c.gridy = 3;
		parametars.add(companyName, c);

		c.gridx = 1;
		c.gridy = 7;
		parametars.add(logo, c);

		c.gridx = 1;
		c.gridy = 4;
		parametars.add(system, c);

		c.gridx = 2;
		c.gridy = 3;
		parametars.add(software, c);

		c.gridx = 1;
		c.gridy = 5;
		parametars.add(version, c);

		c.gridx = 2;
		c.gridy = 4;
		parametars.add(lookAndFeel, c);

		c.gridx = 1;
		c.gridy = 6;
		parametars.add(langauge, c);

	}

	public void setSize()
	{
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		setBounds(0, 0, screenSize.width * 3 / 5, screenSize.height * 3 / 5);
	}

	public JTextField gettName()
	{
		return tName;
	}

	public void settName(JTextField tName)
	{
		this.tName = tName;
	}

	public JTextArea getTaDescription()
	{
		return taDescription;
	}

	public void setTaDescription(JTextArea taDescription)
	{
		this.taDescription = taDescription;
	}

	public JRadioButton getCompanyName()
	{
		return companyName;
	}

	public void setCompanyName(JRadioButton companyName)
	{
		this.companyName = companyName;
	}

	public JRadioButton getSystem()
	{
		return system;
	}

	public void setSystem(JRadioButton system)
	{
		this.system = system;
	}

	public JRadioButton getLogo()
	{
		return logo;
	}

	public void setLogo(JRadioButton logo)
	{
		this.logo = logo;
	}

	public JRadioButton getLangauge()
	{
		return langauge;
	}

	public void setLangauge(JRadioButton langauge)
	{
		this.langauge = langauge;
	}

	public JRadioButton getLookAndFeel()
	{
		return lookAndFeel;
	}

	public void setLookAndFeel(JRadioButton lookAndFeel)
	{
		this.lookAndFeel = lookAndFeel;
	}

	public JRadioButton getVersion()
	{
		return version;
	}

	public void setVersion(JRadioButton version)
	{
		this.version = version;
	}

	public JRadioButton getSoftware()
	{
		return software;
	}

	public void setSoftware(JRadioButton software)
	{
		this.software = software;
	}

	public JPanel getParametars()
	{
		return parametars;
	}

	public void setParametars(JPanel parametars)
	{
		this.parametars = parametars;
	}

}
