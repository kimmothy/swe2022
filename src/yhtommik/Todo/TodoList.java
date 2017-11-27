package yhtommik.Todo;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Scanner;

public class TodoList {
    private enum SortFactor {BASIC, NAME, LIMIT, ADDED_DATE, IS_COMPLETED, IN_MY_DAY};
    private SortFactor sortFactor;
    private String name;
    private ArrayList<TodoTask> tasks;
    private TodoTheme theme;
    private boolean hideCompleted;

    public TodoList(String name){
        this.name = name;
        theme = new TodoTheme();
        tasks = new ArrayList<>();
        sortFactor = SortFactor.BASIC;
    }

    public ArrayList<TodoTask> getList( ) {
        ArrayList<TodoTask> copiedList = new ArrayList<>(tasks);
        sort(copiedList);
        if (hideCompleted){ copiedList.removeIf(x -> x.isCompleted); }
        return copiedList;
    }

    public String getName() {return name;}

    public int getLengthOfList(){
        int length = 0;
        for (TodoTask task : tasks){
            length++;
        }
        return length;
    }

    public void printTasks(){
        for (TodoTask task : tasks){
            System.out.printf("[%s] %s %d. %d. %d. %s",task.printIsCompleted(), task.getName(), task.getLimitYear(), task.getLimitMonth(), task. getLimitDate(), task.printIsAlarmSet());
        }
    }

    public void setName(String name){
        if (name.equals(this.name)) return;
        this.name = name;
    }

    public void setTheme(){
        theme.setTheme();
    }

    public TodoTask addTask(String name){
        TodoTask newTask = new TodoTask(name);
        tasks.add(newTask);
        return newTask;
    }

    public void setSortFactor() {
        for (SortFactor sortFactor : SortFactor.values()){//사용자에게 정렬 기준의 목록을 보여주고 선택받음
            System.out.println(sortFactor);
        }
        System.out.println(("무엇으로?"));
        Scanner scanner = new Scanner(System.in);
        String sortFactor = scanner.nextLine().toUpperCase();

        this.sortFactor = SortFactor.valueOf(sortFactor);
    }

    public void toggleHideCompleted() {
        if (hideCompleted){
            hideCompleted = false;}
        else {
            hideCompleted = true;}
    }

    public void sort(ArrayList<TodoTask> tasks){
        tasks.sort(TodoTask::compareTo);
    }


    class TodoTask {
        private String name;
        private boolean inMyDay;
        private boolean isCompleted;
        private LocalDate limit;
        private LocalDate addedDate;
        private LocalDate alarmDate;
        private LocalTime alarmTime;

        private TodoTask(String name){
            this.name = name;
            addedDate = LocalDate.now();
            isCompleted = false;
        }

        public String getName() {
            return name;
        }

        public String printIsCompleted(){
            if (isCompleted) {return "O";}
            else {return "-";}
        }

        public String printIsAlarmSet(){
            if (alarmDate == null) {return "";}
            else return "알람";
        }

        public int getLimitYear(){
            return limit.getYear();
        }

        public int getLimitMonth(){
            return limit.getMonthValue();
        }

        public int getLimitDate(){
            return limit.getDayOfMonth();
        }

        public int compareTo (TodoTask other) {

            if (sortFactor == SortFactor.ADDED_DATE) {
                if (this.addedDate.isBefore(other.addedDate)) {
                    return 1;
                } else if (this.addedDate.isAfter(other.addedDate)) {
                    return -1;
                } else {
                    return 0;
                }

            } else if (sortFactor == SortFactor.NAME) {
                return this.name.compareTo(other.name);

            } else if (sortFactor == SortFactor.LIMIT) {
                if (this.limit.isBefore(other.limit)) {
                    return 1;
                } else if (this.limit.isAfter(other.limit)) {
                    return -1;
                } else return 0;

            } else if (sortFactor == SortFactor.IN_MY_DAY) {
                if (this.inMyDay && !other.inMyDay) {
                    return 1;
                } else if (!this.inMyDay && other.inMyDay) {
                    return -1;
                } else return 0;
            }

            else if (sortFactor == SortFactor.IS_COMPLETED) {
                if (this.isCompleted && !other.isCompleted) {
                    return 1;
                } else if (!this.isCompleted && other.isCompleted) {
                    return -1;
                } else return 0;
            }

            else {//sortFactor가 BASIC일 때(사용자가 정렬 방식을 입력하지 않았을 때)
                if (this.addedDate.isBefore(other.addedDate)) {
                    return -1;
                } else if (this.addedDate.isAfter(other.addedDate)) {
                    return 1;
                } else {
                    return 0;
                }
            }
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setLimit(int year, int month, int date){
            limit = LocalDate.of(year,month,date);
        }

        public void setAlarm(int year, int month, int date, int time, int minute) {
            alarmDate = LocalDate.of(year,month,date);
            alarmTime = LocalTime.of(time, minute);
        }

        public boolean isAlarmed(){
            if (alarmTime == null) {return false;}
            if (alarmDate.isAfter(LocalDate.now())) {return false;}
            if (alarmTime.isAfter(LocalTime.now())) {return false;}
            return true;
        }

        public void toggleInMyDay() {
            if (inMyDay){
                inMyDay = false;}
            else {
                inMyDay = true;}
        }

        public void setCompleted(){
            if (isCompleted) {isCompleted = false;}
            else {isCompleted = true;}
        }
    }
}
