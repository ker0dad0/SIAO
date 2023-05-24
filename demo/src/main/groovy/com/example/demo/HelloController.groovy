package com.example.demo;
import com.example.demo.Database
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class HelloController implements Initializable {
    @FXML
    private AnchorPane main_form;

    @FXML
    private TextField login;

    @FXML
    private PasswordField password;

    @FXML
    private Button seConnecter;

    // DATABASE Tools
    private Connection connect;
    private PreparedStatement prepare;
    private ResultSet result;

    // NOW LET'S CREATE OUR DATABASE


    public void loginAdmin() {

        String sql = "SELECT * FROM centersadmin WHERE login = ? and password = ?";

        connect = Database.connectDb();

        try { // IT WORKS GOOD :) NOW LET'S DESIGN THE DASHBOARD FORM :)

            Alert alert;

            prepare = connect.prepareStatement(sql);
            prepare.setString(1, login.getText());
            prepare.setString(2, password.getText());

            result = prepare.executeQuery();

            // CHECK IF FIELDS ARE EMPTY
            if (login.getText().isEmpty() || password.getText().isEmpty()) {
                alert = new Alert(AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Veuillez remplir tous les champs vides");
                alert.showAndWait();
            } else {
                if (result.next()) {
                    // THEN PROCEED TO DASHBOARD FORM

                    alert = new Alert(AlertType.INFORMATION);
                    alert.setTitle("Information Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Connecter avec succès !");
                    alert.showAndWait();

                    // TO HIDE THE LOGIN FORM
                    seConnecter.getScene().getWindow().hide();

                    // LINK YOUR DASHBOARD
                    Parent root = FXMLLoader.load(getClass().getResource("dashboard.fxml"));

                    Stage stage = new Stage();
                    Scene scene = new Scene(root);

                    stage.setScene(scene);
                    stage.show();
                } else {
                    // THEN ERROR MESSAGE WILL APPEAR
                    alert = new Alert(AlertType.ERROR);
                    alert.setTitle("Error Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Nom d'utilisateur incorrect / mot de passe");
                    alert.showAndWait();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // Code d'initialisation
    }
}
