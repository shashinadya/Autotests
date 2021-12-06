//Создать класс "Калькулятор", который умел бы делать все операции, присущие калькулятору,
// с такими типами данных, как int и double.


import java.util.Scanner;

public class Calc {

    private static double result;

    public int calculateTheSumOfNumbers(int a, int b) {
        return a + b;
    }

    public double calculateTheSumOfNumbers(double a, double b) {
        return a + b;
    }

    public int calculateTheDifferenceOfNumbers(int a, int b) {
        return a - b;
    }

    public double calculateTheDifferenceOfNumbers(double a, double b) {
        return a - b;
    }

    public int calculateTheMultiplicationOfNumbers(int a, int b) {
        return a * b;
    }

    public double calculateTheMultiplicationOfNumbers(double a, double b) {
        return a * b;
    }

    public int calculateTheDivisionOfNumbers(int a, int b) {
        if (b == 0) {
            System.out.println("Input the number > 0, please!");
        }
        return a / b;
    }

    public double calculateTheDivisionOfNumbers(double a, double b) {
        if (b == 0) {
            System.out.println("Input the number > 0, please!");
        }
        return a / b;
    }

    public int returnResultOfOperation(int a, int b, char operation) {
        switch (operation) {
            case '+':
                result = calculateTheSumOfNumbers(a, b);
                break;
            case '-':
                result = calculateTheDifferenceOfNumbers(a, b);
                break;
            case '*':
                result = calculateTheMultiplicationOfNumbers(a, b);
                break;
            case '/':
                result = calculateTheDivisionOfNumbers(a, b);
                break;
            default:
                System.out.println("Choose the correct operation, please!");
        }
        return (int) result;
    }

    public double returnResultOfOperation(double a, double b, char operation) {
        switch (operation) {
            case '+':
                result = calculateTheSumOfNumbers(a, b);
                break;
            case '-':
                result = calculateTheDifferenceOfNumbers(a, b);
                break;
            case '*':
                result = calculateTheMultiplicationOfNumbers(a, b);
                break;
            case '/':
                result = calculateTheDivisionOfNumbers(a, b);
                break;
            default:
                System.out.println("Choose the correct operation, please!");
        }
        return result;
    }

    public static void main(String[] args) {

        Calc calc = new Calc();
        Scanner in = new Scanner(System.in);
        System.out.print("Input the first number: ");
        int a = in.nextInt();
        System.out.print("Input the second number: ");
        int b = in.nextInt();
        System.out.print("Input the operation (variants: +, -, *, /): ");
        char operation = in.next().charAt(0);

        calc.returnResultOfOperation(a, b, operation);

        System.out.println(result);


    }
}
