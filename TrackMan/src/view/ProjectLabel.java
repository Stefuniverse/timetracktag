package view;

import javafx.scene.layout.HBox;
import java.util.LinkedList;
import javafx.scene.control.Label;

/**
 * Builds labels for the work-on List
 *
 * @author stef
 *
 */
public class ProjectLabel extends HBox {

	Label text;

	//subactivities, not implemented
	LinkedList<String> activities;

	public ProjectLabel(String name){
		super();
		this.text = new Label(name);
		this.getChildren().add(this.text);
	}

}
