package com.example.demo;

import Controller.DbConnexion;
import Controller.OccupationController;
import Controller.PersonInNeedController;
import Model.Bed;
import Model.PersonInNeed;
import Model.Room;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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

    @FXML
    private Button affecter;

    @FXML
    private TextField show_person;



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
    private String s;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        s = "affecter personne";
        show_person.setText(s);
    }


    public void regiterPerson(ActionEvent event) {
        if (event.getSource() == ajouter ) {
            PersonInNeedController.registerPerson(0, Integer.parseInt(age.getText()), first_name.getText(), last_name.getText(), gender.getText(), numberss.getText(), java.sql.Date.valueOf(start_date.getValue()), java.sql.Date.valueOf(end_date.getValue()));
        }
    }


    public String showPerson() throws SQLException {
        PersonInNeed person = PersonInNeedController.getFalsePerson();
        String s = person.getIdp() + " " + person.getFirstName() + " " + person.getLastName();
        show_person.setText(s);
         return  s;
    }

    /***
     * c'est juste pour affecter un personne
     * @param event
     * @throws SQLException
     */
    public  void affectedProcess(ActionEvent event) throws SQLException {
        if (event.getSource() == affecter){
            DbConnexion dbConnexion = new DbConnexion();
            Connection connection = dbConnexion.openConnexion();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT idb, idr FROM beds WHERE state = 0 AND idb = (SELECT MIN(idb) FROM beds WHERE state = 0);");
            if (resultSet.next()) {
                Room room = new Room(resultSet.getInt("idr"), 4);
                Bed bed = new Bed(resultSet.getInt("idb"), room);

                Statement statement1 = connection.createStatement();
                ResultSet resultSet1 = statement1.executeQuery("SELECT * FROM personinneed WHERE idp = (SELECT MAX(idp) FROM personinneed);");
                if (resultSet1.next()) {
                    PersonInNeed personInNeed = new PersonInNeed(
                            resultSet1.getInt("idp"),
                            resultSet1.getInt("age"),
                            resultSet1.getString("firstName"),
                            resultSet1.getString("lastName"),
                            null,
                            null,
                            resultSet1.getDate("startDate"),
                            resultSet1.getDate("endDate")
                    );

                    OccupationController.registerPersonInBed(0, bed, personInNeed);
                    Statement statement3 = connection.createStatement();
                    statement3.execute("UPDATE beds SET state = '1' WHERE idb = " +  bed.getIdb());

                }
            }
        }
    }


}
