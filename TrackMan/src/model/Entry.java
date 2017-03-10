package model;


/**
 * One Entry what you have done today
 * 
 * @author stef
 *
 */
public class Entry {
	
	private double startdate;
	private double hours;
	private String notes;
	
	public Entry (double startdate){
		this.startdate = startdate;
		
	}
	
	public Entry(double startdate, double hours, String notes){
		this.startdate = startdate;
		this.hours = hours;
		this.notes = notes;
	}

	public double getStartdate() {
		return startdate;
	}

	public double getHours() {
		return hours;
	}

	public void setHours(double hours) {
		this.hours = hours;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}
	
	
}
