package shrek.rest.shrek;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
public class Cart {
	public static void start(Stage stage) throws IOException {

		ArrayList<HBox> list = new ArrayList<>();
		ArrayList<Menu> menu = Menu.getMenu();
		HBox title = new HBox();
		Label topName = new Label("Name of Food"), topPrice = new Label("Price For Each"), topQuantity = new Label("Quantity"), topTotal = new Label("Total");

		topName.setPrefWidth(200);
		topPrice.setPrefWidth(150);
		topQuantity.setPrefWidth(150);
		topTotal.setPrefWidth(150);

		topName.setStyle("-fx-font: bold normal 18 serif; -fx-text-fill: #B8DE10;");
		topPrice.setStyle("-fx-font: bold normal 18 serif; -fx-text-fill: #B8DE10;");
		topTotal.setStyle("-fx-font: bold normal 18 serif; -fx-text-fill: #B8DE10;");
		topQuantity.setStyle("-fx-font: bold normal 18 serif; -fx-text-fill: #B8DE10;");

		topName.setBackground(new Background(new BackgroundFill(Color.web("#3A2E24"), new CornerRadii(0), new Insets(0))));
		topPrice.setBackground(new Background(new BackgroundFill(Color.web("#3A2E24"), new CornerRadii(0), new Insets(0))));
		topQuantity.setBackground(new Background(new BackgroundFill(Color.web("#3A2E24"), new CornerRadii(0), new Insets(0))));
		topTotal.setBackground(new Background(new BackgroundFill(Color.web("#3A2E24"), new CornerRadii(0), new Insets(0))));

		topName.setAlignment(Pos.CENTER);
		topPrice.setAlignment(Pos.CENTER);
		topTotal.setAlignment(Pos.CENTER);
		topQuantity.setAlignment(Pos.CENTER);

		title.getChildren().addAll(topName, topPrice, topQuantity, topTotal);
		title.setSpacing(5);
		title.setAlignment(Pos.CENTER);
		int sum1 = 0;

		File file = new File("CART.txt");
		file.createNewFile();

		for (int i = 0; i < 30; i++) {
			if (menu.get(i).getQuantity() > 0) {

				sum1 += menu.get(i).getQuantity()*menu.get(i).getPrice();
				Label name = new Label(menu.get(i).getName()), price = new Label(menu.get(i).getPrice() + "$"), quantity = new Label(menu.get(i).getQuantity() + "");
				Label total = new Label(menu.get(i).getPrice() * menu.get(i).getQuantity() + "");

				try{
					FileWriter fw = new FileWriter(file, true);
					fw.write(menu.get(i).getName() + " " + menu.get(i).getPrice() + " " + menu.get(i).getQuantity() + "\n");
					fw.close();
				}catch(Exception ignored){}

				name.setPrefWidth(200);
				price.setPrefWidth(150);
				quantity.setPrefWidth(150);
				total.setPrefWidth(150);

				name.setAlignment(Pos.CENTER);
				price.setAlignment(Pos.CENTER);
				total.setAlignment(Pos.CENTER);
				quantity.setAlignment(Pos.CENTER);

				name.setStyle("-fx-font: bold normal 15 serif; -fx-text-fill: #B8DE10;");
				price.setStyle("-fx-font: bold normal 15 serif; -fx-text-fill: #B8DE10;");
				quantity.setStyle("-fx-font: bold normal 15 serif; -fx-text-fill: #B8DE10;");
				total.setStyle("-fx-font: bold normal 15 serif; -fx-text-fill: #B8DE10;");

				total.setBackground(new Background(new BackgroundFill(Color.web("#816a46"), new CornerRadii(0), new Insets(0))));
				name.setBackground(new Background(new BackgroundFill(Color.web("#816a46"), new CornerRadii(0), new Insets(0))));
				price.setBackground(new Background(new BackgroundFill(Color.web("#816a46"), new CornerRadii(0), new Insets(0))));
				quantity.setBackground(new Background(new BackgroundFill(Color.web("#816a46"), new CornerRadii(0), new Insets(0))));

				HBox h = new HBox();
				h.setSpacing(5);
				h.getChildren().addAll(name, price, quantity, total);
				h.setAlignment(Pos.CENTER);
				list.add(h);
			}
		}

		HBox bottom = new HBox();

		Button back = new Button("Main"), exit = new Button("Exit");

		back.setStyle(bsbs.getBStyle() + "-fx-font-size: 22px;");
		back.setOnAction(e -> SignIn.start(stage));

		exit.setStyle(bsbs.getBStyle() + "-fx-font-size: 22px;");
		exit.setOnAction(e -> {

			Stage stage1 = new Stage();
			BorderPane pane = new BorderPane();

			Image image = new Image("file:shrek/src/main/java/shrek/rest/shrek/image/shrek_dance.gif");
			ImageView imageView = new ImageView(image);
			imageView.setFitWidth(400);
			imageView.setFitHeight(320);

			Label thank = new Label("Thanks For Buying");
			thank.setPrefWidth(600);
			thank.setAlignment(Pos.CENTER);
			thank.setStyle("-fx-font: bold italic 48 cursive; -fx-font-family: 'Brush Script MT', cursive; -fx-text-fill: #B8DE10;-fx-fill-background: #4a3119;");

			Button back1 = new Button("Main");
			back1.setPrefWidth(150);
			HBox hh = new HBox();
			hh.setAlignment(Pos.CENTER);
			hh.setPrefWidth(600);
			hh.getChildren().add(back1);
			back1.setPadding(new Insets(10));
			back1.setStyle(bsbs.getBStyle() + "-fx-font-size: 22px;");
			back1.setOnAction(e1 -> {
				stage1.hide();
				SignIn.start(stage);
			});

			pane.setCenter(imageView);
			pane.setTop(thank);
			pane.setBottom(hh);

			stage1.setScene(new Scene(pane, 600, 500));
			stage1.setTitle("Thanks");
			stage1.setResizable(false);
			stage1.show();
			stage.hide();
		});
		Label sum = new Label("Sum = " + sum1 + "$");
		sum.setStyle(bsbs.getBStyle() + "-fx-cursor:normal; -fx-font-size: 22px;");
		back.setPadding(new Insets(10));
		back.setPrefWidth(150);
		exit.setPrefWidth(150);
		sum.setAlignment(Pos.CENTER);
		sum.setPrefWidth(250);
		exit.setPadding(new Insets(10));
		sum.setPadding(new Insets(10));
		bottom.getChildren().addAll(back, exit, sum);
		bottom.setAlignment(Pos.BOTTOM_CENTER);
		bottom.setPadding(new Insets(20));
		bottom.setSpacing(50);

		VBox v = new VBox();
		v.setSpacing(3);
		v.getChildren().add(title);
		for (int i = 0; i < list.size(); i++)
			v.getChildren().add(list.get(i));
		v.getChildren().add(bottom);

		ScrollPane root = new ScrollPane();
		root.setContent(v);

		Scene scene = new Scene(root, 700, v.getMinHeight());
		stage.setTitle("Cart");
		stage.setResizable(false);
		stage.setScene(scene);
		stage.show();
	}
}