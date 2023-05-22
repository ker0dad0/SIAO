package View;
import Model.*;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class PaintStrategy extends Application {

    Scene sceneConnexion, scenePrincipale, sceneAjouterPersonne, sceneAffectation, sceneSituationCentre;
    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage stage) throws Exception {

        stage.setTitle("SIAO");

        // Formulaire de connexion (nom d'utilisateur et mot de passe)
        Label label1 = new Label("Welcome!");
        TextField usernameField = new TextField("login");
        PasswordField passwordField = new PasswordField();
        Button button = new Button("Se connecter");

        button.setOnAction(e -> stage.setScene(scenePrincipale));

        VBox layout = new VBox(10);
        layout.setPadding(new Insets(10));
        layout.setAlignment(Pos.CENTER);
        layout.getChildren().addAll(label1, usernameField, passwordField, button);
        sceneConnexion = new Scene(layout, 450, 250);

        // Deuxième scène
        BorderPane layout2 = new BorderPane();
        HBox topBar = new HBox();
        topBar.setSpacing(1);

        Button ajouterPersonneButton = new Button("Ajouter Personne");
        ajouterPersonneButton.setOnAction(e -> stage.setScene(sceneAjouterPersonne));
        Button affectationButton = new Button("Affectation");
        affectationButton.setOnAction(e -> stage.setScene(sceneAffectation));
        Button situationCentreButton = new Button("Situation du Centre");
        situationCentreButton.setOnAction(e -> stage.setScene(sceneSituationCentre));

        topBar.getChildren().addAll(ajouterPersonneButton, affectationButton, situationCentreButton);
        layout2.setTop(topBar);

        Label label2 = new Label("Bienvenue dans votre espace !");
        StackPane centerPane = new StackPane();
        centerPane.getChildren().add(label2);
        layout2.setCenter(centerPane);

        scenePrincipale = new Scene(layout2, 800, 500);

        // Scène Ajouter Personne
        BorderPane layoutAjouterPersonne = new BorderPane();
        HBox topBar1 = new HBox();
        topBar1.setSpacing(1);

        Button ajouterPersonneButton1 = new Button("Ajouter Personne");
        ajouterPersonneButton1.setOnAction(e -> stage.setScene(sceneAjouterPersonne));
        Button affectationButton1 = new Button("Affectation");
        affectationButton1.setOnAction(e -> stage.setScene(sceneAffectation));
        Button situationCentreButton1 = new Button("Situation du Centre");
        situationCentreButton1.setOnAction(e -> stage.setScene(sceneSituationCentre));

        topBar1.getChildren().addAll(ajouterPersonneButton1, affectationButton1, situationCentreButton1);
        layoutAjouterPersonne.setTop(topBar1);

        Label labelAjouterPersonne = new Label("Scène Ajouter Personne");
        StackPane layoutAjouterPersonne1 = new StackPane();
        layoutAjouterPersonne1.getChildren().add(labelAjouterPersonne);
        sceneAjouterPersonne = new Scene(layoutAjouterPersonne1, 800, 500);

        // Scène Affectation
        BorderPane layoutAffectation = new BorderPane();
        HBox topBar2 = new HBox();
        topBar2.setSpacing(1);

        Button ajouterPersonneButton2 = new Button("Ajouter Personne");
        ajouterPersonneButton2.setOnAction(e -> stage.setScene(sceneAjouterPersonne));
        Button affectationButton2 = new Button("Affectation");
        affectationButton2.setOnAction(e -> stage.setScene(sceneAffectation));
        Button situationCentreButton2 = new Button("Situation du Centre");
        situationCentreButton2.setOnAction(e -> stage.setScene(sceneSituationCentre));

        topBar2.getChildren().addAll(ajouterPersonneButton2, affectationButton2, situationCentreButton2);
        layoutAffectation.setTop(topBar2);

        Label labelAffectation = new Label("Scène Affectation");
        StackPane layoutAffectation1 = new StackPane();
        layoutAffectation1.getChildren().add(labelAffectation);
        sceneAffectation = new Scene(layoutAffectation1, 800, 500);

// Scène Situation du Centre
        BorderPane layoutSituationCentre = new BorderPane();
        HBox topBar3 = new HBox();
        topBar3.setSpacing(1);

        Button ajouterPersonneButton3 = new Button("Ajouter Personne");
        ajouterPersonneButton3.setOnAction(e -> stage.setScene(sceneAjouterPersonne));
        Button affectationButton3 = new Button("Affectation");
        affectationButton3.setOnAction(e -> stage.setScene(sceneAffectation));
        Button situationCentreButton3 = new Button("Situation du Centre");
        situationCentreButton3.setOnAction(e -> stage.setScene(sceneSituationCentre));

        topBar3.getChildren().addAll(ajouterPersonneButton3, affectationButton3, situationCentreButton3);
        layoutSituationCentre.setTop(topBar3);

        Label labelSituationCentre = new Label("Scène Situation du Centre");
        StackPane layoutSituationCentre1 = new StackPane();
        layoutSituationCentre1.getChildren().add(labelSituationCentre);
        sceneSituationCentre = new Scene(layoutSituationCentre1, 800, 500);

        stage.setScene(sceneConnexion);
        stage.show();
    }
}
