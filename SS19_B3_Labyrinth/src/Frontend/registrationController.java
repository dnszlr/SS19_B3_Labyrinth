package Frontend;

import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import Backend.Manager;
import Interface.Communication;
import javafx.event.ActionEvent;
import javafx.fxml.*;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class registrationController implements Initializable {
	
	@FXML
	private Label Header;
	@FXML
	private Button StartButton;
	@FXML
	private Button LoadButton;
	@FXML
	private Button CloseButton;
	@FXML
	private Button MazeButton;
	@FXML
	private Button RedPlayer;
	@FXML
	private TextField RedField;
	@FXML
	private Button YellowPlayer;
	@FXML
	private TextField YellowField;
	@FXML
	private Button GreenPlayer;
	@FXML
	private TextField GreenField;
	@FXML
	private Button BluePlayer;
	@FXML
	private TextField BlueField;
	
	
	private LabyrinthFXML model;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		this.model = new LabyrinthFXML();
	}
	
	private void handleRedField(){
		if(this.RedField.isDisable() == true) {
			this.RedField.setDisable(false);
		}else {
			this.RedField.setDisable(true);
		}	
	}
	
	@FXML
	private void handleMazeButton(ActionEvent event) throws IOException {
		
		Parent gamepage_Stage = FXMLLoader.load(getClass().getResource("gamepage.fxml"));
		Scene gamepage_Scene = new Scene(gamepage_Stage, 1400, 800);
		Stage AtmStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		AtmStage.setScene(gamepage_Scene);
		String styleCss = LabyrinthFXML.class.getResource("Style.css").toExternalForm();
		gamepage_Stage.getStylesheets().add(styleCss);
		AtmStage.show();
		
	}
	
	@FXML
	private void handleRedButton() {
		
		this.RedPlayer.setOnMouseClicked(event -> this.handleRedField());
		
	}
	
	private void handleYellowField(){
		if(this.YellowField.isDisable() == true) {
			this.YellowField.setDisable(false);
		}else {
			this.YellowField.setDisable(true);
		}	
	}
	@FXML
	private void handleYellowButton() {
		
		this.YellowPlayer.setOnMouseClicked(event -> this.handleYellowField());
		
	}
	
	private void handleGreenField(){
		if(this.GreenField.isDisable() == true) {
			this.GreenField.setDisable(false);
		}else {
			this.GreenField.setDisable(true);
		}	
	}
	@FXML
	private void handleGreenButton() {
		
		this.GreenPlayer.setOnMouseClicked(event -> this.handleGreenField());
		
	}
	
	private void handleBlueField(){
		if(this.BlueField.isDisable() == true) {
			this.BlueField.setDisable(false);
		}else {
			this.BlueField.setDisable(true);
		}	
	}
	@FXML
	private void handleBlueButton() {
		
		this.BluePlayer.setOnMouseClicked(event -> this.handleBlueField());
		
	}

	
	

}