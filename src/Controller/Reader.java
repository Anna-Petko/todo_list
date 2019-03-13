package Controller;
import java.util.Scanner;

public class Reader{
    private static Scanner scanner = new Scanner(System.in);

    public static int readInt() {
        //TODO call validate int here
        int res = scanner.nextInt();
        scanner.nextLine();
        return res;
    }

    public static String readLine() {
        return scanner.nextLine();
    }
}

