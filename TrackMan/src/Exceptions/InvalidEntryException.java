package Exceptions;

import java.io.IOException;

@SuppressWarnings("serial")
public class InvalidEntryException extends IOException {

	public InvalidEntryException(){
		super("The Workentry is invalid");
	}

}