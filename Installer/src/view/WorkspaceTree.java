package view;

import javax.swing.JTree;
import javax.swing.SwingUtilities;
import javax.swing.tree.DefaultTreeCellRenderer;
import model.Software;
import model.WorkspaceModel;

public class WorkspaceTree extends JTree
{
	public WorkspaceTree()
	{

		setCellEditor(new WorkspaceTreeEditor(this, new DefaultTreeCellRenderer()));
		setCellRenderer(new WorkspaceTreeCellRendered());
	}

	/**
	 * Dodavanje novog softvera u workspace
	 * 
	 * @param software
	 */
	public void addSoftware(Software software)
	{
		((WorkspaceModel) getModel()).addSoftware(software);
		SwingUtilities.updateComponentTreeUI(this);
	}

}
