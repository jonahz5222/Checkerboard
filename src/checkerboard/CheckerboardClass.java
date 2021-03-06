/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package checkerboard;

import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/**
 *
 * @author jonahzukosky
 */
public class CheckerboardClass {
    
    private int numRows;
    private int numColumns;
    
    private double boardWidth;
    private double boardHeight;
    
    private double rectangleWidth;
    private double rectangleHeight;
    
    private static final Color DEFAULT_DARK = Color.BLACK;
    private static final Color DEFAULT_LIGHT = Color.RED;
    
    private Color darkColor;
    private Color lightColor;
    
    private AnchorPane anchorPane;

    
    CheckerboardClass(int numRows,int numColumns,double boardWidth, double boardHeight){
        this(numRows,numColumns,boardWidth,boardHeight,DEFAULT_LIGHT,DEFAULT_DARK);
    }
    
    CheckerboardClass(int numRows,int numColumns,double boardWidth,double boardHeight,Color lightColor,Color darkColor){
        
        this.numRows = numRows;
        this.numColumns = numColumns;
        this.boardWidth = boardWidth;
        this.boardHeight = boardHeight;
        this.darkColor = darkColor;
        this.lightColor = lightColor;
        this.rectangleWidth = Math.ceil(boardWidth / numColumns);
        this.rectangleHeight = Math.ceil(boardHeight / numRows);
        
    }
    
    public AnchorPane build(){
        
        
        AnchorPane anchorPane = new AnchorPane();
        
        for(int row = 0; row < numRows; row++){
            for(int col = 0; col < numColumns; col++){
                
                Rectangle rectangle;
                if(( row + col ) % 2 == 0){
                    rectangle = new Rectangle(rectangleWidth, rectangleHeight, lightColor);
                }else{
                    rectangle = new Rectangle(rectangleWidth, rectangleHeight, darkColor);
                }
                
                AnchorPane.setTopAnchor(rectangle, rectangleHeight * row);
                AnchorPane.setLeftAnchor(rectangle, rectangleWidth * col);
                
                anchorPane.getChildren().add(rectangle);
                
                
            }
        }
        
        this.anchorPane = anchorPane;
        return anchorPane;
    }
    
    public AnchorPane getBoard(){
       return this.anchorPane;
    }
    
    public int getNumRows() {
        return numRows;
    }

    public int getNumColumns() {
        return numColumns;
    }

    public double getBoardWidth() {
        return boardWidth;
    }

    public double getBoardHeight() {
        return boardHeight;
    }

    public Color getDarkColor() {
        return darkColor;
    }

    public Color getLightColor() {
        return lightColor;
    }
    
    
}
