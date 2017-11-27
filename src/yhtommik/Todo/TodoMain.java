package yhtommik.Todo;

import java.util.ArrayList;
import java.util.Scanner;

public class TodoMain {


    static public void main(String[] arg){
        TodoApp app = new TodoApp();
        TodoList listOnView = null;
        TodoList schoolHomework = app.addList("학교 과제");
        schoolHomework.addTask("미국사");
        schoolHomework.addTask("프로그래밍 입문");
        TodoList guitar = app.addList("기타");

        Scanner in = new Scanner(System.in).useDelimiter("\\s");

        while (true) {
            in.reset();
            app.printLists();
            String command = in.next();
            if (command.contains("addList")){
                TodoList newList = app.addList(in.next());
            } else if (command.contains("list")){
                String listName = in.next();
                for (TodoList list : app.getLists()){
                    if (list.getName().equals(listName)){

                        listOnView = list;
                        break;
                    };
                }
                break;


            }

        }
        while (true){
            in.reset();
            listOnView.printTasks();
            String command = in.next();
            if (command.contains("addTodo")){
                TodoList.TodoTask newTask = listOnView.addTask(in.next());
                //newTask.setLimit(in.next());
                /*if (in.hasNext()){
                      in.setAlarm(in.next())
                 */

            }
            if (command.contains("complete")){
                for (TodoList.TodoTask task : listOnView.getList()){
                    if (task.getName() == in.next()){
                        task.setCompleted();
                        break;
                    }
                }
            }


        }

    }
}
