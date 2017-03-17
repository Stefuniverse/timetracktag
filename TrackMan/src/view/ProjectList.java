package view;

import org.json.JSONObject;
import control.ModelController;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;


public class ProjectList extends VBox {


	public ProjectList(){
		super();
		refreshProjectList();
	}

	public void refreshProjectList() {
		JSONObject j = ModelController.getProjectsAsJson();

		for(String i : j.keySet()){
			this.getChildren().add(new ProjectLabel(i));
		}


	}



}
