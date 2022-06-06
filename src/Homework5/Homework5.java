package Lesson05.home;

public class Homework5 {

    public static void main(String[] args) {

        Person mainEmployee = new Person("Виталий", "Валерьевич",
                "Ковальский", "8(495)000-11-22",
                "Test Manager", 80000, 1986);

        Person[] office = {
                mainEmployee,
                new Person("Андрей", "Алексеевич",
                        "Птушкин", "8(495)111-22-33",
                        "project owner", 520000, 1973),
                new Person("Семён", "Евгеньевич",
                        "Самойлов", "8(495)222-33-44",
                        "project manager", 40000, 1963),
                new Person("Наталья", "Викторовна",
                        "Пантелеева", "8(495)333-44-55",
                        "senior developer", 90000, 1990),
                new Person("Аркадий", "Валентинович",
                        "Терешкоф", "8(495)444-55-66",
                        "engineer", 50000, 1983)
        };

        getAllPersonsInOffice(office);
        System.out.println("***************");
        getOldPerson(office, 44);

    }

    private static void getOldPerson(Person[] office, int year) {
        for (int i = 0; i < office.length; i++)
            if (office[i].getAge() > year) {
                System.out.println(office[i].getFullInfo());
            }
    }


    private static void getAllPersonsInOffice(Person[] office) {
        System.out.println("All person: ");
        for (int i = 0; i < office.length; i++)
            System.out.println((i + 1) + " " + office[i].getFullInfo());
    }
}
