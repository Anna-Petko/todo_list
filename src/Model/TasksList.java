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

    public void removeTask(int index){
        tasksList.remove(index);
    }

    public void markTaskAsDone(int index){
        Scanner x = new Scanner(System.in);
        String newStatus = x.nextLine();
        tasksList.get(index).setTaskStatus(newStatus);
    }

    public void updateTask(int index){
        Scanner x = new Scanner(System.in);
        String updatedTaskName = x.nextLine();
        LocalDate updatedDeadline = Validator.validateDate();
        String updatedProjectName = x.nextLine();
        String updatedStatus = x.nextLine();
        Task task = new Task(updatedTaskName, updatedDeadline,updatedProjectName, updatedStatus );
        tasksList.set(index, task);

    }

    public void showTaskByProjectName(String projectName) {
        ArrayList<Task> filteredTasks = new ArrayList<>();
        for (Task t : tasksList) {
            if (t.getProjectName().equals(projectName)) {
                filteredTasks.add(t);
            }
        }
        for (int i = 0; i < filteredTasks.size(); i++) {
            System.out.println("Your tasks for the project "+ projectName + ": " + filteredTasks.get(i));
        }
    }

    public void showAllTaskByDate() {
        Collections.sort(tasksList);
        for (int i = 0; i < tasksList.size(); i++) {
            System.out.println(i + ") " + tasksList.get(i));
        }
        //TODO what happened if we don\t have any task in the list
    }

    public ArrayList<Task> getTasksList(){
        return tasksList;
    }
}


