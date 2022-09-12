package com.example.hw8;

/**
 * Sample Skeleton for 'converter.fxml' Controller Class
 */

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class ConverterCon {

    @FXML // fx:id="clear_btn"
    private Button clear_btn; // Value injected by FXMLLoader

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="lab_g"
    private Label lab_g; // Value injected by FXMLLoader

    @FXML // fx:id="lab_kg"
    private Label lab_kg; // Value injected by FXMLLoader

    @FXML // fx:id="lab_t"
    private Label lab_t; // Value injected by FXMLLoader

    @FXML // fx:id="label_in"
    private TextField label_in; // Value injected by FXMLLoader

    @FXML // fx:id="myChoiceBox"
    private ChoiceBox<String> myChoiceBox; // Value injected by FXMLLoader

    @FXML // fx:id="get_btn"
    private Button get_btn; // Value injected by FXMLLoader

    private String[] option = {"тонн", "килограмм", "грамм"};

    private String myOption = "";

    private float myValue = 0.0f;



    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert lab_g != null : "fx:id=\"lab_g\" was not injected: check your FXML file 'converter.fxml'.";
        assert lab_kg != null : "fx:id=\"lab_kg\" was not injected: check your FXML file 'converter.fxml'.";
        assert lab_t != null : "fx:id=\"lab_t\" was not injected: check your FXML file 'converter.fxml'.";
        assert label_in != null : "fx:id=\"label_in\" was not injected: check your FXML file 'converter.fxml'.";
        assert myChoiceBox != null : "fx:id=\"myChoiceBox\" was not injected: check your FXML file 'converter.fxml'.";
        myChoiceBox.getItems().addAll(option);
        get_btn.setOnAction(actionEvent -> {
            setMyOption(actionEvent);
            try {
                myValue = Float.parseFloat(label_in.getText());
                if (myValue<0) throw new NumberFormatException();
                convert();
            }
            catch (NumberFormatException e){
                lab_t.setText("Неверное значение");
                lab_kg.setText("Неверное значение");
                lab_g.setText("Неверное значение");
            }
        });
        clear_btn.setOnAction(actionEvent -> {
            label_in.setText("");
            lab_t.setText("");
            lab_kg.setText("");
            lab_g.setText("");
        });
    }
    private void setMyOption(ActionEvent event){
        try {
            myOption = myChoiceBox.getValue();
            if (myOption==null) throw new RuntimeException();
        }
        catch (RuntimeException e){
            label_in.setText("Сначала выберите значение в боксе");
        }
    }
    private void convert(){
        switch (myOption){
            case "тонн":
                lab_t.setText(String.valueOf(myValue));
                lab_kg.setText(String.valueOf(myValue*1000));
                lab_g.setText(String.valueOf(myValue*1000000));
                break;
            case "килограмм":
                lab_t.setText(String.valueOf(myValue/1000));
                lab_kg.setText(String.valueOf(myValue));
                lab_g.setText(String.valueOf(myValue*1000));
                break;
            case "грамм":
                lab_t.setText(String.valueOf(myValue/1000000));
                lab_kg.setText(String.valueOf(myValue/1000));
                lab_g.setText(String.valueOf(myValue));
                break;
            default:
                lab_t.setText("Что-то пошло не так,");
                lab_kg.setText(String.valueOf("я не знаю как"));
                lab_g.setText(String.valueOf("тебе это удалось"));
        }
    }

}
