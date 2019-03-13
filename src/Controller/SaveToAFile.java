package Controller;
import Model.TasksList;
import java.io.*;

public class SaveToAFile {

    public static TasksList load()
    {
        TasksList t = new TasksList();
        File f = new File("t.txt");
        if  (f.exists()) {
            FileInputStream fis = null;

            try {
                fis = new FileInputStream(new File("t.txt"));
                ObjectInputStream ios = new ObjectInputStream(fis);

                t = (TasksList) ios.readObject();
                System.out.println("the array after loading " + t);


                fis.close();
                ios.close();

            } catch (java.io.IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }

        }


        return t;
    }

    public static void save(TasksList t)
    {
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(new File("t.txt"));
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(t);

            fos.close();
            oos.close();

        } catch (java.io.IOException e) {
            e.printStackTrace();
        }
    }
}
