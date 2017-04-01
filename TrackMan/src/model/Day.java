package model;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import Exceptions.InvalidEntryException;
import Exceptions.SlotAllreadyInUseException;
import control.ModelController;
import control.ViewController;

public class Day {

	private Calendar date;
	private ArrayList<Entry> entries;

	public Day(Calendar c){
		this.date = c;
		this.entries = new ArrayList<Entry>();
	}

	public Day(Date day, ArrayList<Entry> e){
		this.date = Calendar.getInstance();
		this.entries = e;
	}

	public Calendar getDate() {
		return date;
	}

	public void setDate(Calendar day) {
		this.date = day;
	}

	public ArrayList<Entry> getEntries() {
		return this.entries;
	}

	public void createEntry(Project p, Calendar starts, Calendar end, String desc) throws SlotAllreadyInUseException, InvalidEntryException{
		for(Entry e : entries){
			if(starts.after(e.getStartdate()) && starts.before(e.getHours())
					|| end.after(e.getStartdate()) && end.before(e.getHours())){
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

	public long getEarliest() {
		if(entries.isEmpty()){
			return 0;
		}
		long er = 0;
		for(Entry e: entries){
			if (e.getStartdate().getTimeInMillis() < er || er == 0){
				er = e.getStartdate().getTimeInMillis();
			}
		}
		return er;
	}
	
	public long getLatest() {
		if(entries.isEmpty()){
			return 0;
		}
		long er = 0;
		for(Entry e: entries){
			if (e.getHours().getTimeInMillis() > er){
				er = e.getStartdate().getTimeInMillis();
			}
		}
		return er;
	}

}
