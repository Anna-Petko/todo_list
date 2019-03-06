package com.company;


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
                    System.out.println("show tasklist");
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
