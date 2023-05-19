package Model;

public class CenterAdmin {
    private int ida;
    private String login;
    private String password;
    private Center center;

    public CenterAdmin(String login, String password, Center center) {
        this.login = login;
        this.password = password;
        this.center = center;
    }

    public int getIda() {
        return ida;
    }

    public void setIda(int ida) {
        this.ida = ida;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Center getCenter() {
        return center;
    }

    public void seConnecter(String enteredLogin, String enteredPassword) {
        if (enteredLogin.equals(login) && enteredPassword.equals(password)) {
            System.out.println("Connexion réussie !");
        } else {
            System.out.println("Identifiant ou mot de passe incorrect !");
        }
    }


}

