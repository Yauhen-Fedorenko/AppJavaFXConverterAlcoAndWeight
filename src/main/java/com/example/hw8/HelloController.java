package com.example.hw8;
/**
 * Sample Skeleton for 'homework1.fxml' Controller Class
 */


import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class HelloController {

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="enter"
    private Button enter;

    static String name = "";
    static Stage stage;// Value injected by FXMLLoader

    @FXML // fx:id="welcomeText"
    private TextField welcomeText; // Value injected by FXMLLoader

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert enter != null : "fx:id=\"enter\" was not injected: check your FXML file 'homework1.fxml'.";
        assert welcomeText != null : "fx:id=\"welcomeText\" was not injected: check your FXML file 'homework1.fxml'.";
        enter.setOnAction(actionEvent -> {
            name = welcomeText.getText();
            if (name.isEmpty()) name = "unknown";
            try {
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("homework2.fxml"));
                stage = new Stage();
                Scene scene = new Scene(fxmlLoader.load());
                stage.setTitle("Change your variant");
                stage.setScene(scene);
                stage.show();
            }
            catch (Exception e){
                e.printStackTrace();
            }
            HelloApplication.setCurtail();
        });
    }
}
