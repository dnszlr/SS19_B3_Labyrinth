package Frontend;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
public class LabyrinthUI extends Application {

	@Override
	public void start(Stage Stage) throws Exception {
		Parent root= FXMLLoader.load(getClass().getResource("Labyrinth.fxml"));
		Stage.setTitle("Das verrückte Labyrinth");
		Scene scene = new Scene(root);
		Stage.setScene(scene);
		Stage.show();
		
		
		
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	

}
