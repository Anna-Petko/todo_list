package Model;
import Controller.Validator;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;


public class TasksList implements Serializable {
    private ArrayList<Task> tasksList;
    private static final long serialVersionUID = 1L;

    public TasksList(){
        tasksList = new ArrayList<>();
    }

    public int getSize(){
        return tasksList.size();
    }

    public void removeTask(int index){
        tasksList.remove(index-1);
        System.out.println("Your task was removed");

    }

    public void markTaskAsDone(int index, String newStatus){

        tasksList.get(index-1).setTaskStatus(newStatus);
    }

    public void addTask(String title, LocalDate deadline, String projectName, String status)
    {
        tasksList.add(createTask(title, deadline,projectName, status));

    }

    public Task createTask(String title, LocalDate deadline, String projectName, String status)
    {
        return new Task(title, deadline,projectName, status );
    }
    public void updateTask(int index, String updatedTaskName, LocalDate updatedDeadline, String updatedProjectName, String updatedStatus)
    {
        tasksList.set(index-1, createTask(updatedTaskName, updatedDeadline,updatedProjectName, updatedStatus));


    }


    public void showTaskByProjectName(String projectName) {
        ArrayList<Task> filteredTasks = new ArrayList<>();
        for (Task t : tasksList) {
            if (t.getProjectName().equals(projectName)) {
                filteredTasks.add(t);
            }
        }
        for (int i = 0; i < filteredTasks.size(); i++) {
            System.out.println("Your task for the project "+ projectName + ": " + filteredTasks.get(i));
        }
    }

    public void showAllTaskByDate() {
        Collections.sort(tasksList);
        for (int i = 0; i < tasksList.size(); i++) {
            System.out.println(i + 1 +") " + tasksList.get(i));
        }
      //If there is no tasks in the  list
    }

    public ArrayList<Task> getTasksList(){
        return tasksList;
    }
}


