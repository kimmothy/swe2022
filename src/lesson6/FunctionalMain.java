package lesson6;

import java.util.ArrayList;
import java.util.function.Predicate;

public class FunctionalMain {
    static public void main(String arg){
        Employee me = new Employee(2000), you = new Employee(5000);
        //1. U looser?
        if(EmployeeTest.test(me, (em)->em.salary > 3000)) {
            System.out.println("ok");
        }
        else System.out.println("looser");

        if(EmployeeTest.test(you, (em)->em.salary > 2000)) {
            System.out.println("ok");
        }
        else System.out.println("looser");

        ArrayList<String> list = new ArrayList<>();
        list.add(null);
        list.add("helica");
        list.add(null);
        list.add("jane");

    }

    }

