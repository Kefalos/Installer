package model;

import java.util.ArrayList;
import java.util.Enumeration;

import javax.swing.tree.TreeNode;

import model.Software;

/**
 * Predstavlja workspace koji sadrzi listu softvera
 * 
 * @author Aca
 *
 */
public class Workspace implements TreeNode
{

	// kolekcija projekata
	private ArrayList<Software> softwares = new ArrayList<Software>();

	public Workspace()
	{
		super();
		// TODO Auto-generated constructor stub
	}

	public String toString()
	{
		return "Workspace";
	}

	public TreeNode getChildAt(int arg0)
	{
		return getSoftware(arg0);

	}

	public int getChildCount()
	{
		return getSoftwaresCount();
	}

	public TreeNode getParent()
	{
		// TODO Auto-generated method stub
		return null;
	}

	public int getIndex(TreeNode arg0)
	{
		return getSoftwareIndex((Software) arg0);
	}

	public boolean getAllowsChildren()
	{
		// TODO Auto-generated method stub
		return true;
	}

	public boolean isLeaf()
	{
		// TODO Auto-generated method stub
		return false;
	}

	public Enumeration<Software> children()
	{
		// TODO Auto-generated method stub
		return (Enumeration<Software>) softwares;
	}

	public void addSoftware(Software software)
	{
		softwares.add(software);
	}

	public Software getSoftware(int index)
	{
		return softwares.get(index);
	}

	public int getSoftwareIndex(Software software)
	{
		return softwares.indexOf(software);
	}

	public int getSoftwaresCount()
	{
		return softwares.size();
	}

	public ArrayList<Software> getSoftwares()
	{
		return softwares;
	}

	public void setSoftwares(ArrayList<Software> softwares)
	{
		this.softwares = softwares;
	}

}
