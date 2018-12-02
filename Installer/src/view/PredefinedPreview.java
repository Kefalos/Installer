package view;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Locale;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;

import model.PredefinedParametar;

/**
 * Po uzoru na PredefinedParametarView, prikazuje se custom parametar u preview
 * 
 * @author Aca
 *
 */
public class PredefinedPreview extends JPanel
{

	private String name;
	private String description;
	private boolean companyName;
	private boolean system;
	private boolean logo;
	private boolean langauge;
	private boolean lookAndFeel;
	private boolean version;
	private boolean software;
	private PredefinedParametar parametarModel;

	/**
	 * 
	 * @param p
	 *            Sve podatke koje treba da prikaze uzima iz PredefinedParametar
	 */
	public PredefinedPreview(PredefinedParametar p)
	{
		super();
		this.parametarModel = p;
		this.name = p.getName();
		this.description = p.getDescription();
		this.companyName = p.isCompanyName();
		this.system = p.isSystem();
		this.logo = p.isLogo();
		this.langauge = p.isLangauge();
		this.lookAndFeel = p.isLookAndFeel();
		this.version = p.isVersion();
		this.software = p.isSoftware();

		initialize();
	}

	private void initialize()
	{
		JLabel lName = new JLabel(name);
		JTextArea taDescription = new JTextArea(description);

		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

		taDescription.setLineWrap(true);
		taDescription.setEditable(false);

		JScrollPane sp = new JScrollPane(taDescription);

		sp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		sp.setMaximumSize(new Dimension(400, 100));

		this.add(lName);

		add(Box.createVerticalStrut(10));

		this.add(sp);

		if (companyName)
		{
			EnterCompanyName();
		}

		if (system)
		{
			ChooseSystem();
		}

		if (logo)
		{
			AddLogoCompany();
		}

		if (langauge)
		{
			AddLangauge();
		}

		if (lookAndFeel)
		{
			SetLookAndFeel();
		}

		if (software)
		{
			AddYourSoftware();
		}
		if (version)
		{
			SelectVersion();
		}
	}

	/**
	 * Ako je korisnik zeleo da unese naziv kompanije
	 */
	private void EnterCompanyName()
	{
		JLabel lCompanyName = new JLabel(DeveloperFrame.getInstance().getResourceBundle().getString("lCompanyName"));

		add(Box.createHorizontalGlue());

		JTextField tCompanyName = new JTextField();

		tCompanyName.setPreferredSize(new Dimension(150, 20));

		this.add(lCompanyName);
		this.add(tCompanyName);
		tCompanyName.setText(parametarModel.getValue());
	}

	/**
	 * Omogucava izbog operativnog sistema na koji ce se program instalirait
	 */
	private void ChooseSystem()
	{
		JLabel lChooseSistem = new JLabel(DeveloperFrame.getInstance().getResourceBundle().getString("lChooseSistem"));

		add(Box.createHorizontalGlue());

		JComboBox<String> cbChooseSistem = new JComboBox<String>();

		cbChooseSistem.addItem(parametarModel.getValue());
		cbChooseSistem.setPreferredSize(new Dimension(150, 20));

		this.add(lChooseSistem);
		this.add(cbChooseSistem);
		cbChooseSistem.setEditable(false);
	}

	/**
	 * Dodavanje logoa kompanije
	 */
	private void AddLogoCompany()
	{
		JLabel lLogo = new JLabel(DeveloperFrame.getInstance().getResourceBundle().getString("lLogo"));

		add(Box.createHorizontalGlue());

		JTextField tChooseLogoField = new JTextField();
		tChooseLogoField.setEnabled(false);
		add(Box.createHorizontalGlue());

		JButton bChooseLogo = new JButton(DeveloperFrame.getInstance().getResourceBundle().getString("bChooseLogo"));

		JFileChooser LogoChoose = new JFileChooser();

		tChooseLogoField.setPreferredSize(new Dimension(150, 20));
		bChooseLogo.setPreferredSize(new Dimension(80, 20));

		bChooseLogo.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				if (LogoChoose.showOpenDialog(null) == JFileChooser.APPROVE_OPTION)
				{
					tChooseLogoField.setText(LogoChoose.getSelectedFile().toString());
					parametarModel.setValue(tChooseLogoField.getText());
				} else
				{
					tChooseLogoField.setText("");
					parametarModel.setValue("");
				}
			}
		});

		this.add(lLogo);
		this.add(tChooseLogoField);
		this.add(bChooseLogo);
	}

	/**
	 * Izbor jezika instalatora, menja se runtime
	 */
	private void AddLangauge()
	{
		JLabel lChooseLangauge = new JLabel(
				DeveloperFrame.getInstance().getResourceBundle().getString("lChooseLangauge"));

		add(Box.createHorizontalGlue());

		JComboBox<String> cbChooseLanguage = new JComboBox<>();

		cbChooseLanguage.setPreferredSize(new Dimension(150, 20));

		cbChooseLanguage.addItem(parametarModel.getValue());
		this.add(lChooseLangauge);
		this.add(cbChooseLanguage);

	}

	/**
	 * Unos verzije softvera koji se instalira
	 */
	private void SelectVersion()
	{
		JLabel lVersion = new JLabel(DeveloperFrame.getInstance().getResourceBundle().getString("lVersion"));

		add(Box.createHorizontalGlue());

		JTextField tfVersion = new JTextField();
		tfVersion.setPreferredSize(new Dimension(150, 20));

		tfVersion.setText(parametarModel.getValue());
		tfVersion.setEditable(false);
		this.add(lVersion);
		this.add(tfVersion);
	}

	private void AddYourSoftware()
	{

		JLabel lSoftware = new JLabel(DeveloperFrame.getInstance().getResourceBundle().getString("lSoftware"));

		add(Box.createHorizontalGlue());

		JTextField tSoftwareField = new JTextField();

		add(Box.createHorizontalGlue());

		JButton bSoftwareChoose = new JButton(
				DeveloperFrame.getInstance().getResourceBundle().getString("bSoftwareChoose"));

		JFileChooser SoftwareChoose = new JFileChooser();

		bSoftwareChoose.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent e)
			{
				if (SoftwareChoose.showOpenDialog(null) == JFileChooser.APPROVE_OPTION)
				{
					tSoftwareField.setText(SoftwareChoose.getSelectedFile().toString());
					parametarModel.setValue(tSoftwareField.getText());
				} else
				{
					tSoftwareField.setText("C:\\Program Files");
					parametarModel.setValue(tSoftwareField.getText());
				}
			}
		});

		this.add(lSoftware);
		this.add(tSoftwareField);
		this.add(bSoftwareChoose);
		tSoftwareField.setText(parametarModel.getValue());
		bSoftwareChoose.setEnabled(false);
	}

	/**
	 * Menjanje izgleda instalatora runtime
	 */
	private void SetLookAndFeel()
	{
		JLabel lChooseLook = new JLabel(DeveloperFrame.getInstance().getResourceBundle().getString("lChooseLook"));

		add(Box.createHorizontalGlue());

		JComboBox<String> cblookandfeel = new JComboBox<String>();

		cblookandfeel.addItem(parametarModel.getValue());

		this.add(lChooseLook);
		this.add(cblookandfeel);

	}

	public static String getLookAndFeelClassName(String nameSnippet)
	{
		LookAndFeelInfo[] plafs = UIManager.getInstalledLookAndFeels();

		for (LookAndFeelInfo info : plafs)
		{
			if (info.getName().contains(nameSnippet))
			{
				return info.getClassName();
			}
		}
		return null;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public PredefinedParametar getParametarModel()
	{
		return parametarModel;
	}

	public void setParametarModel(PredefinedParametar parametarModel)
	{
		this.parametarModel = parametarModel;
	}

}
