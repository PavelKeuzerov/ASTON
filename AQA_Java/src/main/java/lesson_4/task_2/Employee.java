package lesson_4.task_2;

public class Employee {
    private String full_name;
    private String position_at_work;
    private String email;
    private String phone_number;
    private int salary;
    private int age;

    public Employee(String full_name, String position_at_work,
                    String email, String phone_number, int salary, int age) {
        this.full_name = full_name;
        this.position_at_work = position_at_work;
        this.email = email;
        this.phone_number = phone_number;
        this.salary = salary;
        this.age = age;
    }

    public void showEmployee() {
        System.out.println(
                "Full name: " + full_name + "\n" +
                        "Position at work: " + position_at_work + "\n" +
                        "Email: " + email + "\n" +
                        "Phone number: " + phone_number + "\n" +
                        "Salary: " + salary + "\n" +
                        "Age: " + age);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "full_name='" + full_name + '\'' +
                ", position_at_work='" + position_at_work + '\'' +
                ", email='" + email + '\'' +
                ", phone_number='" + phone_number + '\'' +
                ", salary=" + salary +
                ", age=" + age +
                '}';
    }
}
