/**
 * This is a class that connects business logic and view. Here we initialize TaskList collection, Scanner to take user input.
 * Program reads saved tasks, can add and save tasks (after program will be over) into task list.
 * User communication is provided here. User can make some actions with tasks and save them.
 */

package Controller;
import Model.TasksList;
import View.Printer;
import java.time.LocalDate;
import java.util.Scanner;

public class ToDoController {
    private TasksList collection;
    private Scanner scanner = new Scanner(System.in).useDelimiter("\n");
    private boolean programIsRunning = true;

    public ToDoController(){
        this.collection = new TasksList();
    }

    // Load file and  read collection from file
    public void loadFile() {
        collection = SaveToAFile.load();
    }

    //Save created task list into file
    public void saveFile() {
        SaveToAFile.save(collection);
    }

    public void chooseCommand(){
        while(programIsRunning) {
            Printer.showMenu();
            String option = scanner.next();
            switch (option) {
                case "1":
                    showTaskList();
                    break;
                case "2":
                    addNewTask();
                    break;
                case "3":
                    System.out.println("edit");
                    editTask();
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

    private void showTaskList() {
        Printer.taskListMenu();
        String menuOption = scanner.next();
        // validate user input
        if(collection.getSize() == 0) {
            System.out.println("Your collection is empty. Please create and add a task ");
        } else {
            switch (menuOption) {
                case "1":
                    collection.showAllTaskByDate();
                    break;
                case "2":
                    System.out.println("Insert the name of the project");
                    collection.showTaskByProjectName(scanner.next());
                    break;
            }
        }
    }

    public void editTask(){
        if(collection.getSize() == 0) {
            System.out.println("Your collection is empty. Please create and add a task ");
        } else {
            System.out.println("Your tasks");
            collection.showAllTaskByDate();
            System.out.println("Please choose a task");
            //int index = Reader.readInt();
            Scanner scanner = new Scanner(System.in);
            int index = Validator.validateInt(1, collection.getSize());
             Printer.editTaskMenu();
                String option = scanner.next();
                switch (option) {
                    case "1":
                        System.out.println("Update");
                        updateTask(index);
                        break;
                    case "2":
                        System.out.println("Mark as done");
                        markTaskAsDone(index);
                        break;
                    case "3":
                        System.out.println("Remove");
                        collection.removeTask(index);
                        break;
                }
        }
    }

    private void markTaskAsDone(int index)
    {
        System.out.println("Mark task as done.Insert 'done'");
        String newStatus = scanner.next();
        collection.markTaskAsDone(index, newStatus);
    }

    private void updateTask(int index)
    {
        System.out.println("insert new name");
        String updatedTaskName = scanner.next();
        System.out.println("insert new date");
        LocalDate updatedDeadline = Validator.validateDate();
        System.out.println("insert project");
        String updatedProjectName = scanner.next();
        System.out.println("insert status");
        String updatedStatus = scanner.next();

        collection.updateTask(index, updatedTaskName, updatedDeadline,updatedProjectName, updatedStatus );

    }

    private void saveAndQuit(){
        // Logic to save the program in a file
        //flag to finish the while
        programIsRunning = false;
        saveFile();
    }

    public void addNewTask(){
        Printer.getTaskTitle();
        String taskName = scanner.next();

        Printer.getTaskDate();
        LocalDate deadline = Validator.validateDate();

        Printer.getTaskProject();
        String projectName = scanner.next();

        Printer.getTaskStatus();
        String status = scanner.next();

        //Here we add a created task to a created taskList
        collection.addTask(taskName, deadline,  projectName, status);
    }
}
