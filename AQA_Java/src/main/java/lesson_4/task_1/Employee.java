package lesson_4.task_1;

public class Employee {

    private String name;
    private String surname;
    private String position_at_work;
    private String email;
    private String phone_number;
    private int salary;
    private int age;

    public Employee(String name, String surname, String position_at_work,
                    String email, String phone_number, int salary, int age) {
        this.name = name;
        this.surname = surname;
        this.position_at_work = position_at_work;
        this.email = email;
        this.phone_number = phone_number;
        this.salary = salary;
        this.age = age;
    }

    public void showEmployee() {
        System.out.println(
                "Name: " + name + "\n" +
                        "Surname: " + surname + "\n" +
                        "Position at work: " + position_at_work + "\n" +
                        "Email: " + email + "\n" +
                        "Phone number: " + phone_number + "\n" +
                        "Salary: " + salary + "\n" +
                        "Age: " + age);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", position_at_work='" + position_at_work + '\'' +
                ", email='" + email + '\'' +
                ", phone_number='" + phone_number + '\'' +
                ", salary=" + salary +
                ", age=" + age +
                '}';
    }
}