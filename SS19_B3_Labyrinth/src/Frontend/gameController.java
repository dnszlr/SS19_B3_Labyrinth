package Frontend;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import Backend.Manager;
import Interface.Communication;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;

public class gameController implements Initializable {

	private LabyrinthFXML model;
	@FXML
	private Label playerCard;
	@FXML
	private Button hideShow;
	@FXML
	private StackPane A1;
	@FXML
	private StackPane A2;
	@FXML
	private StackPane A3;
	@FXML
	private StackPane A4;
	@FXML
	private StackPane A5;
	@FXML
	private StackPane A6;
	@FXML
	private StackPane A7;
	@FXML
	private StackPane B1;
	@FXML
	private StackPane B2;
	@FXML
	private StackPane B3;
	@FXML
	private StackPane B4;
	@FXML
	private StackPane B5;
	@FXML
	private StackPane B6;
	@FXML
	private StackPane B7;
	@FXML
	private StackPane C1;
	@FXML
	private StackPane C2;
	@FXML
	private StackPane C3;
	@FXML
	private StackPane C4;
	@FXML
	private StackPane C5;
	@FXML
	private StackPane C6;
	@FXML
	private StackPane C7;
	@FXML
	private StackPane D1;
	@FXML
	private StackPane D2;
	@FXML
	private StackPane D3;
	@FXML
	private StackPane D4;
	@FXML
	private StackPane D5;
	@FXML
	private StackPane D6;
	@FXML
	private StackPane D7;
	@FXML
	private StackPane E1;
	@FXML
	private StackPane E2;
	@FXML
	private StackPane E3;
	@FXML
	private StackPane E4;
	@FXML
	private StackPane E5;
	@FXML
	private StackPane E6;
	@FXML
	private StackPane E7;
	@FXML
	private StackPane F1;
	@FXML
	private StackPane F2;
	@FXML
	private StackPane F3;
	@FXML
	private StackPane F4;
	@FXML
	private StackPane F5;
	@FXML
	private StackPane F6;
	@FXML
	private StackPane F7;
	@FXML
	private StackPane G1;
	@FXML
	private StackPane G2;
	@FXML
	private StackPane G3;
	@FXML
	private StackPane G4;
	@FXML
	private StackPane G5;
	@FXML
	private StackPane G6;
	@FXML
	private StackPane G7;

	private Communication manager = new Manager();

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		this.model = new LabyrinthFXML();
		int count = 0;
		StackPane[] mazePanes = new StackPane[] { A1, A2, A3, A4, A5, A6, A7, B1, B2, B3, B4, B5, B6, B7, C1, C2, C3,
				C4, C5, C6, C7, D1, D2, D3, D4, D5, D6, D7, E1, E2, E3, E4, E5, E6, E7, F1, F2, F3, F4, F5, F6, F7, G1,
				G2, G3, G4, G5, G6, G7, };
		String[][] maze = manager.getMap();
		for (int i = 0; i < maze.length; i++) {
			for (int j = 0; j < maze.length; j++) {
				String[] line = maze[i][j].split(";");
				ImageView wall = new ImageView("Frontend/Images" + line[1] + line[2] + line[3] + line[4] + ".png");
				mazePanes[count].getChildren().add(wall);
				if(!line[5].equals("null")) {
					ImageView color = new ImageView("Frontend/Images" + line[5].toUpperCase() + ".png");
					mazePanes[count].getChildren().add(color);
				}
				if(!line[6].equals("null")) {
					ImageView treasure = new ImageView("Frontend/Images" + line[6].toUpperCase() + ".png");
					mazePanes[count].getChildren().add(treasure);
				}
				count++;
			}
		}

	}

	@FXML
	private void handleCloseButton(ActionEvent event) throws IOException {
		System.exit(0);

	}

}
