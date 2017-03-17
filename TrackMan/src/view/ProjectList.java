package view;

import java.io.File;

import org.json.JSONObject;
import control.ModelController;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;


public class ProjectList extends VBox {


	public ProjectList(){
		super();
		this.getStyleClass().add("hbox");
		File css = new File("styles/list.css");
		this.getStylesheets().add("file://"+css.getAbsolutePath());
		refreshProjectList();
	}

	public void refreshProjectList() {
		JSONObject j = ModelController.getProjectsAsJson();

		for(String i : j.keySet()){
			this.getChildren().add(new ProjectLabel(i));
		}


	}



}
