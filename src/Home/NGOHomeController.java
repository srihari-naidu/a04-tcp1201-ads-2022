package Home;

import java.net.URL;
import java.util.ResourceBundle;

import Login.NGOLoginController;
import helpers.Views;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import models.Aid;
import models.Donor;

/**
 * FXML Controller class for the homepage of the NGO.
 */
public class NGOHomeController extends NGOLoginController implements Initializable {
    
    @FXML
    private TableView<Aid> ngoAidsTable;
    @FXML
    private TableColumn<Aid, String> name;
    @FXML
    private TableColumn<Aid, Integer> quantity;
    @FXML
    private TableColumn<Aid, String> donor;
    
    @FXML
    Text txtTitle = new Text("NGO's AID/s");
    
    public void setTitle(String title) {
        txtTitle.setText(title);
    }

    @FXML
    void btnRequestAidClicked(ActionEvent event) {
        swithToNGORequestAid(event);
        closeWindow(event);
    }

    /**
     * Initializes the controller class.
     */
    public void initialize(URL url, ResourceBundle resourceBundle) {
        name.setCellValueFactory(new PropertyValueFactory<>("name"));
        quantity.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        donor.setCellValueFactory(new PropertyValueFactory<>("donorID"));

        ngoAidsTable.setItems(getNGOAids());
    }
    
    /**
     * Returns an ObervableList of Aid objects where the Aid object has name, quantity and donor's name. 
     * 
     * @return list of NGO's aids in TableView
     */
    public ObservableList<Aid> getNGOAids() {
        ObservableList<Aid> ngoAids = FXCollections.observableArrayList();

        for (Aid aid : Aid.getAids()) {
            if (aid.getNgoID().equals(user.getID())) {
                ngoAids.add(aid);
            }
        }
        for (Aid ngoAid : ngoAids) {
            ngoAid.setDonorID(Donor.get(ngoAid.getDonorID()).getName());
        }
        
        return ngoAids;
    }

    /** 
     * create a new stage and redirects to the NGO Request aid screen.
     *
     * @param event
     */ 
    public void swithToNGORequestAid(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource(Views.NGO_REQUESTAID));
            Stage stage = new Stage();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}

