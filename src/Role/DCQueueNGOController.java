package Role;

import helpers.Views;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 * FXML Controller class for DC Queue NGO.
 */
public class DCQueueNGOController {

    @FXML
    void btnFifoClicked(ActionEvent event) {
        switchToDCFifoMode(event);
        closeWindow(event);
    }

    @FXML
    void btnPriorityClicked(ActionEvent event) {
        switchToDCPriorityMode(event);
        closeWindow(event);
    }
    
    /** 
     * Creates a new stage and redirects to the Distribution Center Fifo Queue Mode screen.
     *
     * @param event
     */ 
    public void switchToDCFifoMode(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource(Views.DC_FIFOMODE));
            Stage stage = new Stage();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    /** 
     * Creates a new stage and redirects to the Distribution Center Priority Queue Mode screen.
     *
     * @param event
     */ 
    public void switchToDCPriorityMode(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource(Views.DC_PRIORITYMODE));
            Stage stage = new Stage();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    /** 
     * Closes the current stage and redirects to the DC Home screen.
     *
     * @param event
     */ 
    protected void closeWindow(ActionEvent event) {
        ((Stage)(((Button)event.getSource()).getScene().getWindow())).close();      
    }
}
