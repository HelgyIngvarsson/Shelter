package application.controller;

import application.Main;
import application.model.User;
import application.service.UserService;
import application.service.impl.UserServiceImpl;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class LoginController implements Initializable{

    @FXML
    TextField passwordField;

    @FXML
    TextField loginField;

    private UserService userService =new UserServiceImpl();

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    @FXML
    private void logIn() throws IOException {
        String password = passwordField.getText();

        String login = loginField.getText();

        if(!password.equals("")&&!login.equals(""))
        {
            User user;
            //user = userService.validate(password,login);
            if(userService.validate(password,login)!=null)
            {
                user = userService.validate(password,login);
                switch (user.getWorker().getPost().getPost_name())
                {
                    case ("admin"):
                        {
                            Main.setLogInWorker(user.getWorker());
                            openView("adminView.fxml","AdminPanel");
                            clearFields();
                            break;
                        }
                    case("keeper"):
                        {
                            Main.setLogInWorker(user.getWorker());
                            openView("keeperView.fxml","Keeper Panel");
                            clearFields();
                            break;
                        }
                    case("vet"):
                    {
                        Main.setLogInWorker(user.getWorker());
                        openView("vetPanel.fxml","Veterinarian Panel");
                        clearFields();
                        break;
                    }
                }
            }else
                {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setHeaderText("Incorrect login or password");
                    alert.showAndWait();
                    clearFields();
                }
        }
    }

    private void clearFields()
    {
        loginField.setText("");
        passwordField.setText("");
    }

    private void openView(String viewName, String title) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/application/fxml/"+viewName+""));
        Parent root = (Parent) fxmlLoader.load();
        Stage stage = new Stage();
        stage.initModality(Modality.WINDOW_MODAL);
        stage.initStyle(StageStyle.DECORATED);
        stage.setTitle(title+"@LogIn as "+Main.getLogInWorker().getFirst_name()+" "+Main.getLogInWorker().getLast_name());
        stage.setScene(new Scene(root));
        stage.show();
    }
}
