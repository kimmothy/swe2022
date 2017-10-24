package lesson6;

import java.util.Arrays;
import java.util.Comparator;

public class Main {
    static class Run implements Runnable{

        @Override
        public void run() {
            for(int i = 0; i < 2000; i++) Main.doWork();

        }


    }

    static void doWork() {
    }

    static class LengthComparator implements Comparator<String>{

        @Override
        public int compare(String o1, String o2) {
            return o1.length() - o2.length();
        }
    }
    static class EmployeeComparator implements Comparator<Employee>{

        @Override
        public int compare(Employee o1, Employee o2) {
            return o1.salary - o2.salary;
        }

    }
    static public void main(String[] arg){
        Runnable task = new Run();
        Runnable task2 = ()->{
            for(int i = 0; i < 2000; i++);
        };
        Comparator<String> comp1 = new LengthComparator();
        Comparator<String> comp2 = (f, s)-> f.length() - s.length();
        comp2.compare("d","d");

        Employee me = new Employee(100), you = new Employee(200);
        Employee[] members = {me, you};
        Arrays.sort(members, new EmployeeComparator());
        Comparator<Employee> f = (g, s)->(g.salary - s.salary);


        }
    }

