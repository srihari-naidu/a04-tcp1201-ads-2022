package Login;

import Home.DonorHomeController;
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
import models.Donor;

public class DonorLoginController {

    protected static Donor user;
    
    @FXML
    private TextField txtUsername;
    @FXML
    private PasswordField txtPassword;

    @FXML
    void btnLoginClicked(ActionEvent event) { 
        if (validateLogin()) {
            switchToDonorHome(event);
        };
    }
    
    @FXML
    void btnSignUpClicked(ActionEvent event) {
        switchToDonorRegister(event);
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
     * Checks if username and password entered by the Donor, matches. Returns true if it does.
     *
     * @return true if input credentials match
     */ 
    private boolean validateLogin() {
        if (validateInput() == true) {
            String username = txtUsername.getText().trim();
            String password = txtPassword.getText().trim();
            
            for (Donor donor : Donor.getDonors()) {
                if (donor.getUsername().equals(username) && donor.getPassword().equals(password)) {   
                    user = donor;
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
     * Creates a new stage and redirects to the Donor Home screen.
     *
     * @param event
     */ 
    public void switchToDonorHome(ActionEvent event) {
        try {

            FXMLLoader loader = new FXMLLoader(getClass().getResource(Views.DONOR_HOME));
            Parent root = loader.load();
            
            DonorHomeController donorHomeController = loader.getController();
            donorHomeController.setTitle(user.getFirstName() + "'s AID/s");

            Stage stage = new Stage();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
            
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    /** 
     * Creates a new stage and redirects to the Donor Register screen.
     *
     * @param event
     */ 
    private void switchToDonorRegister(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource(Views.DONOR_REGISTER));
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
