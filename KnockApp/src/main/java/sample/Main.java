package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.InputStream;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        FXMLLoader fxmlLoader = new FXMLLoader ();
        InputStream resourceAsStream = getClass ().getClassLoader ().getResourceAsStream ("welcomePage.fxml");
        Parent root = fxmlLoader.load (resourceAsStream);
        root.getStylesheets().add("designKnockApp.css");
        primaryStage.setTitle("KnockApp");
        primaryStage.setScene(new Scene(root, 800, 800));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}


// SET GLOBAL time_zone = '+3:00';
// chose : none OR create in persistence !