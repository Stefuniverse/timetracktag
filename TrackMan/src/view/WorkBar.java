package view;

import java.io.File;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.stream.Collectors;

import javafx.scene.layout.HBox;
import model.Day;
import model.Entry;
import model.Project;
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
		Calendar relativeTime = Calendar.getInstance();
		relativeTime.setTimeInMillis(this.d.getDate().getTimeInMillis());
		Entry before = new Entry(ModelController.roundToDays(relativeTime));
		for (Entry e : d.getEntriesSorted()){
			double m = e.getHours().getTimeInMillis() - e.getStartdate().getTimeInMillis();
			double length = (m / 86400000)*ViewController.getMasterWidth(); //calculates length relative to Bar-length
			if(!before.getHours().equals(e.getStartdate())){
				Entry ee = new Entry(before.getHours(),e.getStartdate(),"Keine erfasste Zeit",Project.NOTTRACKED);
				double mi = ee.getHours().getTimeInMillis() - ee.getStartdate().getTimeInMillis();
				double lengthi = (mi / 86400000)*ViewController.getMasterWidth(); //calculates length relative to Bar-length
				WorkBarEntry wi = new WorkBarEntry(ee);
				wi.setMinWidth(lengthi);
				this.getChildren().add(wi);

			}
			WorkBarEntry en = new WorkBarEntry(e);
			before = e;
			en.setMinWidth(length);
			this.getChildren().add(en);

		}
		relativeTime.add(Calendar.DAY_OF_MONTH, 1);
		if (!relativeTime.equals(before.getHours())){
			Entry ee = new Entry(before.getHours(),relativeTime,"Keine erfasste Zeit",Project.NOTTRACKED);
			double mi = ee.getHours().getTimeInMillis() - ee.getStartdate().getTimeInMillis();
			double lengthi = (mi / 86400000)*ViewController.getMasterWidth(); //calculates length relative to Bar-length
			WorkBarEntry wi = new WorkBarEntry(ee);
			wi.setMinWidth(lengthi);
			this.getChildren().add(wi);
		}
		return;
	}

}
