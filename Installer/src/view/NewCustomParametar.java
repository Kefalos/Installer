package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Locale;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 * Novi prozor koji omogucava kreiranje proizvoljnog parametra
 * 
 * @author Aca
 *
 */
public class NewCustomParametar extends JFrame
{
	private JTextField tfName = new JTextField();
	private JTextArea taDescription = new JTextArea();
	private JButton bBrowse = new JButton(DeveloperFrame.getInstance().getResourceBundle().getString("bBrowse"));
	private JRadioButton rbBrowseText = new JRadioButton(
			DeveloperFrame.getInstance().getResourceBundle().getString("rbBrowseText"));
	private JRadioButton rbBrowseImage = new JRadioButton(
			DeveloperFrame.getInstance().getResourceBundle().getString("rbBrowseImage"));
	private JRadioButton rbUserInput = new JRadioButton(
			DeveloperFrame.getInstance().getResourceBundle().getString("rbUserInput"));
	private JRadioButton rbComboBox = new JRadioButton(
			DeveloperFrame.getInstance().getResourceBundle().getString("rbComboBox"));
	private JTextArea taComboBoxOptions = new JTextArea();
	private JTextField tfLocation = new JTextField();
	private JPanel pCenterParameters = new JPanel();
	private JFileChooser fc = new JFileChooser();

	public NewCustomParametar()
	{
		super();
		setSize();
		setLocationRelativeTo(null);
		setVisible(true);
		setTitle(DeveloperFrame.getInstance().getResourceBundle().getString("customParametarTitle"));

		setCenterParameters();
		add(pCenterParameters, BorderLayout.CENTER);
		add(new NewCustomParametarSouth(this), BorderLayout.SOUTH);
		tfLocation.setEditable(false);
		// BROWSE
		bBrowse.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent e)
			{
				if (fc.showOpenDialog(null) == JFileChooser.APPROVE_OPTION)
				{
					tfLocation.setText(fc.getSelectedFile().toString());
				} else
				{
					tfLocation.setText(" ");
				}
			}
		});
		bBrowse.setEnabled(false);
		rbBrowseText.addChangeListener(new ChangeListener()
		{

			@Override
			public void stateChanged(ChangeEvent e)
			{
				if (rbBrowseText.isSelected() || rbBrowseImage.isSelected())
				{
					bBrowse.setEnabled(true);
				} else
				{
					bBrowse.setEnabled(false);
				}
			}
		});
		// COMBO BOX
		taComboBoxOptions.setEditable(false);
		taComboBoxOptions.setText(DeveloperFrame.getInstance().getResourceBundle().getString("taComboBoxOptions"));

		rbComboBox.addChangeListener(new ChangeListener()
		{

			@Override
			public void stateChanged(ChangeEvent e)
			{

				if (rbComboBox.isSelected())
				{
					taComboBoxOptions.setEnabled(true);
					taComboBoxOptions.setEditable(true);
				} else
				{
					taComboBoxOptions.setEnabled(false);
					taComboBoxOptions.setEditable(false);
				}
			}
		});

	}

	private void setCenterParameters()
	{
		// RADIO DUGMAD
		ButtonGroup bg = new ButtonGroup();
		bg.add(rbBrowseText);
		bg.add(rbBrowseImage);
		bg.add(rbComboBox);
		bg.add(rbUserInput);
		// PODESAVANJE OSTALIH PARAMETARA
		tfName.setPreferredSize(new Dimension(400, 20));
		taDescription.setPreferredSize(new Dimension(400, 100));
		tfLocation.setPreferredSize(new Dimension(400, 20));
		taComboBoxOptions.setPreferredSize(new Dimension(400, 100));
		pCenterParameters.setLayout(new GridBagLayout());
		// POZICIONIRANJE
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 0;
		pCenterParameters.add(new JLabel(DeveloperFrame.getInstance().getResourceBundle().getString("name")), gbc);
		gbc.gridx = 1;
		gbc.gridy = 0;
		pCenterParameters.add(tfName, gbc);
		gbc.gridx = 0;
		gbc.gridy = 1;
		pCenterParameters.add(new JLabel(DeveloperFrame.getInstance().getResourceBundle().getString("description")),
				gbc);
		gbc.gridx = 1;
		gbc.gridy = 1;
		pCenterParameters.add(taDescription, gbc);
		gbc.gridx = 1;
		gbc.gridy = 2;
		pCenterParameters.add(new JLabel(), gbc);
		gbc.gridx = 0;
		gbc.gridy = 3;
		pCenterParameters.add(bBrowse, gbc);
		gbc.gridx = 1;
		gbc.gridy = 3;
		pCenterParameters.add(tfLocation, gbc);
		gbc.gridx = 1;
		gbc.gridy = 4;
		pCenterParameters.add(rbUserInput, gbc);
		gbc.gridx = 1;
		gbc.gridy = 5;
		pCenterParameters.add(rbBrowseText, gbc);
		gbc.gridx = 1;
		gbc.gridy = 6;
		pCenterParameters.add(rbBrowseImage, gbc);
		gbc.gridx = 1;
		gbc.gridy = 7;
		pCenterParameters.add(rbComboBox, gbc);
		gbc.gridx = 1;
		gbc.gridy = 8;
		pCenterParameters.add(taComboBoxOptions, gbc);
	}

	public void setSize()
	{
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		setBounds(0, 0, screenSize.width * 3 / 5, screenSize.height * 3 / 5);
	}

	public JTextField getTfName()
	{
		return tfName;
	}

	public void setTfName(JTextField tfName)
	{
		this.tfName = tfName;
	}

	public JTextArea getTaDescription()
	{
		return taDescription;
	}

	public void setTaDescription(JTextArea taDescription)
	{
		this.taDescription = taDescription;
	}

	public JButton getbBrowse()
	{
		return bBrowse;
	}

	public void setbBrowse(JButton bBrowse)
	{
		this.bBrowse = bBrowse;
	}

	public JRadioButton getRbUserInput()
	{
		return rbUserInput;
	}

	public void setRbUserInput(JRadioButton rbUserInput)
	{
		this.rbUserInput = rbUserInput;
	}

	public JRadioButton getRbComboBox()
	{
		return rbComboBox;
	}

	public void setRbComboBox(JRadioButton rbComboBox)
	{
		this.rbComboBox = rbComboBox;
	}

	public JTextArea getTaComboBoxOptions()
	{
		return taComboBoxOptions;
	}

	public void setTaComboBoxOptions(JTextArea taComboBoxOptions)
	{
		this.taComboBoxOptions = taComboBoxOptions;
	}

	public JTextField getTfLocation()
	{
		return tfLocation;
	}

	public void setTfLocation(JTextField tfLocation)
	{
		this.tfLocation = tfLocation;
	}

	public JPanel getpCenterParameters()
	{
		return pCenterParameters;
	}

	public void setpCenterParameters(JPanel pCenterParameters)
	{
		this.pCenterParameters = pCenterParameters;
	}

	public JFileChooser getFc()
	{
		return fc;
	}

	public void setFc(JFileChooser fc)
	{
		this.fc = fc;
	}

	public JRadioButton getRbBrowseText()
	{
		return rbBrowseText;
	}

	public void setRbBrowseText(JRadioButton rbBrowseText)
	{
		this.rbBrowseText = rbBrowseText;
	}

	public JRadioButton getRbBrowseImage()
	{
		return rbBrowseImage;
	}

	public void setRbBrowseImage(JRadioButton rbBrowseImage)
	{
		this.rbBrowseImage = rbBrowseImage;
	}

}
