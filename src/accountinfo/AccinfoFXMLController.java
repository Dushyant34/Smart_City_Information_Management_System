/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package accountinfo;

import Login.FXMLController;
import static dashboard.DashboFXMLController.ac;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
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
import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;
import javafx.scene.text.Text;

/**
 * FXML Controller class
 *
 * @author dell
 */
public class AccinfoFXMLController implements Initializable {

    public static  String ac = FXMLController.acc;
    
    @FXML
    private Text email;
    @FXML
    private  Text sex;
    @FXML
    private  Text info;
    @FXML
    private  Text mobileno;
    @FXML
    private  Label balance;
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
             email.setText(rs.getString("Email"));
             sex.setText(rs.getString("Gender"));
             info.setText(rs.getString("Info"));
             mobileno.setText(rs.getString("MobileNo"));
           }
           else{
                Alert a = new Alert(Alert.AlertType.ERROR);
            a.setTitle("Error");
            a.setHeaderText("Login Fail");
            a.setContentText("Your Account no.  or Pin is incorrect . Try Again !!!");
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
        setInfo();
    }    
    
}
