package lesson_4.task_3;

public class AppRunner {
    public static void main(String[] args) {
        Park park = new Park();

        Park.Attraction attraction1 = new Park.Attraction("Roller coaster", "12-17", 6);
        Park.Attraction attraction2 = new Park.Attraction("Flying saucer", "17-22", 5);
        Park.Attraction attraction3 = new Park.Attraction("Turbo", "19-23", 5);

        park.addAttraction(attraction1);
        park.addAttraction(attraction2);
        park.addAttraction(attraction3);

        park.infoAttraction();
    }
}
