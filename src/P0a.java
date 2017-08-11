/**
 * Assignment 00a
 * login:  cs11vca
 * DUE:  Saturday, August 12, 2017 @ 6:00am
 * This program aims to demonstrate the basic implementation of JavaFX GUI. 
 **/
import javafx.application.Application;  // Location
import javafx.stage.Stage;
import javafx.scene.layout.Pane;
import javafx.scene.Scene;
import javafx.scene.text.Text;

/**
 * class P0a
 * As a JavaFX application, P0a must be inherited from Application to
 * let the superclass build up a JavaFX-specific environment.
 **/
public class P0a extends Application  // Inheritance
{

  /**
   * After an application has been initiated, Application will call this
   * method to start the application. an arg 'primaryStage' will be passed
   * in as the container of user interface. Customized UI elements should go
   * there. At the end of the method, call show() on the arg is also needed.
   **/
  public void start(Stage primaryStage)
  {
    Text text=new Text(20,20,"Hello San Diego"); // Create a textbox element
    Pane pane = new Pane(); // Create a panel
    pane.getChildren().add(text); // Add the textbox into the panel
    
    Scene scene = new Scene(pane); // Create a Scene containing the panel
    primaryStage.setScene(scene); // Place the scene in stage provided
    primaryStage.show(); // Display the stage
  }

}
