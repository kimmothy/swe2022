package yhtommik.Todo;

import java.time.LocalDate;
import java.util.ArrayList;

public class TodoList {
    static private ArrayList<String> names = new ArrayList<>();

    private String name;

    private ArrayList<TodoTask> tasks;

    private TodoTheme theme;

    public TodoList(String name){
        this.name = name;
        names.add(this.name);
        theme = new TodoTheme("blue", "mountains");
        tasks = new ArrayList<>();
    }
    public void setName(String name){
        if (name.equals(this.name)) return;
        names.remove(this.name);
        this.name = name;
        names.add(this.name);
    }

    public TodoTask addTask(String name){
        TodoTask newTask = new TodoTask(name);
        tasks.add(newTask);
        return newTask;
    }

    public void setTheme(String color, String image){
        theme.setColor(color);
        theme.setImage(image);
    }

    public void sort(String factor){
        if ("addedDate".equals(factor)){
            tasks.sort((x, y) -> {
                        if (x.addedDate.isBefore(y.addedDate)) return 1;
                         else if (x.addedDate.isAfter(y.addedDate)) return -1;
                         else return 0;
            });

        }
        else if ("name".equals(factor)){
            tasks.sort((x,y) -> x.name.compareTo(y.name));
        }
        else if ("limit".equals(factor)){
            tasks.sort((x,y) ->  {
                if (x.limit.isBefore(y.limit)) return 1;
                else if (x.limit.isAfter(y.limit)) return -1;
                else return 0;
            });
        }
        else if ("myDay".equals(factor))
            tasks.sort((x,y) -> {
                if (x.myDay && !y.myDay) return 1;
                else if (!x.myDay && y.myDay) return -1;
                else return 0;

            });
    }


    class TodoTask {
        private String name;
        private boolean myDay;
        private LocalDate limit;
        private LocalDate addedDate;

        private TodoTask(String name){
            this.name = name;
            addedDate = LocalDate.now();
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setLimit(int year, int month, int date){
            limit = LocalDate.of(year,month,date);
        }

        public void toggleMyDay() {
            if (myDay){myDay = false;}
            else if(!myDay){myDay = true;}
        }



    }
}
