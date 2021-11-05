/*
 *  UCF COP3330 Fall 2021 Application Assignment 1 Solution
 *  Copyright 2021 Cesar Hernandez
 */

package assignments;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.util.Objects;

public class toDoListController {

    @FXML
    private DatePicker dateButton;

    @FXML
    private TextField eventTextButton;

    @FXML
    private ListView<?> toDoEventList;

    //create observable list to display data event objects
    //ObservableList<events> list = FXCollections.observableArrayList();
    //toDoList items = new toDoList();


    @FXML
    void addEvent(ActionEvent event) throws IOException {
        //when add event button pressed
        //Date picker value is optional
        //check if event title text field is filled
        //open another scene and prompt user to enter a description between 1 and 256 characters.
        //if description entered is not in range, display error message.
        //if description is in range, return string description back to this fucntion.
        //create a new event and store it in toDoList object
        //display item onto the observable listview.
    }

    @FXML
    void guideUser(ActionEvent event) throws IOException {
        //when user guide button is pressed
        //open new scene
        //display a fxml screen with only text explaining how all the requirements are implemented in the application
    }

    @FXML
    void deleteAllToDoListItems(ActionEvent event){
        //clear all items from internal toDoList
        //remove all items from observable listview
        //display updated toDoList with no items inside
    }

    @FXML
    void deleteToDoList(ActionEvent event) throws IOException {
        //try
        //use toDoList method to remove an event object from the toDoList
        //use listview method to get index of selected object and method will remove object at the received index
        //catch exception
        //if an exception occurs than no object in the to do list was selected
        //display a new scene with error message saying no object was selected
        //update listview to display the toDoList with the object removed
    }

    @FXML
    void displayAllEvents(ActionEvent event) {
        //when display all events option is selected
        //create an observable list and use toDoList method to return all event objects in the list
        //add all event objects into the observable list
        //set listview to display all events in observable list
    }

    @FXML
    void displayCompletedEvents(ActionEvent event) {
        //traverse through event list of current list object using enhanced for loop
        //if item's completed flag is true, then set item in observable list
        //if flag is not set as true, then set item as invisible to user's screen
        //display all observable list items in listview
    }

    @FXML
    void displayIncompletedEvents(ActionEvent event) {
        //traverse through event list of current list object using enhanced for loop
        //if item's completed flag is true, then set item as invisible to user's screen
        //if flag is not set as true, then set item in observable list
        //display all observable list items in listview
    }

    @FXML
    void editEventDescription(ActionEvent event) throws IOException {
        //use listview method getSelectedModel and getSelectedIndex to get currently selected index
        //if index is below 0, then nothing is selected and display an error scene
        //exit method
        //if valid index selected
        //open another scene and prompt user to enter a description between 1 and 256 characters.
        //this function will send the current object description to the scene to edit it.
        //if description entered is not in range, display error message.
        //if description is in range, return string description back to this function.
        //use set description method in toDoList to update event at given index with new description
        //update listview to display the new description on the selected event
    }

    @FXML
    void editEventDueDate(ActionEvent event) throws IOException {
        //use listview method getSelectedModel and getSelectedIndex to get currently selected index
        //if index is below 0, then nothing is selected and display an error scene
        //exit method
        //if valid index selected
        //Open another JavaFX GUI screen to ask what user what date to change to
        //send new date back to this method and update object at selected index with new date with toDoList method
        //use set date method in toDoList to update event at given index with new description
        //update listview to display the new date on the selected event
    }

    @FXML
    void loadList(ActionEvent event) throws IOException {
        //prompt user in another GUI screen to select file to get to load list into the current GUI
        //creates a file object with the path of the entered file name
        //if file doesn't exist, display error message and end class method
        //otherwise, load file and read stored text format to create list object
        //replace current observable list in listview with the loaded toDoList
    }

    @FXML
    void markEventComplete(ActionEvent event) throws IOException {
        //have user select event in current list to mark as complete
        //upon selection, set internal event flag's value to true for marked as complete
        //update observable list to display the item as complete
    }

    @FXML
    void saveList(ActionEvent event) throws IOException {
        //prompt user in another GUI screen to select directory to save file too.
        //Open another GUI screen to ask user to enter desired save file name.
        //convert list into text data and store date in the text file at the desired directory and with the desired name
    }
}
