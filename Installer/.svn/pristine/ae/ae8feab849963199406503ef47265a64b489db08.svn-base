package model;

import javax.swing.tree.DefaultTreeModel;
import javax.swing.event.TreeModelEvent;
import javax.swing.event.TreeModelListener;

import model.Software;
import model.Workspace;

public class WorkspaceModel extends DefaultTreeModel
{
	public WorkspaceModel()
	{
		super(new Workspace());
	}

	public void addSoftware(Software software)
	{
		((Workspace) getRoot()).addSoftware(software);
	}
}
