package model;

import java.util.ArrayList;
import java.util.Enumeration;

import javax.swing.tree.TreeNode;

/*
 * 
 * Predstavlja softver koji sadrzi kolekciju modula
 */
public class Software implements TreeNode
{
	// kolekcija modula u okviru jednog softvera
	private ArrayList<Modul> moduls = new ArrayList<Modul>();
	private String name;

	public Software(String softwareName)
	{
		this.name = softwareName;

	}

	public ArrayList<Modul> getModuls()
	{
		return moduls;
	}

	public void setModuls(ArrayList<Modul> moduls)
	{
		this.moduls = moduls;
	}

	public String getName()
	{
		return name;
	}

	public void addModul(Modul modul)
	{
		moduls.add(modul);

	}

	public String toString()
	{
		return name;
	}

	public Modul getModul(int index)
	{
		return moduls.get(index);
	}

	public int getModulIndex(Modul modul)
	{
		return moduls.indexOf(modul);
	}

	public int getModulCount()
	{
		return moduls.size();
	}

	public boolean isLeaf()
	{
		return false;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public TreeNode getChildAt(int arg0)
	{
		return getModul(arg0);
	}

	public int getChildCount()
	{
		return getModulCount();
	}

	public TreeNode getParent()
	{
		// TODO Auto-generated method stub
		return null;
	}

	public int getIndex(TreeNode arg0)
	{
		return getModulIndex((Modul) arg0);
	}

	public boolean getAllowsChildren()
	{
		// TODO Auto-generated method stub
		return false;
	}

	public Enumeration children()
	{
		// TODO Auto-generated method stub
		return (Enumeration) moduls;
	}
}
