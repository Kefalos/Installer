package view;

import java.awt.Component;
import java.net.URL;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JTree;
import javax.swing.tree.DefaultTreeCellRenderer;

import model.Modul;
import model.Parametar;
import model.Software;

public class WorkspaceTreeCellRendered extends DefaultTreeCellRenderer
{
	public WorkspaceTreeCellRendered()
	{
		super();
	}

	public Component getTreeCellRendererComponent(JTree tree, Object value, boolean sel, boolean expanded, boolean leaf,
			int row, boolean hasFocus)
	{
		super.getTreeCellRendererComponent(tree, value, sel, expanded, leaf, row, hasFocus);

		if (value instanceof Parametar)
		{
			URL imageURL = getClass().getResource("images/tdiagram.gif");
			Icon icon = null;
			if (imageURL != null)
				icon = new ImageIcon(imageURL);
			setIcon(icon);

		} else if (value instanceof Software)
		{
			URL imageURL = getClass().getResource("images/tproject.gif");
			Icon icon = null;
			if (imageURL != null)
				icon = new ImageIcon(imageURL);
			setIcon(icon);
		}

		else if (value instanceof Modul)
		{
			URL imageURL = getClass().getResource("images/tproject.gif");
			Icon icon = null;
			if (imageURL != null)
				icon = new ImageIcon(imageURL);
			setIcon(icon);
		}

		return this;
	}
}
