package Role;

import java.util.ArrayList;

import Login.NGOLoginController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextField;
import models.Aid;

/**
 * FXML Controller class for NGO Request Aid.
 */
public class NGORequestAidController extends NGOLoginController{

    String alertMsg = "";

    @FXML
    private TextField txtAidName;
    @FXML
    private TextField txtAidQuantity;

    @FXML
    void btnRequestClicked(ActionEvent event) {
        if (validateRequest()) {
            requestAid(event);
            super.closeWindow(event);
            super.switchToNGOHome(event);
        }
    }

    /** 
     * Checks if input fields are empty. Returns true if they are not.
     *
     * @return true if input fields are not empty
     */
    private boolean validateInput() {
        return (txtAidName.getText().trim().length() > 0) && 
               (txtAidQuantity.getText().trim().length() > 0);
    }

    /** 
     * Checks if name input contains illegal characters. Returns true if it does not.
     *
     * @return true if name input is valid
     */     
    private boolean validateAidName() {
        String aidName = txtAidName.getText().trim();

        for (int i = 0; i < aidName.length(); i++) {
            if (aidName.charAt(i) == ',') {
                alertMsg = alertMsg + "Aid name contains illegal characters.\n";
                return false; 
            }
        }
        return true;
    }

     /** 
     * Checks if aid quantity input contains illegal characters and if aid quantity input is a valid integer. 
     *
     * @return true if aid quantity input is valid
     */ 
    private boolean validateAidQuantity() {
        String aidQuantity = txtAidQuantity.getText().trim();

        for (int i = 0; i < aidQuantity.length(); i++) {
            if (aidQuantity.charAt(i) == ',' || aidQuantity.charAt(i) == ' ') {
                alertMsg = alertMsg + "Aid quantity contains illegal characters or whitespaces.\n";
                return false; 
            }
        }
        for (int i = 0; i < aidQuantity.length(); i++) {
            if (!(aidQuantity.charAt(i) >= '0' && aidQuantity.charAt(i) <= '9')) {
                alertMsg = alertMsg + "Aid quantity must be a positive number.\n";
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
    private boolean validateRequest() {
        if (validateInput() == true) {
            boolean valAN = validateAidName();
            boolean valAQ = validateAidQuantity();
            
            if (valAN && valAQ) {
                return true;
            }
            else {
                Alert alert = new Alert(AlertType.NONE);
                alert.setAlertType(AlertType.ERROR);
                alert.setHeaderText("Aid Request Failed!");
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
     * Adds the requested aid to the list of existing aids and saves it in its .csv datafile.
     *
     * @param event
     */
    private void requestAid(ActionEvent event) {
        String aidName = txtAidName.getText().trim();
        int aidQuantity = Integer.parseInt(txtAidQuantity.getText().trim());

        ArrayList<Aid> aids = Aid.getAids();
        Aid requestedAid = new Aid(aidName, aidQuantity, "-", user.getID(),"Requested");
        boolean plusAid = false;

        for (Aid aid : aids) {
            if (aid.equals(requestedAid)) {
                aid.setQuantity(aid.getQuantity() + requestedAid.getQuantity());
                plusAid = true;
            }
        }

        if (!plusAid) {
            aids.add(requestedAid);
        }

        Aid.saveAids(aids);
    }
}
