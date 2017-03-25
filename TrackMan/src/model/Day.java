package model;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

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

	public void createEntry(Project p, Calendar starts, Calendar duration, String desc){
		this.entries.add(new Entry(starts, duration, desc, p));
	}

}
