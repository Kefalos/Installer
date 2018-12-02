package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTree;

import controller.ActionOpenParametar;
import controller.ActionSave;
import model.Workspace;
import model.WorkspaceModel;

/**
 * Glavna klasa u kojoj se sve desava
 * 
 * @author Aca
 *
 */
public class DeveloperFrame
{
	private static DeveloperFrame instance = null;
	private ResourceBundle resourceBundle;
	private WorkspaceTree workspaceTree;
	private WorkspaceModel workspaceModel;
	private JFrame frame;
	private JDesktopPane desktop = new JDesktopPane();
	private JPanel contentPanel = new JPanel();
	private MenuBar menu;
	private PanelSouth panelSouth = new PanelSouth();
	private String source;
	private String destination;

	public DeveloperFrame()
	{
		super();

	}

	/**
	 * Za promenu jezika
	 */
	public void changeLanguage()
	{

		resourceBundle = ResourceBundle.getBundle("MessageResources.MessageResources", Locale.getDefault());
		frame.setTitle(resourceBundle.getString("naslov"));
		menu.initText();
		panelSouth.initText();
	}

	/**
	 * Ucitavanje parametara Svaka initialize() metoda u svakoj klasi ima istu
	 * svrhu
	 */
	private void initialize()
	{
		frame = new JFrame("Installer");
		// za menjanje jezika
		Locale.setDefault(new Locale("en", "US"));
		resourceBundle = ResourceBundle.getBundle("MessageResources.MessageResources", Locale.getDefault());

		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		frame.setBounds(0, 0, screenSize.width * 4 / 5, screenSize.height * 3 / 5);
		frame.setLocationRelativeTo(null);
		frame.setLocationRelativeTo(null);

		menu = new MenuBar();
		frame.setJMenuBar(menu);

		JScrollPane scroll = new JScrollPane(workspaceTree);
		scroll.setPreferredSize(new Dimension(350, 150));
		frame.add(scroll, BorderLayout.WEST);
		frame.add(contentPanel, BorderLayout.EAST);
		frame.add(desktop, BorderLayout.CENTER);

		workspaceTree.addMouseListener(new ActionOpenParametar());

		frame.add(panelSouth, BorderLayout.SOUTH);
		setDestination("C:/Program Files/");
		frame.setVisible(true);

	}

	private void initialiseWorkspaceTree()
	{
		workspaceTree = new WorkspaceTree();
		workspaceModel = new WorkspaceModel();
		workspaceTree.setModel(workspaceModel);

	}

	public static DeveloperFrame getInstance()
	{
		if (instance == null)
		{
			instance = new DeveloperFrame();
			instance.initialiseWorkspaceTree();
			instance.initialize();
		}
		return instance;
	}

	public WorkspaceTree getWorkspaceTree()
	{
		return workspaceTree;
	}

	public void setWorkspaceTree(WorkspaceTree workspaceTree)
	{
		this.workspaceTree = workspaceTree;
	}

	public WorkspaceModel getWorkspaceModel()
	{
		return workspaceModel;
	}

	public void setWorkspaceModel(WorkspaceModel workspaceModel)
	{
		this.workspaceModel = workspaceModel;
	}

	public static void setInstance(DeveloperFrame instance)
	{
		DeveloperFrame.instance = instance;
	}

	public JFrame getFrame()
	{
		return frame;
	}

	public void setFrame(JFrame f)
	{
		this.frame = f;
	}

	public JDesktopPane getDesktop()
	{
		return desktop;
	}

	public void setDesktop(JDesktopPane desktop)
	{
		this.desktop = desktop;
	}

	public JPanel getContentPanel()
	{
		return contentPanel;
	}

	public void setContentPanel(JPanel contentPanel)
	{
		this.contentPanel = contentPanel;
	}

	public ResourceBundle getResourceBundle()
	{
		return resourceBundle;
	}

	public void setResourceBundle(ResourceBundle resourceBundle)
	{
		this.resourceBundle = resourceBundle;
	}

	public String getSource()
	{
		return source;
	}

	public void setSource(String source)
	{
		this.source = source;
	}

	public String getDestination()
	{
		return destination;
	}

	public void setDestination(String destination)
	{
		this.destination = destination;
	}

}
