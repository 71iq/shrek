package shrek.rest.shrek;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Optional;
public class Dishes {
	public static void start(Stage stage){
		ScrollPane root = new ScrollPane();
		BorderPane borderPane = new BorderPane();
		Scene scene = new Scene(root, 1250, 750);

		Label title = new Label("Shrek Restaurant");
		title.setStyle("-fx-font: bold italic 84 cursive; -fx-font-family: 'Brush Script MT', cursive; -fx-text-fill: #B8DE10;-fx-fill-background: #4a3119;");
		title.setPrefWidth(scene.getWidth());
		title.setAlignment(Pos.CENTER);
		borderPane.setTop(title);

		Button fastFood = new Button("Fast Food"), drinks = new Button("Drinks"), special = new Button("Our Specials"), logOut = new Button("Log Out"), finish = new Button("Finish");
		fastFood.setStyle(bsbs.getBStyle());
		finish.setStyle(bsbs.getBStyle());
		drinks.setStyle(bsbs.getBStyle());
		special.setStyle(bsbs.getBStyle());
		logOut.setStyle(bsbs.getBStyle());
		fastFood.setPrefWidth(205);
		drinks.setPrefWidth(205);
		logOut.setPrefWidth(205);
		finish.setPrefHeight(100);
		finish.setPrefWidth(205);
		fastFood.setPrefHeight(100);
		special.setPrefHeight(100);
		drinks.setPrefHeight(100);
		logOut.setPrefHeight(100);

		fastFood.setOnAction(e -> borderPane.setCenter(FastFood.getGridPane()));
		drinks.setOnAction(e -> borderPane.setCenter(Drinks.getGridPane()));
		special.setOnAction(e -> borderPane.setCenter(Specials.getGridPane()));
		logOut.setOnAction(e -> {
			Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Your progress will be lost");
			Optional<ButtonType> result = alert.showAndWait();
			if ( result.get() == ButtonType.OK )
				SignIn.start(stage);
		});
		finish.setOnAction(e -> {
			try {
				Cart.start(stage);
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		});

		VBox buttons = new VBox();
		buttons.getChildren().addAll(fastFood, drinks, special, finish, logOut);
		buttons.setSpacing(10);
		borderPane.setCenter(FastFood.getGridPane());
		borderPane.setLeft(buttons);
		Image i = new Image("file:shrek/src/main/java/shrek/rest/shrek/image/shrek_background.png");
		BackgroundImage a = new BackgroundImage(i, null,null, null, null);
		borderPane.setBackground(new Background(a));

		root.setContent(borderPane);
		root.setVbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS);

		stage.setTitle("Menu");
		stage.setScene(scene);
		stage.show();
	}
}