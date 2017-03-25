package control;

import java.util.Calendar;

import model.Day;
import model.Project;

public class Main{

	public static void main(String[] args) {

		//Some simple Testdata
		Project p = new Project("Arbeit","#c0c0c0",true);
		ModelController.addDay(new Day(ModelController.getToday()));
		Calendar c = Calendar.getInstance();
		Calendar d = Calendar.getInstance();
		c.setTimeInMillis(System.currentTimeMillis());
		d.setTimeInMillis(System.currentTimeMillis());
		d.roll(Calendar.HOUR, 2);
		ModelController.getDay(ModelController.getToday()).createEntry(p, c, d, "Activiy a");
		c = Calendar.getInstance();
		d = Calendar.getInstance();
		c.setTimeInMillis(System.currentTimeMillis());
		c.roll(Calendar.HOUR, 3);
		d.setTimeInMillis(System.currentTimeMillis());
		d.roll(Calendar.HOUR, 4);
		ModelController.getDay(ModelController.getToday()).createEntry(p, c, d, "Activiy b");

		ViewController.go(args);



	}

}
