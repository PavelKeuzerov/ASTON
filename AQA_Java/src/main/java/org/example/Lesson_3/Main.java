package org.example.Lesson_3;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        System.out.println(betweenSum10and20(11, 4));
        numberPositiveOrNegative(-2);
        System.out.println(numberBoolean(-3));
        numberAndString(5, "Hello World");
        System.out.println(leapYear(2024));
        changeArray();
        fillArray();
        multiplyingNumbers();
        diagonallyArray();
        dimensionalArray(4, 6);
    }

    public static boolean betweenSum10and20(int a, int b) {
        int sumNumber = a + b;
        return sumNumber >= 10 && sumNumber <= 20;
    }

    public static void numberPositiveOrNegative(int number) {
        if (number >= 0) {
            System.out.println(number + " is positive");
        } else {
            System.out.println(number + " is negative");
        }
    }

    public static boolean numberBoolean(int number) {
        return number < 0;
    }

    public static void numberAndString(int number, String letters) {
        for (int i = 0; i < number; i++) {
            System.out.println(letters);
        }
    }

    public static boolean leapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0 || year % 400 == 0);
    }

    public static void changeArray() {
        int[] arr = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 1) {
                arr[i] = 0;
            } else if (arr[i] == 0) {
                arr[i] = 1;
            }
            System.out.print(arr[i] + " ");
        }
    }

    public static void fillArray() {
        int[] arr = new int[100];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i + 1;
            System.out.println("arr[" + i + "] = " + arr[i]);
        }
    }

    public static void multiplyingNumbers() {
        int[] arr = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 6) {
                arr[i] *= 2;
            }
        }
        System.out.println(Arrays.toString(arr));
    }

    public static void diagonallyArray() {
        int[][] arr = new int[4][4];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0, x = arr[i].length - 1; j < arr[i].length; j++, x--) {
                if (i == j || i == x) arr[i][j] = 1;
                else arr[i][j] = 0;
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void dimensionalArray(int len, int initialValue) {
        int[] arr = new int[len];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = initialValue;
        }
        System.out.println(Arrays.toString(arr));
    }
}