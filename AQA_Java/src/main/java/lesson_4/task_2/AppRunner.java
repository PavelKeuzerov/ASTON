package lesson_4.task_2;

public class AppRunner {
    public static void main(String[] args) {
        Employee employee1 = new Employee("Ivanov Ivan", "Manager",
                "ivan@gmail.com", "11111111111", 1111, 11);
        Employee employee2 = new Employee("Vasil Vasj", "Manager2",
                "vasj@gmail.com", "22222", 2222, 22);
        Employee employee3 = new Employee("Frodo Bagins", "Runer",
                "ring@gmail.com", "3333333", 33333, 33);
        Employee employee4 = new Employee("Harry Potter", "Killer",
                "wizard@gmail.com", "444444444444", 44444, 44);
        Employee employee5 = new Employee("Dr. Watson", "Friend",
                "ask@gmail.com", "555555555", 555555, 55);
        Employee[] person = new Employee[5];
        person[0] = employee1;
        person[1] = employee2;
        person[2] = employee3;
        person[3] = employee4;
        person[4] = employee5;

        for (Employee employee : person) {
            employee.showEmployee();
        }
    }
}
