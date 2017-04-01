package Exceptions;

import java.io.IOException;
import java.util.Calendar;

@SuppressWarnings("serial")
public class DayNotFoundException extends IOException {
	
	public DayNotFoundException(Calendar searchTerm){
		super("Day not in Database: "+searchTerm);
	}

}
