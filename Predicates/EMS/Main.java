package java8.Predicates.EMS;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {

        List<Employee> list = new ArrayList<>();
        populateList(list);

        Predicate<Employee> isManager = emp -> emp.getDesignation().equals("Manager");
        System.out.println("Managers: ");
        display(isManager, list);

        Predicate<Employee> isInBangalore = emp -> emp.getCity().equals("Bangalore");
        System.out.println("In Bangalore: ");
        display(isInBangalore, list);

        Predicate<Employee> havingLessSalary = emp -> emp.getSalary() <= 60000;
        System.out.println("Employees with less salary than 60000: ");
        display(havingLessSalary, list);

        System.out.println("isManager and In Bangalore: ");
        display(isManager.and(isInBangalore), list);

        System.out.println("is not Manager");
        display(isManager.negate(), list);
        Predicate<String> equal = Predicate.isEqual("dd");
        System.out.println(equal.test("dd"));
    }

    private static void display(Predicate<Employee> isManager, List<Employee> list) {
        for (Employee e : list) {
            if (isManager.test(e))
                System.out.println(e);
        }
        System.out.println("******************************************************");
    }

    private static void populateList(List<Employee> list) {
        list.add(new Employee("Dwarkesh", "Engineer", 30000, "Ahmedabad"));
        list.add(new Employee("Saurabh", "Executive", 70000, "Mumbai"));
        list.add(new Employee("Rahul", "Manager", 50000, "Delhi"));
        list.add(new Employee("Ronak", "Manager", 55000, "Bangalore"));
        list.add(new Employee("Ajay", "Director", 200000, "Bangalore"));
        list.add(new Employee("Vijay", "Software Developer", 60000, "Hyderbad"));

    }
}
