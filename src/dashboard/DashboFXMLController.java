/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package dashboard;

import static Login.FXMLController.acc;
import Login.LoginScreen;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import Login.FXMLController;
import static Login.LoginScreen.stage;
import java.awt.Color;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import javafx.scene.layout.Pane;

public class DashboFXMLController implements Initializable {
     private double xOffset =0;
    private double yOffset =0;
    public static String ac = FXMLController.acc;
    @FXML
    private Pane dashboard_main;
    @FXML
    private Button home;
    @FXML
    private Button min;
    @FXML
    private Text name;
    @FXML
    private Circle profilepic;
    @FXML
    private void closeApp(MouseEvent event){
        Platform.exit();
        System.exit(0);
    }
    @FXML
    private void minimizeApp(MouseEvent event){
        Stage stage = (Stage) min.getScene().getWindow();
        
    }
    @FXML
    public void setData(){
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
               InputStream is = rs.getBinaryStream("UserPic");
               OutputStream os = new FileOutputStream(new File ("pic.jpg"));
               byte[] content = new byte[1024];
               int size=0;
               while( (size = is.read(content)) != -1){
                   os.write(content,0,size);
                }
               os.close();
               is.close();
               Image img = new Image("file:pic.jpg",false);
               profilepic.setFill(new ImagePattern (img));
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
    @FXML
    public void click(MouseEvent event){
        xOffset= event.getSceneX();
        yOffset = event.getSceneY();
    }
    @FXML
    public void drag(MouseEvent event){
         FXMLController.stage.setX(event.getSceneX() - xOffset);
         FXMLController.stage.setY(event.getSceneY() - yOffset);
    }
    @FXML
    private void accountInformation(MouseEvent event) throws IOException{
        Parent fxml =FXMLLoader.load(getClass().getResource("/accountinfo/accinfoFXML.fxml"));
        dashboard_main.getChildren().removeAll();
        dashboard_main.getChildren().addAll(fxml);
    }
    @FXML
    private void mainScreen() throws IOException{
        Parent fxml= FXMLLoader.load(getClass().getResource("MainScreen.fxml"));
        dashboard_main.getChildren().removeAll();
       dashboard_main.getChildren().addAll(fxml);
    }
    @FXML
    private void Services(MouseEvent event) throws IOException{
        Parent fxml =FXMLLoader.load(getClass().getResource("/services/servicesFXML.fxml"));
        dashboard_main.getChildren().removeAll();
        dashboard_main.getChildren().addAll(fxml);
    }
    @FXML
    private void aboutUs(MouseEvent event) throws IOException{
        Parent fxml =FXMLLoader.load(getClass().getResource("/Aboutus/AboutusFXML.fxml"));
        dashboard_main.getChildren().removeAll();
        dashboard_main.getChildren().addAll(fxml);
    }
    @FXML
    private void Pinchange(MouseEvent event) throws IOException{
        Parent fxml= FXMLLoader.load(getClass().getResource("/changepin/ChangePIN.fxml"));
        dashboard_main.getChildren().removeAll();
        dashboard_main.getChildren().addAll(fxml);
    }
    public void logout(MouseEvent event) throws IOException{
        ((Node)event.getSource()).getScene().getWindow().hide();
        Parent root = FXMLLoader.load(getClass().getResource("/login/FXML.fxml"));
        Scene scene = new Scene(root);
        scene.getStylesheets().add (getClass().getResource("/dashboard/dashbofxml.css").toExternalForm());
        Stage stage = new Stage();
        stage.initStyle(StageStyle.UNDECORATED);
        stage.setScene(scene);
        stage.show();
        
        root.setOnMousePressed(new EventHandler<MouseEvent>(){
            @Override
            public void handle(MouseEvent event) {
                xOffset= event.getSceneX();
                yOffset = event.getSceneY();
            }
          });
        root.setOnMouseDragged(new EventHandler<MouseEvent>(){
            @Override
            public void handle(MouseEvent event) {
                stage.setX(event.getSceneX() - xOffset);
                stage.setY(event.getSceneY() - yOffset);
            }  
         });
    }
   
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        setData();
         try {
             mainScreen();
         } catch (IOException ex) {
             Logger.getLogger(DashboFXMLController.class.getName()).log(Level.SEVERE, null, ex);
         }
        LoginScreen.stage.close();
    }    
    
}
