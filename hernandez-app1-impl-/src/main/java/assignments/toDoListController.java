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
    private ListView<assignments.events> toDoEventList;

    //create observable list to display data event objects
    ObservableList<events> list = FXCollections.observableArrayList();
    toDoList items = new toDoList();


    @FXML
    void addEvent(ActionEvent event) throws IOException {

        //if no event name is provided, no event to be made and exit method.
        if(eventTextButton.getText().isEmpty()){
            return;
        }

        //when add event button pressed
        //Date picker value is optional
        //check if event title text field is filled
        //open another scene and prompt user to enter a description between 1 and 256 characters.
        //if description entered is not in range, display error message.
        //if description is in range, return string description back to this function.
        String returnDescription;
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("editDescription.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setTitle("Edit Description");
        stage.setScene(scene);
        do {
            stage.showAndWait();
            editDescriptionController controller = loader.getController();
            returnDescription = controller.getDescription();
        }while(!(returnDescription.length() >= 1 && returnDescription.length() <= 256));
        //try to
        try{
            //create a new event and store it in toDoList object
            items.addEvent(new events(dateButton.getValue().toString(), eventTextButton.getText(), returnDescription));

            //display item onto the observable listview.
            list.add(new events(dateButton.getValue().toString(), eventTextButton.getText(), returnDescription));
            toDoEventList.setItems(list);
        }//catch exception if no due date was provided, add string "No Due Date"
        catch (Exception e){
            items.addEvent(new events("No Due Date", eventTextButton.getText(), returnDescription));
            list.add(new events("No Due Date", eventTextButton.getText(), returnDescription));
            toDoEventList.setItems(list);
        }
    }

    @FXML
    void guideUser(ActionEvent event) throws IOException {
        //when user guide button is pressed
        //open new scene
        //display a fxml screen with only text explaining how all the requirements are implemented in the application
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("guideUser.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setTitle("User Guide");
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void deleteAllToDoListItems(ActionEvent event){
        //clear all items from internal toDoList
        items.clearList();
        //remove all items from observable listview
        list.remove(0, list.size());
        //display updated toDoList with no items inside
        toDoEventList.setItems(list);
    }

    @FXML
    void deleteToDoList(ActionEvent event) throws IOException {
        //try
        //use toDoList method to remove an event object from the toDoList
        //use listview method to get index of selected object and method will remove object at the received index
        try{
            items.deleteEvent(toDoEventList.getSelectionModel().getSelectedIndex());
        }
        //catch exception
        catch (Exception e){
        //if an exception occurs, then no object in the to do list was selected
        //display a new scene with error message saying no object was selected
            Parent root =
                    FXMLLoader.load(Objects.requireNonNull(getClass().getResource("NoItemSelectedError.fxml")));

            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setTitle("No Item Selected Error");
            stage.setScene(scene);
            stage.show();
            return;
        }

        //update listview to display the toDoList with the object removed
        ObservableList<events> allList = FXCollections.observableArrayList();
        allList.addAll(items.getList());

        items.clearList();
        list.remove(0, list.size());
        toDoEventList.setItems(list);

        for(events item : allList){
            items.addEvent(item);
        }
        list.addAll(allList);
        toDoEventList.setItems(allList);
    }

    @FXML
    void displayAllEvents(ActionEvent event) {
        //when display all events option is selected
        //create an observable list and use toDoList method to return all event objects in the list
        ObservableList<events> allList = FXCollections.observableArrayList();
        //add all event objects into the observable list
        allList.addAll(items.getList());
        //set listview to display all events in observable list
        toDoEventList.setItems(allList);
    }

    @FXML
    void displayCompletedEvents(ActionEvent event) {
        //create an observable list to store all completed items
        ObservableList<events> completedList = FXCollections.observableArrayList();
        //traverse through event list of current list object using enhanced for loop
        //if item's completed flag is true, then set item in observable list
        //if flag is not set as true, then set item as invisible to user's screen
        completedList.addAll(items.getCompletedList());
        //display all observable list items in listview
        toDoEventList.setItems(completedList);
    }

    @FXML
    void displayIncompletedEvents(ActionEvent event) {
        ObservableList<events> incompletedList = FXCollections.observableArrayList();
        //traverse through event list of current list object using enhanced for loop
        //if item's completed flag is true, then set item as invisible to user's screen
        //if flag is not set as true, then set item in observable list
        incompletedList.addAll(items.getIncompletedList());
        //display all observable list items in listview
        toDoEventList.setItems(incompletedList);
    }

    @FXML
    void editEventDescription(ActionEvent event) throws IOException {
        //use listview method getSelectedModel and getSelectedIndex to get currently selected index
        //if index is below 0, then nothing is selected and display an error scene
        //exit method
        int index;
        if((index = toDoEventList.getSelectionModel().getSelectedIndex()) < 0){
            Parent root =
                    FXMLLoader.load(Objects.requireNonNull(getClass().getResource("NoItemSelectedError.fxml")));

            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setTitle("No Item Selected Error");
            stage.setScene(scene);
            stage.show();
            return;
        }
        //if valid index selected
        //open another scene and prompt user to enter a description between 1 and 256 characters.
        //this function will send the current object description to the scene to edit it.
        //if description entered is not in range, display error message.
        String returnDescription;
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("editDescription.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);

        editDescriptionController controller = loader.getController();
        controller.initData(toDoEventList.getSelectionModel().getSelectedItem().getDescription());

        Stage stage = new Stage();
        stage.setTitle("Edit Description");
        stage.setScene(scene);
        do {
            stage.showAndWait();
            returnDescription = controller.getDescription();
        }while(!(returnDescription.length() >= 1 && returnDescription.length() <= 256));

        //if description is in range, return string description back to this function.
        //use set description method in toDoList to update event at given index with new description
        items.changeDescription(index, returnDescription);

        //update listview to display the new description on the selected event
        ObservableList<events> allList = FXCollections.observableArrayList();
        allList.addAll(items.getList());

        items.clearList();
        list.remove(0, list.size());
        toDoEventList.setItems(list);

        for(events item : allList){
            items.addEvent(item);
        }
        list.addAll(items.getList());
        toDoEventList.setItems(list);
    }

    @FXML
    void editEventDueDate(ActionEvent event) throws IOException {
        //use listview method getSelectedModel and getSelectedIndex to get currently selected index
        //if index is below 0, then nothing is selected and display an error scene
        //exit method
        int index;
        if((index = toDoEventList.getSelectionModel().getSelectedIndex()) < 0){
            Parent root =
                    FXMLLoader.load(Objects.requireNonNull(getClass().getResource("NoItemSelectedError.fxml")));

            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setTitle("No Item Selected Error");
            stage.setScene(scene);
            stage.show();
            return;
        }

        //if valid index selected
        //Open another JavaFX GUI screen to ask what user what date to change to
        //send new date back to this method and update object at selected index with new date with toDoList method
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("dateChanger.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);

        dateChangerController controller = loader.getController();

        Stage stage = new Stage();
        stage.setTitle("Change Date");
        stage.setScene(scene);
        stage.showAndWait();
        String returnDate = controller.getNewDate();

        //use set date method in toDoList to update event at given index with new description
        items.changeDate(index, returnDate);

        //update listview to display the new date on the selected event
        ObservableList<events> allList = FXCollections.observableArrayList();
        allList.addAll(items.getList());

        items.clearList();
        list.remove(0, list.size());
        toDoEventList.setItems(list);

        for(events item : allList){
            items.addEvent(item);
        }
        list.addAll(items.getList());
        toDoEventList.setItems(list);
    }

    @FXML
    void loadList(ActionEvent event) throws IOException {
        //prompt user in another GUI screen to select file to get to load list into the current GUI
        //creates a file object with the path of the entered file name
        try{
            final FileChooser fileChooser = new FileChooser();
            Stage stage = new Stage();
            File file = fileChooser.showOpenDialog(stage);

            //Load file and read stored text format to create list object
            items.loadList(file);

            //replace current observable list in listview with the loaded toDoList
            list.clear();
            list.addAll(items.getList());
            toDoEventList.setItems(list);
        }
        //if file doesn't exist, display error message and end class method
        catch (Exception e){
            Parent root =
                    FXMLLoader.load(Objects.requireNonNull(getClass().getResource("fileNotLoadedError.fxml")));

            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setTitle("Error Loading File");
            stage.setScene(scene);
            stage.show();
        }
    }

    @FXML
    void markEventComplete(ActionEvent event) throws IOException {
        //have user select event in current list to mark as complete
        int index;
        if((index = toDoEventList.getSelectionModel().getSelectedIndex()) < 0){
            Parent root =
                    FXMLLoader.load(Objects.requireNonNull(getClass().getResource("NoItemSelectedError.fxml")));

            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setTitle("No Item Selected Error");
            stage.setScene(scene);
            stage.show();
            return;
        }

        //upon selection, set internal event flag's value to true for marked as complete
        items.changeItemComplete(index);
        //update observable list to display the item as complete
        ObservableList<events> allList = FXCollections.observableArrayList();
        allList.addAll(items.getList());

        items.clearList();
        list.remove(0, list.size());
        toDoEventList.setItems(list);

        for(events item : allList){
            items.addEvent(item);
        }
        list.addAll(allList);
        toDoEventList.setItems(allList);
    }

    @FXML
    void saveList(ActionEvent event) throws IOException {
        //prompt user in another GUI screen to select directory to save file too.
        try{
            final DirectoryChooser directoryChooser = new DirectoryChooser();
            Stage stage = new Stage();
            File file = directoryChooser.showDialog(stage);

            //Open another GUI screen to ask user to enter desired save file name.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("nameSaveFile.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            nameSaveFileController controller = loader.getController();
            stage = new Stage();
            stage.setTitle("Name Save File");
            stage.setScene(scene);
            stage.showAndWait();
            String fileName = file.getAbsolutePath() + "\\" + controller.getName();

            //convert list into text data and store date in the text file at the desired directory and with the desired name
            items.saveList(fileName);
        }//catch exception if there file can not be loaded
        catch (Exception e){
            Parent root =
                    FXMLLoader.load(Objects.requireNonNull(getClass().getResource("fileNotSavedError.fxml")));

            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setTitle("Error Saving File");
            stage.setScene(scene);
            stage.show();
        }
    }
}
