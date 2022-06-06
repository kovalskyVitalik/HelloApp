package Lesson05.home;

public class Person {

    private static final int CURRENT_YEAR = 2021;

    private String surname;
    private String secondName;
    private String name;
    private String position;
    private String phone;
    private int salary;
    private int birthYear;


    public Person(String name,
                  String secondName,
                  String surname,
                  String phone,
                  String position,
                  int salary,
                  int birthYear) {
        this.birthYear = birthYear;
        this.name = name;
        this.surname = surname;
        this.secondName = secondName;
        this.position = position;
        this.phone = phone;
        this.salary = salary;
    }

    int getAge() {
        return CURRENT_YEAR - birthYear;
    }

    int getSalary() {
        return salary;
    }

    String getFullInfo() {
        return this.name + " " +
                this.secondName + " " +
                this.surname + ", " +
                this.getAge() + " years old, " +
                this.position + ". Phone number: " +
                this.phone + ". Salary is " +
                this.getSalary() + " RU";
    }

}
