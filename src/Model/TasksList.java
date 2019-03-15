/**
 * This is a class to create TaskList (ArrayList type) where user can add and store tasks.
 * Implemented methods for task manipulation (add, create, remove, mark as done, update).
 */

package Model;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;


public class TasksList implements Serializable {
    private ArrayList<Task> tasksList;
    private static final long serialVersionUID = 1L;

    //Constructor for TaskList
    public TasksList(){
        tasksList = new ArrayList<>();
    }

    //Size of a collection
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

    public Task createTask(String title, LocalDate deadline, String projectName, String status) {
        return new Task(title, deadline,projectName, status );
    }

    public void updateTask(int index, String updatedTaskName,
                           LocalDate updatedDeadline, String updatedProjectName, String updatedStatus){

        tasksList.set(index-1, createTask(updatedTaskName, updatedDeadline,updatedProjectName, updatedStatus));

    }

    //Method to show tasks from a collection with inserted by user project name
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
    //Method to make a sorting  by due date
    public void showAllTaskByDate() {
        Collections.sort(tasksList);
        for (int i = 0; i < tasksList.size(); i++) {
            System.out.println(i + 1 +") " + tasksList.get(i));
        }
    }

    public ArrayList<Task> getTasksList(){
        return tasksList;
    }
}


