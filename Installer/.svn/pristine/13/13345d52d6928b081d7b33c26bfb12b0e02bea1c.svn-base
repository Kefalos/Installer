package view;

import java.awt.Dimension;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

import javax.imageio.ImageIO;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;

import model.CustomParametar;

/**
 * Po uzoru na CustomParametarView, prikazuje se custom parametar u preview
 * 
 * @author Aca
 *
 */
public class CustomPreview extends JPanel
{
	private String name;
	private String description;
	private String location;
	private String comboBoxOptions;
	private boolean userInput;
	private boolean hasTextFile;
	private boolean hasImage;
	private boolean comboBox;
	private CustomParametar parametarModel;

	/**
	 * 
	 * @param p
	 *            Na osnovu custom parametra iz modela pravi izgled
	 */
	public CustomPreview(CustomParametar p)
	{
		super();
		this.parametarModel = p;
		this.name = p.getName();
		this.description = p.getDescription();
		this.location = p.getLoc();
		this.userInput = p.isUserInput();
		this.hasTextFile = p.isHasTextFile();
		this.hasImage = p.isHasImage();
		this.comboBox = p.isComboBox();
		this.comboBoxOptions = p.getComboBoxOptions();
		initialize();
	}

	private void initialize()
	{
		JLabel lName = new JLabel(name);
		JTextArea taDescription = new JTextArea(description);
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		taDescription.setLineWrap(true);
		taDescription.setEnabled(false);
		JScrollPane sp = new JScrollPane(taDescription);
		sp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		sp.setMaximumSize(new Dimension(400, 100));
		this.add(lName);
		add(Box.createVerticalStrut(10));
		this.add(sp);
		if (userInput)
			userInput();
		if (hasTextFile)
			addTextFile();
		if (hasImage)
			addImage();
		if (comboBox)
			comboBox();

	}

	/**
	 * Ako je korisnik zeleo da napravi Textfield, to se ovde omogucava
	 */
	private void userInput()
	{
		JTextArea taUserInput = new JTextArea();
		taUserInput.setMaximumSize(new Dimension(400, 50));
		add(Box.createVerticalStrut(10));
		taUserInput.setLineWrap(true);
		taUserInput.setEditable(true);
		JScrollPane sp = new JScrollPane(taUserInput);
		sp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		sp.setMaximumSize(new Dimension(400, 200));
		this.add(taUserInput);
		taUserInput.setText(parametarModel.getValue());
		taUserInput.setEditable(false);
	}

	/**
	 * Ako je korisnik zeleo da doda tekstualni fajl, to se ovde omogucava
	 */
	private void addTextFile()
	{
		if (location.endsWith("txt"))
		{
			JTextArea taUserInput = new JTextArea();
			add(Box.createVerticalStrut(10));
			taUserInput.setEnabled(false);
			this.add(taUserInput);
			taUserInput.setText(readLocation());
		}
	}

	/**
	 * Pomocna metoda za citanje sa lokacije
	 * 
	 * @return Tekst ispisan u fajlu na izabranoj lokaciji
	 */
	private String readLocation()
	{

		try
		{
			BufferedReader r = new BufferedReader(new FileReader(location));
			StringBuilder text = new StringBuilder("");
			String l = null;
			while ((l = r.readLine()) != null)
			{
				text.append(l);
				text.append("\n");
			}
			return text.toString();
		} catch (FileNotFoundException e)
		{
			e.printStackTrace();
			return "";
		} catch (IOException e)
		{
			e.printStackTrace();
			return "";
		}

	}

	/**
	 * Ako je korisnik zeleo da doda sliku, to se ovde omogucava
	 */
	private void addImage()
	{
		if (location.endsWith(".jpg") || location.endsWith(".img") || location.endsWith(".jpeg")
				|| location.endsWith(".png") || location.endsWith(".gif"))
		{
			BufferedImage image;
			try
			{
				image = ImageIO.read(new File(location));
				JLabel lImage = new JLabel(new ImageIcon(image));
				lImage.setPreferredSize(new Dimension(400, 400));
				this.add(lImage);
			} catch (IOException e)
			{
				e.printStackTrace();
			}
		}

	}

	/**
	 * Ako je korisnik zeleo da napravi ComboBox, to se ovde omogucava
	 */
	private void comboBox()
	{
		if (comboBox)
		{
			JComboBox<String> cb = new JComboBox<>();
			cb.setMaximumSize(new Dimension(400, 100));
			add(Box.createVerticalStrut(10));

			StringTokenizer st = new StringTokenizer(comboBoxOptions, "\n");

			while (st.hasMoreTokens())
			{
				cb.addItem(st.nextToken());
			}
			this.add(cb);

		}
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public CustomParametar getParametarModel()
	{
		return parametarModel;
	}

	public void setParametarModel(CustomParametar parametarModel)
	{
		this.parametarModel = parametarModel;
	}

}
