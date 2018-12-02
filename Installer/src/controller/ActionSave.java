package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;

import javax.swing.JFileChooser;
import javax.swing.tree.TreeModel;

import org.json.JSONArray;
import org.json.JSONObject;

import model.CustomParametar;
import model.Modul;
import model.PredefinedParametar;
import model.Software;
import view.DeveloperFrame;

/**
 * Sluzi za snimanje instalacionih paketa na zeljenu destinaciju
 * 
 * @author Aca
 *
 */
public class ActionSave implements ActionListener
{

	public ActionSave()
	{
		super();

	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		printJson(DeveloperFrame.getInstance().getWorkspaceTree().getModel(),
				DeveloperFrame.getInstance().getWorkspaceTree().getModel().getRoot());
	}

	private static void printJson(TreeModel model, Object object)
	{
		Software s = (Software) model.getChild(object, 0);
		JSONObject parametarJson = new JSONObject();
		JSONArray parametri = new JSONArray();
		for (Modul m : s.getModuls()) // prolazi kroz svaki modul
		{
			for (int paraIdx = 0; paraIdx < m.getParamCount(); paraIdx++) // prolazi
																			// kroz
																			// sve
																			// parametre
																			// u
																			// modulu
			{
				if (m.getParam(paraIdx).getType().equals("custom"))
				{
					// Ako je value prazno, preskace parametar
					if (m.getParam(paraIdx).getValue().equals(""))
					{
						continue;
					} else
					{

						CustomParametar para = (CustomParametar) m.getParam(paraIdx);
						JSONObject paraJson = new JSONObject();
						paraJson.put("name", para.getName());
						paraJson.put("description", para.getDescription());
						paraJson.put("type", para.getType());
						paraJson.put("value", para.getValue());
						paraJson.put("loc", para.getLoc());
						paraJson.put("comboBoxOptions", para.getComboBoxOptions());
						paraJson.put("userInput", para.isUserInput());
						paraJson.put("hasTextFile", para.isHasTextFile());
						paraJson.put("comboBox", para.isComboBox());
						paraJson.put("hasImage", para.isHasImage());
						parametri.put(paraJson);
					}
				} else
				{

					if (m.getParam(paraIdx).getValue().equals(""))
					{
						continue;
					} else
					{

						PredefinedParametar para = (PredefinedParametar) m.getParam(paraIdx);
						JSONObject paraJson = new JSONObject();
						paraJson.put("name", para.getName());
						paraJson.put("description", para.getDescription());
						paraJson.put("type", para.getType());
						paraJson.put("value", para.getValue());
						paraJson.put("companyName", para.isCompanyName());
						paraJson.put("system", para.isSystem());
						paraJson.put("logo", para.isLogo());
						paraJson.put("langauge", para.isLangauge());
						paraJson.put("lookAndFeel", para.isLookAndFeel());
						paraJson.put("version", para.isVersion());
						paraJson.put("software", para.isSoftware());
						parametri.put(paraJson);
					}
				}

			}
		}

		// biranje destinacije i pravljenje fajla
		JFileChooser saveLocation = new JFileChooser();
		int retrival = saveLocation.showSaveDialog(null);
		if (retrival == JFileChooser.APPROVE_OPTION)
		{
			try
			{
				File location = saveLocation.getSelectedFile();
				if (!location.toString().endsWith(".json"))
				{
					if (location.toString().contains("."))
					{
						location = new File(
								location.getPath().substring(0, location.toString().indexOf('.')) + ".json");
					} else
						location = new File(location.getPath() + ".json");
				}
				// source je izvor instalacionih paketa
				DeveloperFrame.getInstance().setSource(location.getPath());
				System.out.println(DeveloperFrame.getInstance().getSource());
				FileWriter fw = new FileWriter(location);
				fw.write(parametri.toString());
				fw.close();
			} catch (Exception ex)
			{
				ex.printStackTrace();
			}
		}
	}
}