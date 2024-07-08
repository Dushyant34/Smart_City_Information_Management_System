/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package dashboard;

import Login.FXMLController;
import static accountinfo.AccinfoFXMLController.ac;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;

/**
 * FXML Controller class
 *
 * @author dell
 */
public class MainScreenController implements Initializable {
    public static  String ac = FXMLController.acc;
    @FXML
    private Label name;
    @FXML
    private Label body;
    public void setInfo(){
        Connection con=null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try{
           Class.forName("com.mysql.jdbc.Driver");
           con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sdcsmartcity","root","");
           String sql = "SELECT * FROM cityuserdata WHERE Email=?";
           ps =con.prepareStatement(sql);
           
           ps.setString(1, ac);
           
           rs = ps.executeQuery();
           if(rs.next()){
             name.setText(rs.getString("Name"));
            
           }
           else{
                Alert a = new Alert(Alert.AlertType.ERROR);
            a.setTitle("Error");
            a.setHeaderText("Login Fail");
            a.setContentText("Your Email or Password is incorrect . Try Again !!!");
            a.showAndWait();
           }
           
           
        }catch(Exception e){
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.setTitle("Error");
            a.setHeaderText("Error is login account");
            a.setContentText("Your account is not login.There is some technical issue"+ e.getMessage());
            a.showAndWait();
        }
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        body.setText("SDC Smart City is a 450 acre, privately owned gated community\n in the Hadapsar area of Pune, India. It has a commercial area,\n residential area, hospital with severalspecialisations, shopping and malls,\n restaurants, a gym, Aditi Garden (a 25-acre park), and schools.\n 30% (more specially 32.6%) of the area is made up of green space.\n There is a commercial complex named \"Destination Centre\" located herein.\n Construction began in 2000 and continues to develop itself with \nnewer housing societies.");
        setInfo();
    }      
}
