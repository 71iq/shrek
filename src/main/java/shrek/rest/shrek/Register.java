package shrek.rest.shrek;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
public class Register {
	public static void start(Stage stage) throws IOException {

		stage.setTitle("Register");
		Pane pane = new Pane();
		Scene scene = new Scene(pane, 720, 450);
		stage.setScene(scene);


		Image image = new Image("file:shrek/src/main/java/shrek/rest/shrek/image/shrek_background.png");
		BackgroundImage a = new BackgroundImage(image, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, new BackgroundSize(1440, 720, false, false, true, true));

		pane.setBackground(new Background(a));
		scene.setFill(Color.web("3A2E24FF"));

		Button backMain = new Button("Back");
		backMain.setStyle(bsbs.getBStyle() + "-fx-font: bold normal 24 serif;");
		setLayout(backMain, 15, 15);
		backMain.setPrefHeight(20);
		backMain.setPrefWidth(100);
		backMain.setOnAction(e -> SignIn.start(stage));

		ImageView userImage = new ImageView("file:shrek/src/main/java/shrek/rest/shrek/image/user_image.png");
		setLayout(userImage, 325, 70);

		TextField username = new TextField();
		setLayout(username, scene.getWidth() / 2.4, scene.getHeight() / 2.35);
		username.setPrefWidth(200);

		PasswordField password = new PasswordField();
		setLayout(password, scene.getWidth() / 2.4, scene.getHeight() / 2);
		password.setPrefWidth(200);

		PasswordField recheck = new PasswordField();
		setLayout(recheck, scene.getWidth() / 2.4, scene.getHeight() / 1.74);
		recheck.setPrefWidth(200);

		Button login = new Button("Log in");
		login.setPrefHeight(37.5);
		login.setPrefWidth(125);
		login.setStyle(bsbs.getBStyle());
		setLayout(login, scene.getWidth() / 2.4, scene.getHeight() / 1.45);

		Label userText = new Label("Username:");
		userText.setStyle("-fx-font: bold normal 20 serif; -fx-text-fill: #B8DE10;");
		setLayout(userText, scene.getWidth() / 3.65, scene.getHeight() / 2.35);

		Label passText = new Label("Password:");
		passText.setStyle("-fx-font: bold normal 20 serif; -fx-text-fill: #B8DE10;");
		setLayout(passText, scene.getWidth() / 3.55, scene.getHeight() / 1.99);

		Label checkText = new Label("Rewrite password:");
		checkText.setStyle("-fx-font: bold normal 20 serif; -fx-text-fill: #B8DE10;");
		setLayout(checkText, scene.getWidth() / 5.45, scene.getHeight() / 1.74);

		pane.getChildren().addAll(userImage, login, passText, userText, checkText, backMain, username, password, recheck);
		ArrayList<User> users = User.getUsers();
		login.setOnAction(actionEvent -> {

			boolean exists = false;
			for (int i = 0; i < users.size(); i++)
				if (users.get(i).getUserName().equals(username.getText())) exists = true;
			if (exists) new Alert(Alert.AlertType.ERROR, "User already exists", ButtonType.OK).show();
			else if (!password.getText().equals(recheck.getText())) new Alert(Alert.AlertType.ERROR, "Password doesn't match", ButtonType.OK).show();
			else {
				try {
					File file = new File("USER.txt");
					file.createNewFile();
					FileWriter q = new FileWriter(file, true);
					users.add(new User(username.getText(), password.getText()));
					q.write("\n" + username.getText() + " " + password.getText());
					q.close();
				} catch (Exception ignored) {}
				Dishes.start(stage);
			}
		});
	}

	public static void setLayout(Node n, double x, double y) {
		n.setLayoutX(x);
		n.setLayoutY(y);
	}
}
