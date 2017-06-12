package application;

import application.model.Worker;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    public static Worker logInWorker = null;

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("fxml/loginView.fxml"));
        primaryStage.setTitle("Shelter");
        primaryStage.setResizable(false);
        primaryStage.setScene(new Scene(root, 400, 300));
        primaryStage.show();
        primaryStage.setOnCloseRequest(e ->
        {
            Platform.exit();
            System.exit(0);
        });

    }

    public static Worker getLogInWorker() {
        return logInWorker;
    }

    public static void setLogInWorker(Worker logInWorker) {
        Main.logInWorker = logInWorker;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
