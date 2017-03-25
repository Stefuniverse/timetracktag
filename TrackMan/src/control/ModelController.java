package control;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.LinkedList;

import model.Day;
import model.Project;

public class ModelController {

	private static ArrayList<Day> dayList = new ArrayList<Day>();
	private static LinkedList<Project> projects = new LinkedList<Project>();

	/**
	 * Method Stub for model
	 * @return project stub
	 */
	public static LinkedList<Project> getProjects(){
		return projects;
	}

	public static Day getDay(Calendar c){
		Calendar d = Calendar.getInstance();
		d.set(c.get(Calendar.YEAR), c.get(Calendar.MONTH), c.get(Calendar.DAY_OF_MONTH));
		for(Day i : dayList){
			if(i.getDate().equals(d)){
				return i;
			}
		} 
		return null;
	}

	public static Calendar getToday(){
		Calendar c = Calendar.getInstance();
		c.setTimeInMillis(System.currentTimeMillis());
		return roundToDays(c);
	}

	public static void addProject(Project p){
		projects.add(p);
	}

	public static void addDay(Day d){
		dayList.add(d);
	}

	public static Calendar roundToDays(Calendar c){
		Calendar d = Calendar.getInstance();
		d.set(c.get(Calendar.YEAR), c.get(Calendar.MONTH), c.get(Calendar.DAY_OF_MONTH));
		return d;
	}



}
