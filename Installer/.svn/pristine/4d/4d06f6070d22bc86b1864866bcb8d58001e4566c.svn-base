package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.CopyOption;
import java.nio.file.Files;
import java.util.StringTokenizer;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.SwingUtilities;
import javax.swing.plaf.FileChooserUI;

import model.Parametar;

/**
 * Prozor sa progress barom, simulira zavrsetak instalacije
 * 
 * @author Aca
 *
 */
public class Installation extends JFrame
{
	private JProgressBar progBar = new JProgressBar(0, 50);
	private JLabel lProgress = new JLabel(DeveloperFrame.getInstance().getResourceBundle().getString("lProgress"));
	private JButton bFinish = new JButton(DeveloperFrame.getInstance().getResourceBundle().getString("bFinish"));
	private JLabel lComplete = new JLabel(DeveloperFrame.getInstance().getResourceBundle().getString("lComplete"));

	public Installation()
	{
		super();
		initialize();
	}

	private void initialize()
	{
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		setBounds(0, 0, screenSize.width * 1 / 4, screenSize.height * 1 / 4);
		setLocationRelativeTo(null);

		setTitle(DeveloperFrame.getInstance().getResourceBundle().getString("naslov"));
		JPanel p = new JPanel();
		p.setLayout(new BoxLayout(p, BoxLayout.Y_AXIS));

		progBar.setPreferredSize(new Dimension(screenSize.width * 1 / 4, 20));
		p.add(lProgress);
		p.add(progBar);
		p.add(bFinish);
		this.add(p);
		bFinish.setEnabled(false);
		bFinish.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent e)
			{
				dispose();

			}
		});
		setVisible(true);
		run();

	}

	private void updateBar(int percent)
	{
		progBar.setValue(percent);
	}

	private void run()
	{
		for (int i = 0; i <= 50; i++)
		{
			final int percent = i;
			if (percent == 20)
			{

				try
				{
					/**
					 * Kopira fajlove na destinaciju
					 */
					File source = new File(DeveloperFrame.getInstance().getSource());
					String s = DeveloperFrame.getInstance().getSource();

					File destination = new File(
							DeveloperFrame.getInstance().getDestination() + s.substring(s.lastIndexOf("\\")));
					Files.copy(source.toPath(), destination.toPath());
				} catch (IOException e)
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			try
			{
				SwingUtilities.invokeLater(new Runnable()
				{

					@Override
					public void run()
					{
						updateBar(percent);

					}
				});
				java.lang.Thread.sleep(100);
			} catch (InterruptedException e)
			{
				e.printStackTrace();
			}
		}
		lProgress.setText(lComplete.getText());
		bFinish.setEnabled(true);
	}
}
