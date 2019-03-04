package com.company;

public class Main {
    public static void main(String[] args) {

        //Call the Main menu
        Menu menu = new Menu();
        menu.showMenu();

        //Create a new TaskList object that will store added tasks
        TasksList collection = new TasksList();

        //Create a new UserInput object
        UserInput ui = new UserInput();
        //Show added tasks into TaskList object
        ui.insertDataForTask(collection.getTasksList());

        //Print out all tasks from TaskList object
        for (int i = 0; i < collection.getTaskListSize(); i++) {
            System.out.println(collection.getTask(i));
        }

    }
}



