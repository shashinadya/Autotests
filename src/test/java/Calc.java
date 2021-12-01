//Создать класс "Калькулятор", который умел бы делать все операции, присущие калькулятору,
// с такими типами данных, как int и double.


import java.util.Scanner;

public class Calc {
    static Scanner in = new Scanner(System.in);
    static int operation = in.next().charAt(0);
    static int result;

    public int calculateTheSumOfNumbers(int a, int b) {
        return a + b;
    }

    public int calculateTheDifferenceOfNumbers(int a, int b) {
        return a - b;
    }

    public int calculateTheMultiplicationOfNumbers(int a, int b) {
        return a * b;
    }

    public int calculateTheDivisionOfNumbers(int a, int b) {
        if (b == 0) {
            System.out.println("Input the number > 0, please!");
        }
        return a / b;
    }

    public int returnResultOfOperation(int a, int b) {
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

        System.out.print("Input the first number: ");
        int a = in.nextInt();
        System.out.print("Input the second number: ");
        int b = in.nextInt();
        System.out.print("Input the operation (variants: +, -, *, /): ");

        calc.returnResultOfOperation(a, b);

        System.out.println(result);


    }
}
