package lesson6;

import java.util.function.Predicate;

public interface EmployeeTest {
    static public boolean test(Employee em, Predicate<Employee> tester){
        return tester.test(em);
    }

}
