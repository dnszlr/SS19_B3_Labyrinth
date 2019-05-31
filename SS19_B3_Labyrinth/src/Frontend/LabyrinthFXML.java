package Frontend;

import javafx.application.Application;
import javafx.fxml.*;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class LabyrinthFXML extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		
		Parent root = FXMLLoader.load(getClass().getResource("gamepage.fxml"));
		primaryStage.setTitle("Java: 'Adventures in Info2'");
		primaryStage.setScene(new Scene(root, 1600, 1000));
		String styleCss = LabyrinthFXML.class.getResource("Style.css").toExternalForm();
		root.getStylesheets().add(styleCss);
		primaryStage.show();

	}

	public static void main(String[] args) {
		launch(args);
	}
}