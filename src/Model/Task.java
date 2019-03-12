package Model;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Task implements Comparable<Task> {
    private String tasksName;
    private LocalDate deadline;
    private String projectName;
    private String status;
    private DateTimeFormatter formatter; //TODO to delete

    //Constructor to create a task
    public Task(String tasksName, LocalDate deadline, DateTimeFormatter formatter, String projectName, String status) {
        this.tasksName = tasksName;
        this.deadline = deadline;
        this.projectName = projectName;
        this.status = status;
        this.formatter = formatter;
    }

    //Update task's name
    public void setTasksName(String tasksName){
        this.tasksName = tasksName;
    }

    //Update task's date
    public void setDeadline(LocalDate deadline){
        this.deadline = deadline;
    }

    //Update task's project
    public void setProjectName(String projectName){
        this.projectName = projectName;
    }

    //Update task's status
    public void setTaskStatus(String status){
        this.status = status;
    }

    public String getProjectName() {
        return projectName;
    }

    public LocalDate getDeadline(){
        return deadline;
    }

    @Override
    public int compareTo(Task otherTask)
    {
        return this.deadline.compareTo(otherTask.getDeadline());
    }

    @Override
    public String toString(){
        return tasksName + ", " + deadline  + ", " + projectName + ", " + status;
    }
}
