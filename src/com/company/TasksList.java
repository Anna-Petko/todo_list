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

    public String getTask(int index){
        return tasksList.get(index).toString();
    }

    //Deleting a task from a task list
    public void removeTask(Task task) {
        tasksList.remove(task);
    }
    //Deleting a task from task list

}
