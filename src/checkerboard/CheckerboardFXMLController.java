/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package checkerboard;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 *
 * @author jonahzukosky
 */
public class CheckerboardFXMLController implements Initializable,Startable {
    
    
    @FXML
    private AnchorPane anchorPane;
    
    @FXML
    private MenuItem size16;
    
    @FXML
    private MenuItem size10;
    
    @FXML
    private MenuItem size8;
    
    @FXML
    private MenuItem size3;
    
    @FXML
    private MenuItem defaultColors;
    
    @FXML
    private MenuItem blueColors;
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @Override
    public void start(Stage stage) {
        
    }
    
    @FXML
    public void handleChangeSize(ActionEvent event){
        
        MenuItem menuItem = (MenuItem)event.getSource();
        
        switch(menuItem.getId()){
            case "size16" :
                
                break;
                
            case "size10" :
                
                break;
                
            case "size8" :
                
                break;
                
            case "size3" :
                
                break;
        }
        
    }
    
    @FXML
    public void handleChangeColor(ActionEvent event){
        
        MenuItem menuItem = (MenuItem)event.getSource();
        
        switch(menuItem.getId()){
            
            case "defaultColors" :
                
                break;
                
            case "blueColors" :
                
                break;
        }
    }
    
}
