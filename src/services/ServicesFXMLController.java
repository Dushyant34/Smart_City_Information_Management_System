/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package services;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author dell
 */
public class ServicesFXMLController implements Initializable {
    @FXML
    private Pane dashboard_main;
    @FXML
    private void resturant(MouseEvent event) throws IOException{
        Parent fxml =FXMLLoader.load(getClass().getResource("/resturant/resturantFXML.fxml"));
        dashboard_main.getChildren().removeAll();
        dashboard_main.getChildren().addAll(fxml);
    }
    @FXML
    private void cafe(MouseEvent event) throws IOException{
        Parent fxml =FXMLLoader.load(getClass().getResource("/cafe/cafeFXML.fxml"));
        dashboard_main.getChildren().removeAll();
        dashboard_main.getChildren().addAll(fxml);
    }
     @FXML
    private void travelAgencies(MouseEvent event) throws IOException{
        Parent fxml =FXMLLoader.load(getClass().getResource("/travel/travelFXML.fxml"));
        dashboard_main.getChildren().removeAll();
        dashboard_main.getChildren().addAll(fxml);
    }
    @FXML
    private void rikshaw(MouseEvent event) throws IOException{
        Parent fxml =FXMLLoader.load(getClass().getResource("/RickShaw/RickShawFXML.fxml"));
        dashboard_main.getChildren().removeAll();
        dashboard_main.getChildren().addAll(fxml);
    }
    @FXML
    private void vegChicken(MouseEvent event) throws IOException{
        Parent fxml =FXMLLoader.load(getClass().getResource("/VegChicken/vegChickenFXML.fxml"));
        dashboard_main.getChildren().removeAll();
        dashboard_main.getChildren().addAll(fxml);
    }
    @FXML
    private void emerGency(MouseEvent event) throws IOException{
        Parent fxml =FXMLLoader.load(getClass().getResource("/Emergency/EmergencyFXML.fxml"));
        dashboard_main.getChildren().removeAll();
        dashboard_main.getChildren().addAll(fxml);
    }
     @FXML
    private void HealthDep(MouseEvent event) throws IOException{
        Parent fxml =FXMLLoader.load(getClass().getResource("/HealthDepartment/HealthFXML.fxml"));
        dashboard_main.getChildren().removeAll();
        dashboard_main.getChildren().addAll(fxml);
    }
     @FXML
    private void eduCation(MouseEvent event) throws IOException{
        Parent fxml =FXMLLoader.load(getClass().getResource("/Education/EducationFXML.fxml"));
        dashboard_main.getChildren().removeAll();
        dashboard_main.getChildren().addAll(fxml);
    }
       @FXML
    private void grossary(MouseEvent event) throws IOException{
        Parent fxml =FXMLLoader.load(getClass().getResource("/Grossary/GrossaryFXML.fxml"));
        dashboard_main.getChildren().removeAll();
        dashboard_main.getChildren().addAll(fxml);
    }
       @FXML
    private void mainTance(MouseEvent event) throws IOException{
        Parent fxml =FXMLLoader.load(getClass().getResource("/Maintence/MaintenceFXML.fxml"));
        dashboard_main.getChildren().removeAll();
        dashboard_main.getChildren().addAll(fxml);
    }
       @FXML
    private void mall(MouseEvent event) throws IOException{
        Parent fxml =FXMLLoader.load(getClass().getResource("/Mall/MallFXML.fxml"));
        dashboard_main.getChildren().removeAll();
        dashboard_main.getChildren().addAll(fxml);
    }
       @FXML
    private void providers(MouseEvent event) throws IOException{
        Parent fxml =FXMLLoader.load(getClass().getResource("/Providers/ProvidersFXML.fxml"));
        dashboard_main.getChildren().removeAll();
        dashboard_main.getChildren().addAll(fxml);
    }
   
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
