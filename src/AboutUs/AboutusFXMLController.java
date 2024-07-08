/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package AboutUs;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

/**
 * FXML Controller class
 *
 * @author dell
 */
public class AboutusFXMLController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    private Label body;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        body.setText("Every day, a disproportionately large number of people go \nto any city in a nation for reasons like \nhigher education, company growth, employment prospects, tourism, \netc. The city's infrastructure is unknown to individuals who \nhad just moved there. They lack a lot of knowledge \nregarding shopping, transportation, and hotel reservations. \nTo know more about the city and to explore its \nattractions, you'll need a city guide. Nowadays, \nindividuals would rather use the internet to\n search than asking a local or hiring a tour guide.\n In response to this difficulty, we created \na desktop-based solution that stores city information \nand benefits all the users of our software. \nThe application includes all available information\n of a certain city, including tourist attractions,\n the local business environment, details \nof organizations that offers transportation, \nlodging, and information of all emergency services.");
        
                
    }    
    
    
}
