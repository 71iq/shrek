package shrek.rest.shrek;

import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class LogIn {
    public static void start(Stage stage) throws IOException {


        Pane pane = new Pane();
        Scene scene = new Scene(pane, 720, 450);
        Image image = new Image("file:shrek/rest/shrek/image/shrek_background.png");
        BackgroundImage a = new BackgroundImage(image, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, new BackgroundSize(1440, 720, false, false, false, false));
        pane.setBackground(new Background(a));
        scene.setFill(Color.web("3A2E24FF"));
        stage.setScene(scene);
        stage.setTitle("Log In");

        TextField username = new TextField();
        username.setPrefWidth(200);

        PasswordField password = new PasswordField();
        password.setPrefWidth(200);

        Label userText = new Label("Username:");
        userText.setStyle("-fx-font: bold normal 20 serif; -fx-text-fill: #B8DE10;");

        Label passText = new Label("Password:");
        passText.setStyle("-fx-font: bold normal 20 serif; -fx-text-fill: #B8DE10;");

        Button logIn = new Button("Log in");
        logIn.setPrefHeight(37.5);
        logIn.setPrefWidth(125);
        setLayout(logIn, 3, 160);
        logIn.setStyle(bsbs.getBStyle());

        HBox user = new HBox(), pass = new HBox();
        pass.getChildren().addAll(passText, password);
        user.getChildren().addAll(userText, username);
        user.setSpacing(5);
        pass.setSpacing(10);

        ImageView userImage = new ImageView("file:shrek/rest/shrek/image/user_image.png");
        setLayout(userImage, 325, 70);

        VBox log = new VBox();
        log.getChildren().addAll(user, pass, logIn);
        setLayout(log, scene.getWidth() / 2 - 130, scene.getHeight() / 2 - 30);
        log.setAlignment(Pos.CENTER);
        log.setSpacing(10);

        Button backMain = new Button("Back");
        backMain.setStyle(bsbs.getBStyle() + "-fx-font: bold normal 24 serif;");
        setLayout(backMain, 15, 15);
        backMain.setPrefHeight(20);
        backMain.setPrefWidth(100);
        backMain.setOnAction(e -> SignIn.start(stage));

        pane.getChildren().addAll(userImage, log, backMain);

        ArrayList<User> users = User.getUsers();
        logIn.setOnAction(actionEvent -> {
            boolean notExisting = true;
            for (User value : users)
                if (value.getUserName().equals(username.getText()) && value.getPassword().equals(password.getText()))
                    notExisting = false;
            if (notExisting)
                new Alert(Alert.AlertType.ERROR, "Username or password is incorrect", ButtonType.OK).show();
            else Dishes.start(stage);
        });
    }

    public static void setLayout(Node n, double x, double y) {
        n.setLayoutX(x);
        n.setLayoutY(y);
    }
}
