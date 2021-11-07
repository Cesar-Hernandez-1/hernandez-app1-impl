/*
 *  UCF COP3330 Fall 2021 Application Assignment 1 Solution
 *  Copyright 2021 Cesar Hernandez
 */

package assignments;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.application.Application;

import java.util.Objects;

public class TodoListApplication extends Application{

    public static void main(String [] args){
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception{
        Parent root =
                FXMLLoader.load(Objects.requireNonNull(getClass().getResource("toDoListApplication.fxml")));

        Scene scene = new Scene(root);
        stage.setTitle("ToDo List Application");
        stage.setScene(scene);
        stage.show();
    }
}