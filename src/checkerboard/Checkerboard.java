/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package checkerboard;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 *
 * @author jonahzukosky
 */
public class Checkerboard extends Application {
    
    private int numRows;
    private int numColumns;
    
    private double boardWidth;
    private double boardHeight;
    
    private final Color DEFAULT_DARK = Color.BLACK;
    private final Color DEFAULT_LIGHT = Color.RED;
    
    private Color darkColor;
    private Color lightColor;
    
    public void Checkerboard(int numRows,int numColumns,double boardWidth, double boardHeight){
        this.numRows = numRows;
        this.numColumns = numColumns;
        this.boardWidth = boardWidth;
        this.boardHeight = boardHeight;
    }
    public void Checkerboard(int numRows,int numColumns,double boardWidth,double boardHeight,Color darkColor,Color lightColor){
        this.darkColor = darkColor;
        this.lightColor = lightColor;
        
        Checkerboard(numRows,numColumns,boardWidth,boardHeight);
    }
    
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("CheckerboardFXML.fxml"));
        
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
