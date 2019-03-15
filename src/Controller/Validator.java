package Controller;
import Model.TasksList;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Validator {
    private static Scanner scanner = new Scanner(System.in).useDelimiter("\n");
    private  static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");


    public static LocalDate validateDate(){
        while (true){

            String dateString = scanner.next();
            try {
                 LocalDate deadline = LocalDate.parse(dateString, formatter);
                 return deadline;
            }
            catch (Exception e){
                System.out.println("please enter the right format ");
            }
        }
    }

    //TODO speak about scanner
    public static int validateInt(int min ,int max )
    {
        while(true) {
            try {
                //first option
                String input = scanner.next();
                int param = Integer.parseInt(input);

                //second option
                //int param = scanner.nextInt();
                if (param >= min && param <= max) {
                    return param;
                }
                System.out.println("Please insert the right number between " + min);

            } catch (Exception e) {
                System.out.println("Please insert a NUMBER not a text ");
            }
        }
    }
}
