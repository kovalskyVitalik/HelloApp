package Lesson02.home;


public class Homework2 {

    public static void main(String[] args) {

        System.out.println("Результат задания 1 > " + checkNumbers(1, 15));
        System.out.println("***************");

        isPositive1(-20);
        System.out.println("***************");

        System.out.println("result " + isPositive2(20));
        System.out.println("***************");

        methodPrintStringCount("Hello string" , 5);
        System.out.println("***************");

    }

    public static boolean checkNumbers(int first, int second) {
        return (first + second <= 20) && (first + second >= 10);
    }

    public static void isPositive1(int variable) {
        if (variable >= 0) {
            System.out.println(variable + " is positive");
        } else {
            System.out.println(variable + " is negative");
        }
    }

    public static boolean isPositive2(int variable) {
        return variable <= 0;
    }

    public static void methodPrintStringCount(String value, int count) {
        for (int i = 1; i <= count; i++) {
            System.out.println("String #" + i + ": " + value);
        }
    }
}
