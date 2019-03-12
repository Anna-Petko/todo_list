package View;


public class Printer {

    public static void showMenu() {
        System.out.println(">> Welcome to ToDoLy");
        System.out.println(">> You have X tasks todo and Y tasks are done! ");
        System.out.println(">> Pick an option:");
        System.out.println(">> (1) Show Task List (by date or project)");
        System.out.println(">> (2) Add New Task");
        System.out.println(">> (3) Edit Task (update, mark as done, remove)");
        System.out.println(">> (4) Save and Quit ");
        System.out.println(">>");
    }

    public static void farewell() {
        System.out.println("Thanks for using the ToDoLy App");
    }

    public static void getTaskTitle() {
        System.out.println("Create a title's name ");
    }

    public static void getTaskDate(){
        System.out.println("Create a task's date");
    }

    public static void getTaskProject(){
        System.out.println("Assign task to the project");
    }

    public static void getTaskStatus(){
        System.out.println("Define a status of a task");
    }

    public static void taskListMenu() {
        System.out.println("(1) sort task by due date");
        System.out.println("(2) filter tasks by project");
    }

//    public static void listTasks(ArrayList<Task> collection) {
//        for (Task t: collection) {
//            System.out.println(t);
//        }
//    }
}
