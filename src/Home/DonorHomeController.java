package Home;

import java.net.URL;
import java.util.ResourceBundle;

import Login.DonorLoginController;
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
import models.NGO;

/**
 * FXML Controller class for the homepage of the Donor.
 */
public class DonorHomeController extends DonorLoginController implements Initializable {

    @FXML
    private TableView<Aid> donorAidsTable;
    @FXML
    private TableColumn<Aid, String> name;
    @FXML
    private TableColumn<Aid, Integer> quantity;
    @FXML
    private TableColumn<Aid, String> ngo;
    
    @FXML
    private Text txtTitle = new Text("DONOR's AID/s");
    
    public void setTitle(String title) {
        txtTitle.setText(title);
    }

    @FXML
    void btnDonateAidClicked(ActionEvent event) {
        switchToDonorDonateAid(event);
        closeWindow(event);
    }
    
    /**
     * Initializes the controller class.
     */
    public void initialize(URL url, ResourceBundle resourceBundle) {
        name.setCellValueFactory(new PropertyValueFactory<>("name"));
        quantity.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        ngo.setCellValueFactory(new PropertyValueFactory<>("ngoID"));

        donorAidsTable.setItems(getDonorAids());
    }


    /**
     * Returns an ObervableList of Aid objects where the Aid object has name, quantity and NGO's name. 
     * 
     * @return list of donor's aids in TableView
     */
    public ObservableList<Aid> getDonorAids() {
        ObservableList<Aid> donorAids = FXCollections.observableArrayList();
        
        for (Aid aid : Aid.getAids()) {
            if (aid.getDonorID().equals(user.getID())) {
                donorAids.add(aid);
            }
        }
        for (Aid donorAid : donorAids) {
            donorAid.setNgoID(NGO.get(donorAid.getNgoID()).getName());
        }

        return donorAids;
    }

    public void switchToDonorDonateAid(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource(Views.DONOR_DONATEAID));
            Stage stage = new Stage();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
