package Home;

import java.net.URL;
import java.util.ResourceBundle;

import helpers.Views;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import models.Aid;

/**
 * FXML Controller class for the homepage of the Distribution Center.
 */
public class DCHomeController implements Initializable {

    @FXML
    private TableView<Aid> dcAidsTable;
    @FXML
    private TableColumn<Aid, String> donor;
    @FXML
    private TableColumn<Aid, String> phone;
    @FXML
    private TableColumn<Aid, String> aid;
    @FXML
    private TableColumn<Aid, Integer> quantity;
    @FXML
    private TableColumn<Aid, String> ngo;
    @FXML
    private TableColumn<Aid, Integer> manpower;
    @FXML
    private TableColumn<Aid, String> status;

    @FXML
    void btnMatchAidsClicked(ActionEvent event) {
        switchToDCMatchAids(event);
        closeWindow(event);
    }

    @FXML
    void btnQueueNgoClicked(ActionEvent event) {
        switchToDCQueueNGO(event);
        closeWindow(event);
    }
    
    /**
     * Initializes the controller class.
     */
    public void initialize(URL url, ResourceBundle resourceBundle) {
        donor.setCellValueFactory(new PropertyValueFactory<>("donorName"));
        phone.setCellValueFactory(new PropertyValueFactory<>("donorPhone"));
        aid.setCellValueFactory(new PropertyValueFactory<>("name"));
        quantity.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        ngo.setCellValueFactory(new PropertyValueFactory<>("ngoName"));
        manpower.setCellValueFactory(new PropertyValueFactory<>("ngoManpower"));
        status.setCellValueFactory(new PropertyValueFactory<>("status"));
        
        manpower.setCellFactory(tc -> new TableCell<Aid, Integer>() {
            @Override
            protected void updateItem(Integer item, boolean empty) {
                super.updateItem(item, empty);
                if (empty) {
                    setText(null);
                } else {
                    int value = item.intValue();
                    if (value <= 0) {
                        setText("");
                    } else {
                        setText(Integer.toString(value));
                    }
                }
            }
        });

        dcAidsTable.setItems(getDCAids());
    }

    /**
     * Returns an ObervableList of Aid objects where the Aid object has name, quantity and NGO's name. 
     * 
     * @return list of aids in the view of Distribution Center
     */
    public ObservableList<Aid> getDCAids() {
        ObservableList<Aid> dcAids = FXCollections.observableArrayList();
        for(Aid aid : Aid.getTableViewAids()) {
            dcAids.add(aid);
        }
        return dcAids;
    }

    public void switchToDCMatchAids(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource(Views.DC_MATCHAIDS));
            Stage stage = new Stage();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public void switchToDCQueueNGO(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource(Views.DC_QUEUENGO));
            Stage stage = new Stage();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
    
    private void closeWindow(ActionEvent event) {
        ((Stage)(((Button)event.getSource()).getScene().getWindow())).close();      
    }
}