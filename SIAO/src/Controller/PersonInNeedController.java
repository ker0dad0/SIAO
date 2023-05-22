package Controller;

import Model.PersonInNeed;
import Model.Room;
import groovyjarjarantlr4.v4.codegen.model.SrcOp;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;

public class PersonInNeedController {
    /**
     * renvoi un booléen si la personne est déjà logé
     * @param idp
     * @return
     * @throws SQLException
     */
    public static boolean isHoused(int idp) throws SQLException {
        DbConnexion dbConnexion = new DbConnexion();
        Connection connection = dbConnexion.openConnexion();
        ArrayList<Integer> idps = new ArrayList<>();

        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT idp FROM occupations");

        while (resultSet.next()) {
            idps.add(resultSet.getInt("idp"));
        }

        if(idps.contains(idp)){
             return true;
        }
         else {
             return  false;
        }
    }
    /**
     * enregistrer un nouvel utilsateur
     * @param idp // ici on va renvoyer un attribut au depart null pour creer l'objet
     * @param age
     * @param firstName
     * @param lastName
     * @param gender
     * @param ssNumber
     * @param startDate
     * @param endDate
     */
    public static void registerPerson(int idp, int age, String firstName, String lastName, String gender, String ssNumber, Date startDate, Date endDate){
        PersonInNeed personInNeed = new PersonInNeed(idp, age, firstName, lastName, gender, ssNumber, startDate, endDate);

        // sauvagarde de l'objet dans la bd
        try{
            personInNeed.save();
        }catch (SQLException s){
            s.printStackTrace();
        }
    }

    /**
     * supprimer un demandeur de la bd
     * @param idp
     * @throws SQLException
     */
    public static void deletedPerson(int idp) throws SQLException {
        DbConnexion dbConnexion = new DbConnexion();
        Connection connection = dbConnexion.openConnexion();
        Statement statement = connection.createStatement();

        try{
            statement.execute("DELETE FROM personinNeed WHERE idp =" +  idp);
            statement.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static ArrayList<PersonInNeed> getAllPersons() throws SQLException {

        DbConnexion dbConnexion = new DbConnexion();
        Connection connection = dbConnexion.openConnexion();
        Statement statement = connection.createStatement();
        ArrayList<PersonInNeed> persons = new ArrayList<>();

        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM personinneed;");

            while (resultSet.next()) {

                PersonInNeed personInNeed  = new PersonInNeed(resultSet.getInt("idp"),
                        resultSet.getInt("age"),
                        resultSet.getString("firstName"),
                        resultSet.getString("lastName"),
                        resultSet.getString("gender"),
                        resultSet.getString("ssNumber"),
                        resultSet.getDate("startDate"),
                        resultSet.getDate("endDate")
                );
                persons.add(personInNeed);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return persons;
    }
}
