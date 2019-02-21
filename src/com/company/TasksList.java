package com.company;
import java.util.ArrayList;

public class TasksList {

    private ArrayList<Task> tasksList;

    public TasksList(){
       tasksList = new ArrayList<Task>();
    }
    public void addTasksToList(Task task){
        tasksList.add(task);

    }

}
