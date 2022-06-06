
package Lesson01.home;

public class Homework1 {


    public static void main(String[] args) {

        printThreeWords();

        System.out.println("***************");
        if (checkSumSign(12, 14)) {
            System.out.println("Sum positive");
        } else {
            System.out.println("Sum negative");
        }

        System.out.println("***************");
        System.out.println(printColor(101));
        System.out.println(printColor(50));

        System.out.println("***************");
        System.out.println(compareNumbers(20, 15));

    }

    public static void printThreeWords() {
        System.out.println("Orange");
        System.out.println("Banana");
        System.out.println("Apple");
    }
    public static boolean checkSumSign(int a, int b) {
        return (a + b) >= 0;
    }

    public static String printColor(int value) {
        if (value <= 0) {
            return "Red";
        } else if (value > 0 && value <= 100) {
            return "Yellow";
        } else {
            return "Green";
        }
    }

    public static String compareNumbers(int a, int b) {
        if (a >= b) {
            return "a >= b";
        } else {
            return "a < b";
        }
    }
}

