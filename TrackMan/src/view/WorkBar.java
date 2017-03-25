package view;

import java.io.File;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.LinkedList;

import javafx.scene.Node;
import javafx.scene.layout.HBox;
import model.Entry;
import control.ModelController;

/**
 * implements the upper Bar
 * @author Stef
 *
 */
public class WorkBar extends HBox{

	private LinkedList<Node> workEntries;

	public WorkBar(){
		super();
		getEntriesForToday();

		File css = new File("styles/workBar.css");
		this.getStyleClass().add("workbar");
		this.getStylesheets().add("file:///"+css.getAbsolutePath().replace("\\", "/"));


	}

	private void getEntriesForToday() {

		Calendar c = Calendar.getInstance();
		c.setTimeInMillis(System.currentTimeMillis());
		return;
	}

}
