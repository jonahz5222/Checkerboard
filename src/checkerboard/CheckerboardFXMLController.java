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
    
    
    public Stage stage;
    public CheckerboardClass checkerBoard;
      
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
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {}    

    @Override
    public void start(Stage stage) {
        this.stage = stage;
        
        ChangeListener<Number> lambdaChangeListener = (ObservableValue<? extends Number> observable, Number oldValue, final Number newValue) -> {
            newBoard(new CheckerboardClass(this.checkerBoard.getNumRows(), this.checkerBoard.getNumColumns(), stage.getScene().getWidth(),stage.getScene().getHeight() - menuBar.getHeight(), this.checkerBoard.getLightColor(),this.checkerBoard.getDarkColor()));
        };
         
        newBoard(new CheckerboardClass(8,8,anchorPane.getWidth(),anchorPane.getHeight()));
        
        this.stage.widthProperty().addListener(lambdaChangeListener);
        this.stage.heightProperty().addListener(lambdaChangeListener);
    }
    
    @FXML
    public void handleChangeSize(ActionEvent event){
          
        switch(((MenuItem)event.getSource()).getId()){
            case "size16" :
                
                CheckerboardClass board = new CheckerboardClass(16,16,stage.getScene().getWidth(),stage.getScene().getHeight()-menuBar.getHeight(),this.checkerBoard.getLightColor(),this.checkerBoard.getDarkColor());
                newBoard(board);
                break;
                
            case "size10" :
                newBoard(new CheckerboardClass(10,10,stage.getScene().getWidth(),stage.getScene().getHeight()-menuBar.getHeight(),this.checkerBoard.getLightColor(),this.checkerBoard.getDarkColor()));
                break;
                
            case "size8" :
                newBoard(new CheckerboardClass(8,8,stage.getScene().getWidth(),stage.getScene().getHeight()-menuBar.getHeight(),this.checkerBoard.getLightColor(),this.checkerBoard.getDarkColor()));
                break;
                
            case "size3" :
                newBoard(new CheckerboardClass(3,3,stage.getScene().getWidth(),stage.getScene().getHeight()-menuBar.getHeight(),this.checkerBoard.getLightColor(),this.checkerBoard.getDarkColor()));
                break;
        }
        
    }
    
    @FXML
    public void handleChangeColor(ActionEvent event){
        
        switch(((MenuItem)event.getSource()).getId()){
            
            case "defaultColors" :
                newBoard(new CheckerboardClass(this.checkerBoard.getNumRows(),this.checkerBoard.getNumColumns(),stage.getScene().getWidth(),stage.getScene().getHeight()-menuBar.getHeight()));
                break;
                
            case "blueColors" :
                newBoard(new CheckerboardClass(this.checkerBoard.getNumRows(),this.checkerBoard.getNumColumns(),stage.getScene().getWidth(),stage.getScene().getHeight()-menuBar.getHeight(),Color.SKYBLUE,Color.DARKBLUE));
                break;
        }
    }
    
    public void newBoard(CheckerboardClass checkerBoard){
        
        if(checkerBoard.build() != null){

            vbox.getChildren().remove(anchorPane);
            anchorPane = checkerBoard.getBoard();
            vbox.getChildren().add(anchorPane);
            this.checkerBoard = checkerBoard;

        }
    
    }

}
