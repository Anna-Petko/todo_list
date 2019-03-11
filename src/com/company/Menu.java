package com.company;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Menu {
    private TasksList collection;
    private UserInput taskInput;

    public Menu(){
        this.collection = new TasksList();
        this.taskInput = new UserInput();
    }

    public void showMenu() {
        System.out.println(">> You have X tasks todo and Y tasks are done! ");
        System.out.println(">> Pick an option:");
        System.out.println(">> (1) Show Task List (by date or project)");
        System.out.println(">> (2) Add New Task");
        System.out.println(">> (3) Edit Task (update, mark as done, remove)");
        System.out.println(">> (4) Save and Quit ");
        System.out.println(">>");
    }
    public void chooseCommand(){
        System.out.println(">> Welcome to ToDoLy");
        while(true) {
            showMenu();
            String option = taskInput.getUserInput();
            switch (option) {
                case "1":
//                    System.out.println("Please insert the name of the project");
//                    String projectName = new UserInput().getUserInput();
//                    if(collection.getTaskListSize() == 0) {
//                        System.out.println("Your task list is empty. Please create and add a task");
//                    } else if (collection.containsProjectName(projectName)) {
//                        collection.showTaskByProjectName(projectName);
//                    } else {
//                        System.out.println("There is no such project. Try other name");
//                    }
                    System.out.println("Please insert the date");
                    String deadline = new UserInput().getUserInput();
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                    LocalDate date = LocalDate.parse(deadline, formatter);
                    if(collection.getTaskListSize() == 0) {
                        System.out.println("Your task list is empty. Please create and add a task");
                    } else if (collection.containsProjectName(date)) {
                        collection.showTasksByDate(date);
                    } else {
                        System.out.println("There are no tasks for this date. Try another one");
                    }
                    break;
                case "2":
//                    TasksList collection = new TasksList();
//                    UserInput task = new UserInput();
                    taskInput.insertDataForTask(collection.getTasksList());
                    break;
                case "3":
                    System.out.println("edit");
                    break;
                case "4":
                    System.out.println("now it is empty//save");
                    break;
                default:
                    System.out.println("Invalid option");
                    break;
            }
        }
    }
}
