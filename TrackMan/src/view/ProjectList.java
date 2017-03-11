package view;

import org.json.JSONObject;

import control.ModelController;
import javafx.scene.Node;
import javafx.scene.layout.FlowPane;

public class ProjectList extends FlowPane {
	
	
	public ProjectList(){
		super();
		refreshProjectList();
	}

	public void refreshProjectList() {
		JSONObject j = ModelController.getProjectsAsJson();
		for (JSONEntries j:j JSON)
		
		
	}
	
	

}
