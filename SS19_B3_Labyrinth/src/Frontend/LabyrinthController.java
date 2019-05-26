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


public class LabyrinthController implements Initializable {
	
	
	@FXML Button NewGame;
	@FXML Button LoadGame;
	
	
	public void changeScreenButtonPushed( ActionEvent event) throws IOException {
		Parent Anmeldung = FXMLLoader.load(getClass().getResource("Anmeldung.fxml"));
		Scene AnmeldungScene = new Scene (Anmeldung);	
		Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
		window.setScene(AnmeldungScene);
		window.show();
	}
	
	
	
	
	
	@Override	
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}

}
