package yhtommik.Todo;

import java.util.ArrayList;

public class TodoMain {
    static public void main(String[] arg){
        TodoApp todoApp = new TodoApp();
        TodoList schoolHomework = todoApp.addList("학교 과제");
        TodoList guitar = todoApp.addList("기타");
        schoolHomework.addTask("미국사 과제");
        schoolHomework.addTask("창글 과제");
        ArrayList<TodoList.TodoTask> asd = schoolHomework.getList();
        for (TodoList.TodoTask todoTask : asd) {
            System.out.println(todoTask.getName());
        }
        asd.get(0).setLimit(2017,11,30);
        asd.get(0).setAlarm(2017,11,19,20,30);
        if (asd.get(0).isAlarmed()) {
            System.out.println("alarm");
        }


    }
}
