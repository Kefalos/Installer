package controller;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JInternalFrame;

import model.CustomParametar;
import model.Parametar;
import model.PredefinedParametar;
import view.AllParametarsView;
import view.CustomParametarView;
import view.DeveloperFrame;
import view.PredefinedParametarView;

/**
 * Ova klasa sluzi za otvaranje nekog od napravljenih parametara
 * 
 * @author Aca
 *
 */
public class ActionOpenParametar implements MouseListener
{

	@Override
	public void mouseClicked(MouseEvent e)
	{
		boolean flag = true;
		Object p = DeveloperFrame.getInstance().getWorkspaceTree().getLastSelectedPathComponent();
		if (p instanceof Parametar)
		{
			Parametar param = (Parametar) p;
			if (param.getType().equals("custom"))
			{
				CustomParametarView customParametarView = new CustomParametarView((CustomParametar) param);

				AllParametarsView parametarView = new AllParametarsView();
				parametarView.setCustomParametarView(customParametarView);
				/**
				 * Petlja prolazli kroz sve prikazane JFRAME-ove, ukoliko
				 * parametar koji zelite da otvorite nije prikazan, otvorice se
				 */
				for (JInternalFrame intFrame : DeveloperFrame.getInstance().getDesktop().getAllFrames())
				{

					if (intFrame instanceof AllParametarsView)
					{
						AllParametarsView temp = (AllParametarsView) intFrame;
						if (temp.getMyName().equals(parametarView.getMyName()))
						{
							flag = false;
							break;
						}

					}

				}
				if (flag)
				{
					DeveloperFrame.getInstance().getDesktop().add(parametarView);
				}

			}
			/**
			 * Sve isto kao i za custom
			 */
			if (param.getType().equals("predefined"))
			{
				PredefinedParametarView predefined = new PredefinedParametarView((PredefinedParametar) param);
				AllParametarsView parametarView = new AllParametarsView();
				parametarView.setPredefinedParametarView(predefined);
				for (JInternalFrame intFrame : DeveloperFrame.getInstance().getDesktop().getAllFrames())
				{

					if (intFrame instanceof AllParametarsView)
					{
						AllParametarsView temp = (AllParametarsView) intFrame;
						if (temp.getMyName().equals(parametarView.getMyName()))
						{
							flag = false;
							break;
						}

					}

				}
				if (flag)
				{
					DeveloperFrame.getInstance().getDesktop().add(parametarView);
				}
			}

		}

	}

	@Override
	public void mouseEntered(MouseEvent e)
	{

	}

	@Override
	public void mouseExited(MouseEvent e)
	{

	}

	@Override
	public void mousePressed(MouseEvent e)
	{

	}

	@Override
	public void mouseReleased(MouseEvent e)
	{
	}

}
