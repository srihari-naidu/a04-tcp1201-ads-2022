package Home;

import helpers.Views;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * FXML Controller class for the homepage of the Aid Distribution System.
 */
public class HomeController {

    /** 
     * Creates a new stage and redirects to the Donor Login screen.
     *
     * @param event
     */ 
    @FXML
    public void switchToDonorLogin(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource(Views.DONOR_LOGIN));
            Stage stage = new Stage();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    /** 
     * Creates a new stage and redirects to the Distribution Center Home screen.
     *
     * @param event
     */ 
    @FXML
    public void switchToDC(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource(Views.DC_HOME));
            Stage stage = new Stage();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    /** 
     * Creates a new stage and redirects to the NGO Login screen.
     *
     * @param event
     */
    @FXML
    public void switchToNGOLogin(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource(Views.NGO_LOGIN));
            Stage stage = new Stage();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch(Exception e) {
            e.printStackTrace();
        }    
    }
}
