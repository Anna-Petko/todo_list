package Model;

import java.time.LocalDate;
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

    public int getTaskListSize(){
        return tasksList.size();
    }

    //Deleting a task from a task list
    public void removeTask(Task task) {
        tasksList.remove(task);
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

    public void showTasksByDate(LocalDate deadline) {
        ArrayList<Task> filteredTask = new ArrayList<>();
        for(Task t : tasksList) {
            if(t.getDeadline().isEqual(deadline)){
                filteredTask.add(t);
            }
        }
        for(int i = 0; i < filteredTask.size(); i++){
            System.out.println("Deadline: " + filteredTask.get(i).getDeadline());
        }
    }

    public ArrayList<Task> getTasksList(){
        return tasksList;
    }

    public boolean containsProjectName(String projectName) {
        for(Task task: tasksList){
            if(task.getProjectName().equals(projectName)){
                return true;
            }
        }
       return false;
    }

    public boolean containsDateName(LocalDate deadline){
        for(Task task: tasksList){
            if (task.getDeadline().isEqual(deadline)){
                return true;
            }
        }
        return false;
    }
}


