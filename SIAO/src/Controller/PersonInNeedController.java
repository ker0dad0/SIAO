package Controller;

import Model.PersonInNeed;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

public class PersonInNeedController {
    /**
     * enregistrer un nouvel utilsateur
     * @param idp
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
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
