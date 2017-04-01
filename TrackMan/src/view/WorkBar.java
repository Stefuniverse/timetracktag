package view;

import java.io.File;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.stream.Collectors;

import javafx.scene.layout.HBox;
import model.Day;
import model.Entry;
import control.ModelController;
import control.ViewController;

/**
 * implements the upper Bar
 * @author Stef
 *
 */
public class WorkBar extends HBox{

	private Day d;

	public WorkBar(Day d){
		super();
		this.d = d;
		generateVisualElements();

		File css = new File("styles/workBar.css");
		this.getStyleClass().add("workbar");
		this.getStylesheets().add("file:///"+css.getAbsolutePath().replace("\\", "/"));


	}

	private void generateVisualElements() {

		this.getChildren().clear();

		ArrayList<WorkBarEntry> arr = new ArrayList<WorkBarEntry>();

		for (Entry e : d.getEntries()){
			double m = e.getHours().getTimeInMillis() - e.getStartdate().getTimeInMillis();
			double length = (m / 86400000)*ViewController.getMasterWidth(); //calculates length relative to Bar-length
			WorkBarEntry en = new WorkBarEntry(e);
			en.setMinWidth(length);
			arr.add(en);
		}

		Comparator<WorkBarEntry> co = Comparator.comparingLong(WorkBarEntry::getStartInMillis);
		this.getChildren().addAll(arr.stream().sorted(co).collect(Collectors.toCollection(LinkedList::new)));
		return;
	}

}
