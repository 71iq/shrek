package shrek.rest.shrek;
import javafx.application.Application;
import javafx.stage.Stage;

import java.io.File;
import java.util.Scanner;
public class bsbs extends Application {
private final static String bStyle = "-fx-background-color:linear-gradient(#f0ff35, #a9ff00), radial-gradient(center 50% -40%, radius 200%, #b8ee36 45%, #80c800 50%); -fx-background-radius: 6, 5;-fx-background-insets: 0, 1;-fx-effect: dropshadow( three-pass-box , rgba(0,0,0,0.4) , 5, 0.0 , 0 , 1 );-fx-text-fill: #395306;-fx-font: bold normal 24 serif; -fx-cursor: hand;";

public static String getBStyle() {
	return bStyle;
}

public void start(Stage stage) {
	try {
		File file = new File("USER.txt");
		Scanner sc = new Scanner(file);
		while (sc.hasNextLine()) {
			String[] s = sc.nextLine().split(" ");
			User.getUsers().add(new User(s[0], s[1]));
		}
	} catch (Exception ignored) {}

	try{
		File file = new File("MENU.txt");
		Scanner sc = new Scanner(file);
		while ( sc.hasNextLine()){
			String[] s = sc.nextLine().split(",");
			Menu.getMenu().add(new Menu(s[0], s[1], s[2], Integer.parseInt(s[3]), Integer.parseInt(s[4])));
		}
	}catch(Exception ignored){}

	SignIn.start(stage);
}
}
