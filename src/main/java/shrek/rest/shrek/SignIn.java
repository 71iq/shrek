package shrek.rest.shrek;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;
public class SignIn {
	public static void start(Stage stage) {

		stage.setTitle("Sign In");
		Pane pane = new Pane();
		Scene scene = new Scene(pane, 720, 450);

		Label title = new Label("Shrek Restaurant");
		title.setStyle("-fx-font: bold italic 66 cursive; -fx-font-family: 'Brush Script MT', cursive; -fx-text-fill: #B8DE10;");
		setLayout(title, 10, 5);

		Image image = new Image("file:/home/ihab/code/Ideaprojects/shrek/src/main/java/shrek/rest/shrek/image/shrek_background.png");
		BackgroundImage a = new BackgroundImage(image, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, new BackgroundSize(1440, 720, false, false, true, true));

		Button Login = new Button("Login");
		setLayout(Login, 10, 115);
		Login.setPrefWidth(200);
		Login.setPrefHeight(60);
		Login.setStyle(bsbs.getBStyle());
		Login.setOnAction(e -> {
			try {
				LogIn.start(stage);
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		});

		Button register = new Button("Register");
		setLayout(register, 10, 190);
		register.setPrefWidth(200);
		register.setPrefHeight(60);
		register.setStyle(bsbs.getBStyle());
		register.setOnAction(e -> {
			try {
				Register.start(stage);
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		});

		pane.setBackground(new Background(a));
		scene.setFill(Color.web("3A2E24FF"));
		pane.getChildren().addAll(Login, title, register);
		stage.setScene(scene);
		stage.show();
	}

	public static void setLayout(Node n, double x, double y) {
		n.setLayoutX(x);
		n.setLayoutY(y);
	}
}
