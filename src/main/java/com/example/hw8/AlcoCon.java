package com.example.hw8;

/**
 * Sample Skeleton for 'alcoholic.fxml' Controller Class
 */


/**
 * Sample Skeleton for 'alcoholic.fxml' Controller Class
 */

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class AlcoCon {

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="lab_beer"
    private Label lab_beer; // Value injected by FXMLLoader

    @FXML // fx:id="lab_in"
    private TextField lab_in; // Value injected by FXMLLoader

    @FXML // fx:id="lab_wine"
    private Label lab_wine; // Value injected by FXMLLoader

    @FXML // fx:id="lab_wiskey"
    private Label lab_wiskey; // Value injected by FXMLLoader

    @FXML // fx:id="main_lab"
    private Label main_lab; // Value injected by FXMLLoader

    float weight = 0.0f;

    @FXML
    void getAlcoholic(ActionEvent event) {
        String str = lab_in.getText();
        try {
            if (str.isEmpty()) throw new IOException();
            weight = Float.parseFloat(str);
        } catch (IOException e) {
            main_lab.setText("Я узнаю это для твоего блага, ну же");
            clear();
        } catch (NumberFormatException e) {
            main_lab.setText("C такой массой лучше не пить, дружок");
            clear();
        }
        setAlcoDoza();
    }

    @FXML
        // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert lab_beer != null : "fx:id=\"lab_beer\" was not injected: check your FXML file 'alcoholic.fxml'.";
        assert lab_in != null : "fx:id=\"lab_in\" was not injected: check your FXML file 'alcoholic.fxml'.";
        assert lab_wine != null : "fx:id=\"lab_wine\" was not injected: check your FXML file 'alcoholic.fxml'.";
        assert lab_wiskey != null : "fx:id=\"lab_wiskey\" was not injected: check your FXML file 'alcoholic.fxml'.";
        assert main_lab != null : "fx:id=\"main_lab\" was not injected: check your FXML file 'alcoholic.fxml'.";
        main_lab.setText("Скажи мне свой вес собутыльник:");

    }

    public void clear() {
        lab_beer.setText("");
        lab_in.setText("");
        lab_wine.setText("");
        lab_wiskey.setText("");
    }

    private void setAlcoDoza() {
        if (weight <= 40) {
            lab_beer.setText("Я бы тебе не советовал");
            lab_in.setText("");
            lab_wine.setText("Даже не смотри сюда");
            lab_wiskey.setText("МММ... даже не знаю");
        } else if (weight <= 60) {
            lab_beer.setText("0.5 litre");
            lab_in.setText("");
            lab_wine.setText("0.2 litre");
            lab_wiskey.setText("Можно понюхать");
        } else if (weight <= 80) {
            lab_beer.setText("1.5 litre");
            lab_in.setText("");
            lab_wine.setText("0.7 litre");
            lab_wiskey.setText("0,35 litre");
        } else if (weight <= 100) {
            lab_beer.setText("2.0 litre");
            lab_in.setText("");
            lab_wine.setText("1.0 litre");
            lab_wiskey.setText("0,5 litre");
        } else if (weight <= 120) {
            lab_beer.setText("3.0 litre");
            lab_in.setText("");
            lab_wine.setText("1.5 litre");
            lab_wiskey.setText("0,7 litre");
        } else if (weight > 120) {
            lab_beer.setText("Этот компот тебе не нужен");
            lab_in.setText("");
            lab_wine.setText("Неограниченно");
            lab_wiskey.setText("> 1.0 litre");

        }
    }
}

