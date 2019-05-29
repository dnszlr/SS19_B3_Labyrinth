package Frontend;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class startController implements Initializable{

	@FXML
	private Label Header;
	@FXML
	private Button StartButton;
	@FXML
	private Button LoadButton;
	@FXML
	private Button CloseButton;

	private LabyrinthFXML model;

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		this.model = new LabyrinthFXML();
		
	}
	
	@FXML
	private void handleStartButton(ActionEvent event) throws IOException {
		
		Parent registrationPage_Stage = FXMLLoader.load(getClass().getResource("registrationpage.fxml"));
		Scene registrationPage_Scene = new Scene(registrationPage_Stage, 1400, 800);
		Stage AtmStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		AtmStage.setScene(registrationPage_Scene);
		String styleCss = LabyrinthFXML.class.getResource("Style.css").toExternalForm();
		registrationPage_Stage.getStylesheets().add(styleCss);
		AtmStage.show();
		
	}
	
	@FXML
	private void handleCloseButton(ActionEvent event) throws IOException {
		
		System.exit(0);
		
	}

}
