package model;

/**
 * Predstavlja jedan custom parametar, sadrzi sve podatke potrebne za njegovo
 * prikazivanje
 * 
 * @author Aca
 *
 */
public class CustomParametar extends Parametar
{
	private String loc;
	private String comboBoxOptions;
	private boolean userInput;
	private boolean hasTextFile;
	private boolean comboBox;
	private boolean hasImage;

	public CustomParametar(String name, String description, String type, String value, String loc,
			String comboBoxOptions, boolean userInput, boolean hasTextFile, boolean comboBox, boolean hasImage)
	{
		super(name, description, type, value);
		this.loc = loc;
		this.comboBoxOptions = comboBoxOptions;
		this.userInput = userInput;
		this.hasTextFile = hasTextFile;
		this.comboBox = comboBox;
		this.hasImage = hasImage;
	}

	public String getLoc()
	{
		return loc;
	}

	public String getComboBoxOptions()
	{
		return comboBoxOptions;
	}

	public boolean isUserInput()
	{
		return userInput;
	}

	public boolean isHasTextFile()
	{
		return hasTextFile;
	}

	public boolean isComboBox()
	{
		return comboBox;
	}

	public boolean isHasImage()
	{
		return hasImage;
	}

}
