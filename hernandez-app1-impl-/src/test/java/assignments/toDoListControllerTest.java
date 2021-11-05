/*
 *  UCF COP3330 Fall 2021 Application Assignment 1 Solution
 *  Copyright 2021 Cesar Hernandez
 */

package assignments;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class toDoListControllerTest {

    @Test
    void addEvent() {
        //create Event object
        //set name, description, date, and completed boolean to events object using methods
        //create todoList object
        //use addEvent method to add event
        //assertTrue, if method returns true, then successful
        //if return false, an error occurred
    }

    @Test
    void guideUser() {
        //invoke method
        //determine is scene opened
        //true if successful
        //false is unsuccessful
    }

    @Test
    void deleteAllToDoListItems() {
        //create todolist object and populate it with "events" objects
        //invoke deleteAllToDoListItems method.
        //If todolist is equal to the empty todolist, then success
        //false otherwise
    }

    @Test
    void deleteToDoList() {
        //create todolist object and populate it with "events" objects
        //invoke method at given index
        //If todolist is equal to the sample todolist with the object pre-removed, then success
        //false otherwise
    }

    @Test
    void displayAllEvents() {
        //create todolist object and populate it with "events" objects
        //invoke method
        //if all objects are present in the container the objects are method
        //      stores the object in, then success
        //false otherwise
    }

    @Test
    void displayCompletedEvents() {
        //create todolist object and populate it with "events" objects
        //invoke method
        //if all completed objects are present in the container the objects are method
        //      stores the object in, then success
        //false otherwise
    }

    @Test
    void displayIncompletedEvents() {
        //create todolist object and populate it with "events" objects
        //invoke method
        //if all incomplete objects are present in the container the objects are method
        //      stores the object in, then success
        //false otherwise
    }

    @Test
    void editEventDescription() {
        //create a todolist and populate it with "events" objects
        //invoke this method and enter a description.
        //use the getDescription function on the given indexed "events" object
        //      to see if description is the same as a predetermined description
    }

    @Test
    void editEventDueDate() {
        //create a todolist and populate it with "events" objects
        //invoke this method and enter a due date.
        //use the getDueDate function on the given indexed "events" object
        //      to see if due date is the same as a predetermined due date
    }

    @Test
    void loadList() {
        //use saveList method to save a save file in a predetermined location
        //use loadList to load a list from the predetermined save file
        //compare todolist object from method to an expected todolist value set.
        //True is they are the same
        //false otherwise
    }

    @Test
    void markEventComplete() {
        //create a todolist and populate it with en "events" object.
        //invoke method on the object's only "events" object in it
        //if value is true, then success
        //false, otherwise
    }

    @Test
    void saveList() {
        //create a todolist and populate it with "events" objects
        //use method to save list to a specific location
        //open text file and compare contents to an expected text contents.
        //Compare is true if success. False otherwise.
    }
}