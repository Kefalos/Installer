package model;

import java.util.Enumeration;

import javax.swing.tree.TreeNode;

/**
 * Cuva sve podatke o parametrima koji ce biti napravljeni
 * 
 * @author Aca
 *
 */
public class Parametar implements TreeNode
{
	private String name;

	private String description;
	private String type;
	private String value;

	public Parametar(String paramName)
	{
		this.name = paramName;
	}

	public Parametar(String name, String description, String type, String value)
	{
		super();
		this.name = name;
		this.description = description;
		this.type = type;
		this.value = value;
	}

	public String toString()
	{
		return name;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public TreeNode getChildAt(int arg0)
	{
		return null;
	}

	public int getChildCount()
	{
		return 0;
	}

	public TreeNode getParent()
	{
		return null;
	}

	public int getIndex(TreeNode arg0)
	{
		return -1;
	}

	public boolean getAllowsChildren()
	{
		return false;
	}

	public boolean isLeaf()
	{
		return true;
	}

	public Enumeration children()
	{
		return null;
	}

	public String getDescription()
	{
		return description;
	}

	public String getType()
	{
		return type;
	}

	public String getValue()
	{
		return value;
	}

	public void setDescription(String description)
	{
		this.description = description;
	}

	public void setType(String type)
	{
		this.type = type;
	}

	public void setValue(String value)
	{
		this.value = value;
	}

}
