package com.example.demo;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class connexion implements Initializable {
    @FXML
    private TextField login;

    @FXML
    private PasswordField password;

    @FXML
    private Button connexion;

    private Connection connect;
    private PreparedStatement prepare;
    private ResultSet result;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // Code d'initialisation
    }

    @FXML
    public void loginAdmin(ActionEvent event) {
        String sql = "SELECT * FROM centersadmin WHERE login = ? and password = ?";

        connect = Database.connectDb();

        try {
            Alert alert;

            prepare = connect.prepareStatement(sql);
            prepare.setString(1, login.getText());
            prepare.setString(2, password.getText());

            result = prepare.executeQuery();

            // CHECK IF FIELDS ARE EMPTY
            if (login.getText().isEmpty() || password.getText().isEmpty()) {
                alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Veuillez remplir tous les champs vides");
                alert.showAndWait();
            } else {
                if (result.next()) {
                    // THEN PROCEED TO DASHBOARD FORM
                    alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Information Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Connecté avec succès !");
                    alert.showAndWait();

                    // TO HIDE THE LOGIN FORM
                    Stage currentStage = (Stage) connexion.getScene().getWindow();
                    currentStage.hide();

                    // LOAD DASHBOARD
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("dashboard.fxml"));
                    Parent root = loader.load();
                    Stage stage = new Stage();
                    stage.initStyle(StageStyle.UNDECORATED);
                    stage.setScene(new Scene(root));
                    stage.show();
                } else {
                    // THEN ERROR MESSAGE WILL APPEAR
                    alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Nom d'utilisateur incorrect / mot de passe");
                    alert.showAndWait();
                }
            }
        } catch (SQLException | IOException e) {
            e.printStackTrace();
        } finally {
            // Close database resources
            try {
                if (result != null)
                    result.close();
                if (prepare != null)
                    prepare.close();
                if (connect != null)
                    connect.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
