package Controller;
import Model.Task;
import Model.TasksList;
import View.Printer;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class ToDoController {
    private TasksList collection;
    private boolean programIsRunning = true;
    // private Scanner userInput = new Scanner(System.in);
    private transient DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public ToDoController(){
        this.collection = new TasksList();
    }
public void loadFile()
{
    collection = SaveToAFile.load();

}

    public void saveFile()
    {
        SaveToAFile.save(collection);
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

    public void editTask()
    {
        System.out.println("we will remove");
        collection.showAllTaskByDate();
        int index = Reader.readInt(); //userInput.nextInt();
        //userInput.nextLine();
        //TODO check that the index is int, check that this index is in the list

        collection.updateTask(index);

        collection.markTaskAsDone(index);

        collection.removeTask(index);

    }
    private void showTaskList() {
        Printer.taskListMenu();
        String menuOption = Reader.readLine(); //userInput.nextLine();
        // validate user input
        switch (menuOption) {
            case "3":
                showTaskListByDate();
                break;
            case "1":
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
        saveFile();
    }

    private void showTaskListByProjectName() {
        System.out.println("Please insert the name of the project");
        String projectName = Reader.readLine();//userInput.nextLine();
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
        String deadline = Reader.readLine();//userInput.nextLine();
        LocalDate date = Validator.validatDate();//LocalDate.parse(deadline, formatter);//Validator.validatDate();
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
        String taskName = Reader.readLine(); //userInput.nextLine();

        Printer.getTaskDate();
        //String dueDate = userInput.nextLine();
        LocalDate deadline = Validator.validatDate();// LocalDate.parse(dueDate, formatter);

        Printer.getTaskProject();
        String projectName = Reader.readLine(); //userInput.nextLine();

        Printer.getTaskStatus();
        String status = Reader.readLine(); //userInput.nextLine();

        //Here we add a created task to a created taskList
        tasksList.add(new Task(taskName, deadline,  projectName, status));
    }
}
