package Exceptions;

import java.io.IOException;
import java.util.Calendar;

@SuppressWarnings("serial")
public class DayNotFound extends IOException {
	
	public DayNotFound(Calendar searchTerm){
		super("Day not in Database: "+searchTerm);
	}

}
