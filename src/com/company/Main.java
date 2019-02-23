package com.company;
import java.text.SimpleDateFormat;
import java.util.Date;


public class Main {
    public static void main(String[] args) throws Exception { //handle this later
        String date = "02/03/2022";
        SimpleDateFormat formatter = new SimpleDateFormat("dd/mm/yyyy");

        //catch exception if user enters something incorrect
        Date realDate = formatter.parse(date);

        Task first = new Task("finish smth", realDate, formatter,"noName", "in progress");

        TasksList task1 = new TasksList();
        task1.addTasksToList(first);
        TasksList collection = new TasksList();
        collection.addTasksToList(first);
        System.out.println(collection);
        System.out.println(collection.getTask(0));
    }
}
