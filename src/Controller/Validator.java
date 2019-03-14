package Controller;
import Model.TasksList;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Validator {
    private static Scanner scanner = new Scanner(System.in);
    private  static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");


    public static LocalDate validateDate(){
        while (true){
            //TODO
            String dateString = scanner.nextLine();
            try {
                 LocalDate deadline = LocalDate.parse(dateString, formatter);
                 return deadline;
            }
            catch (Exception e){
                System.out.println("please enter the right format ");
            }
        }
    }

    public static Boolean validateInt(int index ,TasksList collection ) {
        try {
            if (collection.getSize() >= index) {
                return true;
            }
        } catch (Exception e) {
            System.out.println("Wrong");
        }
        return false;
    }
}
