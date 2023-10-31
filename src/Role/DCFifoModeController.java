package Role;

import java.net.URL;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.ResourceBundle;
import java.util.Set;
import java.util.TreeSet;

import helpers.Views;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ListView;
import javafx.stage.Stage;
import models.Aid;
import models.NGO;

/**
 * FXML Controller class for the DC FIFO Mode Queue.
 */
public class DCFifoModeController extends DCQueueNGOController implements Initializable {
    
    private static Queue<String> ngoQueue = new LinkedList<>();

    @FXML
    private ChoiceBox<String> ngoChoiceBox;

    @FXML
    private ListView<String> ngoQueueListView;
    
    @FXML
    void btnEnqueueClicked(ActionEvent event) {
        String ngo = ngoChoiceBox.getValue();

        if (validateEnqueue(ngo) == true) {
            enqueue();
            closeWindow(event);
            switchToDCFifoMode(event);
        }

    }

    @FXML
    void btnDequeueClicked(ActionEvent event) {
        if (!ngoQueue.isEmpty()) {
            String ngo = ngoQueue.poll();
            ngo = ngo.split(" : ")[0];
    
            ArrayList<Aid> aids = Aid.getAids();
            for (Aid aid: aids) {
                if (aid.getNgoID().equals(ngo) && aid.getStatus().equals("Reserved")) {
                    aid.setStatus("Collected");
                }
            }
            Aid.saveAids(aids);
    
            closeWindow(event);
            switchToDC(event);
        }
        else {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setHeaderText("Dequeue Failed!");
            alert.setContentText("There aren't any NGOs in the queue.");
            alert.show();
        }
    }

    /**
     * Initializes the controller class.
     */
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ngoChoiceBox.getItems().addAll(getReservedNGOs());
        ngoQueueListView.setItems(getNGOQueueList());
    }

    /** 
     * Validates if NGO is null or it is a duplicate, and shows appropriate error message.
     *
     * @return true if NGO enqueued is not null and is unique
     */ 
    private boolean validateEnqueue(String ngo) {
        Alert alert = new Alert(AlertType.NONE);
        
        if (ngo == null) {
            alert.setAlertType(AlertType.ERROR);
            alert.setHeaderText("Enqueue Failed!");
            alert.setContentText("Please select an NGO to queue.");
            alert.show();
            
            return false;
        }
        else if (ngoQueue.contains(ngo)) {
            alert.setAlertType(AlertType.ERROR);
            alert.setHeaderText("Enqueue Failed!");
            alert.setContentText(ngo + " has already been queued.");
            alert.show();
            
            return false;
        }

        return true;
    }

    /** 
     * Enqueues the selected & validateed NGO.
     *
     */ 
    private void enqueue() {
        ngoQueue.add(ngoChoiceBox.getValue());
        ngoQueueListView.setItems(getNGOQueueList());
    }

    /**
     * Returns a set of NGOs who's aid has been reserved. 
     * 
     * @return set of reserved NGOs
     */
    public Set<String> getReservedNGOs() {
        ArrayList<Aid> reservedAids = Aid.getReservedAids();
        Set<String> reservedNGOs = new TreeSet<>();

        for (Aid aid : reservedAids) {
            String ngo = aid.getNgoID();
            reservedNGOs.add(ngo + " : " + NGO.get(ngo).getName());
        }

        return reservedNGOs;
    }
    
    /**
     * Returns an ObervableList of queued NGOs. 
     * 
     * @return list of NGOs queued in the Distribution Center
     */
    public ObservableList<String> getNGOQueueList() {
        ObservableList<String> ngoQueueList = FXCollections.observableArrayList();

        for(String ngo : ngoQueue) {
            ngoQueueList.add(ngo);
        }
        return ngoQueueList;
    }

    /** 
     * Creates a new stage and redirects to the Distribution Center Home screen.
     *
     * @param event
     */ 
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
}
