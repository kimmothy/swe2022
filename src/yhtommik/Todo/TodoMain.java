package yhtommik.Todo;

import java.util.ArrayList;
import java.util.Scanner;

public class TodoMain {

    private static Scanner in = new Scanner(System.in).useDelimiter("\\s");

    private static void viewList(TodoList list) {
        while (true) {
            in.reset();
            list.printTasks();
            System.out.print("명령입력(list):");
            String command = in.next();
            if (command.startsWith("addTodo")) {
                String taskName = in.next();
                String limit = in.next();
                int limitYear = Integer.parseInt(limit.substring(0,2));
                //달이나 일이 한자리 수일 경우 앞에 0을 붙여야 정상 작동
                int limitMonth = Integer.parseInt(limit.substring(3,5));
                int limitDate = Integer.parseInt(limit.substring(6,8));
                TodoList.TodoTask newTask = list.addTask(taskName.substring(0,taskName.length()-1));

                newTask.setLimit(limitYear, limitMonth, limitDate);
                if (in.hasNext()) {
                    String alarmDate = in.next();
                    String alarmClock = in.next();
                    int alarmYear = Integer.parseInt(alarmDate.substring(0,2));
                    int alarmMonth = Integer.parseInt(alarmDate.substring(3,5));
                    int alarmDay = Integer.parseInt(alarmDate.substring(6,8));
                    int alarmTime = Integer.parseInt(alarmClock.substring(0,2));
                    int alarmMinute = Integer.parseInt(alarmClock.substring(3,5));
                    newTask.setAlarm(alarmYear,alarmMonth,alarmDay,alarmTime,alarmMinute);
                }

            } else if (command.startsWith("complete")) {
                String jobDone = in.next();
                for (TodoList.TodoTask task : list.getList()) {
                    if (task.getName().equals(jobDone)) {
                        task.setCompleted();
                        break;
                    }
                }
            }
        }
    }


    static public void main(String[] arg){
        TodoApp app = new TodoApp();
        TodoList listOnView = null;
        TodoList Homework = app.addList("숙제");
        TodoList.TodoTask america = Homework.addTask("미국사");
        america.setLimit(17,12,30);
        america.setAlarm(17,12,29,17,30);



        while (true) {
            in.reset();
            app.printLists();
            System.out.print("명령 입력(app):");
            String command = in.next();
            if (command.startsWith("addList")){
                TodoList newList = app.addList(in.next());
            } else if (command.startsWith("list")){
                String listName = in.next();
                for (TodoList list : app.getLists()) {
                    if (list.getName().equals(listName)) {
                        viewList(list);
                    }
                }
            }
        }
    }
}
