package Role;

import java.net.URL;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
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
 * FXML Controller class for the DC Priority Mode Queue.
 */
public class DCPriorityModeController extends DCQueueNGOController implements Initializable {
    
    private static PriorityQueue<NGO> ngoQueue = new PriorityQueue<NGO>(10, new NGOComparator());

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
            switchToDCPriorityMode(event);
        }

    }

    @FXML
    void btnDequeueClicked(ActionEvent event) {
        if (!ngoQueue.isEmpty()) {
            String ngo = ngoQueue.poll().getID();
    
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

        String ngoID = ngoChoiceBox.getValue();
        ngoID = ngoID.split(" : ")[0];
        
        for (NGO n : ngoQueue) {
            if (n.getID().equals(ngoID)) {
                alert.setAlertType(AlertType.ERROR);
                alert.setHeaderText("Enqueue Failed!");
                alert.setContentText(ngo + " has already been queued.");
                alert.show();
                
                return false;
            }
        }

        return true;
    }

    /** 
     * Enqueues the selected & validateed NGO.
     *
     */ 
    private void enqueue() {
        String ngo = ngoChoiceBox.getValue();
        ngo = ngo.split(" : ")[0];

        ngoQueue.add(NGO.get(ngo));
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

        for(NGO ngo : ngoQueue) {
            ngoQueueList.add(ngo.getID() + " : " + ngo.getName());
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

/**
 * This class defines a comparison login based on the manpower of an NGO.
 */
class NGOComparator implements Comparator<NGO> {
    
    /** 
     * Compares the equality of an object with this object.
     *
     * @param n1 first NGO object
     * @param n2 second NGO object to compare to
     * @return positive value if n1's manpower count is lesser than n2's
     */   
    public int compare(NGO n1, NGO n2) {
        if (n1.getManpower() < n2.getManpower())
            return 1;
        else if (n1.getManpower() > n2.getManpower())
            return -1;
        return 0;
    }
}
