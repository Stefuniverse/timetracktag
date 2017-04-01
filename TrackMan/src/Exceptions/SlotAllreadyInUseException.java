package Exceptions;

import java.io.IOException;
import java.util.Calendar;

@SuppressWarnings("serial")
public class SlotAllreadyInUseException extends IOException {

	public SlotAllreadyInUseException(){
		super("This timeslot is already in Use.");
	}

}
