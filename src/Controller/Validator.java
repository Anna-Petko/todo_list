package Controller;
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

    public static int validateInt(int min, int max) {
        // 5 + enter
        // title1 TODO discuus scanner
        //TODO use try and catch
        int dsf = scanner.nextInt();
        scanner.nextLine();
        //TODO fix th if statment
        if (dsf >= min && dsf <max)
            return dsf;
        String s = scanner.nextLine();
        int fd = Integer.parseInt(s);
        return 0;
    }
}
