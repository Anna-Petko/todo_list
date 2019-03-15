/**
 * This is a model of a task. Class includes getter and setter methods, overriding.
 * Implemented comparable and serializable interface to make sorting.
 */

package Model;
import java.io.Serializable;
import java.time.LocalDate;

public class Task implements Comparable<Task>, Serializable {
    private String tasksName;
    private LocalDate deadline;
    private String projectName;
    private String status;
    private static final long serialVersionUID = 1L;

    //Constructor to create a task
    public Task(String tasksName, LocalDate deadline, String projectName, String status) {
        this.tasksName = tasksName;
        this.deadline = deadline;
        this.projectName = projectName;
        this.status = status;
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

    //Use this methods to make sorting by due date
    @Override
    public int compareTo(Task otherTask) {
        return this.deadline.compareTo(otherTask.getDeadline());
    }

    //It returns an object
    @Override
    public String toString(){
        return tasksName + ", " + deadline  + ", " + projectName + ", " + status;
    }
}
