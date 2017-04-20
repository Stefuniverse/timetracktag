package view;

import java.time.LocalDate;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.layout.HBox;

public class InputField extends HBox {

	Button create;
	TextTimePicker start;
	TextTimePicker end;


	public InputField(){
		super();
		start = new TextTimePicker();
		end = new TextTimePicker();

		 this.getChildren().add(start);
		 this.getChildren().add(end);
	}




}
