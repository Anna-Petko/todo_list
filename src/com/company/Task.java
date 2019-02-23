package com.company;
import java.util.Date;
import java.text.SimpleDateFormat;

public class Task {
    private String tasksName;
    private Date deadline;
    private String projectName;
    private String status;
    private SimpleDateFormat dateFormatter;

    //Constructor to create a task
    public Task(String tasksName, Date deadline, SimpleDateFormat dateFormatter, String projectName, String status) {
        this.tasksName = tasksName;
        this.deadline = deadline;
        this.projectName = projectName;
        this.status = status;
        this.dateFormatter = dateFormatter;
    }

    //Update task's name
    public void setTasksName(String tasksName){
        this.tasksName = tasksName;
    }

    //Update task's date
    public void setDeadline(Date deadline){
        this.deadline = deadline;
    }

    //Update task's project
    public void setProjectName(String projectName){
        this.projectName = projectName;
    }

    public String toString(){
        return tasksName + ", " + dateFormatter.format(deadline) + ", " + projectName + ", " + status + "," ;
    }
}
