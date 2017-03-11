package control;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import view.Mainview;
import view.ProjectList;

public class ViewController extends Application {
	
	BorderPane root;
	Scene s;

	public void start(Stage ps) throws Exception {
		ps.setTitle("TrackMan 0.1");
		root = new BorderPane();
		
		root.setRight(new ProjectList());
		s = new Scene(root, 800, 600);
		ps.setScene(s);

		ps.show();

	}

	public static void go(String[] args) {
		launch(args);
		
	}

}
