package Controller;
import Model.Task;
import Model.TasksList;
import View.Printer;
import java.time.LocalDate;
import java.util.ArrayList;

public class ToDoController {
    private TasksList collection;
    private boolean programIsRunning = true;

    public ToDoController(){
        this.collection = new TasksList();
    }
    public void loadFile() {
        collection = SaveToAFile.load();
    }

    public void saveFile() {
        SaveToAFile.save(collection);
    }

    public void chooseCommand(){
        while(programIsRunning) {
            Printer.showMenu();
            String option = Reader.readLine();
            switch (option) {
                case "1":
                    showTaskList();
                    break;
                case "2":
                    addNewTask(collection.getTasksList());
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
        String menuOption = Reader.readLine();
        // validate user input
        switch (menuOption) {
            case "1":
                collection.showAllTaskByDate();
                break;
            case "2":
                collection.showTaskByProjectName(Reader.readLine());
                break;
        }
    }

    public void editTask(){
        if(collection.getSize() == 0) {
            System.out.println("Your collection is empty. Please create and add a task ");
        } else {
            System.out.println("Your tasks");
            collection.showAllTaskByDate();
            System.out.println("Please choose a task");
            int index = Reader.readInt();
            Printer.editTaskMenu();
            String option = Reader.readLine();
            switch (option) {
                case "1":
                    System.out.println("Update");
                    collection.updateTask(index);
                    break;
                case "2":
                    System.out.println("Mark as done");
                    collection.markTaskAsDone(index);
                    break;
                case "3":
                    System.out.println("Remove");
                    collection.removeTask(index);
                    break;
            }
        }
        //TODO check that the index is int, check that this index is in the list
    }

    private void saveAndQuit(){
        // Logic to save the program in a file
        //flag to finish the while
        programIsRunning = false;
        saveFile();
    }

    public void addNewTask(ArrayList<Task> tasksList){
        Printer.getTaskTitle();
        String taskName = Reader.readLine();

        Printer.getTaskDate();
        LocalDate deadline = Validator.validateDate();

        Printer.getTaskProject();
        String projectName = Reader.readLine();

        Printer.getTaskStatus();
        String status = Reader.readLine();

        //Here we add a created task to a created taskList
        tasksList.add(new Task(taskName, deadline,  projectName, status));
    }
}
