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
import mode.User;
import repository.UserRepository;

import java.io.InputStream;

public class controllerLogin {

    public Button btnBackAccessID;
    public Button btnShowActionID;
    public Button btnLoginActionID;
    public TextField textFieldUsernameLogin;
    public PasswordField passwordFieldPasswordLogin;
    public TextField textFieldPasswordLogin;
    private UserRepository userRepository;


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

    public Scene getAppInside() throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader();
        InputStream resourceAsStream = getClass().getClassLoader().getResourceAsStream("appInsidePage.fxml");
        Parent root = fxmlLoader.load(resourceAsStream);
        root.getStylesheets().add("designKnockApp.css");
        return new Scene(root, 800, 800);
    }


    public void showAction(ActionEvent actionEvent) {
        if (!textFieldPasswordLogin.isVisible ()) {
            btnShowActionID.setText ("Hide");
            textFieldPasswordLogin.setText (passwordFieldPasswordLogin.getText ());
            textFieldPasswordLogin.setEditable (false);
            textFieldPasswordLogin.setVisible (true);
        }
        else {
            btnShowActionID.setText ("Show");
            textFieldPasswordLogin.setVisible (false);
            passwordFieldPasswordLogin.setVisible (true);
            
        }
    }

    @FXML
    public void loginAction(ActionEvent actionEvent) throws Exception {

//        if(textFieldUsername.getText ().length ()<1){
//            lblUserName.setTextFill(Color.CRIMSON);
//            lblInfo.setVisible (true);
//            lblInfo.setText("ALERT: Please add username !");
//            lblInfo.setTextFill (Color.GREEN);
//        }
       // else{
            User user = userRepository.findById (textFieldUsernameLogin.getText ()).get();
            if (user.getPassword ().equals (passwordFieldPasswordLogin.getText ())){
                System.out.println (textFieldUsernameLogin.getText ());
                System.out.println (passwordFieldPasswordLogin.getText ());

                Stage stageTheEventSourceNodeBelongs = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
                stageTheEventSourceNodeBelongs.setScene(getAppInside());

                System.out.println ("Register Pane Inside");

//                lblInfo.setVisible (true);
//                lblInfo.setText ("INFO: Connect ! ");
//                lblInfo.setTextFill (Color.GREEN);
//                tabPane.getTabs ().remove (tabLogin);
//                tabPane.getTabs ().add (tabMain);
            }
            else {
                System.out.println ("Fail Login !");
            }
       // }
    }
}
