package Controller;
import Model.Task;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class UserInput {

    Scanner userInput = new Scanner(System.in);
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public String getUserInput(){
        return userInput.nextLine();
    }


    public void insertDataForTask(ArrayList<Task> tasksList){

        System.out.println("Create a title's name ");
        String taskName = userInput.nextLine();

        System.out.println("Set up a deadline");
        String dueDate = userInput.nextLine();
        LocalDate deadline = LocalDate.parse(dueDate, formatter);

        System.out.println("Assign task to the project");
        String projectName = userInput.nextLine();

        System.out.println("Define a status of a task");
        String status = userInput.nextLine();

        //Here we add a created task to a created taskList
        tasksList.add(new Task(taskName, deadline, formatter, projectName, status));

    }
}
