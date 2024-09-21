package lesson_4.task_3;

import java.util.ArrayList;
import java.util.List;

public class Park {
    public List<Attraction> attractionList = new ArrayList<>();

    public List<Attraction> getAttractionList() {
        return attractionList;
    }

    public void addAttraction(Attraction attraction) {
        attractionList.add(attraction);
    }

    public void infoAttraction() {
        for (Attraction attraction : attractionList) {
            System.out.println(attraction);
        }
    }

    public static class Attraction {
        public String name;
        public String workingHours;
        public int price;

        public Attraction(String name, String workingHours, int price) {
            this.name = name;
            this.workingHours = workingHours;
            this.price = price;
        }

        @Override
        public String toString() {
            return "Attraction: " + name + "," +
                    " Working hours " + workingHours +
                    " Attraction price: " + price + " $";
        }
    }
}
