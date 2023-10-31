package Login;

import Home.NGOHomeController;
import helpers.Views;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import models.NGO;

public class NGOLoginController {
    
    protected static NGO user;

    @FXML
    private TextField txtUsername;
    @FXML
    private PasswordField txtPassword;

    @FXML
    void btnLoginClicked(ActionEvent event) {
        if (validateLogin()) {
            switchToNGOHome(event);
        };
    }
    
    @FXML
    void btnSignUpClicked(ActionEvent event) {
        switchToNGORegister(event);
    }

    /** 
     * Checks if input fields are empty. Returns true if they are not.
     *
     * @return true if input fields are not empty
     */ 
    private boolean validateInput() {
        return (txtUsername.getText().trim().length() > 0) && 
               (txtPassword.getText().trim().length() > 0);
    }

    /** 
     * Checks if username and password entered by the NGO, matches. Returns true if it does.
     *
     * @return true if input credentials match
     */ 
    private boolean validateLogin() {
        if (validateInput() == true) {
            String username = txtUsername.getText().trim(); 
            String password = txtPassword.getText().trim();

            for (NGO ngo : NGO.getNGOs()) {
                if (ngo.getUsername().equals(username) && ngo.getPassword().equals(password)) { 
                    user = ngo;
                    return true;
                }
            }

            Alert alert = new Alert(AlertType.NONE);
            alert.setAlertType(AlertType.ERROR);
            alert.setHeaderText("Login Failed!");
            alert.setContentText("Credentials do not match.");
            alert.show();

            return false;
        }
        else {
            Alert alert = new Alert(AlertType.NONE);
            alert.setAlertType(AlertType.ERROR);
            alert.setContentText("Field(s) cannot be left blank!");
            alert.show();
        }
        return false;
    }

    /** 
     * Creates a new stage and redirects to the NGO Home screen.
     *
     * @param event
     */ 
    protected void switchToNGOHome(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(Views.NGO_HOME));
            Parent root = loader.load();
            
            NGOHomeController ngoHomeController = loader.getController();
            ngoHomeController.setTitle(user.getName() + "'s AID/s");
            
            Stage stage = new Stage();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    /** 
     * Creates a new stage and redirects to the NGO Register screen.
     *
     * @param event
     */ 
    private void switchToNGORegister(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource(Views.NGO_REGISTER));
            Stage stage = new Stage();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    /** 
     * Closes the current stage/window.
     *
     * @param event
     */ 
    protected void closeWindow(ActionEvent event) {
        ((Stage)(((Button)event.getSource()).getScene().getWindow())).close();      
    }
}
