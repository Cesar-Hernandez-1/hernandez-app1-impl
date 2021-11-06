package assignments;

public class events {
    private final String nameEvent;
    private String description;
    private String dueDate;
    private Boolean completed;

    public events(String name, String date, String description, String completed){
        this.nameEvent = name;
        this.dueDate = date;
        this.description = description;
        this.completed = Boolean.valueOf(completed);
    }

    public events(String date, String name, String description){
        this(name, date, description, "false");
    }

    public void setCompleted(Boolean status){
        this.completed = status;
    }

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

    @Override
    public String toString(){
        return "To Do: " + getNameEvent() + "\nDue: " + getDueDate() + "\nDescription: " + getDescription() + "\nCompleted: " + getCompleted();
    }
}
