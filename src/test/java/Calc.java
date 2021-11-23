//Создать класс "Калькулятор", который умел бы делать все операции, присущие калькулятору,
// с такими типами данных, как int и double.


import java.util.Scanner;

public class Calc {
    public static int calculateTheSumOfNumbers(int a, int b) {
        return a + b;
    }

    public static int calculateTheDifferenceOfNumbers(int a, int b) {
        return a - b;
    }

    public static int calculateTheMultiplicationOfNumbers(int a, int b) {
        return a * b;
    }

    public static int calculateTheDivisionOfNumbers(int a, int b) {
        return a / b;
    }

    public static void main(String[] args) {
        int result;
        Scanner in = new Scanner(System.in);
        System.out.print("Input the first number: ");
        int a = in.nextInt();
        System.out.print("Input the second number: ");
        int b = in.nextInt();
        System.out.print("Input the operation (variants: +, -, *, /): ");
        int operation = in.next().charAt(0);

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
                return;
        }
        System.out.println(result);


    }
}
