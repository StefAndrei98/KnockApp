package sample;

import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.paint.Color;


public class Controller {

    public Button btnLogin;
    public TextField textFieldPassword;
    public TextField textFieldUsername;
    public Button btnShow;
    public PasswordField pwdFieldPassword;
    public Label lblUserName;
    public Label lblInfo;
    public MenuItem menuitemLogin;
    public Tab tabMain;
    public Tab tabLogin;
    public TabPane tabPane;
    public MenuItem menuItemLogout;

    public void initialize(){
//        tabPane.getTabs().remove(tabLogin);
//        tabPane.getTabs().remove(tabMain);
        tabPane.getTabs ().clear ();

    }

    public void login(ActionEvent actionEvent) {
        if(textFieldUsername.getText ().length ()<1){
            lblUserName.setTextFill(Color.CRIMSON);
            lblInfo.setVisible (true);
            lblInfo.setText("ALERT: Please add username !");
            lblInfo.setTextFill (Color.GREEN);
        }
        else{
            System.out.println (textFieldUsername.getText ());
            System.out.println (textFieldPassword.getText ());
            lblInfo.setVisible (true);
            lblInfo.setText ("INFO: Connect ! ");
            lblInfo.setTextFill (Color.GREEN);
            tabPane.getTabs ().remove (tabLogin);
            tabPane.getTabs ().add (tabMain);
        }


    }

    public void showPassword(ActionEvent actionEvent) {
        if (!textFieldPassword.isVisible ()) {
            btnShow.setText ("Hide");
            textFieldPassword.setText (pwdFieldPassword.getText ());
            textFieldPassword.setEditable (false);
            textFieldPassword.setVisible (true);
            pwdFieldPassword.setVisible (false);
            lblInfo.setVisible (true);
            lblInfo.setText ("INFO: Hide password !");
            lblInfo.setTextFill (Color.GREEN);
        }
        else {
            btnShow.setText ("Show");
            textFieldPassword.setVisible (false);
            pwdFieldPassword.setVisible (true);
            lblInfo.setVisible (true);
            lblInfo.setText ("INFO: Show password !");
            lblInfo.setTextFill (Color.GREEN);
        }
    }

    public void loginPane(ActionEvent actionEvent) {
        tabPane.getTabs().add(tabLogin);
    }

    public void choseLogout(ActionEvent actionEvent) {
        tabPane.getTabs ().clear ();
    }
}
