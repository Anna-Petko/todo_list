package com.company;

import Controller.ToDoController;

public class Main {

    public static void main(String[] args) {

        ToDoController service = new ToDoController();
        service.loadFile();
        service.chooseCommand();

    }
}



