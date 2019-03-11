package com.company;

import Controller.ToDoController;

public class Main {
    public static void main(String[] args) {

        //Show the Main menu
        //ToDoInterface menu = new ToDoInterface();
       // menu.showMenu();
        ToDoController service = new ToDoController();
        service.chooseCommand();


    }
}



