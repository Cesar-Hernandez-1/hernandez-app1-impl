/*
 *  UCF COP3330 Fall 2021 Application Assignment 1 Solution
 *  Copyright 2021 Cesar Hernandez
 */

package assignments;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class toDoList {
    //create ArrayList object to store "events" inside
    private ArrayList<events> itemList;

    public toDoList(){
        //initialize the ArrayList variable with a new ArrayList
        itemList = new ArrayList<>();
    }

    public void addEvent(events listEvent){
        //add an "events" object into the toDoList ArrayList
        itemList.add(listEvent);
    }

    public events getEvent(int index){
        //return "events" object in list at given index
        return itemList.get(index);
    }
    public void deleteEvent(int event){
        //remove the "events" object at the received index
        itemList.remove(event);
    }

    public void clearList(){
        //delete every element in the todolist by using ArrayList method clear
        itemList.clear();
        //create a fresh todolist
        itemList = new ArrayList<>();
    }

    public void changeDescription(int index, String description){
        //use "events" object at received index method setDescription to change description to received one
        itemList.get(index).setDescription(description);
    }

    public void changeDate(int index, String date){
        //use "events" object at received index method setDueDate to change due date to received one
        itemList.get(index).setDueDate(date);
    }

    public void changeItemComplete(int eventIndex){
        //use "events" object at received index method setCompleted to change completed status to opposite boolean value
        boolean completedStatus = itemList.get(eventIndex).getCompleted();
        itemList.get(eventIndex).setCompleted(!completedStatus);
    }

    public List<events> getList(){
        //return the ArrayList of "events"
        return itemList;
    }

    public List<events> getCompletedList(){
        ArrayList<events> completedItems = new ArrayList<>();
        for(events item : itemList){
            if(item.getCompleted()){
                completedItems.add(item);
            }
        }
        return completedItems;
    }

    public List<events> getIncompletedList(){
        ArrayList<events> incompletedItems = new ArrayList<>();
        for(events item : itemList){
            if(!item.getCompleted()){
                incompletedItems.add(item);
            }
        }
        return incompletedItems;
    }

    public void saveList(String saveFile) throws IOException{

        //try to open a new text file at specified directory path received
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(saveFile))){
            //String builder to convert list and items to text
            StringBuilder saveOutput = new StringBuilder();
            //convert all items to text
            for(events item : itemList){
                saveOutput.append(item.getNameEvent()).append("\n").append(item.getDueDate()).append("\n").append(item.getDescription()).append("\n").append(item.getCompleted()).append("\n");
            }
            //write text to text file
            writer.write(saveOutput.toString());
        }
    }

    public void loadList(File loadFile) throws IOException{

        //try to open file specified in received File Chooser
        try(BufferedReader reader = new BufferedReader(new FileReader(loadFile))) {

            //make new todolist to populate
            String line;
            ArrayList<events> newToDoList = new ArrayList<>();

            //get every line and construct an "events" object on received data
            while((line = reader.readLine()) != null){
                String date = reader.readLine();
                String description = reader.readLine();
                String completed = reader.readLine();
                //add "events" object into the todolist
                newToDoList.add(new events(line, date, description, completed));
            }

            //clear current todolist and add make the new list the current list
            itemList.clear();
            itemList = newToDoList;
        }
    }
}
