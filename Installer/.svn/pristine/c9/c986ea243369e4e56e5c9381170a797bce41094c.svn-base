package view;

import javax.swing.JInternalFrame;
import javax.swing.JPanel;

import model.CustomParametar;
import model.Parametar;
import model.PredefinedParametar;

/**
 * Klasa koja sluzi da prikaze napravljene parametre u glavnom prozoru sa desne
 * strane Klasa je izmenjena Zeceviceva klasa sa materijala
 * 
 * @author Aca
 *
 */
public class AllParametarsView extends JInternalFrame
{

	/**
	 * Da se prozori ne bi otvarali jedan tacno preko drugog svaki sledeci
	 * otvoreni se pomeri
	 */
	static int openFrameCount = 0;
	// pozicija prozora
	static final int xOffset = 30, yOffset = 30;

	private CustomParametarView custom;
	private PredefinedParametarView predefined;
	// framework nam predstavlja radnu povrsinu za dijagram
	// ne moze direktno iscrtavanje

	private String myName;

	public AllParametarsView()
	{

		super("", true, // resizable
				true, // closable
				true, // maximizable
				true);// iconifiable
		++openFrameCount;
		setLocation(xOffset * openFrameCount, yOffset * openFrameCount);
		setIconifiable(true);
		setClosable(true);

		setSize(400, 400);
		setVisible(true);

	}

	public void setPredefinedParametarView(PredefinedParametarView p)
	{
		this.predefined = p;
		this.add(predefined);
		this.myName = p.getName();

		setTitle(p.getName());
	}

	public PredefinedParametarView getPredefinedParametarView()
	{
		return predefined;
	}

	public void setCustomParametarView(CustomParametarView p)
	{
		this.custom = p;
		this.add(custom);
		this.myName = p.getName();

		setTitle(p.getName());
	}

	public CustomParametarView getCustomParametarView()
	{
		return custom;
	}

	public String getMyName()
	{
		return myName;
	}

	public void setMyName(String myName)
	{
		this.myName = myName;
	}

}
