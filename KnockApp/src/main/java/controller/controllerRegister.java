package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.InputStream;

public class controllerRegister {

    public Button btnBackAccessID;
    public PasswordField textFieldConfirmPasswordRegister;
    public PasswordField textFieldPasswordRegister;
    public TextField textFieldUsernameRegister;

    @FXML
    public void goBack(ActionEvent event) throws Exception {
        Stage stageTheEventSourceNodeBelongs = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stageTheEventSourceNodeBelongs.setScene(getWelcomeScene());
    }

    public Scene getWelcomeScene() throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader();
        InputStream resourceAsStream = getClass().getClassLoader().getResourceAsStream("welcomePage.fxml");
        Parent root = fxmlLoader.load(resourceAsStream);
        root.getStylesheets().add("designKnockApp.css");
        return new Scene(root, 800, 800);
    }

    public void registerAction(ActionEvent actionEvent) {
    }
}
