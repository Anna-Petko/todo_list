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
        tasksList.remove(index-1);
        System.out.println("Your task was removed");

    }

    public void markTaskAsDone(int index){
        System.out.println("Mark task as done.Insert 'done'");
        Scanner x = new Scanner(System.in);
        String newStatus = x.nextLine();
        tasksList.get(index-1).setTaskStatus(newStatus);
    }

    public void updateTask(int index){
        Scanner x = new Scanner(System.in);
        System.out.println("insert new name");
        String updatedTaskName = x.nextLine();
        System.out.println("insert new date");
        LocalDate updatedDeadline = Validator.validateDate();
        System.out.println("insert project");
        String updatedProjectName = x.nextLine();
        System.out.println("insert status");
        String updatedStatus = x.nextLine();
        Task task = new Task(updatedTaskName, updatedDeadline,updatedProjectName, updatedStatus );
        tasksList.set(index-1, task);

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


