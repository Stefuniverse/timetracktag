package control;

import java.util.Calendar;

import Exceptions.DayNotFoundException;
import Exceptions.InvalidEntryException;
import Exceptions.SlotAllreadyInUseException;
import model.Day;
import model.Project;

public class Main{

	public static void main(String[] args) {

		//Some simple Testdata
		Project p = new Project("Arbeit","#c0c0c0",true);
		ModelController.addProject(p);
		Calendar c = Calendar.getInstance();
		Calendar d = Calendar.getInstance();
		c.setTimeInMillis(ModelController.getToday().getDate().getTimeInMillis());
		c.add(Calendar.HOUR, 4);
		d.setTimeInMillis(ModelController.getToday().getDate().getTimeInMillis());
		d.add(Calendar.HOUR, 8);
		try {
			ModelController.getToday().createEntry(p, c, d, "Activiy a");
		c = Calendar.getInstance();
		d = Calendar.getInstance();
		c.setTimeInMillis(ModelController.getToday().getDate().getTimeInMillis());
		c.add(Calendar.HOUR, 15);
		d.setTimeInMillis(ModelController.getToday().getDate().getTimeInMillis());
		d.add(Calendar.HOUR, 16);
		ModelController.getToday().createEntry(p, c, d, "Activiy b");
		} catch (SlotAllreadyInUseException | InvalidEntryException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ViewController.go(args);



	}

}
