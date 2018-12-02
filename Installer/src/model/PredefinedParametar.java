
package model;

/**
 * Predstavlja jedan predefined parametar, sadrzi sve podatke potrebne za
 * njegovo prikazivanje
 * 
 * @author Aca
 *
 */
public class PredefinedParametar extends Parametar
{

	private boolean companyName;
	private boolean system;
	private boolean logo;
	private boolean langauge;
	private boolean lookAndFeel;
	private boolean version;
	private boolean software;

	public PredefinedParametar(String name, String description, String type, String value, boolean companyName,
			boolean system, boolean logo, boolean langauge, boolean lookAndFeel, boolean version, boolean software)
	{
		super(name, description, type, value);
		this.companyName = companyName;
		this.system = system;
		this.logo = logo;
		this.langauge = langauge;
		this.lookAndFeel = lookAndFeel;
		this.version = version;
		this.software = software;

	}

	public boolean isCompanyName()
	{
		return companyName;
	}

	public boolean isSystem()
	{
		return system;
	}

	public boolean isLogo()
	{
		return logo;
	}

	public boolean isLangauge()
	{
		return langauge;
	}

	public boolean isLookAndFeel()
	{
		return lookAndFeel;
	}

	public boolean isVersion()
	{
		return version;
	}

	public boolean isSoftware()
	{
		return software;
	}

}
