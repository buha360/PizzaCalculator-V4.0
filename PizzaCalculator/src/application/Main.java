package application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Main extends Application {

	@Override
	public void start(Stage stage) {
		try {
			System.setProperty("prism.lcdtext", "false");

			Parent root = FXMLLoader.load(getClass().getResource("Main.fxml"));
			Scene scene = new Scene(root); // 1100, 660
			Image icon = new Image("PizzaCalculator_image.png");
			String css = this.getClass().getResource("application.css").toExternalForm();
			scene.getStylesheets().add(css);
			stage.initStyle(StageStyle.TRANSPARENT);
			stage.getIcons().add(icon);
			stage.setResizable(false);
			stage.setTitle("PizzaCalculator V4.0");
			stage.setScene(scene);
			stage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}
