package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.InputStream;

public class controllerWelcome {
    public Button btnLoginAccessID;
    public Button btnRegisterAccessID;

    public void goToLoginPage(ActionEvent actionEvent) throws Exception {

        Stage loadPane = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        loadPane.setScene(getLoginScene());

         System.out.println ("Login Pane Activated");

    }

    public void goToRegisterPage(ActionEvent actionEvent) throws Exception {

        Stage loadPane = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        loadPane.setScene(getRegisterScene());

        System.out.println ("Register Pane Activated");
    }

    public Scene getLoginScene() throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader();
        InputStream resourceAsStream = getClass().getClassLoader().getResourceAsStream("loginPage.fxml");
        Parent root = fxmlLoader.load(resourceAsStream);
        root.getStylesheets().add("designKnockApp.css");
        return new Scene(root, 800, 800);
    }

    public Scene getRegisterScene() throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader();
        InputStream resourceAsStream = getClass().getClassLoader().getResourceAsStream("registerPage.fxml");
        Parent root = fxmlLoader.load(resourceAsStream);
        root.getStylesheets().add("designKnockApp.css");
        return new Scene(root, 800, 800);
    }
}
