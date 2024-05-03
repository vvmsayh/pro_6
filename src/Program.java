import java.util.ArrayList;
import java.util.List;

public class Program {
    public static void main(String[] args) {
        // Creating a list of employees
        List<Employee> employees = new ArrayList<>();

        // Creating developers
        Employee dev = new Employee("John", "Doe", "New York", "john@doe.com", "123456789", 2020);
        dev.addTechnology(new Technology("Java", 800));
        employees.add(dev);

        // Creating testers
        Employee tester = new Employee("Jane", "Smith", "Los Angeles", "jane@smith.com", "987654321", 2021);
        tester.addTestType("UI/UX");
        employees.add(tester);

        // Creating a manager
        Employee manager = new Employee("Bob", "Johnson", "Chicago", "bob@johnson.com", "1122334455", 2019);
        manager.addGoal(new Goal(2010, 10, 15, "Implementing FB login", 1000));
        employees.add(manager);

        // Calculating total amount to be paid
        int totalAmount = 0;
        for (Employee employee : employees) {
            totalAmount += employee.calculateSalary();
        }
        System.out.println("Total amount to be paid this month: " + totalAmount + " USD");
    }
}
