/*
 *  UCF COP3330 Fall 2021 Application Assignment 1 Solution
 *  Copyright 2021 Cesar Hernandez
 */

package assignments;

public class events {
    private final String nameEvent;
    private String description;
    private String dueDate;
    private Boolean completed;

    public events(String name, String date, String description, String completed){
        //constructor sets name, date, description, and completed boolean status
        //into respective variables
        this.nameEvent = name;
        this.dueDate = date;
        this.description = description;
        //cast string "true" or "false" to boolean values
        this.completed = Boolean.valueOf(completed);
    }

    public events(String date, String name, String description){
        //make a constructor that only accepts all parameters except
        //completion boolean and set default complete status to false
        this(name, date, description, "false");
    }

    public void setCompleted(Boolean status){ this.completed = status; }

    public boolean getCompleted(){
        return this.completed;
    }


    public void setDueDate(String date){
        this.dueDate = date;
    }

    public String getDueDate(){
        return this.dueDate;
    }

    public String getNameEvent(){
        return this.nameEvent;
    }

    public void setDescription(String des){
        this.description= des;
    }

    public String getDescription(){
        return this.description;
    }

    //override toString method to make this "events" item formated into a readable string to store or display
    @Override
    public String toString(){
        return "To Do: " + getNameEvent() + "\nDue: " + getDueDate() + "\nDescription: " + getDescription() + "\nCompleted: " + getCompleted();
    }
}
