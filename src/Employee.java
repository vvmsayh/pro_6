import java.util.ArrayList;
import java.util.List;

public class Employee {
    private String firstName;
    private String lastName;
    private String address;
    private String email;
    private String pesel;
    private int yearOfEmployment;
    private List<String> testTypes;
    private List<Technology> technologies;
    private List<Goal> goals;
    public Employee(String firstName, String lastName, String address, String email, String pesel, int yearOfEmployment) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.email = email;
        this.pesel = pesel;
        this.yearOfEmployment = yearOfEmployment;
        this.testTypes = new ArrayList<>();
        this.technologies = new ArrayList<>();
        this.goals = new ArrayList<>();
    }

//dev add tech
    public void addTechnology(Technology tech) {
        this.technologies.add(tech);
    }

//test
    public void addTestType(String testType) {
        this.testTypes.add(testType);
    }

//managers)
    public void addGoal(Goal goal) {
        this.goals.add(goal);
    }

//salary
    public int calculateSalary() {
        int baseSalary = 3000 + (2024 - yearOfEmployment/* for example 2022*/) * 1000; // Base salary
        int bonus = 0;

        // Bonus for developers (technologies)
        for (Technology tech : technologies) {
            bonus += tech.getBonus();
        }

        // Bonus for testers (test types)
        bonus += testTypes.size() * 300;

        // Bonus for managers (achieved goals)
        for (Goal goal : goals) {
            if (goal.isAchieved()) {
                bonus += goal.getBonusAmount();
            }
        }

        return baseSalary + bonus;
    }
}

class Technology {
    private String name;
    private int bonus;

    public Technology(String name, int bonus) {
        this.name = name;
        this.bonus = bonus;
    }

    public int getBonus() {
        return bonus;
    }
}

class Goal {
    private int year;
    private int month;
    private int day;
    private String name;
    private int bonusAmount;

    public Goal(int year, int month, int day, String name, int bonusAmount) {
        this.year = year;
        this.month = month;
        this.day = day;
        this.name = name;
        this.bonusAmount = bonusAmount;
    }

    public boolean isAchieved() {
        // Assuming today's date is 2024-05-03
        return year <= 2024 && month <= 5 && day <= 3;
    }

    public int getBonusAmount() {
        return bonusAmount;
    }
}
