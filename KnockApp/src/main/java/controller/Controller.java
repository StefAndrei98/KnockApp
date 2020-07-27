package controller;

import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.paint.Color;
import mode.User;
import repository.UserRepository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class Controller {

    public Button btnLogin;
    public TextField textFieldPassword;
    public TextField textFieldUsername;
    public Button btnShow;
    public PasswordField pwdFieldPassword;
    public Label lblUserName;
    public Label lblInfo;
    public MenuItem menuItemLogin;
    public Tab tabMain;
    public Tab tabLogin;
    public TabPane tabPane;
    public MenuItem menuItemLogout;
    public Tab tabRegister;
    public MenuItem menuItemRegister;
    public Button btnRegister;
    public PasswordField fieldConPwReg;
    public PasswordField fieldPWReg;
    public TextField fieldUserReg;
    private UserRepository userRepository;

    public void initialize(){
//      tabPane.getTabs().remove(tabLogin);
//      tabPane.getTabs().remove(tabMain);
        tabPane.getTabs ().clear ();

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory ("KnockApp");
        EntityManager entityManager = entityManagerFactory.createEntityManager ();
        userRepository = new UserRepository (entityManager);
    }

    public void login(ActionEvent actionEvent) {
        if(textFieldUsername.getText ().length ()<1){
            lblUserName.setTextFill(Color.CRIMSON);
            lblInfo.setVisible (true);
            lblInfo.setText("ALERT: Please add username !");
            lblInfo.setTextFill (Color.GREEN);
        }
        else{
            User user = userRepository.findById (textFieldUsername.getText ()).get();
            if (user.getPassword ().equals (pwdFieldPassword.getText ())){
                System.out.println (textFieldUsername.getText ());
                System.out.println (textFieldPassword.getText ());
                lblInfo.setVisible (true);
                lblInfo.setText ("INFO: Connect ! ");
                lblInfo.setTextFill (Color.GREEN);
                tabPane.getTabs ().remove (tabLogin);
                tabPane.getTabs ().add (tabMain);
            }
           else {
                System.out.println ("Fail Login !");
            }
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
        tabPane.getTabs ().clear ();
        tabPane.getTabs().add(tabLogin);
    }

    public void choseLogout(ActionEvent actionEvent) {
        textFieldUsername.clear ();
        pwdFieldPassword.clear ();
        fieldUserReg.clear ();
        fieldPWReg.clear ();
        fieldConPwReg.clear ();
        tabPane.getTabs ().clear ();
    }

    public void registerPane(ActionEvent actionEvent) {
        tabPane.getTabs ().clear ();
        tabPane.getTabs ().add (tabRegister);
    }

    public void registerAction(ActionEvent actionEvent) {
        if (!userRepository.findById (fieldUserReg.getText ()).isPresent ()) {
            if (fieldPWReg.getText ().equals (fieldConPwReg.getText ())) {
            User user = new User();
            user.setUsername (fieldUserReg.getText ());
            user.setPassword (fieldPWReg.getText ());

            userRepository.save (user);
            tabPane.getTabs ().add (tabLogin);
            tabPane.getTabs ().remove (tabRegister);

            }
        }
        else {
            lblInfo.setVisible (true);
            lblInfo.setText ("User already exists ! ");
        }
    }
}
