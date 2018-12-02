package model;

import java.util.ArrayList;
import java.util.Enumeration;

import javax.swing.tree.TreeNode;

/**
 * Jedan od softverskih modula Sadrzi listu parametara
 * 
 * @author Aca
 *
 */
public class Modul implements TreeNode
{
	// kolekcija dijagrama u okviru jednog projekta
	private ArrayList<Parametar> params = new ArrayList<Parametar>();
	private String name;

	public Modul(String modulName)
	{
		this.name = modulName;

	}

	public void addParametar(Parametar parametar)
	{
		params.add(parametar);
		parametar.setName(parametar.getName());
	}

	public String toString()
	{
		return name;
	}

	public Parametar getParam(int index)
	{
		return params.get(index);
	}

	public int getParamIndex(Parametar param)
	{
		return params.indexOf(param);
	}

	public int getParamCount()
	{
		return params.size();
	}

	public boolean isLeaf()
	{
		return false;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getName()
	{
		return this.name;
	}

	public TreeNode getChildAt(int arg0)
	{
		return getParam(arg0);
	}

	public int getChildCount()
	{
		return getParamCount();
	}

	public TreeNode getParent()
	{
		// TODO Auto-generated method stub
		return null;
	}

	public int getIndex(TreeNode arg0)
	{
		return getParamIndex((Parametar) arg0);
	}

	public boolean getAllowsChildren()
	{
		// TODO Auto-generated method stub
		return false;
	}

	public Enumeration children()
	{
		// TODO Auto-generated method stub
		return (Enumeration) params;
	}

	public ArrayList<Parametar> getParams()
	{
		return params;
	}

	public void setParams(ArrayList<Parametar> params)
	{
		this.params = params;
	}

}
