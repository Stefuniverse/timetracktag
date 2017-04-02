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
	DatePicker start;
	DatePicker end;

	public InputField(){
		super();

		start = new DatePicker();
		end = new DatePicker();
		start.setOnAction(new EventHandler<ActionEvent>() {
		     @Override
			 public void handle(ActionEvent t) {
		         LocalDate date = start.getValue();
		         start = new DatePicker();
		     }
		 });

		 this.getChildren().add(start);
	}




}
