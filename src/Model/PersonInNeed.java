package Model;

import java.util.Date;
public class PersonInNeed {
    private int idp;
    private int age;
    private String firstName;
    private String lastName;
    private String gender;
    private String ssNumber;
    private Date startDate;
    private Date endDate;
    // private Bed bed; pas besoin car on a pas encore affecter cette personne à un lit, on va utiliser dans l'association Occupation

    public PersonInNeed(int idp, int age, String firstName, String lastName, String gender, String ssNumber, Date startDate, Date endDate) {
        this.idp = idp;
        this.age = age;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.ssNumber = ssNumber;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    // getters et setters
    public int getIdp() {
        return idp;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getSsNumber() {
        return ssNumber;
    }

    public void setSsNumber(String ssNumber) {
        this.ssNumber = ssNumber;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

// peut etre on va utiliser ces méthodes en bas dans la partie Controller(CenterManager.java).
    // méthode pour créer un PersonInNeed
    public void create() {
        // Instructions pour insérer la personne dans la base de données
        System.out.println("Person created successfully.");
    }

    // méthode pour supprimer un PersonInNeed
    public void delete() {
        // Instructions pour supprimer la personne de la base de données
        System.out.println("Person deleted successfully.");
    }
}

