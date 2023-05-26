package Controller;

import Model.Bed;
import Model.Occupation;
import Model.PersonInNeed;

import java.sql.SQLException;

public class OccupationController {
    /**
     * faire l'enregistrement d'un demandeur à un lit
     * @param ido
     * @param bed
     * @param personInNeed
     * @throws SQLException
     */
    public static void registerPersonInBed(int ido, Bed bed, PersonInNeed personInNeed) throws SQLException {
        Occupation occupation = new Occupation(personInNeed, bed, ido);

        occupation.save();
    }

    /**
     * supprimer l'enregistrement d'un lit
     * @param occupation
     * @throws SQLException
     */

    public static  void deletedPersonInBed(Occupation occupation) throws SQLException {
        occupation.deleteOccupation();
        occupation.delete();
    }


}
