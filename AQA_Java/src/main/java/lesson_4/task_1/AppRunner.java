package lesson_4.task_1;

public class AppRunner {
    public static void main(String[] args) {
        Employee employee1 = new Employee(
                "Ivan",
                "Ivanov",
                "manager",
                "ivan@gmail.com",
                "111111",
                123,
                44);
        employee1.showEmployee();
    }
}