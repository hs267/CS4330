/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package randomgrid;

import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

/**
 *
 * @author dale
 */
public class RandomGridFXMLController implements Initializable, Startable {
    
    private Stage stage;
    
    private final int numRows = 53;
    private final int numCols = 53;
    
    private double gridWidth;
    private double gridHeight;
    
    private final Color[] colors = {Color.CORAL, Color.DEEPPINK, Color.BISQUE, Color.AZURE, Color.SEAGREEN};
    
   
    @FXML
    private GridPane gridPane; 
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        System.out.println(gridPane.getWidth());
    } 
    
    public void start(Stage stage) {
        this.stage = stage;
        System.out.println(gridPane.getWidth());
        
        refresh();

        
    }

    @FXML
    private void handleRefresh(ActionEvent event) {
        System.out.println("refresh");
        refresh();
    }
    
    @FXML
    private void handleClear(ActionEvent event) {
        System.out.println("clear");
        clearGridPane();
    }
    
    @FXML
    private void handleAbout(ActionEvent event) {
        System.out.println("about");
    }
    
    private void refresh() {
        clearGridPane();
        
        gridWidth = gridPane.getWidth();
        gridHeight = gridPane.getHeight();
        
        Random rn = new Random();
        
        double rectWidth = Math.ceil(gridWidth / numCols);
        double rectHeight = Math.ceil(gridHeight / numRows);
        
        int numColors = colors.length;
        for (int row = 0; row < numRows; row++) {
            for (int col = 0; col < numCols; col++) {
                Color color = colors[rn.nextInt(numColors)];
                Rectangle rect = new Rectangle(rectWidth, rectHeight, color);
                
                gridPane.add(rect, row, col);
            }
        }        
        
    }
    
    private void clearGridPane() {
        gridPane.getChildren().clear();
    }
    
}
