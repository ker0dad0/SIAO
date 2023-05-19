package Model;

import java.util.ArrayList;
import java.util.List;

public class Room {
    private int idr;
    private int numberOfPlaces;
    private ArrayList<Bed> listBed;
    private boolean state;  // false si la chambre est vide, true si la chambre est occupée
    private int occupiedBeds;

    public Room(int idr, int numberOfPlaces) {
        this.idr = idr;
        this.numberOfPlaces = numberOfPlaces;
        state = false;   // false car on vient de créer une nouvelle chambre et y a encore des places libres
        listBed = new ArrayList<>();
    }

    public int getIdr() {
        return idr;
    }

    public int getNumberOfPlaces() {
        return numberOfPlaces;
    }

    public void setNumberOfPlaces(int numberOfPlaces) {
        this.numberOfPlaces = numberOfPlaces;
    }

    public boolean getState() {
        return state;    // false si y a encore des places et True s'y a plus de place libre
    }

    public void setState(boolean state) {
        this.state = state;
    }

    public int getOccupiedBeds() {
        return occupiedBeds;
    }

    public void setOccupiedBeds(int occupiedBeds) {
        this.occupiedBeds = occupiedBeds;
    }

    public void addBed(Bed bed){
        listBed.add(bed);
    }

    public int getNumberBeds() {
        return listBed.size();
    }

    public List<Bed> getBeds() {
        return listBed;
    }

    public static List<Room> getAvailableRooms(List<Room> rooms) {
        List<Room> availableRooms = new ArrayList<>();
        for (Room room : rooms) {
            if (!room.getState()) {   // on prend que les chambres qui retourne false ie y a encore au moins une place libre
                availableRooms.add(room);  // là on rajoute toutes les chambres où il y a encore des places disponibles
            }
        }
        return availableRooms;
    }
//***********************************  à déf dans le controller
    public String showRoom() {
        if (state) {
            return "Occupied";  // si state = True donc ya plus de place
        } else {
            return "Vacant";  // sinon on a encore des places
        }
    }


}

// on peut aussi rajouter la méthode qui va nous retourner le nombre de place libre(à discuter on peut la mettre dans controller)


