package control;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.LinkedList;

import Exceptions.DayNotFoundException;
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

	public static Day getDay(Calendar c) throws DayNotFoundException{
		Calendar d = Calendar.getInstance();
		d.clear();
		d.set(c.get(Calendar.YEAR), c.get(Calendar.MONTH), c.get(Calendar.DAY_OF_MONTH));
		for(Day i : dayList){
			System.out.println(i.getDate());
			System.out.println(d);
			if(i.getDate().equals(d)){
				return i;
			}
		}
		throw new DayNotFoundException(c);
	}

	public static Day getToday(){
		Calendar c = Calendar.getInstance();
		c.setTimeInMillis(System.currentTimeMillis());
		try{
			return getDay(roundToDays(c));
		} catch (DayNotFoundException e){
			Day d = new Day(roundToDays(c));
			addDay(d);
			return d;
		}
	}

	public static Day getTommorow(){
		Calendar d = getToday().getDate();
		d.add(Calendar.DAY_OF_MONTH, 1);
		try {
			return getDay(d);
		} catch (DayNotFoundException e) {
			Day day = new Day(d);
			addDay(day);
			return day;
		}
	}

	public static void addProject(Project p){
		projects.add(p);
	}

	public static void addDay(Day d){
		d.setDate(roundToDays(d.getDate()));
		dayList.add(d);
	}

	public static Calendar roundToDays(Calendar c){
		Calendar d = Calendar.getInstance();
		d.clear();
		d.set(c.get(Calendar.YEAR), c.get(Calendar.MONTH), c.get(Calendar.DAY_OF_MONTH));
		return d;
	}



}
