package com.example.demo;

import Controller.PersonInNeedController;
import Model.PersonInNeed;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.ResourceBundle;

public class dashboardController implements Initializable {
    @FXML
    private AnchorPane home;

    @FXML
    private AnchorPane ajouter_personne;

    @FXML
    private AnchorPane heberger;

    @FXML
    private Button home_btn;

    @FXML
    private Button ajouter_personne_btn;

    @FXML
    private Button heberger_btn;

    @FXML
    private TextField first_name;

    @FXML
    private TextField last_name;

    @FXML
    private TextField age;

    @FXML
    private TextField numberss;

    @FXML
    private DatePicker start_date;

    @FXML
    private DatePicker end_date;

    @FXML
    private TextField gender;

    @FXML
    private Button ajouter;



    public void switchForm(ActionEvent event) {
        if (event.getSource() == home_btn) {
            home.setVisible(true);
            ajouter_personne.setVisible(false);
            heberger.setVisible(false);

        } else if (event.getSource() == ajouter_personne_btn) {
            home.setVisible(false);
            ajouter_personne.setVisible(true);
            heberger.setVisible(false);

        } else if (event.getSource() == heberger_btn) {
            home.setVisible(false);
            ajouter_personne.setVisible(false);
            heberger.setVisible(true);

        }
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }


    public void regiterPerson(ActionEvent event) {
        if (event.getSource() == ajouter ) {
            PersonInNeedController.registerPerson(0, Integer.parseInt(age.getText()), first_name.getText(), last_name.getText(), gender.getText(), numberss.getText(), java.sql.Date.valueOf(start_date.getValue()), java.sql.Date.valueOf(end_date.getValue()));
        }
    }
}
