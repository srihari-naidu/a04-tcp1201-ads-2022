package Role;

import java.util.ArrayList;

import Home.HomeController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import models.Aid;

/**
 * FXML Controller class for DC Match Aids.
 */
public class DCMatchAidsController {

    @FXML
    void btnOneToOneClicked(ActionEvent event) {
        matchOneToOne(event);
        closeWindow(event);
    }
    
    @FXML
    void btnOneToManyClicked(ActionEvent event) {
        matchOneToMany(event);
        closeWindow(event);
    }
    
    @FXML
    void btnManyToOneClicked(ActionEvent event) {
        matchManyToOne(event);
        closeWindow(event);
        
    }
    
    @FXML
    void btnManyToManyClicked(ActionEvent event) {
        matchManyToMany(event);
        closeWindow(event);
    }
    
    public void matchOneToOne(ActionEvent event) {
        ArrayList<Aid> aids = Aid.getMatchedAids();
        for (Aid aid: Aid.getMatchOneToOne()) {
            aids.add(aid);
        }
        Aid.saveAids(aids);

        HomeController homeController = new HomeController();
        homeController.switchToDC(event);
    }

    public void matchOneToMany(ActionEvent event) {
        ArrayList<Aid> aids = Aid.getMatchedAids();
        for (Aid aid: Aid.getMatchOneToMany()) {
            aids.add(aid);
        }
        Aid.saveAids(aids);

        HomeController homeController = new HomeController();
        homeController.switchToDC(event);
    }   
    
    public void matchManyToOne(ActionEvent event) {
        ArrayList<Aid> aids = Aid.getMatchedAids();
        for (Aid aid: Aid.getMatchManyToOne()) {
            aids.add(aid);
        }
        Aid.saveAids(aids);

        HomeController homeController = new HomeController();
        homeController.switchToDC(event);
    }
        
    public void matchManyToMany(ActionEvent event) {
        ArrayList<Aid> aids = Aid.getMatchedAids();
        for (Aid aid: Aid.getMatchManyToMany()) {
            aids.add(aid);
        }
        Aid.saveAids(aids);

        HomeController homeController = new HomeController();
        homeController.switchToDC(event);
    }

    /** 
     * Closes the current stage and redirects to the DC Home screen.
     *
     * @param event
     */ 
    private void closeWindow(ActionEvent event) {
        ((Stage)(((Button)event.getSource()).getScene().getWindow())).close();      
    }
}
