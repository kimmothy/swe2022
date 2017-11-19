package yhtommik.Todo;

import java.util.ArrayList;

public class TodoApp {
    private ArrayList<TodoList> Lists = new ArrayList<>();

    public TodoList addList(String name){
        TodoList newList = new TodoList(name);
        Lists.add(newList);
        return newList;
    }

    public void delList(TodoList list){
        Lists.remove(list);
    }



}
