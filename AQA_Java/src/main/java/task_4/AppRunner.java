package task_4;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

public class AppRunner {
    public static void main(String[] args) {
        Collection<Student> students = Arrays.asList(
                new Student("Дмитрий", 17, Gender.MAN),
                new Student("Максим", 20, Gender.MAN),
                new Student("Екатерина", 20, Gender.WOMAN),
                new Student("Михаил", 28, Gender.MAN));

        Double averageAge = students.stream().filter(o -> o.getGender() == Gender.MAN)
                .collect(Collectors.averagingInt(Student::getAge));
        System.out.printf("Average age of male students: %.2f\n", averageAge);

        System.out.println("Which students are at risk of receiving a summons this year:");
        students.stream().filter(o -> o.getAge() >= 18 && o.getAge() <= 27 && o.getGender()
                .equals(Gender.MAN)).forEach(System.out::println);
    }
}
