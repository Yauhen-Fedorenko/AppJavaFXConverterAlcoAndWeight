module com.example.hw8 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.hw8 to javafx.fxml;
    exports com.example.hw8;
}