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
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage; 


public class AnmeldungController implements Initializable {
	
	
	@FXML private Button StartGame;
	@FXML private Button Back;
	
	@FXML private CheckBox RED;
	@FXML private CheckBox YELLOW;
	@FXML private CheckBox GREEN;
	@FXML private CheckBox BLUE;
	
	@FXML private TextField tf1;
	@FXML private TextField tf2;
	@FXML private TextField tf3;
	@FXML private TextField tf4;
	
	
	public void changeScreenButtonPushed( ActionEvent event) throws IOException {
		Parent Anmeldung = FXMLLoader.load(getClass().getResource("Labyrinth.fxml"));
		Scene AnmeldungScene = new Scene (Anmeldung);	
		Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
		window.setScene(AnmeldungScene);
		window.show();
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}

}
