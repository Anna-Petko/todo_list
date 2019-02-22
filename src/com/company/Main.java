package com.company;


public class Main {

    public static void main(String[] args) {
      Task first = new Task("finish smth", "12 march", "noName");
      TasksList task1 = new TasksList();
      task1.addTasksToList(first);
      TasksList collection = new TasksList();
      collection.addTasksToList(first);
        System.out.println(collection);
        System.out.println( collection.getTask(0));
    }
}
