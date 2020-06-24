//AMEENA SAJJAD
//5/11/17
//SnakeGame.java
//The purpose of this code is to create a snake game

//ANALYSIS
//In this program I am going to create a snake game using all the knowledge that I Leaned in java which includes javafx, exceptions and GUI interface

//DESIGN-PSEUDOCODE
//Insert the all required package names
//create a class called snake game and extend it to application
//Create a start function
//initialize the start button
//create lablels to display when lost
//set the direction based on the users keyboard input
//set the title and the scene of the game 
//Create a main funtion that launches the program
//In the main function demonstrate exception by using try and catch block
//In teh main fuction demostrate usage of binary file by sending the score data tog the file

//TESTING
// I tested the results by running the program and the program compiled sucessfully without any errors
/////////////////////////////////////

//package name 
package finalGame;

//Insert all required packages
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import static javafx.application.Application.launch;
import javafx.event.ActionEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.geometry.Insets;
import javafx.scene.input.KeyCode;

//class that exends application
public class SnakeGame extends Application 
{
    //to overide 
    @Override
    
    //start function
    public void start(Stage mainStage)
    {   
        //Initializing start button
        Button btn1 = new Button();
        btn1.setText("   PLAY  ");
        btn1.setOnAction((ActionEvent event) -> 
        {
            SnakePane s = new SnakePane();
            
            //labels that will display once lost
            FlowPane fail = new FlowPane(new Label("YOU LOSE"));
            fail.getChildren().add(new Button("TRY AGAIN"));
            
            
            //based on input of the keyboard
            s.setOnKeyPressed(e->
            {
             if(e.getCode()== KeyCode.UP)
             {
                 s.setDirection(s.TOP);
             }
             if(e.getCode()== KeyCode.DOWN)
             {
                 s.setDirection(s.DOWN);
             }
             if(e.getCode()== KeyCode.LEFT)
             {
                 s.setDirection(s.LEFTSIDE);
             }
             if(e.getCode()== KeyCode.RIGHT)
             {
                 s.setDirection(s.RIGHTSIDE);
             }
            });
            
            Scene playPage = new Scene(s,600,450);
            mainStage.setScene(playPage);
            mainStage.show();
            s.requestFocus();
            
            //code for fail page
            Scene failPage = new Scene(fail,600,450);
            mainStage.setScene(playPage);
            mainStage.show();         
        });

        HBox hbox1 = new HBox();
        hbox1.setPadding(new Insets(100,100,100,100));
        hbox1.getChildren().addAll(btn1);
        
        BorderPane frontpage = new BorderPane();
        frontpage.setCenter(hbox1);
        
        //to set the title and the scene of the game
        Scene scene = new Scene(frontpage, 600, 450);
        mainStage.setTitle("FIANL GAME");
        mainStage.setScene(scene);
        
        mainStage.show();
    }

    
    /**
     * @param args the command line arguments
     */
    //main function that demonstrates exceptions
    public static void main(String[] args) throws IOException
    {/*
        try 
        {
        launch(args);
        }
        catch (Exception ex)
        {
            System.out.println(ex);
        }
    } */
        
        launch(args);
        try ( 
            // Create an output stream for file temp.dat
            DataOutputStream output = new DataOutputStream(new FileOutputStream("temp.dat"));
            ) 
        {
           // Write student test scores to the file
           output.writeDouble(85.5);
         }
    }
    
}

