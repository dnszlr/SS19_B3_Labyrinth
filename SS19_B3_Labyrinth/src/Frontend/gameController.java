package Frontend;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class gameController implements Initializable {

	private LabyrinthFXML model;
	@FXML
	private Label playerCard;
	@FXML
	private Button hideShow;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		this.model = new LabyrinthFXML();

	}

	@FXML
	private void handleCloseButton(ActionEvent event) throws IOException {

		System.exit(0);

	}

}
