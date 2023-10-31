package Register;

import java.util.ArrayList;

import Login.NGOLoginController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import models.NGO;

public class NGORegisterController extends NGOLoginController {

    String alertMsg = "";

    @FXML
    private TextField txtName;
    @FXML
    private TextField txtManpower;
    @FXML
    private TextField txtUsername;
    @FXML
    private PasswordField txtPassword;

    @FXML
    void btnRegisterClicked(ActionEvent event) {
        if (validateRegistration()) {
            register(event);
            super.closeWindow(event);
        }
    }
    
    @FXML
    void btnSignInClicked(ActionEvent event) {
        switchBackToNGOLogin(event);    
    }

    /** 
     * Checks if input fields are empty. Returns true if they are not.
     *
     * @return true if input fields are not empty
     */
    private boolean validateInput() {
        return (txtName.getText().trim().length() > 0) && 
               (txtManpower.getText().trim().length() > 0) &&
               (txtUsername.getText().trim().length() > 0) &&
               (txtPassword.getText().trim().length() > 0);
    }
    
    /** 
     * Checks if name input contains illegal characters. Returns true if it does not.
     *
     * @return true if name input is valid
     */
    private boolean validateName() {
        String name = txtName.getText().trim();

        for (int i = 0; i < name.length(); i++) {
            if (name.charAt(i) == ',') {
                alertMsg = alertMsg + "Name contains illegal characters.\n";
                return false; 
            }
        }
        return true;
    }

    /** 
     * Checks if manpower input contains illegal characters. Checks if the input is a positive integer. Returns true if it does not.
     *
     * @return true if name input is valid
     */  
    private boolean validateManpower() {
        String manpower = txtManpower.getText().trim();

        for (int i = 0; i < manpower.length(); i++) {
            if (manpower.charAt(i) == ',' || manpower.charAt(i) == ' ') {
                alertMsg = alertMsg + "Manpower Count contains illegal characters or whitespaces.\n";
                return false; 
            }
        }
        for (int i = 0; i < manpower.length(); i++) {
            if (!(manpower.charAt(i) >= '0' && manpower.charAt(i) <= '9')) {
                alertMsg = alertMsg + "Manpower Count must be a positive number.\n";
                return false; 
            }
        }
        return true;
    }

    /** 
     * Checks if username contains illegal characters and if username is already taken. Returns true if it does not.
     *
     * @return true if username input is valid
     */
    private boolean validateUsername() {
        String username = txtUsername.getText().trim(); 

        for (NGO donor : NGO.getNGOs()) {
            if (donor.getUsername().equals(username)) {
                alertMsg = alertMsg + "Username is already taken.\n";
                return false; 
            }
        }
        for (int i = 0; i < username.length(); i++) {
            if (username.charAt(i) == ',' || username.charAt(i) == ' ') {
                alertMsg = alertMsg + "Username contains illegal characters or whitespaces.\n";
                return false; 
            }
        }
        return true;
    }

    /** 
     * Checks if password contains illegal characters. Returns true if it does not.
     *
     * @return true if password input is valid
     */
    private boolean validatePassword() {
        String password = txtPassword.getText().trim();

        for (int i = 0; i < password.length(); i++) {
            if (password.charAt(i) == ',' || password.charAt(i) == ' ') {
                alertMsg = alertMsg + "Password contains illegal characters or whitespaces.\n";
                return false; 
            }
        }
        return true;
    }

    /** 
     * Checks and returns true if all inputs are valid.
     *
     * @return true if inputs are valid
     */ 
    private boolean validateRegistration() {
        if (validateInput() == true) {
            boolean valN = validateName();
            boolean valM = validateManpower();
            boolean valU = validateUsername();
            boolean valP = validatePassword();
            
            if (valN && valM && valU && valP) {
                Alert alert = new Alert(AlertType.NONE);
                alert.setAlertType(AlertType.INFORMATION);
                alert.setHeaderText("Registration Successful!");
                alert.show();

                return true;
            }
            else {
                Alert alert = new Alert(AlertType.NONE);
                alert.setAlertType(AlertType.ERROR);
                alert.setHeaderText("Registration Failed!");
                alert.setContentText(alertMsg);
                alertMsg = "";
                alert.show();
                
                return false;
            }
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
     * Adds the NGO to the list of existing NGO and saves it in its .csv datafile.
     *
     * @param event
     */
    private void register(ActionEvent event) {
        String name = txtName.getText().trim();
        int manpower = Integer.parseInt(txtManpower.getText().trim());
        String username = txtUsername.getText().trim(); 
        String password = txtPassword.getText().trim();

        ArrayList<NGO> ngos = NGO.getNGOs();
        ngos.add(new NGO(NGO.genID(), username, password, name, manpower));
        NGO.saveNGOs(ngos);
    }

    /** 
     * Closes the current stage and redirects to the NGO Login screen.
     *
     * @param event
     */ 
    private void switchBackToNGOLogin(ActionEvent event){
        super.closeWindow(event);
    }
}
