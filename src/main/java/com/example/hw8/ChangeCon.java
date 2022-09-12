package com.example.hw8;

/**
 * Sample Skeleton for 'homework2.fxml' Controller Class
 */

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class ChangeCon {


    static Stage stage;

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="alc"
    private Button alc; // Value injected by FXMLLoader

    @FXML // fx:id="conv"
    private Button conv; // Value injected by FXMLLoader

    @FXML // fx:id="label"
    private Label label; // Value injected by FXMLLoader

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert alc != null : "fx:id=\"alc\" was not injected: check your FXML file 'homework2.fxml'.";
        assert conv != null : "fx:id=\"conv\" was not injected: check your FXML file 'homework2.fxml'.";
        assert label != null : "fx:id=\"label\" was not injected: check your FXML file 'homework2.fxml'.";

        label.setText("Hello, "+HelloController.name+", nice to met you, select your option");
        conv.setOnAction(actionEvent -> {
            getConv();
        });
        alc.setOnAction(actionEvent -> {
            getAlc();
        });
    }
    private void getConv(){
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("converter.fxml"));
            stage = new Stage();
            Scene scene = new Scene(fxmlLoader.load());
            stage.setTitle("Converter");
            stage.setScene(scene);
            stage.show();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
    private void getAlc(){
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("alcoholic.fxml"));
            stage = new Stage();
            Scene scene = new Scene(fxmlLoader.load());
            stage.setTitle("alcoholic");
            stage.setScene(scene);
            stage.show();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
