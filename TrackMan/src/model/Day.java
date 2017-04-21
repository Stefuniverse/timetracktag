package model;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Comparator;
import java.util.Date;
import java.util.LinkedList;
import java.util.stream.Collectors;

import Exceptions.InvalidEntryException;
import Exceptions.SlotAllreadyInUseException;
import control.ModelController;
import control.ViewController;
import view.WorkBarEntry;

public class Day {

	private int year;
	private int month;
	private int dayOfMonth;
	private LinkedList<Entry> entries;

	public Day(int year, int month, int dayOfMonth){
		this.year = year;
		this.month = month;
		this.dayOfMonth = dayOfMonth;
		this.entries = new LinkedList<Entry>();
	}

	public LinkedList<Entry> getEntriesSorted() {
		Comparator<Entry> co = Comparator.comparingDouble(Entry::getStartHour);
		LinkedList<Entry> e = entries.stream().sorted(co).collect(Collectors.toCollection(LinkedList::new));


		return this.entries;
	}


	public Boolean equals(Day d){
		if(dayOfMonth == d.getDayOfMonth() &&
				month == d.getMonth() &&
				year == d.getYear()){
			return true;
		} return false;

	}

	public void createEntry(Project p, double starts, double end, String desc) throws SlotAllreadyInUseException, InvalidEntryException{
		for(Entry e : entries){
			if(e.getStartHour() > starts && e.getEndHour() < end ||
					e.getStartHour() < starts && end < e.getEndHour() ||
					e.getStartHour() < starts && e.getEndHour() ||
					){
				throw new SlotAllreadyInUseException();
			} else if (end.before(starts)){
				throw new InvalidEntryException();
			}
		}
		if(starts.get(Calendar.DAY_OF_MONTH) != end.get(Calendar.DAY_OF_MONTH)){
			long thisDay = ModelController.getTommorow().getDate().getTimeInMillis() - starts.getTimeInMillis();
			long inNewDay = (end.getTimeInMillis() - starts.getTimeInMillis()) - thisDay;
			Calendar endTimeNewDay = Calendar.getInstance();
			endTimeNewDay.setTimeInMillis(inNewDay + ModelController.getTommorow().getDate().getTimeInMillis()-1);

			ModelController.getTommorow().createEntry(p, ModelController.getTommorow().getDate(), endTimeNewDay , desc);

			this.entries.add(new Entry(starts, ModelController.getTommorow().getDate(), desc, p));
		}
		if(date.equals(ModelController.getToday())){
			ViewController.rebuildWorkBar();
		}

		this.entries.add(new Entry(starts, end, desc, p));

	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public int getDayOfMonth() {
		return dayOfMonth;
	}

	public void setDayOfMonth(int dayOfMonth) {
		this.dayOfMonth = dayOfMonth;
	}



}
