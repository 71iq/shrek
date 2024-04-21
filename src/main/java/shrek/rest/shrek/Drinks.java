package shrek.rest.shrek;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

import java.util.ArrayList;
public class Drinks {
	public static GridPane getGridPane() {
		GridPane gridPane = new GridPane();
		ArrayList<Menu> menu = Menu.getMenu();
		for (int i = 0; i < 10; i++) {
			VBox vbox = new VBox();
			vbox.setAlignment(Pos.CENTER);

			Image image = new Image("file:shrek/src/main/java/shrek/rest/shrek/image/" + menu.get(i + 10).getImageName());
			ImageView iv = new ImageView(image);
			String des = menu.get(i + 10).getDescription();
			iv.setFitWidth(300);
			iv.setFitHeight(300);

			Label name = new Label(menu.get(i + 10).getName());
			name.setStyle("-fx-font: bold normal 24 serif; -fx-text-fill: #B8DE10");

			Label price = new Label("Price: " + menu.get(i + 10).getPrice() + "$");
			price.setStyle("-fx-font: bold normal 24 serif; -fx-text-fill: #B8DE10");

			Spinner<Integer> quantity = new Spinner<>(0, 99, 0, 1);

			Label info = new Label("?");
			info.setStyle(bsbs.getBStyle() + "-fx-font-size: 24;");
			info.setAlignment(Pos.CENTER);
			info.setPrefWidth(22);
			info.setOnMouseClicked(e -> {
				Alert alert = new Alert(Alert.AlertType.INFORMATION, des, ButtonType.OK);
				alert.setTitle("Food Description");
				alert.setHeaderText("");
				alert.show();
			});

			Button addToCard = new Button("Add to Cart");
			addToCard.setStyle(bsbs.getBStyle() + "-fx-font: bold normal 17 serif");
			int finalI = i + 10;
			addToCard.setOnAction(e -> {
				if (quantity.getValue() > 0) Menu.getMenu().get(finalI).setQuantity(quantity.getValue());
				else {
					Alert alert = new Alert(Alert.AlertType.ERROR, "The quantity = 0", ButtonType.OK);
					alert.setHeaderText("");
					alert.show();
				}
			});

			HBox hbox = new HBox();
			hbox.getChildren().addAll(name, info);
			hbox.setSpacing(15);
			hbox.setAlignment(Pos.CENTER);

			vbox.setPadding(new Insets(10, 10, 10, 10));
			vbox.setBackground(new Background(new BackgroundFill(Color.web("#4a3119"), new CornerRadii(5), new Insets(0))));
			vbox.setSpacing(10);
			vbox.getChildren().addAll(iv, hbox, price, quantity, addToCard);
			gridPane.add(vbox, i % 3, i / 3);
		}
		gridPane.setHgap(5);
		gridPane.setVgap(5);
		return gridPane;
	}
}