package com.company;

public class Task {
    private String tasksName;
    private String deadline;
    private String projectName;

    //Constructor to create a task
    public Task(String tasksName, String deadline, String projectName) {
        this.tasksName = tasksName;
        this.deadline = deadline;
        this.projectName = projectName;
    }

    //Update task's name
    public void setTasksName(String tasksName){
        this.tasksName = tasksName;
    }

    //Update task's date
    public void setDeadline(String deadline){
        this.tasksName = deadline;
    }

    //Update task's project
    public void setProjectName(String projectName){
        this.projectName = projectName;
    }


}
