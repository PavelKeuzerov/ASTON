import java.util.*;
import java.util.stream.Collectors;

public class Task1 {
    public static void main(String[] args) {
        Random random = new Random();
        List<Integer> integersRandomList = new ArrayList<>();
        for (int i = 0; i < random.nextInt(111); i++) {
            integersRandomList.add(random.nextInt(111));
        }
        List<Integer> evenNumbersList = integersRandomList.stream().filter(o -> o % 2 == 0).collect(Collectors.toList());
        System.out.println("Number of even numbers " + (long) evenNumbersList.size());
        System.out.println(evenNumbersList);
    }
}
