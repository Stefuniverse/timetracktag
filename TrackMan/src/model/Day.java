package model;

import java.util.ArrayList;
import java.util.Date;

public class Day {
	
	private Date day;
	private ArrayList<Entry> entries;
	
	public Day(Date day){
		this.day = day;
		this.entries = new ArrayList<Entry>();
	}

	public Date getDay() {
		return day;
	}

	public void setDay(Date day) {
		this.day = day;
	}

	public ArrayList<Entry> getEntries() {
		return entries;
	}

	public void setEntries(ArrayList<Entry> entries) {
		this.entries = entries;
	}

}
