package model;

import java.util.Calendar;

/**
 * One Entry what you have done today
 *
 * @author stef
 *
 */
public class Entry {

	private Calendar startdate;
	private Calendar endDate;
	private String notes;
	private Project project;

	public Entry(Calendar startdate, Calendar hours, String notes, Project project){
		this.project = project;
		this.startdate = startdate;
		this.endDate = hours;
		this.notes = notes;
	}

	public Entry (Calendar startdate){
		this.startdate = startdate;

	}

	public Calendar getStartdate() {
		return startdate;
	}

	public Calendar getHours() {
		return endDate;
	}

	public void setHours(Calendar hours) {
		this.endDate = hours;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}


}
