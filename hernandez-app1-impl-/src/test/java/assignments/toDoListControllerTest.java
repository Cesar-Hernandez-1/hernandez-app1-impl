/*
 *  UCF COP3330 Fall 2021 Application Assignment 1 Solution
 *  Copyright 2021 Cesar Hernandez
 */

package assignments;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class toDoListControllerTest {

    @Test
    void addEvent() {
        //create "events" object
        //set name, description, date, and completed boolean to events object using methods
        events item = new events("Test Task","No Due Date","This is a test", "false");

        //create todoList object
        toDoList todoList = new toDoList();

        //use addEvent method to add event
        todoList.addEvent(item);

        //assertEquals, if method getEvent at index 0 returns the save created "events" object, then successful
        //false otherwise
        assertEquals(item, todoList.getEvent(0));
    }

    @Test
    void guideUser() {
        //method does not need to be tested as it only
        //displays a GUI scene that only displays text
        //that shows how the application is used.
    }

    @Test
    void deleteAllToDoListItems() {
        //create todolist object and populate it with "events" objects
        toDoList list = new toDoList();
        for(int i = 0; i < 3; i++){
            list.addEvent(new events("Test Task" + (i + 1),"No Due Date","Test task" + (i + 1),"false"));
        }

        //invoke clearList method on todolist object.
        list.clearList();

        //If todolist is equal to the freshly created empty todolist, then success
        //false otherwise
        assertEquals(new toDoList().getList(), list.getList());
    }

    @Test
    void deleteToDoList() {
        //create todolist object and populate it with "events" objects
        toDoList actualList = new toDoList();
        for(int i = 0; i < 2; i++){
            actualList.addEvent(new events("Test Task" + (i + 1),"No Due Date","Test task" + (i + 1),"false"));
        }

        //create expected output todolist populated with expected number of items inside to compare too
        toDoList expectedList = new toDoList();
        for(int i = 0; i < 1; i++){
            expectedList.addEvent(new events("Test Task" + (i + 1),"No Due Date","Test task" + (i + 1),"false"));
        }

        //invoke todolist's deleteEvent method at given index
        actualList.deleteEvent(1);

        //If actual todolist is equal to the expected todolist size with the object pre-removed, then success
        //false otherwise
        assertEquals(expectedList.getList().size(), actualList.getList().size());
    }

    @Test
    void displayAllEvents() {
        //create todolist object and populate it with "events" objects marked as completed and incomplete
        toDoList list = new toDoList();
        for(int i = 0; i < 3; i++){
            list.addEvent(new events("Test Task" + (i + 1),"No Due Date","Test task" + (i + 1),"false"));
            list.addEvent(new events("Test Task" + (i + 2),"No Due Date","Test task" + (i + 2),"true"));
        }

        //create expected output arraylist of "events" to compare too
        ArrayList<events> expectedList = new ArrayList<>();
        for(int i = 0; i < 3; i++){
            expectedList.add(new events("Test Task" + (i + 1),"No Due Date","Test task" + (i + 1),"false"));
            expectedList.add(new events("Test Task" + (i + 2),"No Due Date","Test task" + (i + 2),"true"));
        }

        //if all objects are present in the container after invoking the getList method, then success
        //false otherwise
        //assert equals from the stored expected items from the items returned by the method
        assertEquals(expectedList.toString(),list.getList().toString());
    }

    @Test
    void displayCompletedEvents() {
        //create todolist object and populate it with "events" objects marked as completed and incomplete
        toDoList list = new toDoList();
        for(int i = 0; i < 3; i++){
            list.addEvent(new events("Test Task" + (i + 1),"No Due Date","Test task" + (i + 1),"false"));
            list.addEvent(new events("Test Task" + (i + 2),"No Due Date","Test task" + (i + 2),"true"));
        }

        //create expected output arraylist of "events" to compare too
        ArrayList<events> expectedList = new ArrayList<>();
        for(int i = 0; i < 3; i++){
            expectedList.add(new events("Test Task" + (i + 2),"No Due Date","Test task" + (i + 2),"true"));
        }

        //if all objects are present in the container after invoking the getCompletedList method, then success
        //false otherwise
        //assert equals from the stored expected items from the items returned by the method
        assertEquals(expectedList.toString(), list.getCompletedList().toString());
    }

    @Test
    void displayIncompletedEvents() {
        //create todolist object and populate it with "events" objects
        toDoList list = new toDoList();
        for(int i = 0; i < 3; i++){
            list.addEvent(new events("Test Task" + (i + 1),"No Due Date","Test task" + (i + 1),"false"));
            list.addEvent(new events("Test Task" + (i + 2),"No Due Date","Test task" + (i + 2),"true"));
        }

        //create expected output arraylist of "events" to compare too
        ArrayList<events> expectedList = new ArrayList<>();
        for(int i = 0; i < 3; i++){
            expectedList.add(new events("Test Task" + (i + 1),"No Due Date","Test task" + (i + 1),"false"));
        }

        //if all objects are present in the container after invoking the getIncompletedList method, then success
        //false otherwise
        //assert equals from the stored expected items from the items returned by the method
        assertEquals(expectedList.toString(), list.getIncompletedList().toString());
    }

    @Test
    void editEventDescription() {
        //create a todolist and populate it with "events" objects
        toDoList list = new toDoList();
        for(int i = 0; i < 3; i++){
            list.addEvent(new events("Test Task" + (i + 1),"No Due Date","Test task" + (i + 1),"false"));
        }

        //invoke this changeDescription method and provide an index of item to change and description to change too.
        list.changeDescription(1, "Change Description!");

        //use the getDescription function on the given indexed "events" object
        //      to see if description is the same as a predetermined description
        assertEquals("Change Description!", list.getEvent(1).getDescription());
    }

    @Test
    void editEventDueDate() {
        //create a todolist and populate it with "events" objects
        toDoList list = new toDoList();
        for(int i = 0; i < 3; i++){
            list.addEvent(new events("Test Task" + (i + 1),"No Due Date","Test task" + (i + 1),"false"));
        }

        //invoke this changeDate method and provide an index of item to change and date to change too.
        list.changeDate(1, "2021-12-12");

        //use the getDueDate function on the given indexed "events" object
        //      to see if due date is the same as a predetermined due date
        assertEquals("2021-12-12", list.getEvent(1).getDueDate());
    }

    @Test
    void loadList() {
        //method does not need to be tested as creating a path to save a file too may
        //interfere with submission file structure.
    }

    @Test
    void markEventComplete() {
        //create a todolist and populate it with an "events" object.
        toDoList list = new toDoList();
        list.addEvent(new events("Test Task","No Due Date","Test task","false"));

        //invoke changeItemComplete method on an "events" object in it
        list.changeItemComplete(0);

        //if value is true, then success
        //false, otherwise
        assertTrue(list.getEvent(0).getCompleted());

        //invoke method again and test if completed status changed to opposite value
        list.changeItemComplete(0);
        assertFalse(list.getEvent(0).getCompleted());
    }

    @Test
    void saveList() {
        //method does not need to be tested as creating a path to save a file too may
        //interfere with submission file structure.
    }
}