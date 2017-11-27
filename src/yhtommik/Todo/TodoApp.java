package yhtommik.Todo;

import java.util.ArrayList;

public class TodoApp {
    private ArrayList<TodoList> Lists = new ArrayList<>();

    public TodoList addList(String name){
        TodoList newList = new TodoList(name);
        Lists.add(newList);
        return newList;
    }

    public ArrayList<TodoList> getLists() {
        return Lists;
    }

    public void delList(TodoList list){
        Lists.remove(list);
    }

    public void printLists (){
        for (TodoList list : Lists){
            System.out.printf("- %s: %d%n",list.getName(), list.getLengthOfList());

        }
    }



}
