package Controller;
import Model.Task;
import Model.TasksList;
import View.Printer;
import View.Reader;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class ToDoController {
    private TasksList collection;
    private boolean programIsRunning = true;
    private Scanner userInput = new Scanner(System.in);
    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public ToDoController(){
        this.collection = new TasksList();
    }

    public void chooseCommand(){
        while(programIsRunning) {
            Printer.showMenu();
            String option = Reader.readLine(); //userInput.nextLine();
            switch (option) {
                case "1":
                    showTaskList();
                    break;
                case "2":
                    insertDataForTask(collection.getTasksList());
                    break;
                case "3":
                    System.out.println("edit");
                    nour();
                    break;
                case "4":
                    saveAndQuit();
                    Printer.farewell();
                    break;
                default:
                    System.out.println("Invalid option");
                    break;
            }
        }
    }

    public void nour()
    {
        System.out.println("we will remove");
        collection.showAllTaskByDate();
        int index = userInput.nextInt();//Reader.readInt();
        //userInput.nextLine();
        //TODO check that the index is int, check that this index is in the list

        collection.updateTask(index);

        //collection.markTaskAsDone(index);

        //collection.removeTask(index);

    }
    private void showTaskList() {
        Printer.taskListMenu();
        String menuOption = userInput.nextLine();
        // validate user input
        switch (menuOption) {
            case "1":
                showTaskListByDate();
                break;
            case "3":
                collection.showAllTaskByDate();
                break;
            case "2":
                showTaskListByProjectName();
                break;
        }
    }

    private void saveAndQuit(){
        // Logic to save the program in a file
        //flag to finish the while
        programIsRunning = false;
    }

    private void showTaskListByProjectName() {
        System.out.println("Please insert the name of the project");
        String projectName = userInput.nextLine();
        if (collection.getTaskListSize() == 0) {
            System.out.println("Your task list is empty. Please create and add a task");
        } else if (collection.containsProjectName(projectName)) {
            collection.showTaskByProjectName(projectName);
        } else {
            System.out.println("There is no such project. Try other name");
        }
    }
        private void showTaskListByDate(){
            System.out.println("Please insert the date");
            String deadline = userInput.nextLine();
            LocalDate date = LocalDate.parse(deadline, formatter);//Validator.validatDate();
            if (collection.getTaskListSize() == 0) {
                System.out.println("Your task list is empty. Please create and add a task");
            } else if (collection.containsDateName(date)) {
                collection.showTasksByDate(date);
            } else {
                System.out.println("There are no tasks for this date. Try another one");
            }
        }

    private void insertDataForTask(ArrayList<Task> tasksList){
        Printer.getTaskTitle();
        String taskName = userInput.nextLine();

        Printer.getTaskDate();
        //String dueDate = userInput.nextLine();
        LocalDate deadline = Validator.validatDate();// LocalDate.parse(dueDate, formatter);

        Printer.getTaskProject();
        String projectName = userInput.nextLine();

        Printer.getTaskStatus();
        String status = userInput.nextLine();

        //Here we add a created task to a created taskList
        tasksList.add(new Task(taskName, deadline, formatter, projectName, status));
    }
}
