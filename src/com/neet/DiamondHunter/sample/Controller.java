package com.neet.DiamondHunter.sample;

import com.neet.DiamondHunter.MapViewer.World1;
import javafx.embed.swing.SwingNode;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.scene.image.ImageView;

import javax.swing.*;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements  Initializable  {
    World1 wr=new World1();

   @FXML
   Button btn ,btn2;
   @FXML
    Label label;
   @FXML
    AnchorPane anc ;
   @FXML
    ImageView bt ;
   @FXML
    StackPane stp , stp2;

   boolean bt_moveable=false , ax_moveable=false;
   int bt_count=0;
   int ax_count=0;

   @FXML
    private void handleButtonAction(ActionEvent event) throws IOException {
       // Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
      //Stage stage = (Stage) root.getScene().getWindow();
        //you can use label instead of root.
        Stage stage= (Stage) btn.getScene().getWindow();
        stage.close();
    }

    @FXML
    public void jp() {

      anc.setOnMouseClicked(new EventHandler<MouseEvent>() {

          @Override
          public void handle(MouseEvent event) {
              final double x = event.getX();
              final double y = event.getY();
              label.setText("X = " + (Math.round(x)/12)+" Y = " + (Math.round(y)/12) );

             if(bt_moveable){

                  stp.setLayoutX(  ( (int)Math.round(x)/12)*12 );
                  stp.setLayoutY(  ( (int)Math.round(y)/12)*12 );
                  bt_count++;

                if(bt_count==3||bt_count>3){
                    bt_moveable=false;
                    bt_count=0;
                }

                            }

////////////////////////////////////////////////////////////////////////////////
              if(ax_moveable){

                  stp2.setLayoutX(  ( (int)Math.round(x)/12)*12 );
                  stp2.setLayoutY(  ( (int)Math.round(y)/12)*12 );
                  ax_count++;

                  if(ax_count==3 || ax_count>3){
                      ax_moveable=false;
                      ax_count=0;
                  }

              }
             }

      });

    }


    public void np(){

      stp.setOnMouseClicked(new EventHandler<MouseEvent>() {
          @Override
          public void handle(MouseEvent event) {
              bt_count++;
              if(bt_count==1)
              bt_moveable=true;
            }
      });

    }


    public void ap(){

        stp2.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                ax_count++;
                if(ax_count==1)
                    ax_moveable=true;


            }


        });

    }




    @Override
    public void initialize(URL location, ResourceBundle resources)  {
    wr.loadMap();

    jp();
    np();
    ap();

  }

}
