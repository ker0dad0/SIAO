package Model;
import Model.Bed;
import java.util.Date;

public class Occupation {
    private PersonInNeed person;
    private Bed bed;
    //private Room room;  car on déjà défini les classe Bed avec Room.


    public Occupation(PersonInNeed person, Bed bed /* Room room,*/ ) {
        this.person = person;
        this.bed = bed;
       // this.room = room;

    }

    public PersonInNeed getPerson() {
        return person;
    }

    public void setPerson(PersonInNeed person) {
        this.person = person;
    }

    public Bed getBed() {
        return bed;
    }

    public void setBed(Bed bed) {
        this.bed = bed;
    }

    public Room getRoom() {
        return bed.getRoom();
    }

   /* public void setRoom(Room room) {
        this.bed.getRoom() = room;
    } */



    public int occupationTime() {
        long startTime = person.getStartDate().getTime();
        long endTime = person.getEndDate().getTime();
        long diffTime = endTime - startTime;
        long diffDays = diffTime / (24 * 60 * 60 * 1000);   //1000 présente le nombre milliseconde d'une seconde
        return (int) diffDays;
    }

    public void affectationBed() {
        if (!bed.getState()) {
            bed.setState(true);
            bed.getRoom().setOccupiedBeds(bed.getRoom().getOccupiedBeds() + 1);
            System.out.println("Person " + person.getFirstName() + " " + person.getLastName() + " assigned to Bed " + bed.getIdb() + " in Room " + bed.getRoom().getIdr());
        } else {
            System.out.println("Bed " + bed.getIdb() + " is already occupied.");
        }
    }

    public void deleteOccupation() {
        bed.setState(false);
        bed.getRoom().setOccupiedBeds(bed.getRoom().getOccupiedBeds() - 1);
        System.out.println("Occupation deleted successfully. Bed " + bed.getIdb() + " in Room " + bed.getRoom().getIdr() + " is now vacant.");
    }
}

