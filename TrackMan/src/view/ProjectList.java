package view;

import java.io.File;

import org.json.JSONObject;
import control.ModelController;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;
import model.Project;


public class ProjectList extends VBox {


	public ProjectList(){
		super();
		this.getStyleClass().add("vbox");
		File css = new File("styles/list.css");
		this.getStylesheets().add("file:///"+css.getAbsolutePath().replace("\\", "/"));
		refreshProjectList();
	}

	public void refreshProjectList() {

		for(Project i : ModelController.getProjects()){
			this.getChildren().add(new ProjectLabel(i.getName()));
		}


	}



}
