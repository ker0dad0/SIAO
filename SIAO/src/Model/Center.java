package Model;

import java.util.ArrayList;

public class Center {
    private String name;
    private String adresse;
    private int roomNumber;
    private ArrayList<Room> listRoom;   // juste la liste des chambres dans notres chambre de type Room

    public Center(String name, String adresse, int roomNumber) {
        this.name = name;
        this.adresse = adresse;
        this.roomNumber = roomNumber;
        listRoom = new ArrayList<>();   // on initialise la liste des chambres (list vide) et on va la remplire
                                       // en fonction de la construction de notre centre
    }


// getters et setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAdresse() {
        return adresse;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }
/*
    public int getNumberRooms() {
        return listRoom.size();
    }  */

    // méthode pour retourner la liste des chambres
    public ArrayList<Room> getRooms() {
        return listRoom;
    }

    // méthode pour retourner une chambre à travers son ID
    public Room getRoomById(int idr) {
        for (Room room : listRoom) {
            if (room.getIdr() == idr) {
                return room;
            }
        }
        return null; // Retourne null si la chambre n'est pas trouvée
    }

    // pour rajouter une chambre à notre centre
    public void addRoom(Room room) {
        listRoom.add(room);
    }

    // méthode pour montrer le détail de notre centre
    public String showCenter() {
        StringBuilder centerInfo = new StringBuilder();
        centerInfo.append("Center Name: ").append(name).append("\n");
        centerInfo.append("Address: ").append(adresse).append("\n");
        centerInfo.append("Room Count: ").append(roomNumber).append("\n");

        for (Room room : listRoom) {
            centerInfo.append("\nRoom ID: ").append(room.getIdr()).append("\n");
            centerInfo.append("Number of Beds: ").append(room.getNumberBeds()).append("\n");
            centerInfo.append("Room State: ").append(room.showRoom()).append("\n");
        }

        return centerInfo.toString();
    }
}

