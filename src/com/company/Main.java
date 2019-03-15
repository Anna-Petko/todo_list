/**
 * This is a main class, the root of the app. Here ToDOController object is being created,
 * called methods for load file with saved tasks, show menu for user.
 **/

package com.company;
import Controller.ToDoController;

public class Main {
    public static void main(String[] args) {
        ToDoController service = new ToDoController();
        service.loadFile();
        service.chooseCommand();
    }
}



