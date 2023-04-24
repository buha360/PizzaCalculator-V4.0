package application;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.PauseTransition;
import javafx.animation.Timeline;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Rectangle2D;
import javafx.scene.Cursor;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DialogPane;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.ContextMenuEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;
import pizzas.Ingredients;
import pizzas.Neapolitan;
import pizzas.Poolish;
import pizzas.Sheet;

public class Controller implements Initializable {

	@FXML
	private Pane root;
	@FXML
	private Scene scene;
	@FXML
	private Stage stage;
	@FXML
	private Label napolyi = new Label();
	@FXML
	private Label romai = new Label();
	@FXML
	private Label segitseg = new Label();
	@FXML
	private Label fooldal = new Label();
	@FXML
	private javafx.scene.control.TextField weight = new javafx.scene.control.TextField();
	@FXML
	private javafx.scene.control.TextField hydration = new javafx.scene.control.TextField();
	@FXML
	private javafx.scene.control.TextField db = new javafx.scene.control.TextField();
	@FXML
	private javafx.scene.control.TextField a_side = new javafx.scene.control.TextField();
	@FXML
	private javafx.scene.control.TextField b_side = new javafx.scene.control.TextField();
	@FXML
	private javafx.scene.control.TextField thickness = new javafx.scene.control.TextField();
	@FXML
	private Text fooldal_szoveg1 = new Text();
	@FXML
	private Text fooldal_szoveg2 = new Text();
	@FXML
	private Text fooldal_szoveg3 = new Text();
	@FXML
	private Button ButtonX = new Button();
	@FXML
	private ScrollPane segitseg_scroll = new ScrollPane();
	@FXML
	private Line line = new Line(0, 0, 2000, 0);

	// Rgb_line previous scene színével
	public void rgb_line_first(Color previousLineColor) {
		line.setStrokeWidth(4);
		line.setRotate(90);
		line.setTranslateX(-725);

		Timeline colorTimeline = new Timeline();
		colorTimeline.setCycleCount(Timeline.INDEFINITE);

		KeyValue kv0 = new KeyValue(line.strokeProperty(), previousLineColor);
		KeyValue kv1 = new KeyValue(line.strokeProperty(), Color.RED);
		KeyValue kv2 = new KeyValue(line.strokeProperty(), Color.MAGENTA);
		KeyValue kv3 = new KeyValue(line.strokeProperty(), Color.PURPLE);
		KeyValue kv4 = new KeyValue(line.strokeProperty(), Color.AQUA);
		KeyValue kv5 = new KeyValue(line.strokeProperty(), Color.LIGHTSEAGREEN);
		KeyValue kv6 = new KeyValue(line.strokeProperty(), Color.GREEN);
		KeyValue kv7 = new KeyValue(line.strokeProperty(), Color.YELLOWGREEN);
		KeyValue kv8 = new KeyValue(line.strokeProperty(), Color.YELLOW);
		KeyValue kv9 = new KeyValue(line.strokeProperty(), Color.ORANGE);
		KeyValue kv10 = new KeyValue(line.strokeProperty(), Color.RED);

		KeyFrame kf0 = new KeyFrame(Duration.ZERO, kv0);
		KeyFrame kf1 = new KeyFrame(Duration.seconds(0.7), kv1);
		KeyFrame kf2 = new KeyFrame(Duration.seconds(1.4), kv2);
		KeyFrame kf3 = new KeyFrame(Duration.seconds(2.1), kv3);
		KeyFrame kf4 = new KeyFrame(Duration.seconds(2.8), kv4);
		KeyFrame kf5 = new KeyFrame(Duration.seconds(3.5), kv5);
		KeyFrame kf6 = new KeyFrame(Duration.seconds(4.2), kv6);
		KeyFrame kf7 = new KeyFrame(Duration.seconds(4.9), kv7);
		KeyFrame kf8 = new KeyFrame(Duration.seconds(5.6), kv8);
		KeyFrame kf9 = new KeyFrame(Duration.seconds(6.3), kv9);
		KeyFrame kf10 = new KeyFrame(Duration.seconds(7.0), kv10);

		colorTimeline.getKeyFrames().addAll(kf0, kf1, kf2, kf3, kf4, kf5, kf6, kf7, kf8, kf9, kf10);

		colorTimeline.play();

		((Pane) scene.getRoot()).getChildren().add(line);

		Duration duration = Duration.millis(6990);
		PauseTransition pause = new PauseTransition(duration);
		pause.setOnFinished(e -> {
			rgb_line_second();
		});

		pause.play();
	}

	// Rgb_line újrahívása már a previous scene színe nélkül
	public void rgb_line_second() {
		line.setStrokeWidth(4);
		line.setRotate(90);
		line.setTranslateX(-725);

		Timeline colorTimeline = new Timeline();
		colorTimeline.setCycleCount(Timeline.INDEFINITE);

		KeyValue kv1 = new KeyValue(line.strokeProperty(), Color.RED);
		KeyValue kv2 = new KeyValue(line.strokeProperty(), Color.MAGENTA);
		KeyValue kv3 = new KeyValue(line.strokeProperty(), Color.PURPLE);
		KeyValue kv4 = new KeyValue(line.strokeProperty(), Color.AQUA);
		KeyValue kv5 = new KeyValue(line.strokeProperty(), Color.LIGHTSEAGREEN);
		KeyValue kv6 = new KeyValue(line.strokeProperty(), Color.GREEN);
		KeyValue kv7 = new KeyValue(line.strokeProperty(), Color.YELLOWGREEN);
		KeyValue kv8 = new KeyValue(line.strokeProperty(), Color.YELLOW);
		KeyValue kv9 = new KeyValue(line.strokeProperty(), Color.ORANGE);

		KeyFrame kf0 = new KeyFrame(Duration.ZERO, kv1);
		KeyFrame kf1 = new KeyFrame(Duration.seconds(0.7), kv2);
		KeyFrame kf2 = new KeyFrame(Duration.seconds(1.4), kv3);
		KeyFrame kf3 = new KeyFrame(Duration.seconds(2.1), kv4);
		KeyFrame kf4 = new KeyFrame(Duration.seconds(2.8), kv5);
		KeyFrame kf5 = new KeyFrame(Duration.seconds(3.5), kv6);
		KeyFrame kf6 = new KeyFrame(Duration.seconds(4.2), kv7);
		KeyFrame kf7 = new KeyFrame(Duration.seconds(4.9), kv8);
		KeyFrame kf8 = new KeyFrame(Duration.seconds(5.6), kv9);
		KeyFrame kf9 = new KeyFrame(Duration.seconds(6.3), kv1);

		colorTimeline.getKeyFrames().addAll(kf0, kf1, kf2, kf3, kf4, kf5, kf6, kf7, kf8, kf9);

		colorTimeline.play();
	}

	// Scenek
	public void switchToScene1(MouseEvent event) throws IOException {
		Color previousLineColor = (Color) line.getStroke();
		root = FXMLLoader.load(getClass().getResource("Napolyi.fxml"));
		stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		String css = this.getClass().getResource("application.css").toExternalForm();
		scene = new Scene(root);
		scene.getStylesheets().add(css);
		stage.setScene(scene);
		stage.show();
		rgb_line_first(previousLineColor);
	}

	public void switchToScene2(MouseEvent event) throws IOException {
		Color previousLineColor = (Color) line.getStroke();
		root = FXMLLoader.load(getClass().getResource("Romai.fxml"));
		stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		String css = this.getClass().getResource("application.css").toExternalForm();
		scene = new Scene(root);
		scene.getStylesheets().add(css);
		stage.setScene(scene);
		stage.show();
		rgb_line_first(previousLineColor);
	}

	public void switchToScene3(MouseEvent event) throws IOException {
		Color previousLineColor = (Color) line.getStroke();
		root = FXMLLoader.load(getClass().getResource("Segitseg.fxml"));
		stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		String css = this.getClass().getResource("application.css").toExternalForm();

		VBox vbox = new VBox();
		segitseg_scroll.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
		vbox.setSpacing(11);
		vbox.setStyle(
				"-fx-font-size: 25px; -fx-background-color: #2a2f3b; -fx-border-color: #2a2f3b; -fx-border-width: 0 0 0 2; -fx-translate-x: 347px; -fx-translate-y: 60px");

		Text label1 = new Text(" 1. Mérd ki precízen a nyersanyagokat!");
		Text label2 = new Text(" 2. Alaposan kavard össze az előtésztát!");
		Text label3 = new Text(" 3. Sózd meg a tésztavizet!");
		Text label4 = new Text(" 4. Add hozzá a lisztet és gyúrd össze a tésztát!");

		label1.setStyle("-fx-fill: white;");
		label2.setStyle("-fx-fill: white;");
		label3.setStyle("-fx-fill: white;");
		label4.setStyle("-fx-fill: white;");

		vbox.getChildren().addAll(label1, label2, label3, label4);
		vbox.setFillWidth(true);
		segitseg_scroll.setStyle("-fx-background-color: #212327; -fx-control-inner-background: #212327");
		root.getChildren().add(vbox);

		scene = new Scene(root);
		scene.getStylesheets().add(css);
		stage.setScene(scene);
		stage.show();
		rgb_line_first(previousLineColor);
	}

	public void switchToScene4(MouseEvent event) throws IOException {
		Color previousLineColor = (Color) line.getStroke();
		root = FXMLLoader.load(getClass().getResource("Main.fxml"));
		stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		String css = this.getClass().getResource("application.css").toExternalForm();
		scene = new Scene(root);
		scene.getStylesheets().add(css);
		stage.setScene(scene);
		stage.show();
		rgb_line_first(previousLineColor);
	}

	// WD logo kattinthato
	public void clickableLogo(MouseEvent event) throws IOException {
		try {
			Desktop.getDesktop().browse(new URI("https://users.iit.uni-miskolc.hu/~buha/"));
		} catch (IOException | URISyntaxException e) {
			e.printStackTrace();
		}
	}

	// Initialize
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		line.setStrokeWidth(4);
		line.setRotate(90);
		line.setTranslateX(-725);

		// Timeline animáció létrehozása a vonal színváltáshoz
		Timeline colorTimeline = new Timeline();
		colorTimeline.setCycleCount(Timeline.INDEFINITE);

		// Kezdő szín és időpont
		KeyValue kv0 = new KeyValue(line.strokeProperty(), Color.ORANGE);
		KeyValue kv1 = new KeyValue(line.strokeProperty(), Color.RED);
		KeyValue kv2 = new KeyValue(line.strokeProperty(), Color.MAGENTA);
		KeyValue kv3 = new KeyValue(line.strokeProperty(), Color.PURPLE);
		KeyValue kv4 = new KeyValue(line.strokeProperty(), Color.AQUA);
		KeyValue kv5 = new KeyValue(line.strokeProperty(), Color.LIGHTSEAGREEN);
		KeyValue kv6 = new KeyValue(line.strokeProperty(), Color.GREEN);
		KeyValue kv7 = new KeyValue(line.strokeProperty(), Color.YELLOWGREEN);
		KeyValue kv8 = new KeyValue(line.strokeProperty(), Color.YELLOW);
		KeyValue kv9 = new KeyValue(line.strokeProperty(), Color.ORANGE);

		KeyFrame kf0 = new KeyFrame(Duration.ZERO, kv0);
		KeyFrame kf1 = new KeyFrame(Duration.seconds(0.7), kv1);
		KeyFrame kf2 = new KeyFrame(Duration.seconds(1.4), kv2);
		KeyFrame kf3 = new KeyFrame(Duration.seconds(2.1), kv3);
		KeyFrame kf4 = new KeyFrame(Duration.seconds(2.8), kv4);
		KeyFrame kf5 = new KeyFrame(Duration.seconds(3.5), kv5);
		KeyFrame kf6 = new KeyFrame(Duration.seconds(4.2), kv6);
		KeyFrame kf7 = new KeyFrame(Duration.seconds(4.9), kv7);
		KeyFrame kf8 = new KeyFrame(Duration.seconds(5.6), kv8);
		KeyFrame kf9 = new KeyFrame(Duration.seconds(6.3), kv9);

		colorTimeline.getKeyFrames().addAll(kf0, kf1, kf2, kf3, kf4, kf5, kf6, kf7, kf8, kf9);

		// Az animációk indítása
		colorTimeline.play();

		// Hozzáadás a root-hoz
		root.getChildren().add(line);

		// Betű szín feherre allitas
		napolyi.setTextFill(Color.WHITE);
		romai.setTextFill(Color.WHITE);
		segitseg.setTextFill(Color.WHITE);
		fooldal.setTextFill(Color.WHITE);
		fooldal_szoveg1.setFill(Color.WHITE);
		fooldal_szoveg2.setFill(Color.WHITE);
		fooldal_szoveg3.setFill(Color.WHITE);

		// Hover események kezelése a labeleknel
		napolyi.setOnMouseEntered(event -> {
			animateTextColor(napolyi, Color.RED);
		});
		napolyi.setOnMouseExited(event -> {
			animateTextColor(napolyi, Color.WHITE);
		});
		romai.setOnMouseEntered(event -> {
			animateTextColor(romai, Color.RED);
		});
		romai.setOnMouseExited(event -> {
			animateTextColor(romai, Color.WHITE);
		});
		segitseg.setOnMouseEntered(event -> {
			animateTextColor(segitseg, Color.RED);
		});
		segitseg.setOnMouseExited(event -> {
			animateTextColor(segitseg, Color.WHITE);
		});
		fooldal.setOnMouseEntered(event -> {
			animateTextColor(fooldal, Color.RED);
		});
		fooldal.setOnMouseExited(event -> {
			animateTextColor(fooldal, Color.WHITE);
		});

		weight.addEventFilter(ContextMenuEvent.CONTEXT_MENU_REQUESTED, Event::consume);
		weight.addEventFilter(ContextMenuEvent.CONTEXT_MENU_REQUESTED, event -> {
			if (!weight.getText().isEmpty()) {
				weight.setStyle(
						"-fx-focus-color: #ff0000; -fx-control-inner-background: #2a2f3b; -fx-border-color: #ff0000; -fx-border-radius: 3;");
				weight.clear();
			}
			event.consume();
		});
		hydration.addEventFilter(ContextMenuEvent.CONTEXT_MENU_REQUESTED, Event::consume);
		hydration.addEventFilter(ContextMenuEvent.CONTEXT_MENU_REQUESTED, event -> {
			if (!hydration.getText().isEmpty()) {
				hydration.setStyle(
						"-fx-focus-color: #ff0000; -fx-control-inner-background: #2a2f3b; -fx-border-color: #ff0000; -fx-border-radius: 3;");
				hydration.clear();
			}
			event.consume();
		});
		db.addEventFilter(ContextMenuEvent.CONTEXT_MENU_REQUESTED, Event::consume);
		db.addEventFilter(ContextMenuEvent.CONTEXT_MENU_REQUESTED, event -> {
			if (!db.getText().isEmpty()) {
				db.setStyle(
						"-fx-focus-color: #ff0000; -fx-control-inner-background: #2a2f3b; -fx-border-color: #ff0000; -fx-border-radius: 3;");
				db.clear();
			}
			event.consume();
		});
		a_side.addEventFilter(ContextMenuEvent.CONTEXT_MENU_REQUESTED, Event::consume);
		a_side.addEventFilter(ContextMenuEvent.CONTEXT_MENU_REQUESTED, event -> {
			if (!a_side.getText().isEmpty()) {
				a_side.setStyle(
						"-fx-focus-color: #ff0000; -fx-control-inner-background: #2a2f3b; -fx-border-color: #ff0000; -fx-border-radius: 3;");
				a_side.clear();
			}
			event.consume();
		});
		b_side.addEventFilter(ContextMenuEvent.CONTEXT_MENU_REQUESTED, Event::consume);
		b_side.addEventFilter(ContextMenuEvent.CONTEXT_MENU_REQUESTED, event -> {
			if (!b_side.getText().isEmpty()) {
				b_side.setStyle(
						"-fx-focus-color: #ff0000; -fx-control-inner-background: #2a2f3b; -fx-border-color: #ff0000; -fx-border-radius: 3;");
				b_side.clear();
			}
			event.consume();
		});
		thickness.addEventFilter(ContextMenuEvent.CONTEXT_MENU_REQUESTED, Event::consume);
		thickness.addEventFilter(ContextMenuEvent.CONTEXT_MENU_REQUESTED, event -> {
			if (!thickness.getText().isEmpty()) {
				thickness.setStyle(
						"-fx-focus-color: #ff0000; -fx-control-inner-background: #2a2f3b; -fx-border-color: #ff0000; -fx-border-radius: 3;");
				thickness.clear();
			}
			event.consume();
		});

		// Kép hozzáadása + kattinthatosag es weboldalam
		Image image = new Image("wd_logo.png", 200, 140, true, true);
		ImageView imageView = new ImageView(image);
		imageView.setCursor(Cursor.HAND);
		Rectangle2D viewportRect = new Rectangle2D(0, 0, 400, 300);
		imageView.setViewport(viewportRect);
		Group group = new Group(imageView);
		group.setLayoutY(525);
		group.setLayoutX(35);

		group.setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				try {
					Desktop.getDesktop().browse(new URI("https://users.iit.uni-miskolc.hu/~buha/"));
				} catch (IOException | URISyntaxException e) {
					e.printStackTrace();
				}
			}
		});

		root.getChildren().add(group);

		// Nem tudom miért, de ide is be kell rakni
		ButtonX.setStyle("-fx-background-color: #ff0000; -fx-text-fill: #ffffff;");
		ButtonX.setOnAction(e -> {
			Stage stage = (Stage) ButtonX.getScene().getWindow();
			stage.close();
		});

	}

	// Escape button - X (IDK MIÉRT ÍGY - 331. SOR)
	public void EscapeButton() {
	}

	public void CalculatingButton() {
		if (getTextFieldInputWeight() == 0 || getTextFieldInputHydration() == 0 || getTextFieldInputDB() == 0) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.initStyle(StageStyle.TRANSPARENT);
			alert.setTitle("Hibás adatok!");
			alert.setHeaderText(" Sajnos rossz értékeket adtál meg!\t\t");
			alert.setContentText("Ha az érték helyes, akkor zöld lesz a mezője!");

			alert.setX(860);
			alert.setY(275);

			DialogPane dialogPane = alert.getDialogPane();
			dialogPane.getStylesheets().add(getClass().getResource("myDialogs.css").toExternalForm());
			dialogPane.setStyle("-fx-border-color: #ff0000; -fx-border-width: 1.5;");
			dialogPane.getStyleClass().add("myDialog");

			Button okBtn = (Button) alert.getDialogPane().lookupButton(ButtonType.OK);
			okBtn.setStyle("-fx-background-color: #ff0000; -fx-text-fill: #2a2f3b;");

			alert.showAndWait();
		} else {
			Ingredients ingredients = new Ingredients(getTextFieldInputWeight(), getTextFieldInputHydration(),
					getTextFieldInputDB());
			Poolish poolish = new Poolish(ingredients.flour(ingredients.getWeight(), ingredients.getHydration()),
					ingredients.water(ingredients.getWeight(), ingredients.getHydration()),
					ingredients.yeast(ingredients.getWeight()), ingredients.getDb());
			Neapolitan neapolitan = new Neapolitan(poolish.getFlour(), poolish.getWater(), poolish.getYeast(),
					ingredients.olive_oil(ingredients.getDb()),
					ingredients.salt(ingredients.getWeight(), ingredients.getHydration()), ingredients.getDb());

			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setX(860);
			alert.setY(185);
			alert.initStyle(StageStyle.TRANSPARENT);
			alert.setTitle("Kiszámítás kész");
			alert.setHeaderText(" Az értékek kiszámolásra kerültek!           ");
			alert.setContentText("Összes hozzávaló:      " + "     Ebből előtésztához:\n" + "Liszt: "
					+ (int) Math.round(neapolitan.getFlour()) + "g  \t\t        Liszt: "
					+ (int) Math.round(neapolitan.getWater()) + "g" + "\nVíz: "
					+ (int) Math.round(neapolitan.getWater()) + "ml  \t\t        Víz: "
					+ (int) Math.round(neapolitan.getWater()) + "ml" + "\nSó: " + (int) Math.round(neapolitan.getSalt())
					+ "g  \t\t\t        Élesztő: " + (int) Math.round(neapolitan.getYeast()) + "g\nÉlesztő: "
					+ (int) Math.round(neapolitan.getYeast()) + "g  \t\t        Kiskanálnyi méz" + "\nOliva olaj: "
					+ (int) Math.round(neapolitan.getOlive_oil()) + " löttyintés");

			DialogPane dialogPane = alert.getDialogPane();
			dialogPane.getStylesheets().add(getClass().getResource("myDialogs.css").toExternalForm());
			dialogPane.setStyle("-fx-border-color: #00ff7b; -fx-border-width: 1.5;");
			dialogPane.getStyleClass().add("myDialog");

			Button okBtn = (Button) alert.getDialogPane().lookupButton(ButtonType.OK);
			okBtn.setStyle("-fx-background-color: #00ff7b; -fx-text-fill: #2a2f3b;");

			alert.showAndWait();

		}
	}

	public void CalculatingButtonRomai() {
		if (getTextFieldInputASide() == 0 || getTextFieldInputBSide() == 0 || getTextFieldInputThickness() == 0
				|| getTextFieldInputHydration() == 0) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.initStyle(StageStyle.TRANSPARENT);
			alert.setTitle("Hibás adatok!");
			alert.setHeaderText(" Sajnos rossz értékeket adtál meg!\t\t");
			alert.setContentText("Ha az érték helyes, akkor zöld lesz a mezője!");

			alert.setX(860);
			alert.setY(275);

			DialogPane dialogPane = alert.getDialogPane();
			dialogPane.getStylesheets().add(getClass().getResource("myDialogs.css").toExternalForm());
			dialogPane.setStyle("-fx-border-color: #ff0000; -fx-border-width: 1.5;");
			dialogPane.getStyleClass().add("myDialog");

			Button okBtn = (Button) alert.getDialogPane().lookupButton(ButtonType.OK);
			okBtn.setStyle("-fx-background-color: #ff0000; -fx-text-fill: #2a2f3b;");

			alert.showAndWait();
		} else {
			// ide jönnek a Sheet pizza functionok
			Ingredients ingredients = new Ingredients(
					(getTextFieldInputASide() * getTextFieldInputBSide()) / getTextFieldInputThickness(),
					getTextFieldInputHydration(), 1);
			Poolish poolish = new Poolish(ingredients.flour(ingredients.getWeight(), ingredients.getHydration()),
					ingredients.water(ingredients.getWeight(), ingredients.getHydration()),
					ingredients.yeast(ingredients.getWeight()), ingredients.getDb());
			Sheet sheet = new Sheet(poolish.getFlour(), poolish.getWater(), poolish.getYeast(),
					ingredients.olive_oil(ingredients.getDb()),
					ingredients.salt(ingredients.getWeight(), ingredients.getHydration()));

			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setX(860);
			alert.setY(185);
			alert.initStyle(StageStyle.TRANSPARENT);
			alert.setTitle("Kiszámítás kész");
			alert.setHeaderText(" Az értékek kiszámolásra kerültek!            ");
			alert.setContentText("Összes hozzávaló:      " + "       Ebből előtésztához:\n" + "Liszt: "
					+ (int) Math.round(sheet.getFlour()) + "g  \t\t          Liszt: "
					+ (int) Math.round(sheet.getWater()) + "g" + "\nVíz: " + (int) Math.round(sheet.getWater())
					+ "ml  \t\t          Víz: " + (int) Math.round(sheet.getWater()) + "ml" + "\nSó: "
					+ (int) Math.round(sheet.getSalt()) + "g  \t\t\t          Élesztő: "
					+ (int) Math.round(sheet.getYeast()) + "g\nÉlesztő: " + (int) Math.round(sheet.getYeast())
					+ "g  \t\t          Kiskanálnyi méz" + "\nOliva olaj: " + (int) Math.round(sheet.getOlive_oil())
					+ " löttyintés");

			DialogPane dialogPane = alert.getDialogPane();
			dialogPane.getStylesheets().add(getClass().getResource("myDialogs.css").toExternalForm());
			dialogPane.setStyle("-fx-border-color: #00ff7b; -fx-border-width: 1.5;");
			dialogPane.getStyleClass().add("myDialog");

			Button okBtn = (Button) alert.getDialogPane().lookupButton(ButtonType.OK);
			okBtn.setStyle("-fx-background-color: #00ff7b; -fx-text-fill: #2a2f3b;");

			alert.showAndWait();

		}

	}

	private void animateTextColor(Label label, Color targetColor) {
		Duration duration = Duration.seconds(0.2);
		Timeline timeline = new Timeline(
				new KeyFrame(Duration.ZERO, new KeyValue(label.textFillProperty(), label.getTextFill())),
				new KeyFrame(duration, new KeyValue(label.textFillProperty(), targetColor)));
		timeline.play();
	}

	public void setTextFieldBorderColor(boolean valid, String name) {
		if (name.equalsIgnoreCase("weight")) {
			if (valid) {
				weight.setStyle(
						"-fx-focus-color: #00ff7b; -fx-control-inner-background: #2a2f3b; -fx-border-color: #00ff7b; -fx-border-radius: 3;");
			} else {
				weight.setStyle(
						"-fx-focus-color: #ff0000; -fx-control-inner-background: #2a2f3b; -fx-border-color: #ff0000; -fx-border-radius: 3;");
			}
		} else if (name.equalsIgnoreCase("hydration")) {
			if (valid) {
				hydration.setStyle(
						"-fx-focus-color: #00ff7b; -fx-control-inner-background: #2a2f3b; -fx-border-color: #00ff7b; -fx-border-radius: 3;");
			} else {
				hydration.setStyle(
						"-fx-focus-color: #ff0000; -fx-control-inner-background: #2a2f3b; -fx-border-color: #ff0000; -fx-border-radius: 3;");
			}
		} else {
			if (valid) {
				db.setStyle(
						"-fx-focus-color: #00ff7b; -fx-control-inner-background: #2a2f3b; -fx-border-color: #00ff7b; -fx-border-radius: 3;");
			} else {
				db.setStyle(
						"-fx-focus-color: #ff0000; -fx-control-inner-background: #2a2f3b; -fx-border-color: #ff0000; -fx-border-radius: 3;");
			}
		}
	}

	public void setTextFieldBorderColorRomai(boolean valid, String name) {
		if (name.equalsIgnoreCase("a_side")) {
			if (valid) {
				a_side.setStyle(
						"-fx-focus-color: #00ff7b; -fx-control-inner-background: #2a2f3b; -fx-border-color: #00ff7b; -fx-border-radius: 3;");
			} else {
				a_side.setStyle(
						"-fx-focus-color: #ff0000; -fx-control-inner-background: #2a2f3b; -fx-border-color: #ff0000; -fx-border-radius: 3;");
			}
		} else if (name.equalsIgnoreCase("b_side")) {
			if (valid) {
				b_side.setStyle(
						"-fx-focus-color: #00ff7b; -fx-control-inner-background: #2a2f3b; -fx-border-color: #00ff7b; -fx-border-radius: 3;");
			} else {
				b_side.setStyle(
						"-fx-focus-color: #ff0000; -fx-control-inner-background: #2a2f3b; -fx-border-color: #ff0000; -fx-border-radius: 3;");
			}
		} else if (name.equalsIgnoreCase("thickness")) {
			if (valid) {
				thickness.setStyle(
						"-fx-focus-color: #00ff7b; -fx-control-inner-background: #2a2f3b; -fx-border-color: #00ff7b; -fx-border-radius: 3;");
			} else {
				thickness.setStyle(
						"-fx-focus-color: #ff0000; -fx-control-inner-background: #2a2f3b; -fx-border-color: #ff0000; -fx-border-radius: 3;");
			}
		} else {
			if (valid) {
				hydration.setStyle(
						"-fx-focus-color: #00ff7b; -fx-control-inner-background: #2a2f3b; -fx-border-color: #00ff7b; -fx-border-radius: 3;");
			} else {
				hydration.setStyle(
						"-fx-focus-color: #ff0000; -fx-control-inner-background: #2a2f3b; -fx-border-color: #ff0000; -fx-border-radius: 3;");
			}
		}
	}

	public int getTextFieldInputWeight() {
		if (!weight.getText().isEmpty()) {
			try {
				String input = weight.getText();
				int real_weight;
				if (input.length() == 3 && input.matches("\\d+")) {
					real_weight = Integer.parseInt(input);
					if (real_weight >= 280 && real_weight <= 450) {
						setTextFieldBorderColor(true, "weight");
						return (int) Math.round(real_weight);
					}
					setTextFieldBorderColor(false, "weight");
					return 0;
				} else {
					setTextFieldBorderColor(false, "weight");
					return 0;
				}
			} catch (NumberFormatException e) {
				setTextFieldBorderColor(false, "weight");
				return 0;
			}
		} else {
			setTextFieldBorderColor(false, "weight");
			return 0;
		}
	}

	public int getTextFieldInputHydration() {
		if (!hydration.getText().isEmpty()) {
			try {
				String input = hydration.getText();
				int hydration;
				if (input.length() == 2 && input.matches("\\d+")) {
					hydration = Integer.parseInt(input);
					if (hydration >= 60 && hydration <= 70) {
						setTextFieldBorderColorRomai(true, "hydration");
						setTextFieldBorderColor(true, "hydration");
						return hydration;
					}
					setTextFieldBorderColorRomai(false, "hydration");
					setTextFieldBorderColor(false, "hydration");
					return 0;
				} else {
					setTextFieldBorderColorRomai(false, "hydration");
					setTextFieldBorderColor(false, "hydration");
					return 0;
				}
			} catch (NumberFormatException e) {
				setTextFieldBorderColorRomai(false, "hydration");
				setTextFieldBorderColor(false, "hydration");
				return 0;
			}
		} else {
			setTextFieldBorderColorRomai(false, "hydration");
			setTextFieldBorderColor(false, "hydration");
			return 0;
		}
	}

	public int getTextFieldInputDB() {
		if (!db.getText().isEmpty()) {
			try {
				String input = db.getText();
				int db;
				if ((input.length() == 1 || input.length() == 2 || input.length() == 3) && input.matches("\\d+")) {
					db = Integer.parseInt(input);
					if (db > 0) {
						setTextFieldBorderColor(true, "db");
						return db;
					}
					setTextFieldBorderColor(false, "db");
					return 0;
				} else {
					setTextFieldBorderColor(false, "db");
					return 0;
				}
			} catch (NumberFormatException e) {
				setTextFieldBorderColor(false, "db");
				return 0;
			}
		} else {
			setTextFieldBorderColor(false, "db");
			return 0;
		}
	}

	public int getTextFieldInputASide() {
		if (!a_side.getText().isEmpty()) {
			try {
				String input = a_side.getText();
				int a_side;
				if ((input.length() == 1 || input.length() == 2 || input.length() == 3) && input.matches("\\d+")) {
					a_side = Integer.parseInt(input);
					if (a_side > 0) {
						setTextFieldBorderColorRomai(true, "a_side");
						return a_side;
					}
					setTextFieldBorderColorRomai(false, "a_side");
					return 0;
				} else {
					setTextFieldBorderColorRomai(false, "a_side");
					return 0;
				}
			} catch (NumberFormatException e) {
				setTextFieldBorderColorRomai(false, "a_side");
				return 0;
			}
		} else {
			setTextFieldBorderColorRomai(false, "a_side");
			return 0;
		}
	}

	public int getTextFieldInputBSide() {
		if (!b_side.getText().isEmpty()) {
			try {
				String input = b_side.getText();
				int b_side;
				if ((input.length() == 1 || input.length() == 2) && input.matches("\\d+")) {
					b_side = Integer.parseInt(input);
					if (b_side > 0) {
						setTextFieldBorderColorRomai(true, "b_side");
						return b_side;
					}
					setTextFieldBorderColorRomai(false, "b_side");
					return 0;
				} else {
					setTextFieldBorderColorRomai(false, "b_side");
					return 0;
				}
			} catch (NumberFormatException e) {
				setTextFieldBorderColorRomai(false, "b_side");
				return 0;
			}
		} else {
			setTextFieldBorderColorRomai(false, "b_side");
			return 0;
		}
	}

	public double getTextFieldInputThickness() {
		if (!thickness.getText().isEmpty()) {
			try {
				String input = thickness.getText();
				double thickness;
				if ((input.length() == 3) && input.matches("\\d+")) {
					thickness = Integer.parseInt(input);
					thickness = thickness / 100;
					if (thickness > 0) {
						setTextFieldBorderColorRomai(true, "thickness");
						return thickness;
					}
					setTextFieldBorderColorRomai(false, "thickness");
					return 0;
				} else {
					setTextFieldBorderColorRomai(false, "thickness");
					return 0;
				}
			} catch (NumberFormatException e) {
				setTextFieldBorderColorRomai(false, "thickness");
				return 0;
			}
		} else {
			setTextFieldBorderColorRomai(false, "thickness");
			return 0;
		}
	}
}
