/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package checkerboard;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 *
 * @author jonahzukosky
 */
public class CheckerboardFXMLController implements Initializable,Startable {
    
    @FXML
    private MenuBar menuBar;
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
    
    @FXML
    private VBox vbox;
    
    int size;
    Color darkColor;
    Color lightColor;
    private Stage stage;
    public CheckerboardClass checkerBoard;
    
    ChangeListener<Number> lambdaChangeListener = ((ObservableValue<? extends Number> observable, Number oldValue, final Number newValue) -> {
        newBoard(new CheckerboardClass(this.checkerBoard.getNumRows(), this.checkerBoard.getNumColumns(), stage.getScene().getWidth(),stage.getScene().getHeight() - menuBar.getHeight(), this.checkerBoard.getDarkColor(),this.checkerBoard.getLightColor()));
    });
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @Override
    public void start(Stage stage) {
        this.stage = stage;
        
        
        //Checkerboard checkerboard = new Checkerboard();
        
    }
    
    @FXML
    public void handleChangeSize(ActionEvent event){
        
        MenuItem menuItem = (MenuItem)event.getSource();
        
        switch(menuItem.getId()){
            case "size16" :
                size = 16;
                break;
                
            case "size10" :
                size = 10;
                break;
                
            case "size8" :
                size = 8;
                break;
                
            case "size3" :
                size = 3;
                break;
        }
        
    }
    
    @FXML
    public void handleChangeColor(ActionEvent event){
        
        MenuItem menuItem = (MenuItem)event.getSource();
        
        switch(menuItem.getId()){
            
            case "defaultColors" :
                darkColor = Color.BLACK;
                lightColor = Color.RED;
                break;
                
            case "blueColors" :
                darkColor = Color.DARKBLUE;
                lightColor = Color.SKYBLUE;
                break;
        }
    }
    
    public void newBoard(CheckerboardClass checkerboard){
        
    if(checkerboard != null){
        
        this.checkerBoard = checkerboard;
        
        vbox.getChildren().remove(anchorPane);
        anchorPane = checkerboard.getBoard();
        vbox.getChildren().add(anchorPane);
        
        
   
    }
    
}
