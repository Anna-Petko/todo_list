package com.company;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


public class Main {
    public static void main(String[] args) throws Exception { //handle this later
        String input = "02/03/1994";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate realDate = LocalDate.parse(input, formatter);
        //System.out.println(realDate);
        Task first = new Task("finish smth", realDate, formatter, "noName", "in progress");
        Task second = new Task("call", realDate, formatter, "other", "notDone");
        TasksList collection = new TasksList();

        collection.addTasksToList(first);
        collection.addTasksToList(second);

        collection.showTaskByProjectName("noName");
        String input1 = "02/03/1994";
        LocalDate localDate = LocalDate.parse(input1, formatter);

        collection.showTasksByDate(localDate);

    }
}



