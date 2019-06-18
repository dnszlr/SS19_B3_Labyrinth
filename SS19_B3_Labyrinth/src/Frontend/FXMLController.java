package Frontend;

import javafx.scene.control.CheckBox;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.ResourceBundle;
import Backend.Manager;
import Interface.Communication;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class FXMLController implements Initializable {

	// startController

	@FXML
	private Label Header;
	@FXML
	private Button StartButton;
	@FXML
	private Button LoadButton;
	@FXML
	private Button CloseButton;

	// registrationController

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
	@FXML
	private CheckBox RedKI;
	@FXML
	private CheckBox YellowKI;
	@FXML
	private CheckBox GreenKI;
	@FXML
	private CheckBox BlueKI;

	// gameController
	@FXML
	private HBox players;
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
	@FXML
	private Label playerCard;
	@FXML
	private Button hideShow;
	@FXML
	private Button A2move;
	@FXML
	private Button A4move;
	@FXML
	private Button A6move;
	@FXML
	private Button G2move;
	@FXML
	private Button G4move;
	@FXML
	private Button G6move;
	@FXML
	private Button B1move;
	@FXML
	private Button D1move;
	@FXML
	private Button F1move;
	@FXML
	private Button B7move;
	@FXML
	private Button D7move;
	@FXML
	private Button F7move;
	@FXML
	private StackPane freeMazeCard;
	@FXML
	private Button rotateRight;
	@FXML
	private Button rotateLeft;
	@FXML
	private StackPane activePlayerTreasureCard;
	@FXML
	private Button EndRound;
	@FXML
	private Label activePlayer;

	private Communication manager;
	private LabyrinthFXML model;

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		manager = new Manager();
		model = new LabyrinthFXML();

	}

	@FXML
	private void handleStartButton(ActionEvent event) throws IOException {

		Parent pane = FXMLLoader.load(getClass().getResource("registrationpage.fxml"));
		Stage primaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		primaryStage.setTitle("Java: 'Adventures in Info2'");
		String styleCss = LabyrinthFXML.class.getResource("Style.css").toExternalForm();
		pane.getStylesheets().add(styleCss);
		primaryStage.setScene(new Scene(pane, 1400, 900));
		primaryStage.show();

	}

	@FXML
	private void handleMazeButton(ActionEvent event) throws Exception {

		FXMLLoader loader = new FXMLLoader(getClass().getResource("gamepage.fxml"));
		loader.setController(this);
		Parent pane = loader.load();
		Stage primaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		primaryStage.setTitle("Java: 'Adventures in Info2'");
		String styleCss = LabyrinthFXML.class.getResource("Style.css").toExternalForm();
		pane.getStylesheets().add(styleCss);
		addPlayers();
		String startGame = manager.startGame();
		if (startGame.equals("Please add Players befor you start the game")) {

			Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("Error!");
			alert.setHeaderText("");
			alert.setContentText(startGame);
			alert.showAndWait();

		} else {

			primaryStage.setScene(new Scene(pane, 1400, 900));
			getMaze();
			getFreeCard();
			getActivePlayerTreasureCard();
			getPlayers();
			checkIfKITurn();
			primaryStage.show();
		}

	}

	@FXML
	private void handleSERLoadButton(ActionEvent event) throws ClassNotFoundException, IOException {

		Path currentRelativePath = Paths.get("");
		String s = currentRelativePath.toAbsolutePath().toString();
		File directory = new File(s);
		FileChooser fileSER = new FileChooser();
		fileSER.setInitialDirectory(directory);
		FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("SER (*.ser)", "*.ser");
		fileSER.getExtensionFilters().add(extFilter);
		File file = fileSER.showOpenDialog((Stage) ((Node) event.getSource()).getScene().getWindow());
		if (file != null) {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("gamepage.fxml"));
			loader.setController(this);
			Parent pane = loader.load();
			Stage primaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
			primaryStage.setTitle("Java: 'Adventures in Info2'");
			String styleCss = LabyrinthFXML.class.getResource("Style.css").toExternalForm();
			pane.getStylesheets().add(styleCss);
			primaryStage.setScene(new Scene(pane, 1400, 900));
			this.manager.loadGame(file.toString(), "ser");
			getMaze();
			getFreeCard();
			getActivePlayerTreasureCard();
			getPlayers();
			primaryStage.show();
		}

	}

	@FXML
	private void handleCSVLoadButton(ActionEvent event) throws ClassNotFoundException, IOException {
		Path currentRelativePath = Paths.get("");
		String s = currentRelativePath.toAbsolutePath().toString();
		File directory = new File(s);
		FileChooser fileCSV = new FileChooser();
		fileCSV.setInitialDirectory(directory);
		FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("CSV (*.csv)", "*.csv");
		fileCSV.getExtensionFilters().add(extFilter);
		File file = fileCSV.showOpenDialog((Stage) ((Node) event.getSource()).getScene().getWindow());
		if (file != null) {

			this.manager.loadGame(file.toString(), "csv");
			getMaze();
			getFreeCard();
			getActivePlayerTreasureCard();
			getPlayers();

		}

	}

	@FXML
	private void handleJSONLoadButton(ActionEvent event) throws ClassNotFoundException, IOException {
		Path currentRelativePath = Paths.get("");
		String s = currentRelativePath.toAbsolutePath().toString();
		File directory = new File(s);
		FileChooser fileCSV = new FileChooser();
		fileCSV.setInitialDirectory(directory);
		FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("JSON (*.json)", "*.json");
		fileCSV.getExtensionFilters().add(extFilter);
		File file = fileCSV.showOpenDialog((Stage) ((Node) event.getSource()).getScene().getWindow());
		if (file != null) {

			FXMLLoader loader = new FXMLLoader(getClass().getResource("gamepage.fxml"));
			loader.setController(this);
			Parent pane = loader.load();
			Stage primaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
			primaryStage.setTitle("Java: 'Adventures in Info2'");
			String styleCss = LabyrinthFXML.class.getResource("Style.css").toExternalForm();
			pane.getStylesheets().add(styleCss);
			primaryStage.setScene(new Scene(pane, 1400, 900));
			this.manager.loadGame(file.toString(), "json");
			getMaze();
			getFreeCard();
			getActivePlayerTreasureCard();
			getPlayers();

		}

	}

	@FXML
	private void handleSaveButton(ActionEvent event) throws IOException {

		Path currentRelativePath = Paths.get("");
		String s = currentRelativePath.toAbsolutePath().toString();
		File directory = new File(s);
		FileChooser fileSave = new FileChooser();
		fileSave.setInitialDirectory(directory);
		FileChooser.ExtensionFilter extFilterCSV = new FileChooser.ExtensionFilter("CSV (*.csv)", "*.csv");
		FileChooser.ExtensionFilter extFilterSER = new FileChooser.ExtensionFilter("SER (*.ser)", "*.ser");
		FileChooser.ExtensionFilter extFilterJSON = new FileChooser.ExtensionFilter("JSON (*.json)", "*.json");
		fileSave.getExtensionFilters().add(extFilterCSV);
		fileSave.getExtensionFilters().add(extFilterSER);
		fileSave.getExtensionFilters().add(extFilterJSON);
		File file = fileSave.showSaveDialog((Stage) ((Node) event.getSource()).getScene().getWindow());
		if (file != null) {
			String path = file.getCanonicalPath().toLowerCase();
			if (path.endsWith(".csv")) {
				manager.saveGame(file.toString(), "csv");
			} else if (path.endsWith(".ser")) {
				manager.saveGame(file.toString(), "ser");
			} else if (path.endsWith(".json")) {
				manager.saveGame(file.toString(), "json");
			}
		}

	}

	private void addPlayers() {

		if (this.RedField.isDisable() == false && !this.RedField.getText().equals("null")
				&& this.RedField.getText().length() > 0) {

			if (this.RedKI.isSelected()) {
				manager.addKI(RedField.getText(), "RED");
			} else {
				manager.addPlayer(RedField.getText(), "RED");
			}
		}
		if (this.YellowField.isDisable() == false && !this.YellowField.getText().equals("null")
				&& this.YellowField.getText().length() > 0) {

			if (this.YellowKI.isSelected()) {
				manager.addKI(YellowField.getText(), "YELLOW");
			} else {
				manager.addPlayer(YellowField.getText(), "YELLOW");
			}
		}
		if (this.GreenField.isDisable() == false && !this.GreenField.getText().equals("null")
				&& this.GreenField.getText().length() > 0) {

			if (this.GreenKI.isSelected()) {
				manager.addKI(GreenField.getText(), "GREEN");
			} else {
				manager.addPlayer(GreenField.getText(), "GREEN");
			}
		}
		if (this.BlueField.isDisable() == false && !this.BlueField.getText().equals("null")
				&& this.BlueField.getText().length() > 0) {

			if (this.BlueKI.isSelected()) {
				manager.addKI(BlueField.getText(), "BLUE");
			} else {
				manager.addPlayer(BlueField.getText(), "Blue");
			}
		}

	}

	private void getMaze() {

		StackPane[][] mazePanes = new StackPane[][] { { A1, B1, C1, D1, E1, F1, G1 }, { A2, B2, C2, D2, E2, F2, G2 },
				{ A3, B3, C3, D3, E3, F3, G3 }, { A4, B4, C4, D4, E4, F4, G4 }, { A5, B5, C5, D5, E5, F5, G5 },
				{ A6, B6, C6, D6, E6, F6, G6 }, { A7, B7, C7, D7, E7, F7, G7 } };
		String[][] maze = manager.getMap();
		for (int i = 0; i < maze.length; i++) {
			for (int j = 0; j < maze.length; j++) {
				ImageView ground = new ImageView("Frontend/Images/groundCard.jpg");
				ground.setFitHeight(100.0);
				ground.setFitWidth(100.0);
				mazePanes[i][j].getChildren().clear();
				mazePanes[i][j].getChildren().add(ground);
				String[] line = maze[i][j].split(";");
				String walls = "Frontend/Images/Walls/" + line[1] + line[2] + line[3] + line[4] + ".png";
				ImageView wall = new ImageView(new Image(walls));
				wall.setFitHeight(100.0);
				wall.setFitWidth(100.0);
				mazePanes[i][j].getChildren().add(wall);
				if (!line[5].equals("null")) {
					String getColor = "Frontend/Images/Colors/" + line[5] + ".png";
					ImageView color = new ImageView(new Image(getColor));
					color.setFitHeight(100.0);
					color.setFitWidth(100.0);
					mazePanes[i][j].getChildren().add(color);
				} else if (!line[6].equals("null")) {
					String getTreasure = "Frontend/Images/Treasures/" + line[6] + ".png";
					ImageView treasure = new ImageView(new Image(getTreasure));
					treasure.setFitHeight(100.0);
					treasure.setFitWidth(100.0);
					mazePanes[i][j].getChildren().add(treasure);
				}
				if (line.length > 6) {
					for (int y = 7; y < line.length; y++) {
						String getFigure = "Frontend/Images/Figures/" + "Figure" + line[y] + ".png";
						ImageView figure = new ImageView(new Image(getFigure));
						figure.setFitHeight(100.0);
						figure.setFitWidth(100.0);
						mazePanes[i][j].getChildren().add(figure);
					}
				}

			}
		}

	}

	@FXML
	private void getPlayers() {

		this.players.getChildren().clear();
		String[] getPlayers = manager.getPlayers();
		for (int i = 0; i < getPlayers.length; i++) {
			String[] player = getPlayers[i].split(";");
			int foundCards = 0;
			for (int j = 1; j < player.length; j++) {
				if (player[j].equals("true")) {
					foundCards++;
				}
			}
			Label label = new Label();
			label.setText("| " + player[0] + " - " + "Found:" + foundCards + " |");
			label.getStyleClass().add("Players");
			this.players.getChildren().add(label);
		}

	}

	private void getFreeCard() {

		String freeMazeCard = manager.getFreeMazeCard();
		String[] line = freeMazeCard.split(";");
		ImageView ground = new ImageView("Frontend/Images/groundCard.jpg");
		ground.setFitHeight(100.0);
		ground.setFitWidth(100.0);
		this.freeMazeCard.getChildren().clear();
		this.freeMazeCard.getChildren().add(ground);
		for (int i = 0; i < line.length; i++) {
			String walls = "Frontend/Images/Walls/" + line[1] + line[2] + line[3] + line[4] + ".png";
			ImageView wall = new ImageView(new Image(walls, true));
			wall.setFitHeight(100.0);
			wall.setFitWidth(100.0);
			this.freeMazeCard.getChildren().add(wall);
			if (!line[5].equals("null")) {
				String getColor = "Frontend/Images/Colors/" + line[5] + ".png";
				ImageView color = new ImageView(new Image(getColor));
				color.setFitHeight(100.0);
				color.setFitWidth(100.0);
				this.freeMazeCard.getChildren().add(color);
			} else if (!line[6].equals("null")) {
				String getTreasure = "Frontend/Images/Treasures/" + line[6] + ".png";
				ImageView treasure = new ImageView(new Image(getTreasure));
				treasure.setFitHeight(100.0);
				treasure.setFitWidth(100.0);
				this.freeMazeCard.getChildren().add(treasure);
			}
		}
	}

	private void getActivePlayerTreasureCard() {

		String activePlayer = manager.getActivePlayer();
		String[] player = activePlayer.split(";");
		this.activePlayer.setText(player[0]);
		this.activePlayer.setStyle("-fx-text-fill: " + player[1]);

		String TreasureCard = manager.getActivePlayerTreasureCard();
		String[] line = TreasureCard.split(";");
		ImageView cardBack = new ImageView("Frontend/Images/CardBack.jpg");
		cardBack.setFitHeight(250.0);
		cardBack.setFitWidth(200.0);
		this.activePlayerTreasureCard.getChildren().clear();
		this.activePlayerTreasureCard.getChildren().add(cardBack);
		String getTreasure = "Frontend/Images/Treasures/" + line[0] + ".png";
		ImageView treasure = new ImageView(new Image(getTreasure));
		treasure.setFitHeight(250.0);
		treasure.setFitWidth(200.0);
		this.activePlayerTreasureCard.getChildren().add(treasure);

	}

	@FXML
	private void handlehideShow(MouseEvent event) {

		if (this.activePlayerTreasureCard.getChildren().size() == 1) {
			getActivePlayerTreasureCard();
		} else {
			this.activePlayerTreasureCard.getChildren().remove(1);
		}
	}

	private void checkIfKITurn() {

		if (manager.checkBotsTurn()) {
			
			manager.KIRound();
			getFreeCard();
			getMaze();
			this.EndRound.fire();
		}
		
		
	}

	@FXML
	private void handleMoveFigure(MouseEvent event) {

		StackPane maze = (StackPane) event.getSource();

		int row = GridPane.getRowIndex(maze);
		int column = GridPane.getColumnIndex(maze);

		int[] position = new int[] { column - 1, row - 1 };

		if (manager.moveFigure(position)) {

			getMaze();

		} else {

			Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("Error!");
			alert.setHeaderText("");
			alert.setContentText("Can't move!");
			alert.showAndWait();

		}

	}

	@FXML
	private void handleEndRound(MouseEvent event) throws IOException {

		String endRound = manager.endRound();
		String[] activePlayer = this.manager.getActivePlayer().split(";");

		if (endRound.equals("won the game!")) {
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("");
			alert.setHeaderText(null);
			alert.setContentText("Congratulations: " + activePlayer[0] + " you won the game!");

			alert.showAndWait();
			Parent pane = FXMLLoader.load(getClass().getResource("startpage.fxml"));
			Stage primaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
			primaryStage.setTitle("Java: 'Adventures in Info2'");
			String styleCss = LabyrinthFXML.class.getResource("Style.css").toExternalForm();
			pane.getStylesheets().add(styleCss);
			primaryStage.setScene(new Scene(pane, 1600, 1000));
			primaryStage.show();
			manager = new Manager();
		} else if (!endRound.equals("You have to move the gears once per round!")) {

			getActivePlayerTreasureCard();
			getPlayers();
			checkIfKITurn();

		} else {

			Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("Error!");
			alert.setHeaderText("");
			alert.setContentText("You have to move gears first!");
			alert.showAndWait();
		}

	}

	@FXML
	private void moveGears(ActionEvent event) {
		String move;
		Button button = (Button) event.getSource();

		if (button.equals(this.A2move)) {

			move = manager.moveGears("A2");
			if (move.equals("Couldn't move, try again with other position")) {
				Alert alert = new Alert(AlertType.WARNING);
				alert.setTitle("Error!");
				alert.setHeaderText("");
				alert.setContentText(move);

				alert.showAndWait();
			} else {
				StackPane[] gears = new StackPane[] { this.A2, this.B2, this.C2, this.D2, this.E2, this.F2, this.G2 };
				for (int i = 0; i < gears.length; i++) {
					gears[i].getChildren().clear();
				}
				getFreeCard();
				getMaze();
			}

		} else if (button.equals(this.A4move)) {

			move = manager.moveGears("A4");
			if (move.equals("Couldn't move, try again with other position")) {
				Alert alert = new Alert(AlertType.WARNING);
				alert.setTitle("Error!");
				alert.setHeaderText("");
				alert.setContentText(move);

				alert.showAndWait();
			} else {
				StackPane[] gears = new StackPane[] { this.A4, this.B4, this.C4, this.D4, this.E4, this.F4, this.G4 };
				for (int i = 0; i < gears.length; i++) {
					gears[i].getChildren().clear();
				}
				getFreeCard();
				getMaze();
			}
		} else if (button.equals(this.A6move)) {

			move = manager.moveGears("A6");
			if (move.equals("Couldn't move, try again with other position")) {
				Alert alert = new Alert(AlertType.WARNING);
				alert.setTitle("Error!");
				alert.setHeaderText("");
				alert.setContentText(move);

				alert.showAndWait();
			} else {
				StackPane[] gears = new StackPane[] { this.A6, this.B6, this.C6, this.D6, this.E6, this.F6, this.G6 };
				for (int i = 0; i < gears.length; i++) {
					gears[i].getChildren().clear();
				}
				getFreeCard();
				getMaze();
			}
		} else if (button.equals(this.G2move)) {

			move = manager.moveGears("G2");
			if (move.equals("Couldn't move, try again with other position")) {
				Alert alert = new Alert(AlertType.WARNING);
				alert.setTitle("Error!");
				alert.setHeaderText("");
				alert.setContentText(move);

				alert.showAndWait();
			} else {
				StackPane[] gears = new StackPane[] { this.A2, this.B2, this.C2, this.D2, this.E2, this.F2, this.G2 };
				for (int i = 0; i < gears.length; i++) {
					gears[i].getChildren().clear();
				}
				getFreeCard();
				getMaze();
			}
		} else if (button.equals(this.G4move)) {

			move = manager.moveGears("G4");
			if (move.equals("Couldn't move, try again with other position")) {
				Alert alert = new Alert(AlertType.WARNING);
				alert.setTitle("Error!");
				alert.setHeaderText("");
				alert.setContentText(move);

				alert.showAndWait();
			} else {
				StackPane[] gears = new StackPane[] { this.A4, this.B4, this.C4, this.D4, this.E4, this.F4, this.G4 };
				for (int i = 0; i < gears.length; i++) {
					gears[i].getChildren().clear();
				}
				getFreeCard();
				getMaze();
			}
		} else if (button.equals(this.G6move)) {

			move = manager.moveGears("G6");
			if (move.equals("Couldn't move, try again with other position")) {
				Alert alert = new Alert(AlertType.WARNING);
				alert.setTitle("Error!");
				alert.setHeaderText("");
				alert.setContentText(move);

				alert.showAndWait();
			} else {
				StackPane[] gears = new StackPane[] { this.A6, this.B6, this.C6, this.D6, this.E6, this.F6, this.G6 };
				for (int i = 0; i < gears.length; i++) {
					gears[i].getChildren().clear();
				}
				getFreeCard();
				getMaze();
			}
		} else if (button.equals(this.B1move)) {

			move = manager.moveGears("B1");
			if (move.equals("Couldn't move, try again with other position")) {
				Alert alert = new Alert(AlertType.WARNING);
				alert.setTitle("Error!");
				alert.setHeaderText("");
				alert.setContentText(move);

				alert.showAndWait();
			} else {
				StackPane[] gears = new StackPane[] { this.B1, this.B2, this.B3, this.B4, this.B5, this.B6, this.B7 };
				for (int i = 0; i < gears.length; i++) {
					gears[i].getChildren().clear();
				}
				getFreeCard();
				getMaze();
			}
		} else if (button.equals(this.D1move)) {

			move = manager.moveGears("D1");
			if (move.equals("Couldn't move, try again with other position")) {
				Alert alert = new Alert(AlertType.WARNING);
				alert.setTitle("Error!");
				alert.setHeaderText("");
				alert.setContentText(move);

				alert.showAndWait();
			} else {
				StackPane[] gears = new StackPane[] { this.D1, this.D2, this.D3, this.D4, this.D5, this.D6, this.D7 };
				for (int i = 0; i < gears.length; i++) {
					gears[i].getChildren().clear();
				}
				getFreeCard();
				getMaze();
			}
		} else if (button.equals(this.F1move)) {

			move = manager.moveGears("F1");
			if (move.equals("Couldn't move, try again with other position")) {
				Alert alert = new Alert(AlertType.WARNING);
				alert.setTitle("Error!");
				alert.setHeaderText("");
				alert.setContentText(move);

				alert.showAndWait();
			} else {
				StackPane[] gears = new StackPane[] { this.F1, this.F2, this.F3, this.F4, this.F5, this.F6, this.F7 };
				for (int i = 0; i < gears.length; i++) {
					gears[i].getChildren().clear();
				}
				getFreeCard();
				getMaze();
			}
		} else if (button.equals(this.B7move)) {

			move = manager.moveGears("B7");
			if (move.equals("Couldn't move, try again with other position")) {
				Alert alert = new Alert(AlertType.WARNING);
				alert.setTitle("Error!");
				alert.setHeaderText("");
				alert.setContentText(move);

				alert.showAndWait();
			} else {
				StackPane[] gears = new StackPane[] { this.B1, this.B2, this.B3, this.B4, this.B5, this.B6, this.B7 };
				for (int i = 0; i < gears.length; i++) {
					gears[i].getChildren().clear();
				}
				getFreeCard();
				getMaze();
			}
		} else if (button.equals(this.D7move)) {

			move = manager.moveGears("D7");
			if (move.equals("Couldn't move, try again with other position")) {
				Alert alert = new Alert(AlertType.WARNING);
				alert.setTitle("Error!");
				alert.setHeaderText("");
				alert.setContentText(move);

				alert.showAndWait();
			} else {
				StackPane[] gears = new StackPane[] { this.D1, this.D2, this.D3, this.D4, this.D5, this.D6, this.D7 };
				for (int i = 0; i < gears.length; i++) {
					gears[i].getChildren().clear();
				}
				getFreeCard();
				getMaze();
			}
		} else if (button.equals(this.F7move)) {

			move = manager.moveGears("F7");
			if (move.equals("Couldn't move, try again with other position")) {
				Alert alert = new Alert(AlertType.WARNING);
				alert.setTitle("Error!");
				alert.setHeaderText("");
				alert.setContentText(move);

				alert.showAndWait();
			} else {
				StackPane[] gears = new StackPane[] { this.F1, this.F2, this.F3, this.F4, this.F5, this.F6, this.F7 };
				for (int i = 0; i < gears.length; i++) {
					gears[i].getChildren().clear();
				}
				getFreeCard();
				getMaze();
			}
		}

	}

	@FXML
	private void handleRotateLeft(MouseEvent event) {

		manager.rotateGear("Left");
		this.freeMazeCard.getChildren().clear();
		getFreeCard();

	}

	@FXML
	private void handleRotateRight(MouseEvent event) {

		manager.rotateGear("Right");
		this.freeMazeCard.getChildren().clear();
		getFreeCard();

	}

	@FXML
	private void handleRedButton() {

		this.RedPlayer.setOnMouseClicked(event -> {

			if (this.RedField.isDisable() == true) {
				this.RedField.setDisable(false);
			} else {
				this.RedField.setDisable(true);
			}

		});

	}

	@FXML
	private void handleYellowButton() {

		this.YellowPlayer.setOnMouseClicked(event -> {

			if (this.YellowField.isDisable() == true) {
				this.YellowField.setDisable(false);
			} else {
				this.YellowField.setDisable(true);
			}

		});

	}

	@FXML
	private void handleGreenButton() {

		this.GreenPlayer.setOnMouseClicked(event -> {

			if (this.GreenField.isDisable() == true) {
				this.GreenField.setDisable(false);
			} else {
				this.GreenField.setDisable(true);
			}

		});

	}

	@FXML
	private void handleBlueButton() {

		this.BluePlayer.setOnMouseClicked(event -> {

			if (this.BlueField.isDisable() == true) {
				this.BlueField.setDisable(false);
			} else {
				this.BlueField.setDisable(true);
			}

		});

	}

	@FXML
	private void handleCloseButton(ActionEvent event) throws IOException {
		System.exit(0);

	}

}
