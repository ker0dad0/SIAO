package Controller;

import Model.Bed;
import Model.Room;

public class BedController {

    /**
     * renvois la disponibilité d'un lit
     * @return
     */
    public static boolean isAvailable(Bed bed){
        return bed.getState();
    }

    /**
     * afficher les details d'un lit
     */
    public static Bed showBed(Bed bed){
        return bed;
    }

}