package com.company;
import java.util.ArrayList;

public class TasksList {

    private ArrayList<Task> tasksList;

    public TasksList(){
       tasksList = new ArrayList<>();
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

    public void showTaskByProjectName(String projectName) {
        ArrayList<Task> filteredTasks = new ArrayList<>();
        for (Task t : tasksList) {
            if (t.getProjectName() == projectName) {
                filteredTasks.add(t);
            }
        }
        for (int i = 0; i < filteredTasks.size(); i++) {
            System.out.println("Project Name : " + filteredTasks.get(i).getProjectName());
        }
    }

}
