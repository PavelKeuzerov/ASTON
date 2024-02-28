package lesson_7;

import java.util.Arrays;
import java.util.regex.Pattern;

public class AppRunner {
    public static void main(String[] args) throws MyArraySizeException, MyArrayDataException {
        String[][] array = {
                {"1", "2", "3"},
                {"4", "5", "6", "7"},
                {"8", "9", "10", "11"},
                {"12", "13", "14", "15"}};
        String[][] array2 = {
                {"1", "2", "3", "4"},
                {"five", "6", "7", "8"},
                {"9", "10", "11", "12"},
                {"13", "14", "15", "16"}};
        String[][] array3 = {
                {"1", "2", "3", "4"},
                {"5", "6", "7", "8"},
                {"9", "10", "11", "12"},
                {"13", "14", "15", "16"}};

        try {
            int result = checkArray(array3);
            System.out.println("Sum of all array elements: " + result);
        } catch (MyArraySizeException | MyArrayDataException exception) {
            System.out.println(exception);
        }
//
        try {
            System.out.println(checkArray(array));
        } catch (MyArraySizeException | MyArrayDataException exception) {
            System.out.println(exception);
        }

        try {
            System.out.println(checkArray(array2));
        } catch (MyArrayDataException | MyArraySizeException exception) {
            System.out.println(exception);
        }

    }

    static int checkArray(String[][] array) throws MyArraySizeException, MyArrayDataException {
        if (array.length != 4) {
            throw new MyArraySizeException("MyArraySizeException");
        }
        for (int i = 0; i < 4; i++) {
            if (array[i].length != 4) {
                throw new MyArraySizeException("Line: " + (i + 1) + ", Index out of range: " + array[i].length);
            }
        }

        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                try {
                    sum += Integer.parseInt(array[i][j]);
                } catch (NumberFormatException exception) {
                    throw new MyArrayDataException("Illegal argument in the line: " + (i + 1) + ", field: "
                            + (j + 1) + " '" + array[i][j] + "'");
                }
            }
        }
        return sum;
    }
}
