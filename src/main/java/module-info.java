module shrek.rest.shrek {
    requires javafx.controls;
    requires javafx.fxml;


    opens shrek.rest.shrek to javafx.fxml;
    exports shrek.rest.shrek;
}