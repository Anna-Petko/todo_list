package Controller;
import Model.TasksList;
import View.ToDoInterface;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class ToDoController {
    private TasksList collection;
    private UserInput taskInput;
    private ToDoInterface toDoInterface;

    public ToDoController(){
        this.collection = new TasksList();
        this.taskInput = new UserInput();
        this.toDoInterface = new ToDoInterface();
    }

    public void chooseCommand(){
        while(true) {
            toDoInterface.showMenu();
            String option = taskInput.getUserInput();
            switch (option) {
                case "1":
//                    System.out.println("Please insert the name of the project");
//                    String projectName = new UserInput().getUserInput();
//                    if(collection.getTaskListSize() == 0) {
//                        System.out.println("Your task list is empty. Please create and add a task");
//                    } else if (collection.containsProjectName(projectName)) {
//                        collection.showTaskByProjectName(projectName);
//                    } else {
//                        System.out.println("There is no such project. Try other name");
//                    }
                    System.out.println("Please insert the date");
                    String deadline = new UserInput().getUserInput();
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                    LocalDate date = LocalDate.parse(deadline, formatter);
                    if(collection.getTaskListSize() == 0) {
                        System.out.println("Your task list is empty. Please create and add a task");
                    } else if (collection.containsDateName(date)) {
                        collection.showTasksByDate(date);
                    } else {
                        System.out.println("There are no tasks for this date. Try another one");
                    }
                    break;
                case "2":
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
